package org.iesalandalus.programacion.matriculacion.dominio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Matricula {
    //Constantes
    public static final int MAX_HORAS_MATRICULA = 1000;
    public static final int MAX_ASIGNATURAS = 10;
    public static final int MAX_DIAS_RETRASO = 15;
    public static final int MAX_MESES_ANULACION = 6;
    public static final String FORMATO_CURSO_ACADEMICO = "\\D{2}-\\d{2}";

    //Atributos
    private int id;
    private String cursoAcademico;
    private LocalDate fechaMatricula;
    private LocalDate fechaAnulacion;
    private List<Asignatura> asignaturas;

    //Constructores
    public Matricula(int id, String cursoAcademico, LocalDate fechaMatricula, List<Asignatura> asignaturas) {
        setId(id);
        setCursoAcademico(cursoAcademico);
        setFechaMatricula(fechaMatricula);
        setAsignaturas(asignaturas);
    }

    public Matricula(Matricula otra) {
        this(otra.id, otra.cursoAcademico, otra.fechaMatricula, new ArrayList<>(otra.asignaturas));
        this.fechaAnulacion = otra.fechaAnulacion;
    }

    //Metodos de acceso y modificacion


    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El identificador debe ser un numero positivo.");
        }
        this.id = id;
    }

    public String getCursoAcademico() {
        return cursoAcademico;
    }

    public void setCursoAcademico(String cursoAcademico) {
        if (cursoAcademico == null || !cursoAcademico.matches(FORMATO_CURSO_ACADEMICO)) {
            throw new IllegalArgumentException("El curso academico debe tener el formato dd-dd. ");
        }
        this.cursoAcademico = cursoAcademico;
    }

    public LocalDate getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(LocalDate fechaMatricula) {
        if (fechaMatricula == null || ChronoUnit.DAYS.between(fechaMatricula, LocalDate.now()) > MAX_DIAS_RETRASO) {
            throw new IllegalArgumentException("La fecha de matrículo no puede superar los "+ MAX_DIAS_RETRASO + "dias de retraso.");
        }
        this.fechaMatricula = fechaMatricula;
    }

    public LocalDate getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(LocalDate fechaAnulacion) {
        if (fechaAnulacion != null && ChronoUnit.MONTHS.between(fechaMatricula, fechaAnulacion) > MAX_MESES_ANULACION) {
           throw new IllegalArgumentException("La fecha de anulacion no puede superar los " + MAX_MESES_ANULACION + " meses desde la matricula.");
        }
        this.fechaAnulacion = fechaAnulacion;
    }

    public List<Asignatura> getAsignaturas() {
        return new ArrayList<>(asignaturas);
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        if (asignaturas == null || asignaturas.size() > MAX_ASIGNATURAS) {
            throw new IllegalArgumentException("El número máximo de asignaturas es " + MAX_ASIGNATURAS + ".");
        }
        if (superaMaximoNumeroHorasMatricula(asignaturas)) {
            throw new IllegalArgumentException("El total de horas de las asignaturas no puede superar " + MAX_HORAS_MATRICULA + ".");
        }
        this.asignaturas = new ArrayList<>(asignaturas);
    }

    // Métodos adicionales
    private boolean superaMaximoNumeroHorasMatricula(List<Asignatura> asignaturas) {
        return asignaturas.stream().mapToInt(Asignatura::getHorasAnuales).sum() > MAX_HORAS_MATRICULA;
    }


    public String asignaturasMatricula() {
        StringBuilder sb = new StringBuilder();
        for (Asignatura asignatura : asignaturas) {
            sb.append(asignatura.imprimir()).append("\n");
        }
        return sb.toString().trim();
    }

    // Métodos equals y hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matricula matricula = (Matricula) o;
        return id == matricula.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Métodos imprimir y toString

    public String imprimir() {
        return String.format("Matrícula [%d - Curso: %s]", id, cursoAcademico);
    }

    @Override
    public String toString() {
        return String.format("Matricula [id=%d, cursoAcademico=%s, fechaMatricula=%s, fechaAnulacion=%s, asignaturas=%s]",
                id, cursoAcademico, fechaMatricula, fechaAnulacion, asignaturasMatricula());
    }

    public Object getAlumno() {
        return null;
    }

    public Object getCicloFormativo() {
        return null;
    }
}
