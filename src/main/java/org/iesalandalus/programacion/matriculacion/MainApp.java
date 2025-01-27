package org.iesalandalus.programacion.matriculacion;

import org.iesalandalus.programacion.matriculacion.controlador.Controlador;
import org.iesalandalus.programacion.matriculacion.modelo.Modelo;
import org.iesalandalus.programacion.matriculacion.vista.Vista;

public class MainApp{
    public static void main(String[] args) {
        // Crear las instancias de Modelo, Vista y Controlador
        Modelo modelo = new Modelo();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(modelo, vista);

        // Pasar el controlador a la vista
        vista.setControlador(controlador);

        // Iniciar la aplicación
        controlador.comenzar();
    }

}
