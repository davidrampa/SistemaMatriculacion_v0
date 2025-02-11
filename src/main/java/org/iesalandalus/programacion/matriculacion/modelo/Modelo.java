package org.iesalandalus.programacion.matriculacion.modelo;

import org.iesalandalus.programacion.matriculacion.modelo.dominio.*;
import java.util.ArrayList;
import java.util.List;

public class Modelo {
    private final List<Alumno> alumnos = new ArrayList<>();
    private final List<Asignatura> asignaturas = new ArrayList<>();
    private final List<CicloFormativo> ciclosFormativos = new ArrayList<>();
    private final List<Matricula> matriculas = new ArrayList<>();

    // Métodos de inserción
    public void insertarAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    public void insertarAsignatura(Asignatura asignatura) {
        asignaturas.add(asignatura);
    }

    public void insertarCicloFormativo(CicloFormativo ciclo) {
        ciclosFormativos.add(ciclo);
    }

    public void insertarMatricula(Matricula matricula) {
        matriculas.add(matricula);
    }

    // Métodos de búsqueda
    public Alumno buscarAlumno(String dni) {
        for (Alumno alumno : alumnos) {
            if (alumno.getDni().equals(dni)) {
                return alumno;
            }
        }
        return null;
    }

    public Asignatura buscarAsignatura(String codigo) {
        for (Asignatura asignatura : asignaturas) {
            if (asignatura.getCodigo().equals(codigo)) {
                return asignatura;
            }
        }
        return null;
    }

    public CicloFormativo buscarCicloFormativo(String codigo) {
        for (CicloFormativo ciclo : ciclosFormativos) {
            if (ciclo.getCodigo().equals(codigo)) {
                return ciclo;
            }
        }
        return null;
    }

    public Matricula buscarMatricula(String id) {
        for (Matricula matricula : matriculas) {
            if (matricula.getId().equals(id)) {
                return matricula;
            }
        }
        return null;
    }

    // Métodos de borrado
    public void borrarAlumno(String dni) {
        alumnos.removeIf(alumno -> alumno.getDni().equals(dni));
    }

    public void borrarAsignatura(String codigo) {
        asignaturas.removeIf(asignatura -> asignatura.getCodigo().equals(codigo));
    }

    public void borrarCicloFormativo(String codigo) {
        ciclosFormativos.removeIf(ciclo -> ciclo.getCodigo().equals(codigo));
    }

    public void borrarMatricula(String id) {

    }

    // Métodos de obtención de listas
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public List<CicloFormativo> getCiclosFormativos() {
        return ciclosFormativos;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void comenzar() {
    }

    public void terminar() {
    }
}
