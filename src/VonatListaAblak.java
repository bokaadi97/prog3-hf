import javax.swing.*;
import java.awt.*;

public class VonatListaAblak extends JFrame {
    private Tarolo adat;

    VonatListaAblak(Fokepernyo szulo){
        super("Vonatok listája");
        adat = szulo.getTarolo();

        setSize(new Dimension(500, 200));

        this.setLayout(new BorderLayout());
        JTable table = new JTable(adat);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        add(scrollPane, BorderLayout.CENTER);
    }
}
