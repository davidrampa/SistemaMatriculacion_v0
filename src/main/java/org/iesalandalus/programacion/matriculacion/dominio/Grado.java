package org.iesalandalus.programacion.matriculacion.dominio;

public enum Grado {
    BASICO("Grado Basico"),
    MEDIO("Grado Medio"),
    SUPERIOR("Grado Superior");

    private final String cadenaAMostar;

    Grado(String cadenaAMostar) {
        this.cadenaAMostar = cadenaAMostar;
    }

    @Override
    public String toString() {
        return cadenaAMostar;
    }
}
