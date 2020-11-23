import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Tarolo {
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
            if(max < lista.get(i).getId()){
                max = lista.get(i).getId();
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

    void hozzaad(){
        Scanner in = new Scanner(System.in);
        System.out.print("Indulas helye: ");
        String iH = in.nextLine();
        System.out.print("Erkezes helye: ");
        String eH = in.nextLine();
        System.out.print("Indulas ideje: ");
        int iI  = in.nextInt();
        System.out.print("Erkezes ideje: ");
        int eI = in.nextInt();
        System.out.print("Vagonok szama: ");
        int vSz = in.nextInt();
        System.out.print("Ferohelyek szama vagononkent: ");
        int f = in.nextInt();
        System.out.print("Jegy ara: ");
        double a = in.nextDouble();
        Jegy j = new Jegy(iH, eH, iI, eI, vSz, f, a);
        lista.add(j);
    }

    void torol(int id){
        for(int i = 0; i < lista.size(); i++)
            if(lista.get(i).getVonatszam() == id)
                lista.remove(i);
    }

}
