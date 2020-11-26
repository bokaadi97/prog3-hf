import java.io.Serializable;

public class Vonat implements Serializable{
    private static int id;
    private int vonatszam;
    private String indulasHelye;
    private String erkezesHelye;
    private Ido indulasIdeje;
    private Ido erkezesIdeje;
    private int vagonokSzama;
    private int ferohely;
    private double ar;
    private int telitettseg;

    Vonat(String iH, String eH, Ido iI, Ido eI, int vSz, int f, double a){
        vonatszam = id++;
        indulasHelye = iH;
        erkezesHelye = eH;
        indulasIdeje = iI;
        erkezesIdeje = eI;
        vagonokSzama = vSz;
        ferohely = f;
        ar = a;
        telitettseg = 0;
    }

    Vonat() {}

    int getVonatszam(){ return vonatszam;}
    String getIndulasHelye(){ return indulasHelye;}
    String getErkezesHelye(){ return erkezesHelye;}
    Ido getIndulasIdeje(){ return indulasIdeje;}
    Ido getErkezesIdeje(){ return erkezesIdeje;}
    int getVagonokSzama(){ return vagonokSzama;}
    int getFerohely(){ return ferohely;}
    double getAr(){ return ar;}
    int getTelitettseg(){ return telitettseg;}

    void setId(int id){ this.id = id;}
    void setTelitettseg(int t){telitettseg = t;}

    boolean betelnee(int jegyekSzama){
        if(telitettseg + jegyekSzama > vagonokSzama * ferohely)
            return true;
        else
            return false;
    }

}
