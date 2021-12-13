package pkg;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Nemocnice implements KarantenniBudova {

    private String obec;
    private Pacient[] pokoj;

    public Nemocnice(String obec, Pacient[] pokoj) {
        this.obec = obec;
        this.pokoj = pokoj;
    }

    public String getObec() {
        return obec;
    }

    public Pacient[] getPokoj() {
        return pokoj;
    }

    public void setObec(String obec) {
        this.obec = obec;
    }

    public void setPokoj(Pacient[] pokoj) {
        this.pokoj = pokoj;
    }

    @Override
    public boolean vlozPacienta(Pacient pacient) {
        for (int i = 0; i < this.pokoj.length; i++) {
            if (this.pokoj[i] == null) {
                this.pokoj[i] = pacient;
                return true;
            }
        }
        return false;
    }

    @Override
    public double procentoOckovanych() {
        int ockovani = 0;
        int pocetPacientu = 0;

        for (int i = 0; i < this.pokoj.length; i++) {
            if (this.pokoj[i] != null) {
                pocetPacientu++;
                if (this.pokoj[i].isOckovany()) {
                    ockovani++;
                }
            }
        }

        return (double) ockovani/pocetPacientu * 100;
    }

    @Override
    public void uloz(String cestaKSouboru) {
        try (PrintWriter printWriter = new PrintWriter(new File(cestaKSouboru))) {
            for (Pacient pacient : this.pokoj) {
                if (pacient != null) {
                    printWriter.printf("%s;%s\n", pacient.getJmeno(), pacient.isOckovany());
                }
            }
        } catch (IOException e) {
            System.out.println("Chyba při zápisu");
        }
    }
}
