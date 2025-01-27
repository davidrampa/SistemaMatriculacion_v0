package org.iesalandalus.programacion.matriculacion.modelo;

import java.util.ArrayList;
import java.util.List;

import org.iesalandalus.programacion.matriculacion.modelo.dominio.*;
import org.iesalandalus.programacion.matriculacion.modelo.negocio.*;

public class Modelo {

    private Alumnos alumnos;
    private Asignaturas asignaturas;
    private CiclosFormativos ciclosFormativos;
    private Matriculas matriculas;

    //Metodo para inicializar las instancias
    public void comenzar() {
        int tamanoMaximo = 50; // Tamaño maximo para inicializar las colecciones
        alumnos = new Alumnos(tamanoMaximo);
        asignaturas = new Asignaturas(tamanoMaximo);
        ciclosFormativos = new CiclosFormativos(tamanoMaximo);
        matriculas = new Matriculas(tamanoMaximo);
        System.out.println("Modelo iniciado correctamente.");
    }

    //Metodo para finalizar el modelo
    public void terminar() {
        System.out.println("Modelo finalizado correctamente.");
    }

    //Metodos insertar
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

    //Metodos buscar
    public Alumno buscarAlumno(String dni) {
        Alumno encontrado = alumnos.buscar(dni);
        return (encontrado != null) ? new Alumno(encontrado) : null;
    }

    public CicloFormativo buscarAsignaturas(String codigo) {
        Asignatura encontrada = asignaturas.buscar(codigo);
        return (encontrada !=null) ? new CicloFormativo(encontrada.getCicloFormativo()) : null;
    }

    public CicloFormativo buscarCicloFormativo(String codigo) {
        CicloFormativo encontrado = ciclosFormativos.buscar(codigo);
        return (encontrado != null) ? new CicloFormativo(encontrado) : null;
    }

    public Matricula buscarMatricula(String id) {
        Matricula encontrada = matriculas.buscar(id);
        return (encontrada != null) ? new Matricula(encontrada.getId()) : null;
    }

    //Metodos borrar
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
        matriculas.borrar(id);
    }

    //Metodos get
    public List<Alumno> getAlumnos() {
        return new ArrayList<>(alumnos.getLista());
    }

    public List<Asignatura> getAsignaturas() {
        return new ArrayList<>(asignaturas.getLista());
    }

    public List<CicloFormativo> getCiclosFormativos() {
        return new ArrayList<>(ciclosFormativos.getLista());
    }

    public List<Matricula> getMatriculas() {
        return new ArrayList<>(matriculas.getLista());
    }

}
