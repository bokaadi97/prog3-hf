import java.util.ArrayList;

public class Kosar {
    ArrayList<Vonat> kosar = new ArrayList<>();

    void kosarbaTesz(Tarolo t, int vonatszam, int darab){
        for(int i = 0; i < darab; i++)
            kosar.add(t.lista.get(vonatszam));
    }

    void kilistaz(){
        for(int i = 0; i < kosar.size(); i++){
            System.out.println(kosar.get(i).getIndulasHelye() + " " + kosar.get(i).getErkezesHelye() + " " + kosar.get(i).getIndulasIdeje() + " "
                    + kosar.get(i).getErkezesIdeje() + " " + kosar.get(i).getVagonokSzama() + " " + kosar.get(i).getFerohely() + " "
                    + kosar.get(i).getAr() + " - ID: " + kosar.get(i).getVonatszam() + "  kedvezmeny: " + kosar.get(i).getKedvezmeny());
        }
        System.out.println("\n\n");
    }

    void osszegez(){
        double vegosszeg=0;
        for(int i = 0; i < kosar.size(); i++){
            vegosszeg += kosar.get(i).getAr()*(1-kosar.get(i).getKedvezmeny()*0.01);
        }
        System.out.println("A vegosszeg: " + vegosszeg);
    }

}
