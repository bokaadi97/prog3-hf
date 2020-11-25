import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;

public class VasarlasAblak extends JFrame {
    private Fokepernyo szulo;
    private JTextField vonatszam, vonatszamSzoveg, dbSzoveg, kedv33, kedv33Szoveg, kedv50, kedv50Szoveg, kedv90, kedv90Szoveg;
    private JButton ok;

    VasarlasAblak(Fokepernyo szulo){
        super("Menetjegy vásárlás");
        setSize(500, 200);
        setResizable(false);

        this.szulo = szulo;

        vonatszamSzoveg = new JTextField("Hányas számú vonatra szeretnél jegyet venni?");
        vonatszamSzoveg.setEditable(false);
        dbSzoveg = new JTextField("Hány darabot szeretnél venni az alábbi jegytípusokból?");
        dbSzoveg.setEditable(false);
        kedv33Szoveg = new JTextField("33% (26 éven aluli/családi kedv.)");
        kedv33Szoveg.setEditable(false);
        kedv50Szoveg = new JTextField("50% (diák/nyugdíjas)");
        kedv50Szoveg.setEditable(false);
        kedv90Szoveg = new JTextField("90% (munkanélküli/nagycsaládos)");
        kedv90Szoveg.setEditable(false);

        vonatszam = new JTextField();
        kedv33 = new JTextField();
        kedv50 = new JTextField();
        kedv90 = new JTextField();

        ok = new JButton("Vásárlás");
        ok.addActionListener(new OkButtonActionListener());


        JPanel panel = new JPanel();
        add(panel);
        GroupLayout gl = new GroupLayout(panel);
        panel.setLayout(gl);



        gl.setHorizontalGroup(gl.createSequentialGroup()
                //első oszlop fentről lefelé
                .addGroup(gl.createParallelGroup()
                        .addComponent(vonatszamSzoveg)
                        .addComponent(dbSzoveg)
                        .addComponent(kedv33Szoveg)
                        .addComponent(kedv50Szoveg)
                        .addComponent(kedv90Szoveg)
                )
                //második oszlop fentről lefelé
                .addGroup(gl.createParallelGroup()
                        .addComponent(vonatszam)
                        .addComponent(kedv33)
                        .addComponent(kedv50)
                        .addComponent(kedv90)
                        .addComponent(ok)
                )
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                //első sor fentről lefelé
                .addGroup(gl.createParallelGroup()
                        .addComponent(vonatszamSzoveg)
                        .addComponent(vonatszam)
                )
                //második sor fentről lefelé
                .addGroup(gl.createParallelGroup()
                        .addComponent(dbSzoveg)
                )
                .addGroup(gl.createParallelGroup()
                        .addComponent(kedv33Szoveg)
                        .addComponent(kedv33)
                )
                .addGroup(gl.createParallelGroup()
                        .addComponent(kedv50Szoveg)
                        .addComponent(kedv50)
                )
                .addGroup(gl.createParallelGroup()
                        .addComponent(kedv90Szoveg)
                        .addComponent(kedv90)
                )
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(ok)
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
            if(!vonatszam.getText().isEmpty() && !kedv33.getText().isEmpty()){
                szulo.getKosar().kosarbaTesz(szulo.getTarolo(), parseInt(vonatszam.getText()), 33, parseInt(kedv33.getText()));
            } else if(!vonatszam.getText().isEmpty() && !kedv50.getText().isEmpty()){
                szulo.getKosar().kosarbaTesz(szulo.getTarolo(), parseInt(vonatszam.getText()), 50, parseInt(kedv50.getText()));
            } else if(!vonatszam.getText().isEmpty() && !kedv90.getText().isEmpty()){
                szulo.getKosar().kosarbaTesz(szulo.getTarolo(), parseInt(vonatszam.getText()), 90, parseInt(kedv90.getText()));
            }
            else JOptionPane.showMessageDialog(szulo, "Hiányzó adatok", "Warning", JOptionPane.WARNING_MESSAGE);
            for(int i = 0; i < szulo.getKosar().getKosar().size(); i++){
                szulo.getKosar().getKosar().get(i).kiir();
            }
            VasarlasAblak.this.dispose();
        }

    }

}
