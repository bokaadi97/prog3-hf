import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KosarAblak extends JFrame {
    private Fokepernyo szulo;
    private JPanel also;
    private JTextField vegosszeg, vegosszegSzoveg;
    private JButton fizetes, torles;

    KosarAblak(Fokepernyo szulo){
        super("Kosár");
        this.szulo = szulo;
        Kosar adat = szulo.getKosar();

        setSize(new Dimension(500, 200));

        this.setLayout(new BorderLayout());
        JTable table = new JTable(adat);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        add(scrollPane, BorderLayout.CENTER);

        vegosszegSzoveg = new JTextField("Végösszeg:");
        vegosszegSzoveg.setEditable(false);
        vegosszeg = new JTextField(adat.osszegez() + "Ft");
        vegosszeg.setEditable(false);

        fizetes = new JButton("Fizetés");
        fizetes.addActionListener(new FizetesButtonActionListener());
        torles =new JButton("Kosár törlése");
        torles.addActionListener(new TorlesButtonActionListener());

        also = new JPanel();
        GroupLayout gl = new GroupLayout(also);
        also.setLayout(gl);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                //első oszlop fentről lefelé
                .addGroup(gl.createParallelGroup()
                        .addComponent(vegosszegSzoveg)
                        .addComponent(torles)
                )
                //második oszlop fentről lefelé
                .addGroup(gl.createParallelGroup()
                        .addComponent(vegosszeg)
                        .addComponent(fizetes)
                )
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                //első sor fentről lefelé
                .addGroup(gl.createParallelGroup()
                        .addComponent(vegosszegSzoveg)
                        .addComponent(vegosszeg)
                )
                //második sor fentről lefelé
                .addGroup(gl.createParallelGroup()
                        .addComponent(torles)
                        .addComponent(fizetes)
                )
        );

        add(also, BorderLayout.SOUTH);

    }

    private class TorlesButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            szulo.getKosar().kosarUrites(szulo.getTarolo());
            KosarAblak.this.dispose();
        }

    }

    private class FizetesButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            szulo.getKosar().kosarTorles();
            KosarAblak.this.dispose();
            JOptionPane.showMessageDialog(szulo, "Kérem fizessen, majd vegye el jegyét!\nKellemes utazást!");
        }

    }
}
