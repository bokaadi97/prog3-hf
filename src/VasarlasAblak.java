import javax.swing.*;
import java.awt.*;

public class VasarlasAblak extends JFrame {
    private Tarolo data;
    private Fokepernyo szulo;
    
    VasarlasAblak(Fokepernyo szulo){
        super("Vásárlás");
        this.szulo = szulo;
        data = szulo.tarolo;

        // Felépítjük az ablakot
        setMinimumSize(new Dimension(500, 200));

        this.setLayout(new BorderLayout());
        JTable table = new JTable(data);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        add(scrollPane, BorderLayout.CENTER);
    }
}
