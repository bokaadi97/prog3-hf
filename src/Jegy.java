public class Jegy {
    private Vonat vonat;
    private int kedvezmeny;
    private double kedvezmenyesAr;

    Vonat getVonat(){return vonat;}
    double getKedvezmenyesAr(){return kedvezmenyesAr;}

    Jegy(Vonat v, int k){
        vonat = v;
        kedvezmeny = k;
        kedvezmenyesAr = v.getAr()*(1-k*0.01);
        //kosar.get(i).getAr();//*(1-kosar.get(i).getKedvezmeny()*0.01);
    }

    void kiir(){
        System.out.println(vonat.getVonatszam() + " - " + vonat.getIndulasHelye() + " - " + kedvezmeny);
    }
}
