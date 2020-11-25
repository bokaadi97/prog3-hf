import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VonatListaAblak extends JFrame {
    private Fokepernyo szulo;
    private Tarolo tarolo;
    private JPanel also;
    private JButton torles;
    private JTable table;

    VonatListaAblak(Fokepernyo szulo){
        super("Vonatok listája");
        this.szulo=szulo;
        tarolo = szulo.getTarolo();

        setSize(new Dimension(500, 200));

        this.setLayout(new BorderLayout());
        table = new JTable(tarolo);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        add(scrollPane, BorderLayout.CENTER);

        torles = new JButton("Törlés");
        torles.addActionListener(new TorlesButtonActionListener());
        also = new JPanel();
        GroupLayout gl = new GroupLayout(also);
        also.setLayout(gl);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                //első oszlop fentről lefelé
                .addGroup(gl.createParallelGroup()
                        .addComponent(torles)
                )
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                //első sor fentről lefelé
                .addGroup(gl.createParallelGroup()
                        .addComponent(torles)
                )

        );

        add(also, BorderLayout.SOUTH);

    }

    private class TorlesButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int sor = table.getSelectedRow();
            int vonatszam = (int) table.getModel().getValueAt(sor, 0);
            szulo.getTarolo().torol(vonatszam);
            try {
                szulo.getTarolo().mentes();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

}
