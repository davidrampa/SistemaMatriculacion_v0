package org.iesalandalus.programacion.matriculacion.dominio;

import java.time.LocalDate;

public class Alumno {
    //Constante para el formato de fecha
    public static final String FORMATO_FECHA = "dd/MM/yyyy";

    //Atributos de la clase Alumno
    private String nombre;
    private String telefono;
    private String email;
    private String dni;
    priavte LocalDate fechaNacimiento;
    private String nia;

    public Alumno() {

    }
}
