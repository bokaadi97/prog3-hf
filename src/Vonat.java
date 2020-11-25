import java.io.Serializable;

public class Vonat implements Serializable{
    private static int id;
    private int vonatszam;
    private String indulasHelye;
    private String erkezesHelye;
    private int indulasIdeje;
    private int erkezesIdeje;
    private int vagonokSzama;
    private int ferohely;
    private double ar;
    private int kedvezmeny;

    Vonat(String iH, String eH, int iI, int eI, int vSz, int f, double a){
        vonatszam = id++;
        indulasHelye = iH;
        erkezesHelye = eH;
        indulasIdeje = iI;
        erkezesIdeje = eI;
        vagonokSzama = vSz;
        ferohely = f;
        ar = a;
        kedvezmeny = 0;
    }

    public Vonat() {}

    int getId(){ return id;}
    int getVonatszam(){ return vonatszam;}
    String getIndulasHelye(){ return indulasHelye;}
    String getErkezesHelye(){ return erkezesHelye;}
    int getIndulasIdeje(){ return indulasIdeje;}
    int getErkezesIdeje(){ return erkezesIdeje;}
    int getVagonokSzama(){ return vagonokSzama;}
    int getFerohely(){ return ferohely;}
    double getAr(){ return ar;}
    int getKedvezmeny(){ return kedvezmeny;}

    void setId(int id){ this.id = id;}
    void setKedvezmeny(int kedvezmeny){ this.kedvezmeny = kedvezmeny;}

}
