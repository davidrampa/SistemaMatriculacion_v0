package org.iesalandalus.programacion.matriculacion.dominio;

import java.util.Objects;

public class Asignatura {
    // Constantes
    public static final int MAX_HORAS_ANUALES = 300;
    public static final int MAX_HORAS_DESDOBLE = 6;

    // Atributos
    private String codigo; // Identificador de la asignatura
    private String nombre; // Nombre de la asignatura
    private int horasAnuales; // Número de horas anuales
    private int horasDesdoble; // Número de horas de desdoble
    private Curso curso; // Curso en el que se imparte (PRIMERO o SEGUNDO)
    private EspecialidadProfesorado especialidad; // Especialidad necesaria del profesorado
    private CicloFormativo cicloFormativo; // Ciclo formativo al que pertenece

    // Constructores
    public Asignatura(String codigo, String nombre, int horasAnuales, int horasDesdoble, Curso curso,
                      EspecialidadProfesorado especialidad, CicloFormativo cicloFormativo) {
        setCodigo(codigo);
        setNombre(nombre);
        setHorasAnuales(horasAnuales);
        setHorasDesdoble(horasDesdoble);
        setCurso(curso);
        setEspecialidad(especialidad);
        setCicloFormativo(cicloFormativo);
    }


    public Asignatura(Asignatura otra) {
        this(otra.codigo, otra.nombre, otra.horasAnuales, otra.horasDesdoble,
                otra.curso, otra.especialidad, otra.cicloFormativo);
    }

    public Asignatura(String codigo, String nombre) {

    }

    // Métodos de acceso y modificación

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código no puede ser nulo o vacío.");
        }
        this.codigo = codigo.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }
        this.nombre = nombre.trim();
    }

    public int getHorasAnuales() {
        return horasAnuales;
    }

    public void setHorasAnuales(int horasAnuales) {
        if (horasAnuales <= 0 || horasAnuales > MAX_HORAS_ANUALES) {
            throw new IllegalArgumentException("Las horas anuales deben estar entre 1 y " + MAX_HORAS_ANUALES + ".");
        }
        this.horasAnuales = horasAnuales;
    }

    public int getHorasDesdoble() {
        return horasDesdoble;
    }

    public void setHorasDesdoble(int horasDesdoble) {
        if (horasDesdoble < 0 || horasDesdoble > MAX_HORAS_DESDOBLE) {
            throw new IllegalArgumentException("Las horas de desdoble deben estar entre 0 y " + MAX_HORAS_DESDOBLE + ".");
        }
        this.horasDesdoble = horasDesdoble;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        if (curso == null) {
            throw new IllegalArgumentException("El curso no puede ser nulo.");
        }
        this.curso = curso;
    }

    public EspecialidadProfesorado getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(EspecialidadProfesorado especialidad) {
        if (especialidad == null) {
            throw new IllegalArgumentException("La especialidad no puede ser nula.");
        }
        this.especialidad = especialidad;
    }

    public CicloFormativo getCicloFormativo() {
        return cicloFormativo;
    }

    public void setCicloFormativo(CicloFormativo cicloFormativo) {
        if (cicloFormativo == null) {
            throw new IllegalArgumentException("El ciclo formativo no puede ser nulo.");
        }
        this.cicloFormativo = cicloFormativo;
    }

    // Métodos equals y hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asignatura that = (Asignatura) o;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    // Metodo toString

    @Override
    public String toString() {
        return String.format("Asignatura [codigo=%s, nombre=%s, horasAnuales=%d, horasDesdoble=%d, curso=%s, especialidad=%s, ciclo=%s]",
                codigo, nombre, horasAnuales, horasDesdoble, curso, especialidad, cicloFormativo.imprimir());
    }

    // Metodo imprimir

    public String imprimir() {
        return String.format("%s - %s (%s)", codigo, nombre, curso);
    }
}