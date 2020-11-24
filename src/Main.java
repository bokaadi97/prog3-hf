import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner in = new Scanner(System.in);
        Tarolo t = new Tarolo();
	    Kosar k = new Kosar();
        t.beolvas();
        Fokepernyo fk = new Fokepernyo(t);
        fk.setVisible(true);

        while(true){
            System.out.println("Mit szeretnel csinalni?\n" +
                    "1. Menetjegy vásárlása\n" +
                    "2. Új vonat hozzáadása\n" +
                    "3. Vonat törlése\n" +
                    "4. Kilépés\n");
            int valasz = in.nextInt();
            switch (valasz){
                case 1:
                    t.kilistaz();
                    System.out.println("Melyik szamu vonatot?");
                    int vonatszam = in.nextInt();
                    System.out.println("Hany db jegyet?");
                    int darab = in.nextInt();
                    k.kosarbaTesz(t, vonatszam, darab);
                    System.out.println("Hány százalékos kedvezmennyel?");
                    int kedvezmeny = in.nextInt();
                    k.kosar.get(k.kosar.size() - 1).setKedvezmeny(kedvezmeny);
                    k.kilistaz();
                    k.osszegez();
                    break;
                case 2:
                    //t.hozzaad();
                    break;
                case 3:
                    t.kilistaz();
                    System.out.println("Hanyas szamu vonatot szeretned torolni?");
                    int id = in.nextInt();
                    t.torol(id);
                    System.out.println("Sikeres torles");
                    t.kilistaz();
                    break;
                case 4:
                    System.out.println("Good bye!");
                    t.mentes();
                    System.exit(0);
                default:
                    System.out.println("Ne legyél már full retard!!");
            }

        }

    }
}
