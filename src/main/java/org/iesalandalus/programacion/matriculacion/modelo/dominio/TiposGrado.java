package org.iesalandalus.programacion.matriculacion.modelo.dominio;

public enum TiposGrado {
        MEDIO("Grado Medio"),
        SUPERIOR("Grado Superior");

        private final String descripcion;

        private TiposGrado(String descripcion) {
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
