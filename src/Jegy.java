public class Jegy {
    private Vonat vonat;
    private static int id;
    private int jegyszam;
    private int kedvezmeny;
    private double kedvezmenyesAr;

    Vonat getVonat(){return vonat;}
    int getJegyszam(){return jegyszam;}
    double getKedvezmenyesAr(){return kedvezmenyesAr;}

    Jegy(Vonat v, int k){
        vonat = v;
        jegyszam = id++;
        kedvezmeny = k;
        kedvezmenyesAr = v.getAr()*(1-k*0.01);
    }

    void kiir(){
        System.out.println(vonat.getVonatszam() + " - " + vonat.getIndulasHelye() + " - " + kedvezmeny);
    }
}
