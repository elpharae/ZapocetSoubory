package pkg;

public class Pacient {

    private String jmeno;
    private boolean ockovany;

    public Pacient(String jmeno, boolean ockovany) {
        this.jmeno = jmeno;
        this.ockovany = ockovany;
    }

    public String getJmeno() {
        return jmeno;
    }

    public boolean isOckovany() {
        return ockovany;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public void setOckovany(boolean ockovany) {
        this.ockovany = ockovany;
    }
}
