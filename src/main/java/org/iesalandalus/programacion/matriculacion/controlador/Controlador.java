package org.iesalandalus.programacion.matriculacion.controlador;

import org.iesalandalus.programacion.matriculacion.modelo.Modelo;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.Alumno;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.Asignatura;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.CicloFormativo;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.Matricula;
import org.iesalandalus.programacion.matriculacion.vista.Vista;

import java.util.List;

public class Controlador {
    private final Modelo modelo;
    private final Vista vista;

    // Constructor con parámetros
    public Controlador(Modelo modelo, Vista vista) {
        if (modelo == null) {
            throw new NullPointerException("El modelo no puede ser nulo.");
        }
        if (vista == null) {
            throw new NullPointerException("La vista no puede ser nula.");
        }
        this.modelo = modelo;
        this.vista = vista;
        this.vista.setControlador(this);
    }

    // Metodo para iniciar el modelo y la vista
    public void comenzar() {
        modelo.comenzar();
        vista.comenzar();
    }

    // Metodo para finalizar el modelo y la vista
    public void terminar() {
        modelo.terminar();
        vista.terminar();
    }

    // Métodos para insertar entidades
    public void insertarAlumno(Alumno alumno) {
        modelo.insertarAlumno(alumno);
    }

    public void insertarAsignatura(Asignatura asignatura) {
        modelo.insertarAsignatura(asignatura);
    }

    public void insertarCicloFormativo(CicloFormativo ciclo) {
        modelo.insertarCicloFormativo(ciclo);
    }

    public void insertarMatricula(Matricula matricula) {
        modelo.insertarMatricula(matricula);
    }

    // Métodos para buscar entidades
    public Alumno buscarAlumno(String dni) {
        return modelo.buscarAlumno(dni);
    }

    public Asignatura buscarAsignatura(String codigo) {
        return modelo.buscarAsignatura(codigo);
    }

    public CicloFormativo buscarCicloFormativo(String codigo) {
        return modelo.buscarCicloFormativo(codigo);
    }

    public Matricula buscarMatricula(String id) {
        return modelo.buscarMatricula(id);
    }

    // Métodos para borrar entidades
    public void borrarAlumno(String dni) {
        modelo.borrarAlumno(dni);
    }

    public void borrarAsignatura(String codigo) {
        modelo.borrarAsignatura(codigo);
    }

    public void borrarCicloFormativo(String codigo) {
        modelo.borrarCicloFormativo(codigo);
    }

    public void borrarMatricula(String id) {
        modelo.borrarMatricula(id);
    }

    // Métodos para listar entidades
    public List<Alumno> getAlumnos() {
        return modelo.getAlumnos();
    }

    public List<Asignatura> getAsignaturas() {
        return modelo.getAsignaturas();
    }

    public List<CicloFormativo> getCiclosFormativos() {
        return modelo.getCiclosFormativos();
    }

    public List<Matricula> getMatriculas() {
        return modelo.getMatriculas();
    }

    public List<Matricula> getMatriculasPorAlumno(Alumno alumno) {
        return null;
    }

    public List<Matricula> getMatriculasPorCiclo(CicloFormativo ciclo) {
        return null;
    }

    public List<Matricula> getMatriculasPorCurso(int curso) {
        return null;
    }
}

