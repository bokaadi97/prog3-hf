import java.io.Serializable;
import static java.lang.Integer.parseInt;

public class Ido implements Serializable {
    private int ora, perc;

    Ido(){}

    Ido(int o, int p) throws IllegalArgumentException {
        if(o > 24 || p > 60)
            throw new IllegalArgumentException("Hibás idő formátum");
        else {
            ora = o;
            perc = p;
        }
    }

    Ido stringToIdo(String s) throws IllegalArgumentException {
        if(s.split(":").length != 2)
            throw new IllegalArgumentException("Hibás idő formátum");
        else{
            String[] darabok = s.split(":");
            int ora = parseInt(darabok[0]);
            int perc = parseInt(darabok[1]);
            return new Ido(ora, perc);
        }
    }

    @Override
    public String toString() {
        if(ora < 10 && perc < 10)
            return "0" + ora + ":0" + perc;
        if(ora < 10)
            return "0" + ora + ":" + perc;
        if(perc < 10)
            return ora + ":0" + perc;
        else
            return ora + ":" + perc;
    }

    public int getOra() {
        return ora;
    }

    public int getPerc() {
        return perc;
    }

    public boolean kesobbiIdopont(Ido i){
        if(i.getOra() == this.getOra() && i.getPerc() > this.getPerc())
            return true;
        if(i.getOra() > this.getOra())
            return true;
        else
            return false;
    }
}
