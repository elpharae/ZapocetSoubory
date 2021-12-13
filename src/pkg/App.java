package pkg;

public class App {

    public static void main(String[] args) {

        Pacient[] pacienti = new Pacient[] {
            new Pacient("Adam", true),
            new Pacient("Roman", true),
            new Pacient("Jan", false),
            new Pacient("Petr", false),
            new Pacient("Adam", true),
            null,
            null,
            null,
            null,
            null
        };

        Nemocnice nemocnice = new Nemocnice("Pardubice", pacienti);
        System.out.println("% očkovaných: " + nemocnice.procentoOckovanych());
        nemocnice.vlozPacienta(new Pacient("Tadeáš", true));
        System.out.println("% očkovaných: " + nemocnice.procentoOckovanych());
        nemocnice.uloz("osoby.txt");

    }
}
