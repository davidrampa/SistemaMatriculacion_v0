package org.iesalandalus.programacion.matriculacion.modelo.dominio;

public class Grado {
    private String nombre;
    private String iniciales;
    private int numAnos;

    // Constructor
    public Grado(String nombre, int numAnos) {
        setNombre(nombre);
        setNumAnios(numAnos);
    }

    // Metodo getter para obtener el nombre del grado
    public String getNombre() {
        return nombre;
    }

    // Metodo setter para establecer el nombre del grado
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del grado no puede estar vacío.");
        }
        this.nombre = nombre;
        setIniciales(); // Actualiza las iniciales cada vez que se cambia el nombre
    }

    // Metodo privado para establecer las iniciales en mayúsculas
    private void setIniciales() {
        String[] palabras = nombre.split("\\s+"); // Divide el nombre en palabras
        StringBuilder sb = new StringBuilder();
        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                sb.append(Character.toUpperCase(palabra.charAt(0))); // Toma la primera letra
            }
        }
        this.iniciales = sb.toString();
    }

    // Metodo getter para obtener las iniciales
    public String getIniciales() {
        return iniciales;
    }

    // Metodo getter para obtener el número de años
    public int getNumAnios() {
        return numAnos;
    }

    // Metodo setter para establecer el número de años
    public void setNumAnios(int numAnios) {
        if (numAnios <= 0) {
            throw new IllegalArgumentException("El número de años debe ser mayor que 0.");
        }
        this.numAnos = numAnios;
    }

    // Metodo toString para representar la información del grado
    @Override
    public String toString() {
        return String.format("(%s) - %s", iniciales, nombre);
    }
}
