import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class UjVonatAblak extends JFrame{
    private Fokepernyo szulo;
    private JTextField indulasHelye, erkezesHelye, indulasIdeje, erkezesIdeje, vagonokSzama, ferohely, ar;
    private JTextField indulasHelyeSzoveg, erkezesHelyeSzoveg, indulasIdejeSzoveg, erkezesIdejeSzoveg,
            vagonokSzamaSzoveg, ferohelySzoveg, arSzoveg;
    private JButton ok;

    UjVonatAblak(Fokepernyo szulo){
        super("Új vonat hozzáadása");
        this.szulo = szulo;
        setSize(500, 250);
        setResizable(false);

        indulasHelyeSzoveg = new JTextField("Indulás helye: ");
        indulasHelyeSzoveg.setEditable(false);
        erkezesHelyeSzoveg = new JTextField("Érkezés helye: ");
        erkezesHelyeSzoveg.setEditable(false);
        indulasIdejeSzoveg = new JTextField("Indulás ideje: ");
        indulasIdejeSzoveg.setEditable(false);
        erkezesIdejeSzoveg = new JTextField("Érkezés ideje: ");
        erkezesIdejeSzoveg.setEditable(false);
        vagonokSzamaSzoveg = new JTextField("Vagonok száma: ");
        vagonokSzamaSzoveg.setEditable(false);
        ferohelySzoveg = new JTextField("Férőhelyek száma vagononként: ");
        ferohelySzoveg.setEditable(false);
        arSzoveg = new JTextField("Utazás ára: ");
        arSzoveg.setEditable(false);

        indulasHelye = new JTextField();
        erkezesHelye = new JTextField();
        indulasIdeje = new JTextField();
        erkezesIdeje = new JTextField();
        vagonokSzama = new JTextField();
        ferohely = new JTextField();
        ar = new JTextField();

        ok = new JButton("Mentés");
        ok.addActionListener(new OkButtonActionListener());

        JPanel panel = new JPanel();
        add(panel);
        GroupLayout gl = new GroupLayout(panel);
        panel.setLayout(gl);



        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup()
                        .addComponent(indulasHelyeSzoveg)
                        .addComponent(erkezesHelyeSzoveg)
                        .addComponent(indulasIdejeSzoveg)
                        .addComponent(erkezesIdejeSzoveg)
                        .addComponent(vagonokSzamaSzoveg)
                        .addComponent(ferohelySzoveg)
                        .addComponent(arSzoveg))
                .addGroup(gl.createParallelGroup()
                        .addComponent(indulasHelye)
                        .addComponent(erkezesHelye)
                        .addComponent(indulasIdeje)
                        .addComponent(erkezesIdeje)
                        .addComponent(vagonokSzama)
                        .addComponent(ferohely)
                        .addComponent(ar)
                        .addComponent(ok)
                )
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup()
                        .addComponent(indulasHelyeSzoveg)
                        .addComponent(indulasHelye))
                .addGroup(gl.createParallelGroup()
                        .addComponent(erkezesHelyeSzoveg)
                        .addComponent(erkezesHelye))
                .addGroup(gl.createParallelGroup()
                        .addComponent(indulasIdejeSzoveg)
                        .addComponent(indulasIdeje))
                .addGroup(gl.createParallelGroup()
                        .addComponent(erkezesIdejeSzoveg)
                        .addComponent(erkezesIdeje))
                .addGroup(gl.createParallelGroup()
                        .addComponent(vagonokSzamaSzoveg)
                        .addComponent(vagonokSzama))
                .addGroup(gl.createParallelGroup()
                        .addComponent(ferohelySzoveg)
                        .addComponent(ferohely))
                .addGroup(gl.createParallelGroup()
                        .addComponent(arSzoveg)
                        .addComponent(ar))
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(ok))
        );







    }

    private class OkButtonActionListener implements ActionListener {
        /**
         * Elvégzi egy személy létrehozásának műveletét.
         * @param e
         * */
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!indulasHelye.getText().isEmpty() && !erkezesHelye.getText().isEmpty() && !indulasIdeje.getText().isEmpty() &&
                    !erkezesIdeje.getText().isEmpty() && !vagonokSzama.getText().isEmpty() && !ferohely.getText().isEmpty() &&
                    !ar.getText().isEmpty()){
                Jegy j = new Jegy(
                        indulasHelye.getText(),
                        erkezesHelye.getText(),
                        parseInt(indulasIdeje.getText()),
                        parseInt(erkezesIdeje.getText()),
                        parseInt(vagonokSzama.getText()),
                        parseInt(ferohely.getText()),
                        parseDouble(ar.getText())
                        );
                szulo.tarolo.hozzaad(j);
                try {
                    szulo.tarolo.mentes();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                JOptionPane.showMessageDialog(szulo, "Sikeres művelet.");
                UjVonatAblak.this.dispose();
            }
            else JOptionPane.showMessageDialog(szulo, "Hiányzó adatok", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }



}
