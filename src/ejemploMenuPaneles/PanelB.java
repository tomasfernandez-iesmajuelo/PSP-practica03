package ejemploMenuPaneles;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Panel B: recibe un número (desde fuera, con setNumero) y,
 * al pulsar el botón, muestra sus divisores e indica si es primo.
 */
public class PanelB extends JPanel {

    private final JLabel etiquetaNumero = new JLabel("Sin número", SwingConstants.CENTER);
    private final JButton botonCalcular = new JButton("Calcular divisores");
    private final JTextArea areaResultado = new JTextArea(6, 30);

    private Integer numero = null;

    public PanelB() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        etiquetaNumero.setFont(new Font("SansSerif", Font.BOLD, 36));

        areaResultado.setEditable(false);
        areaResultado.setLineWrap(true);
        areaResultado.setWrapStyleWord(true);

        JPanel norte = new JPanel(new GridLayout(2, 1));
        norte.add(new JLabel("Panel B", SwingConstants.CENTER));
        norte.add(etiquetaNumero);

        JPanel sur = new JPanel();
        sur.add(botonCalcular);

        add(norte, BorderLayout.NORTH);
        add(new JScrollPane(areaResultado), BorderLayout.CENTER);
        add(sur, BorderLayout.SOUTH);

        botonCalcular.addActionListener(e -> calcular());
    }

    /** Punto de entrada del dato: lo llama quien "conecta" los paneles. */
    public void setNumero(Integer numero) {
        this.numero = numero;
        areaResultado.setText("");
        etiquetaNumero.setText(numero == null ? "Sin número" : String.valueOf(numero));
    }

    private void calcular() {
        if (numero == null) {
            JOptionPane.showMessageDialog(this,
                    "Primero genera un número en el Panel A.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        List<Integer> divisores = new ArrayList<>();
        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                divisores.add(i);
            }
        }

        // Un número es primo si tiene exactamente 2 divisores (1 y él mismo)
        boolean esPrimo = divisores.size() == 2;

        areaResultado.setText("Divisores: " + divisores + "\n\n"
                + (esPrimo ? "Es un número PRIMO." : "NO es un número primo."));
    }
}
