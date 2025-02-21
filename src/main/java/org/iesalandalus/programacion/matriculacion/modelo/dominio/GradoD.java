package org.iesalandalus.programacion.matriculacion.modelo.dominio;

public class GradoD {
        private String nombre;
        private int numAnos;

        // Constructor
        public GradoD(String nombre, int numAnos) {
            setNombre(nombre);
            setNumAnos(numAnos);
        }

        // Getter para el nombre
        public String getNombre() {
            return nombre;
        }

        // Setter para el nombre con validación
        public void setNombre(String nombre) {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre del grado no puede estar vacío.");
            }
            this.nombre = nombre;
        }

        // Getter para el número de años
        public int getNumAnos() {
            return numAnos;
        }

        // Setter para el número de años con validación
        public void setNumAnos(int numAnos) {
            if (numAnos != 2 && numAnos != 3) {
                throw new IllegalArgumentException("El número de años debe ser 2 o 3.");
            }
            this.numAnos = numAnos;
        }

        // Metodo toString para representar la información del grado
        @Override
        public String toString() {
            return String.format("%s (%d años)", nombre, numAnos);
        }

}
