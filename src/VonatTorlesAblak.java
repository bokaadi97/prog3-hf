import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import static java.lang.Integer.parseInt;

public class VonatTorlesAblak extends JFrame {
    private Fokepernyo szulo;
    private JTextField szoveg, id;
    private JButton torles;


    VonatTorlesAblak(Fokepernyo szulo){
        super("Vonat törlése");
        this.szulo = szulo;
        setSize(350, 80);
        setResizable(false);

        szoveg = new JTextField("Hányas számú vonatot törli?");
        szoveg.setEditable(false);
        id = new JTextField();
        torles = new JButton("Törlés!");
        torles.addActionListener(new OkButtonActionListener());

        JPanel panel = new JPanel();
        add(panel);
        GroupLayout gl = new GroupLayout(panel);
        panel.setLayout(gl);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup()
                        .addComponent(szoveg))
                .addGroup(gl.createParallelGroup()
                        .addComponent(id)
                        .addComponent(torles)
                )
        );
        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup()
                        .addComponent(szoveg)
                        .addComponent(id))
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(torles)
                )
        );
    }


    private class OkButtonActionListener implements ActionListener {
        /**
         * Elvégzi egy személy létrehozásának műveletét.
         * @param e
         * */
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!id.getText().isEmpty()){
                szulo.tarolo.torol(parseInt(id.getText()));
                VonatTorlesAblak.this.dispose();
                try {
                    szulo.tarolo.mentes();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                /*try {
                    szulo.tarolo.mentes();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                JOptionPane.showMessageDialog(szulo, "Sikeres művelet.");
                VonatTorlesAblak.this.dispose();*/
            }
            else JOptionPane.showMessageDialog(szulo, "Hiányzó adatok", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
}
