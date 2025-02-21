package org.iesalandalus.programacion.matriculacion.modelo.dominio;

import java.util.Objects;

public class CicloFormativo {

    public static final int MAX_HORAS = 2000;
    public static final String REGEX_IDENTIFICADOR = "\\d{4}";

    private String codigo;
    private String familiaProfesional;
    private Grado grado;
    private String nombre;
    private int horas;

    public CicloFormativo(String codigo, String familiaProfesional, Grado grado, String nombre, int horas) {
        setCodigo(codigo);
        setFamiliaProfesional(familiaProfesional);
        setGrado(grado);
        setNombre(nombre);
        setHoras(horas);
    }
    public CicloFormativo(CicloFormativo otro) {
        this(otro.codigo, otro.familiaProfesional, otro.grado, otro.nombre, otro.horas);
        }

    public CicloFormativo(String codigo, String nombre) {
    }

    public CicloFormativo(String codigo, String nombreFicticio, GradoD presencial) {

    }

    public CicloFormativo(String codigo, String nombre, Grado grado) {

    }

    public CicloFormativo(String codigo, String nombre, GradoE grado) {

    }

    public String getCodigo(){
        return codigo;
    }
    public void setCodigo(String codigo) {
        if (codigo == null || !codigo.matches(REGEX_IDENTIFICADOR)) {
            throw new IllegalArgumentException("El codigo debe ser un número de 4 dígitos.");
        }
        this.codigo = codigo;
    }

    public String getFamiliaProfesional() {
        return familiaProfesional;
    }

    public void setFamiliaProfesional(String familiaProfesional) {
        if (familiaProfesional == null || familiaProfesional.isBlank()) {
            throw new IllegalArgumentException("El nombre de la familia profesional no puede estar vacío.");
        }
        this.familiaProfesional = familiaProfesional.trim();
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        if (grado == null) {
            throw new IllegalArgumentException("El grado no puede ser nulo.");
        }
        this.grado = grado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del ciclo no puede estar vacío.");
        }
        this.nombre = nombre.trim();
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        if (horas <= 0 || horas > MAX_HORAS) {
            throw new IllegalArgumentException("El total de horas debe ser mayor a 0 y menor o igual a " + MAX_HORAS + ".");
        }
        this.horas = horas;
    }

    // Métodos equals y hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CicloFormativo that = (CicloFormativo) o;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    // Metodo toString

    @Override
    public String toString() {
        return String.format("CicloFormativo [codigo=%s, familia=%s, grado=%s, nombre=%s, horas=%d]",
                codigo, familiaProfesional, grado, nombre, horas);
    }

    // Metodo imprimir

    public String imprimir() {
        return String.format("%s - %s (%s)", codigo, nombre, grado);
    }

    public ScopedValue<Object> map(Object o) {
        return null;
    }
}
