package org.iesalandalus.programacion.matriculacion.modelo.dominio;

public enum Modalidad {
        PRESENCIAL("Presencial"),
        SEMIPRESENCIAL("Semipresencial");

        private final String descripcion;

        private Modalidad(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getDescripcion() {
            return descripcion;
        }

        @Override
        public String toString() {
            return descripcion;
        }
}
