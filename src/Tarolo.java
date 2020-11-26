import javax.swing.table.AbstractTableModel;
import java.io.*;
import java.util.ArrayList;

public class Tarolo extends AbstractTableModel {
    private ArrayList<Vonat> lista = new ArrayList<>();

    Vonat vonatKereseseVonatszamAlapjan(int vonatszam){
        for(int i = 0; i < lista.size(); i++){
            if(vonatszam == lista.get(i).getVonatszam()){
                return lista.get(i);
            }
        }
        return null;
    }

    /**
     *
     */
    void idInicializalas(){
        int max = 0;
        for(int i = 0; i < lista.size(); i++){
            if(max < lista.get(i).getVonatszam()){
                max = lista.get(i).getVonatszam();
            }
        }
        Vonat v = new Vonat();
        v.setId(++max);
    }

    public void mentes() throws IOException {
        FileOutputStream fos = new FileOutputStream("vonatok.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(lista);
        oos.close();
        fos.close();
    }

    public void beolvas() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("vonatok.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        lista = (ArrayList) ois.readObject();
        ois.close();
        fis.close();
        idInicializalas();
    }

    /*
    void kilistaz(){
        for(int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i).getIndulasHelye() + " " + lista.get(i).getErkezesHelye() + " " + lista.get(i).getIndulasIdeje() + " "
                            + lista.get(i).getErkezesIdeje() + " " + lista.get(i).getVagonokSzama() + " " + lista.get(i).getFerohely() + " "
                            + lista.get(i).getAr() + " - ID: " + lista.get(i).getVonatszam());
        }
        System.out.println("\n\n");
    }
    */

    void hozzaad(Vonat v){
        lista.add(v);
    }

    void torol(int id){
        for(int i = 0; i < lista.size(); i++)
            if(lista.get(i).getVonatszam() == id)
                lista.remove(i);
        fireTableRowsDeleted(0, lista.size() - 1);
    }



    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    /**
     *
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vonat v = lista.get(rowIndex);
        switch(columnIndex) {
            case 1: return v.getIndulasHelye();
            case 2: return v.getErkezesHelye();
            case 3: return v.getIndulasIdeje().toString();
            case 4: return v.getErkezesIdeje().toString();
            case 5: return v.getVagonokSzama();
            case 6: return v.getFerohely();
            case 7: return v.getAr();
            case 8: return v.getTelitettseg();
            default: return v.getVonatszam();
        }
    }


    @Override
    public String getColumnName(int column) {
        switch(column){
            case 1:
                return "Indulás helye";
            case 2:
                return "Érkezés helye";
            case 3:
                return "Indulás ideje";
            case 4:
                return "Érkezés ideje";
            case 5:
                return "Vagonok száma";
            case 6:
                return "Férőhelyek száma";
            case 7:
                return "Ár";
            case 8:
                return "Telítettség";
            default:
                return "Vonat azonosítója";
        }
    }


    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 1:
            case 2:
                return String.class;
            default:
                return Integer.class;
        }
    }


}
