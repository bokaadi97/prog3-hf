public class Jegy {
    private Vonat vonat;
    private int kedvezmeny;

    Jegy(Vonat v, int k){
        vonat = v;
        kedvezmeny = k;
    }

    void kiir(){
        System.out.println(vonat.getVonatszam() + " - " + vonat.getIndulasHelye() + " - " + kedvezmeny);
    }
}
