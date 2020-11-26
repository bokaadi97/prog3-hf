import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class Kosar extends AbstractTableModel {
    private ArrayList<Jegy> kosar = new ArrayList<>();

    void kosarUrites(Tarolo t){
        for(int i = 0; i < kosar.size(); i++){
            int vonatszam = kosar.get(i).getVonat().getVonatszam();
            int telitettseg = t.vonatKereseseVonatszamAlapjan(vonatszam).getTelitettseg();
            t.vonatKereseseVonatszamAlapjan(vonatszam).setTelitettseg(telitettseg - 1);
        }
        kosar.clear();
    }

    void kosarTorles(){
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
        return String.valueOf(vegosszeg);
    }

    @Override
    public int getRowCount() {
        return kosar.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Jegy j = kosar.get(rowIndex);
        switch(columnIndex) {
            case 0: return j.getJegyszam();
            case 1: return j.getVonat().getIndulasHelye();
            case 2: return j.getVonat().getErkezesHelye();
            case 3: return j.getVonat().getIndulasIdeje().toString();
            case 4: return j.getVonat().getErkezesIdeje().toString();
            default: return j.getKedvezmenyesAr();
        }
    }


    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "Sorszám";
            case 1:
                return "Indulás helye";
            case 2:
                return "Érkezés helye";
            case 3:
                return "Indulás ideje";
            case 4:
                return "Érkezés ideje";
            default:
                return "Ár";
        }
    }


    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0: return Integer.class;
            case 5: return Double.class;
            default:
                return String.class;
        }
    }

}
