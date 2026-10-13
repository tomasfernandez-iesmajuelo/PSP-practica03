package vista;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * VISTA: ventana que muestra un cliente cada vez.
 * Solo dibuja y expone métodos. No tiene lógica ni conoce la clase Cliente.
 */
public class VistaClientes extends JFrame {
    private final JLabel lblPosicion = new JLabel("", SwingConstants.CENTER);
    private final JLabel lblNombre = new JLabel();
    private final JLabel lblEdad = new JLabel();
    private final JButton btnAnterior = new JButton("< Anterior");
    private final JButton btnSiguiente = new JButton("Siguiente >");

    public VistaClientes() {
        super("Clientes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel datos = new JPanel(new GridLayout(2, 2, 8, 8));
        datos.add(new JLabel("Nombre:"));
        datos.add(lblNombre);
        datos.add(new JLabel("Edad:"));
        datos.add(lblEdad);

        JPanel botones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        botones.add(btnAnterior);
        botones.add(btnSiguiente);

        add(lblPosicion, BorderLayout.NORTH);
        add(datos, BorderLayout.CENTER);
        add(botones, BorderLayout.SOUTH);

        setSize(380, 220);
        setLocationRelativeTo(null);
    }

    public void mostrarCliente(String nombre, String edad, int posicion, int total) {
        lblPosicion.setText("Cliente " + posicion + " de " + total);
        lblNombre.setText(nombre);
        lblEdad.setText(edad);
    }

    /** El controlador decide qué botones tienen sentido; la vista solo obedece. */
    public void setNavegacion(boolean puedeRetroceder, boolean puedeAvanzar) {
        btnAnterior.setEnabled(puedeRetroceder);
        btnSiguiente.setEnabled(puedeAvanzar);
    }

    // La vista solo avisa de que "se pulsó algo"
    public void addAnteriorListener(ActionListener l) { btnAnterior.addActionListener(l); }
    public void addSiguienteListener(ActionListener l) { btnSiguiente.addActionListener(l); }
}
