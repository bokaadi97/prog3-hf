import java.io.Serializable;
import static java.lang.Integer.parseInt;

public class Ido implements Serializable {
    private int ora, perc;

    Ido(){}

    Ido(int o, int p){
        ora = o;
        perc = p;
    }

    Ido stringToIdo(String s){
        String[] darabok = s.split(":");
        int ora = parseInt(darabok[0]);
        int perc = parseInt(darabok[1]);
        return new Ido(ora, perc);
    }

    @Override
    public String toString() {
        if(perc == 0)
            return ora + ":" + perc + "0";
        else
            return ora + ":" + perc;
    }
}
