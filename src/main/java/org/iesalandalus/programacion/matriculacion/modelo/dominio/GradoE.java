package org.iesalandalus.programacion.matriculacion.modelo.dominio;

public class GradoE extends Grado {
        private String nombre;
        private final int numAnos = 1; // Siempre será 1

        // Constructor
        public GradoE(String modalidad) {
            setNombre(nombre);
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

        // Getter para el número de años (no hay setter porque es fijo)
        public int getNumAnos() {
            return numAnos;
        }

        // Metodo toString para representar la información del grado
        @Override
        public String toString() {
            return String.format("%s (%d año)", nombre, numAnos);
        }

}
