import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fokepernyo extends JFrame {
    Tarolo tarolo;
    private JMenuItem kilepes, vasarlas, jonmegy, ujszemely, szemelylista, nyitzar, szekrenylista;
    private JMenu app, jegy, szekrenyek;
    private JMenuBar menu;
    //private JButton jonmegyb, nyitzarb;

    Fokepernyo(Tarolo t){
        super("ELVIRA");
        tarolo = t;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(640, 480);
        menuSetup();
        //panelSetup();
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


        szekrenyek = new JMenu("Szekrények");
        nyitzar = new JMenuItem("Szekrény kezelése...");
        nyitzar.setActionCommand("nyitzar");
        //nyitzar.addActionListener(new ElemActionListener());
        szekrenyek.add(nyitzar);
        szekrenylista = new JMenuItem("Szekrények listája...");
        szekrenylista.setActionCommand("szekrenylista");
        //szekrenylista.addActionListener(new ElemActionListener());
        szekrenyek.add(szekrenylista);
        menu.add(szekrenyek);
        this.setJMenuBar(menu);

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
                case "vasarlas":
                    VasarlasAblak va = new VasarlasAblak(Fokepernyo.this);
                    va.setVisible(true);
                    break;

                    /*
                case "jonmegy":
                    JonMegyWindow jonMegyWindow = new JonMegyWindow(MainWindow.this);
                    jonMegyWindow.setVisible(true);
                    break;
                case "ujszemely":
                    UjszemelyWindow ujszemelyWindow = new UjszemelyWindow(MainWindow.this);
                    ujszemelyWindow.setVisible(true);
                    break;
                case "szemelylista":
                    SzemelylistaWindow szemelylistaWindow = new SzemelylistaWindow(MainWindow.this);
                    szemelylistaWindow.setVisible(true);
                    break;
                case "nyitzar":
                    NyitzarWindow nyitzarWindow = new NyitzarWindow(MainWindow.this);
                    nyitzarWindow.setVisible(true);
                    break;
                case "szekrenylista":
                    SzekrenylistaWindow szekrenylistaWindow = new SzekrenylistaWindow(MainWindow.this);
                    szekrenylistaWindow.setVisible(true);
                    break;

                     */
            }
        }
    }



}
