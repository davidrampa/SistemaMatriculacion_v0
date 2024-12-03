package org.iesalandalus.programacion.matriculacion.dominio;

public enum EspecialidadProfesorado {
    INFORMATICA("Informática"),
    SISTEMAS_Y_APLICACIONES_INFORMATICAS("Sistemas y Aplicaciones Informáticas"),
    FORMACION_Y_ORIENTACION_LABORAL("Formación y Orientación Laboral");

    // Atributo que almacena la representación textual de la especialidad
    private final String cadenaAMostrar;


    EspecialidadProfesorado(String cadenaAMostrar) {
        this.cadenaAMostrar = cadenaAMostrar;
    }

    public String imprimir() {
        return String.format("%d.-%s", this.ordinal(), this.cadenaAMostrar);
    }


    @Override
    public String toString() {
        return cadenaAMostrar;
    }
}


