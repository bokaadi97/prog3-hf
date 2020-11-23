import javax.swing.*;
import java.awt.*;

public class VasarlasAblak extends JFrame {
    private Fokepernyo szulo;
    private JButton ok;

    VasarlasAblak(){//Fokepernyo szulo){
        //this.szulo = szulo;
        setSize(350, 120);
        setTitle("Vásárlás");

        ok = new JButton("Ok");

        JPanel jp = new JPanel(new SpringLayout());
        jp.add(ok);
        add(jp);


        //ok.addActionListener(new OkButtonActionListener());
    }
}
