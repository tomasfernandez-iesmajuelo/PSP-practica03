package ejemploMenuPaneles;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Panel A: genera un número aleatorio al pulsar un botón
 * y lo guarda para que otros componentes puedan consultarlo.
 */
public class PanelA extends JPanel {

    private final JLabel etiquetaNumero = new JLabel("Pulsa el botón", SwingConstants.CENTER);
    private final JButton botonGenerar = new JButton("Generar número aleatorio");
    private final Random random = new Random();

    // Dato que se compartirá con el panel B (null = aún no generado)
    private Integer numero = null;

    public PanelA() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        etiquetaNumero.setFont(new Font("SansSerif", Font.BOLD, 48));

        JPanel zonaBoton = new JPanel();
        zonaBoton.add(botonGenerar);

        add(new JLabel("Panel A", SwingConstants.CENTER), BorderLayout.NORTH);
        add(etiquetaNumero, BorderLayout.CENTER);
        add(zonaBoton, BorderLayout.SOUTH);

        botonGenerar.addActionListener(e -> {
            numero = random.nextInt(1000) + 1;   // entre 1 y 1000
            etiquetaNumero.setText(String.valueOf(numero));
        });
    }

    /** Getter: así otros componentes leen el dato sin tocar la lógica interna. */
    public Integer getNumero() {
        return numero;
    }
}
