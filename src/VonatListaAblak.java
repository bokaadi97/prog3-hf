import javax.swing.*;
import java.awt.*;

public class VonatListaAblak extends JFrame {
    private Tarolo data;
    //private Fokepernyo szulo;

    VonatListaAblak(Fokepernyo szulo){
        super("Vásárlás");
        //this.szulo = szulo;
        data = szulo.getTarolo();

        // Felépítjük az ablakot
        setSize(new Dimension(500, 200));

        this.setLayout(new BorderLayout());
        JTable table = new JTable(data);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        add(scrollPane, BorderLayout.CENTER);
    }
}
