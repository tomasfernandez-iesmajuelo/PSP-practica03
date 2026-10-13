package ejemploMenuPaneles;

import javax.swing.*;
import java.awt.*;

/**
 * JFrame principal: tiene un menú (Panel A, Panel B, Salir) y usa CardLayout
 * para mostrar un panel u otro. También es quien "conecta" A con B.
 */
public class VentanaPrincipal extends JFrame {

    private static final String CARTA_A = "PANEL_A";
    private static final String CARTA_B = "PANEL_B";

    private final CardLayout cardLayout = new CardLayout();
    private final JPanel contenedor = new JPanel(cardLayout);

    // Se crean UNA sola vez, así conservan su estado al cambiar de panel
    private final PanelA panelA = new PanelA();
    private final PanelB panelB = new PanelB();

    public VentanaPrincipal() {
        super("Ejemplo de paneles en Swing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        contenedor.add(panelA, CARTA_A);
        contenedor.add(panelB, CARTA_B);
        add(contenedor);

        setJMenuBar(crearMenu());

        setSize(500, 350);
        setLocationRelativeTo(null);   // centrar en pantalla
    }

    private JMenuBar crearMenu() {
        JMenuItem itemA = new JMenuItem("Panel A");
        JMenuItem itemB = new JMenuItem("Panel B");
        JMenuItem itemSalir = new JMenuItem("Salir");

        itemA.addActionListener(e -> cardLayout.show(contenedor, CARTA_A));
// Sin Java Lambda        
//        itemA.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                cardLayout.show(contenedor, CARTA_A);
//            }
//        });
        
        

        itemB.addActionListener(e -> {
            // PASO DE DATOS: antes de mostrar B, le entregamos el número de A
            panelB.setNumero(panelA.getNumero());
            cardLayout.show(contenedor, CARTA_B);
        });

        itemSalir.addActionListener(e -> System.exit(0));

        JMenu menu = new JMenu("Menú");
        menu.add(itemA);
        menu.add(itemB);
        menu.addSeparator();
        menu.add(itemSalir);

        JMenuBar barra = new JMenuBar();
        barra.add(menu);
        return barra;
    }

    public static void main(String[] args) {
        // Swing debe crearse en el hilo de eventos (EDT)
        SwingUtilities.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }
}
