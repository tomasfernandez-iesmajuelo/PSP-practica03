package modelo;

/** MODELO: un cliente con nombre y edad. No sabe nada de Swing. */
public class Cliente {
    private String nombre;
    private int edad;

    public Cliente(String nombre, int edad) {
        setNombre(nombre);
        setEdad(edad);
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }

    // Las reglas de negocio viven en el modelo
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        this.nombre = nombre.trim();
    }

    public void setEdad(int edad) {
        if (edad < 0)
            throw new IllegalArgumentException("La edad no puede ser negativa.");
        this.edad = edad;
    }
}
