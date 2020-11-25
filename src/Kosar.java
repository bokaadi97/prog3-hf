import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class Kosar extends AbstractTableModel {
    private ArrayList<Jegy> kosar = new ArrayList<>();

    //ArrayList<Jegy> getKosar(){return kosar;}

    void kosarUrites(){
            kosar.clear();
    }

    void kosarbaTesz(Tarolo t, int vonatszam, int kedvezmeny, int darab){
        for(int i = 0; i < darab; i++) {
            Vonat v = t.vonatKereseseVonatszamAlapjan(vonatszam);
            kosar.add(new Jegy(v, kedvezmeny));
        }
    }

    String osszegez(){
        double vegosszeg = 0;
        for(int i = 0; i < kosar.size(); i++){
            vegosszeg += kosar.get(i).getKedvezmenyesAr();
        }
        String s;
        return s = String.valueOf(vegosszeg);
    }

    @Override
    public int getRowCount() {
        return kosar.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Jegy j = kosar.get(rowIndex);
        switch(columnIndex) {
            case 0: return j.getVonat().getIndulasHelye();
            case 1: return j.getVonat().getErkezesHelye();
            case 2: return j.getVonat().getIndulasIdeje();
            case 3: return j.getVonat().getErkezesIdeje();
            default: return j.getKedvezmenyesAr();
        }
    }


    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "Indulás helye";
            case 1:
                return "Érkezés helye";
            case 2:
                return "Indulás ideje";
            case 3:
                return "Érkezés ideje";
            default:
                return "Ár";
        }
    }


    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0:
            case 1:
                return String.class;
            case 2:
            case 3:
                return Integer.class;
            default:
                return Double.class;
        }
    }



    /*
    void kosarbaTesz(Tarolo t, int vonatszam, int darab){
        for(int i = 0; i < darab; i++)
            kosar.add(t.lista.get(vonatszam));
    }


    void kilistaz(){
        for(int i = 0; i < kosar.size(); i++){
            System.out.println(kosar.get(i).getIndulasHelye() + " " + kosar.get(i).getErkezesHelye() + " " + kosar.get(i).getIndulasIdeje() + " "
                    + kosar.get(i).getErkezesIdeje() + " " + kosar.get(i).getVagonokSzama() + " " + kosar.get(i).getFerohely() + " "
                    + kosar.get(i).getAr() + " - ID: " + kosar.get(i).getVonatszam()// + "  kedvezmeny: " + kosar.get(i).getKedvezmeny()
            );
        }
        System.out.println("\n\n");
    }

    void osszegez(){
        double vegosszeg=0;
        for(int i = 0; i < kosar.size(); i++){
            vegosszeg += kosar.get(i).getAr();//*(1-kosar.get(i).getKedvezmeny()*0.01);
        }
        System.out.println("A vegosszeg: " + vegosszeg);
    }

    */

}
