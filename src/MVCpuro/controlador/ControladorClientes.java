package controlador;

import modelo.Cliente;
import modelo.GestorClientes;
import vista.VistaClientes;

/** CONTROLADOR: lleva el índice del cliente actual y conecta modelo y vista. */
public class ControladorClientes {
    private final GestorClientes modelo;
    private final VistaClientes vista;
    private int indice = 0;

    public ControladorClientes(GestorClientes modelo, VistaClientes vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.addAnteriorListener(e -> { indice--; mostrar(); });
        this.vista.addSiguienteListener(e -> { indice++; mostrar(); });
        mostrar();   // pinta el primer cliente al arrancar
    }

    private void mostrar() {
        Cliente c = modelo.get(indice);
        vista.mostrarCliente(c.getNombre(), String.valueOf(c.getEdad()), indice + 1, modelo.total());
        vista.setNavegacion(indice > 0, indice < modelo.total() - 1);
    }
}
