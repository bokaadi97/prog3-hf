import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Fokepernyo extends JFrame {
    private Tarolo tarolo;
    private Kosar kosar;
    private JMenuItem kilepes, vasarlas, hozzaad, torol, listaz;
    private JMenu app, jegy, vonat;
    private JMenuBar menu;
    private JButton vasarlas2, kilepes2;

    Tarolo getTarolo(){return tarolo;}
    Kosar getKosar(){return kosar;}

    Fokepernyo() throws IOException, ClassNotFoundException {
        super("ELVIRA");
        tarolo = new Tarolo();
        tarolo.beolvas();

        kosar = new Kosar();
/*
        kosar.kosarbaTesz(tarolo, 1, 10);
        kosar.kosarbaTesz(tarolo, 0, 0);
        for(int i = 0; i < kosar.getKosar().size(); i++){
            kosar.getKosar().get(i).kiir();
        }
*/
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(640, 480);
        //setResizable(false);
        menuSetup();
    }

    private void menuSetup(){
        menu = new JMenuBar();
        app = new JMenu("Jegyautomata");
        kilepes = new JMenuItem("Kilépés");
        kilepes.setActionCommand("exit");
        kilepes.addActionListener(new ElemActionListener());
        app.add(kilepes);
        menu.add(app);



        jegy = new JMenu("Menetjegy");
        vasarlas = new JMenuItem("Vásárlás");
        vasarlas.setActionCommand("vasarlas");
        vasarlas.addActionListener(new ElemActionListener());
        jegy.add(vasarlas);
        menu.add(jegy);


        vonat = new JMenu("Vonatok kezelése");
        hozzaad = new JMenuItem("Új vonat hozzáadása");
        hozzaad.setActionCommand("hozzaad");
        hozzaad.addActionListener(new ElemActionListener());
        vonat.add(hozzaad);
        torol = new JMenuItem("Vonat törlése");
        torol.setActionCommand("torol");
        torol.addActionListener(new ElemActionListener());
        vonat.add(torol);
        listaz = new JMenuItem("Vonatok listázása");
        listaz.setActionCommand("listaz");
        listaz.addActionListener(new ElemActionListener());
        vonat.add(listaz);


        menu.add(vonat);
        this.setJMenuBar(menu);


        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5,5,5,5);
        vasarlas2 = new JButton("Menetjegy vásárlása");
        vasarlas2.setActionCommand("vasarlas");
        vasarlas2.addActionListener(new ElemActionListener());
        c.gridx = 0; c.gridy = 0;
        panel.add(vasarlas2, c);
        kilepes2 = new JButton("Kilépés");
        kilepes2.setActionCommand("exit");
        kilepes2.addActionListener(new ElemActionListener());
        c.gridx = 0; c.gridy = 1; c.gridwidth = 2;
        panel.add(kilepes2, c);
        add(panel);

    }

    public class ElemActionListener implements ActionListener {
        /**
         * Megjeleníti a kívánt funkcióhoz tartozó ablakot, vagy bezárja a programot.
         * @param e
         * */
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()){
                case "exit":
                    System.exit(0);
                    break;
                case "listaz":
                    VonatListaAblak vla = new VonatListaAblak(Fokepernyo.this);
                    vla.setVisible(true);
                    break;
                case "vasarlas":
                    VasarlasAblak va = new VasarlasAblak(Fokepernyo.this);
                    va.setVisible(true);
                    break;
                case "hozzaad":
                    UjVonatAblak uva = new UjVonatAblak(Fokepernyo.this);
                    uva.setVisible(true);
                    break;
                case "torol":
                    VonatTorlesAblak vta = new VonatTorlesAblak(Fokepernyo.this);
                    vta.setVisible(true);
                    break;
            }
        }
    }



}
