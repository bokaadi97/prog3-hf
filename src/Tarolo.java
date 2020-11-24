import javax.swing.table.AbstractTableModel;
import java.io.*;
import java.util.ArrayList;

public class Tarolo extends AbstractTableModel {
    ArrayList<Jegy> lista = new ArrayList<>();

    /*
    void beolvas() throws IOException {
        File file = new File("C:\\Users\\Dell\\Downloads\\hf\\hf\\adat.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String sor;
        while ((sor = br.readLine()) != null){
            String[] arrOfStr = sor.split("\t", 7);
            Jegy j = new Jegy(arrOfStr[0], arrOfStr[1], parseInt(arrOfStr[2]), parseInt(arrOfStr[3]),
                    parseInt(arrOfStr[4]), parseInt(arrOfStr[5]), parseDouble(arrOfStr[6]));
            lista.add(j);
        }
    }
    */

    void idInicializalas(){
        int max = 0;
        for(int i = 0; i < lista.size(); i++){
            if(max < lista.get(i).getVonatszam()){
                max = lista.get(i).getVonatszam();
            }
        }
        Jegy j = new Jegy();
        j.setId(++max);
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

    //String toString(int i){
    //    return lista.get(i).getIndulasHelye() + " " + lista.get(i).getErkezesHelye();
    //}

    void kilistaz(){
        for(int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i).getIndulasHelye() + " " + lista.get(i).getErkezesHelye() + " " + lista.get(i).getIndulasIdeje() + " "
                            + lista.get(i).getErkezesIdeje() + " " + lista.get(i).getVagonokSzama() + " " + lista.get(i).getFerohely() + " "
                            + lista.get(i).getAr() + " - ID: " + lista.get(i).getVonatszam());
        }
        System.out.println("\n\n");
    }

    void hozzaad(Jegy j){
        lista.add(j);
    }

    void torol(int id){
        for(int i = 0; i < lista.size(); i++)
            if(lista.get(i).getVonatszam() == id)
                lista.remove(i);
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Jegy jegy = lista.get(rowIndex);
        switch(columnIndex) {
            case 1: return jegy.getIndulasHelye();
            case 2: return jegy.getErkezesHelye();
            case 3: return jegy.getIndulasIdeje();
            case 4: return jegy.getErkezesIdeje();
            case 5: return jegy.getVagonokSzama();
            case 6: return jegy.getFerohely();
            case 7: return jegy.getAr();
            default: return jegy.getVonatszam();
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
