import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;

public class VasarlasAblak extends JFrame {
    private Fokepernyo szulo;
    private JTextField vonatszam, vonatszamSzoveg, dbSzoveg, teljes, teljesSzoveg, kedv33, kedv33Szoveg, kedv50, kedv50Szoveg, kedv90, kedv90Szoveg;
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
        teljesSzoveg = new JTextField("Teljes árú");
        teljesSzoveg.setEditable(false);
        kedv33Szoveg = new JTextField("33% kedvezmény(26 éven aluli/családi)");
        kedv33Szoveg.setEditable(false);
        kedv50Szoveg = new JTextField("50% kedvezmény(diák/nyugdíjas)");
        kedv50Szoveg.setEditable(false);
        kedv90Szoveg = new JTextField("90% kedvezmény(munkanélküli/nagycsaládos)");
        kedv90Szoveg.setEditable(false);

        vonatszam = new JTextField();
        teljes =new JTextField();
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
                        .addComponent(teljesSzoveg)
                        .addComponent(kedv33Szoveg)
                        .addComponent(kedv50Szoveg)
                        .addComponent(kedv90Szoveg)
                )
                //második oszlop fentről lefelé
                .addGroup(gl.createParallelGroup()
                        .addComponent(vonatszam)
                        .addComponent(teljes)
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
                        .addComponent(teljesSzoveg)
                        .addComponent(teljes)
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
         *
         * @param e
         * */
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                if(!vonatszam.getText().isEmpty()){
                    szulo.getTarolo().vonatKereseseVonatszamAlapjan(parseInt(vonatszam.getText()));
                }

                try {
                    if(!vonatszam.getText().isEmpty() && !teljes.getText().isEmpty() &&
                            !szulo.getTarolo().vonatKereseseVonatszamAlapjan(parseInt(vonatszam.getText())).tultelnee(parseInt(teljes.getText()))
                    ){
                        szulo.getKosar().kosarbaTesz(szulo.getTarolo(), parseInt(vonatszam.getText()), 0, parseInt(teljes.getText()));
                        szulo.getTarolo().vonatKereseseVonatszamAlapjan(parseInt(vonatszam.getText())).setTelitettseg(
                                szulo.getTarolo().vonatKereseseVonatszamAlapjan(parseInt(vonatszam.getText())).getTelitettseg() + parseInt(teljes.getText())
                        );
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(szulo, "Sajnos már elfogytak a szabad jegyek!", "Sikertelen vásárlás(Teljes áru)", JOptionPane.ERROR_MESSAGE);
                    exception.printStackTrace();
                }
                try {
                    if(!vonatszam.getText().isEmpty() && !kedv33.getText().isEmpty() &&
                            !szulo.getTarolo().vonatKereseseVonatszamAlapjan(parseInt(vonatszam.getText())).tultelnee(parseInt(kedv33.getText()))){
                        szulo.getKosar().kosarbaTesz(szulo.getTarolo(), parseInt(vonatszam.getText()), 33, parseInt(kedv33.getText()));
                        szulo.getTarolo().vonatKereseseVonatszamAlapjan(parseInt(vonatszam.getText())).setTelitettseg(
                                szulo.getTarolo().vonatKereseseVonatszamAlapjan(parseInt(vonatszam.getText())).getTelitettseg() + parseInt(kedv33.getText())
                        );
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(szulo, "Sajnos már elfogytak a szabad jegyek!", "Sikertelen vásárlás(33%-os)", JOptionPane.ERROR_MESSAGE);
                    exception.printStackTrace();
                }
                try {
                    if(!vonatszam.getText().isEmpty() && !kedv50.getText().isEmpty() &&
                            !szulo.getTarolo().vonatKereseseVonatszamAlapjan(parseInt(vonatszam.getText())).tultelnee(parseInt(kedv50.getText()))){
                        szulo.getKosar().kosarbaTesz(szulo.getTarolo(), parseInt(vonatszam.getText()), 50, parseInt(kedv50.getText()));
                        szulo.getTarolo().vonatKereseseVonatszamAlapjan(parseInt(vonatszam.getText())).setTelitettseg(
                                szulo.getTarolo().vonatKereseseVonatszamAlapjan(parseInt(vonatszam.getText())).getTelitettseg() + parseInt(kedv50.getText())
                        );
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(szulo, "Sajnos már elfogytak a szabad jegyek!", "Sikertelen vásárlás(50%-os)", JOptionPane.ERROR_MESSAGE);
                    exception.printStackTrace();
                }
                try {
                    if(!vonatszam.getText().isEmpty() && !kedv90.getText().isEmpty() &&
                            !szulo.getTarolo().vonatKereseseVonatszamAlapjan(parseInt(vonatszam.getText())).tultelnee(parseInt(kedv90.getText()))){
                        szulo.getKosar().kosarbaTesz(szulo.getTarolo(), parseInt(vonatszam.getText()), 90, parseInt(kedv90.getText()));
                        szulo.getTarolo().vonatKereseseVonatszamAlapjan(parseInt(vonatszam.getText())).setTelitettseg(
                                szulo.getTarolo().vonatKereseseVonatszamAlapjan(parseInt(vonatszam.getText())).getTelitettseg() + parseInt(kedv90.getText())
                        );
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(szulo, "Sajnos már elfogytak a szabad jegyek!", "Sikertelen vásárlás(90%os)", JOptionPane.ERROR_MESSAGE);
                    exception.printStackTrace();
                }

                VasarlasAblak.this.dispose();
            } catch (IllegalArgumentException iae) {
                JOptionPane.showMessageDialog(szulo, "Nem létezik ilyen számú vonat!", "Vonatszám hiba", JOptionPane.ERROR_MESSAGE);
            }


        }

    }

}
