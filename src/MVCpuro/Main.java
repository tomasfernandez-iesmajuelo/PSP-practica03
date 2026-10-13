import controlador.ControladorClientes;
import javax.swing.SwingUtilities;
import modelo.Cliente;
import modelo.GestorClientes;
import vista.VistaClientes;

/** Solo ensambla: crea los datos, la vista y el controlador, y los conecta. */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GestorClientes modelo = new GestorClientes();
            modelo.añadir(new Cliente("Ana López", 34));
            modelo.añadir(new Cliente("Luis Pérez", 52));
            modelo.añadir(new Cliente("Marta Ruiz", 28));
            modelo.añadir(new Cliente("Pablo Gómez", 41));
            modelo.añadir(new Cliente("Lucía Torres", 19));

            VistaClientes vista = new VistaClientes();
            new ControladorClientes(modelo, vista);
            vista.setVisible(true);
        });
    }
}
