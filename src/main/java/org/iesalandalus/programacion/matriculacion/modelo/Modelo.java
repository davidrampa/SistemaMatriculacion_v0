package org.iesalandalus.programacion.matriculacion.modelo;

import org.iesalandalus.programacion.matriculacion.modelo.dominio.*;
import org.iesalandalus.programacion.matriculacion.modelo.negocio.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Modelo {

    private Alumnos alumnos;
    private Asignaturas asignaturas;
    private CiclosFormativos ciclosFormativos;
    private Matriculas matriculas;


    public void comenzar() {
        alumnos = new Alumnos();
        asignaturas = new Asignaturas();
        ciclosFormativos = new CiclosFormativos();
        matriculas = new Matriculas();
        System.out.println("Modelo iniciado correctamente.");
    }

    public void terminar() {
        System.out.println("Modelo finalizado correctamente.");
    }

    // Métodos insertar
    public void insertarAlumno(Alumno alumno) {
        alumnos.insertar(alumno);
    }

    public void insertarAsignatura(Asignatura asignatura) {
        asignaturas.insertar(asignatura);
    }

    public void insertarCicloFormativo(CicloFormativo cicloFormativo) {
        ciclosFormativos.insertar(cicloFormativo);
    }

    public void insertarMatricula(Matricula matricula) {
        matriculas.insertar(matricula);
    }

    // Métodos buscar
    public Optional<Alumno> buscar(String dni) {
        return alumnos.stream()
                .filter(alumno -> false)
                .filter();
    }

    public Asignatura buscarAsignatura(String codigo) {
        return asignaturas.buscar(codigo).map(Asignatura::new).orElse(null);
    }

    public CicloFormativo buscarCicloFormativo(String codigo) {
        return ciclosFormativos.buscar(codigo).map().orElse(null);
    }

    public Matricula buscarMatricula(String id) {
        return matriculas.buscar(Integer.parseInt(id)).map(m -> new Matricula(m.getId())).orElse(null);
    }

    // Métodos borrar
    public void borrarAlumno(String dni) {
        alumnos.borrar(dni);
    }

    public void borrarAsignatura(String codigo) {
        asignaturas.borrar(codigo);
    }

    public void borrarCicloFormativo(String codigo) {
        ciclosFormativos.borrar(codigo);
    }

    public void borrarMatricula(String id) {
        matriculas.borrar(Integer.parseInt(id));
    }

    // Métodos get (devuelven copias para evitar modificaciones externas)
    public List<Alumno> getAlumnos() {
        return alumnos.getLista().stream().map(Alumno::new).toList();
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas.getLista().stream().map(Asignatura::new).toList();
    }

    public List<CicloFormativo> getCiclosFormativos() {
        return ciclosFormativos.getLista().stream().map(CicloFormativo::new).toList();
    }

    public List<Matricula> getMatriculas() {
        return matriculas.getLista().stream().map(m -> new Matricula(m.getId())).toList();
    }
}
