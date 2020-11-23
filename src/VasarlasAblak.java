import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class VasarlasAblak extends JFrame {
    private Tarolo data;
    private Fokepernyo szulo;



    private JTextField szoveg1, szoveg2, nev, kod;
    private JCheckBox bentiek;
    private JButton keres, torles;
    private JPanel also;
    private JTable tablazat;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private TableRowSorter<DefaultTableModel> sorter;
    
    
    VasarlasAblak(Fokepernyo szulo){
        super("Vásárlás");
        this.szulo = szulo;
        data = szulo.tarolo;

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        /* Induláskor betöltjük az adatokat
        try {
            data = szulo.tarolo;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"));
            data.students = (List<Student>)ois.readObject();
            ois.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        // Bezáráskor mentjük az adatokat
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"));
                    oos.writeObject(data.students);
                    oos.close();
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        */

        // Felépítjük az ablakot
        setMinimumSize(new Dimension(500, 200));

        this.setLayout(new BorderLayout());
        JTable table = new JTable(data);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        add(scrollPane, BorderLayout.CENTER);







    }
}
