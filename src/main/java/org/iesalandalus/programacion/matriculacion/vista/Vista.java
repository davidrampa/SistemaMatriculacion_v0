package org.iesalandalus.programacion.matriculacion.vista;

import org.iesalandalus.programacion.matriculacion.controlador.Controlador;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.*;
import java.util.*;

public class Vista {
    private Controlador controlador;

    // Constructor que asigna la vista a Opcion
    public Vista() {
        Opcion.setVista(this);
    }

    // Metodo para asignar el controlador
    public void setControlador(Controlador controlador) {
        if (controlador == null) {
            throw new NullPointerException("El controlador no puede ser nulo.");
        }
        this.controlador = controlador;
    }

    // Metodo para iniciar el menú principal
    public void comenzar() {
        boolean salir = false;
        do {
            Consola.mostrarMenu();
            Opcion opcion = Consola.elegirOpcion();
            opcion.ejecutar();  // Se ejecuta el metodo correspondiente en Opcion
            if (opcion == Opcion.SALIR) {
                salir = true;
            }
        } while (!salir);
    }

    // Metodo para mostrar un mensaje de despedida
    public void salir() {
        System.out.println("Gracias por utilizar la aplicación. ¡Hasta pronto!");
    }

    // Metodos para insertar datos
    public void insertarAlumno() {
        Alumno alumno = Consola.leerAlumno();
        controlador.insertarAlumno(alumno);
        System.out.println("Alumno insertado correctamente.");
    }

    public void insertarAsignatura() {
        Asignatura asignatura = Consola.leerAsignatura();
        controlador.insertarAsignatura(asignatura);
        System.out.println("Asignatura insertada correctamente.");
    }

    public void insertarMatricula() {
        Alumno alumno = Consola.getAlumnoPorDni();
        List<Asignatura> asignaturasElegidas = Consola.elegirAsignaturasMatricula(controlador.getAsignaturas());
        Matricula matricula = Consola.leerMatricula(alumno, asignaturasElegidas);
        controlador.insertarMatricula(matricula);
        System.out.println("Matrícula insertada correctamente.");
    }

    public void insertarCicloFormativo() {
        CicloFormativo ciclo = Consola.leerCicloFormativo();
        controlador.insertarCicloFormativo(ciclo);
        System.out.println("Ciclo formativo insertado correctamente.");
    }

    // Métodos para buscar datos
    public void buscarAlumno() {
        Alumno alumno = Consola.getAlumnoPorDni();
        Alumno encontrado = controlador.buscarAlumno(alumno.getDni());
        if (encontrado != null) {
            System.out.println(STR."Alumno encontrado: \{encontrado}");
        } else {
            System.out.println("No se ha encontrado el alumno.");
        }
    }

    public void buscarAsignatura() {
        Asignatura asignatura = Consola.getAsignaturaPorCodigo();
        Asignatura encontrada = controlador.buscarAsignatura(asignatura.getCodigo());
        if (encontrada != null) {
            System.out.println(STR."Asignatura encontrada: \{encontrada}");
        } else {
            System.out.println("No se ha encontrado la asignatura.");
        }
    }

    public void buscarMatricula() {
        Matricula matricula = Consola.leerMatriculaBuscar();
        Matricula encontrada = controlador.buscarMatricula(String.valueOf(matricula));
        if (encontrada != null) {
            System.out.println(STR."Matrícula encontrada: \{encontrada}");
        } else {
            System.out.println("No se ha encontrado la matrícula.");
        }
    }

    public void buscarCicloFormativo() {
        CicloFormativo ciclo = Consola.getCicloPorCodigo();
        CicloFormativo encontrado = controlador.buscarCicloFormativo(ciclo.getCodigo());
        if (encontrado != null) {
            System.out.println(STR."Ciclo formativo encontrado: \{encontrado}");
        } else {
            System.out.println("No se ha encontrado el ciclo formativo.");
        }
    }

    // Métodos para borrar datos
    public void borrarAlumno() {
        Alumno alumno = Consola.getAlumnoPorDni();
        controlador.borrarAlumno(alumno.getDni());
        System.out.println("Alumno borrado correctamente.");
    }

    public void borrarAsignatura() {
        Asignatura asignatura = Consola.getAsignaturaPorCodigo();
        controlador.borrarAsignatura(asignatura.getCodigo());
        System.out.println("Asignatura borrada correctamente.");
    }

    public void borrarMatricula() {
        Matricula matricula = Consola.leerMatriculaBuscar();
        controlador.borrarMatricula(String.valueOf(matricula));
        System.out.println("Matrícula borrada correctamente.");
    }

    public void borrarCicloFormativo() {
        CicloFormativo ciclo = Consola.getCicloPorCodigo();
        controlador.borrarCicloFormativo(ciclo.getCodigo());
        System.out.println("Ciclo formativo borrado correctamente.");
    }

    // Métodos para listar datos
    public void listarAlumnos() {
        List<Alumno> alumnos = new ArrayList<>(controlador.getAlumnos());
        Collections.sort(alumnos, Comparator.comparing(Alumno::getNombre));
        Consola.mostrarAlumnos(alumnos);
    }

    public void listarAsignaturas() {
        ArrayList<List<Asignatura>> asignaturas = new ArrayList<>(List.of(controlador.getAsignaturas()));
        asignaturas.sort(Comparator.comparing(Asignatura::getCodigo));
        Consola.mostrarAsignaturas(asignaturas);
    }

    public void listarCiclosFormativos() {
        List<CicloFormativo> ciclosFormativos = new ArrayList<>(controlador.getCiclosFormativos());
        Collections.sort(ciclosFormativos, Comparator.comparing(CicloFormativo::getCodigo));
        Consola.mostrarCiclosFormativos(ciclosFormativos);
    }

    public void listarMatriculas() {
        List<Matricula> matriculas = new ArrayList<>(controlador.getMatriculas());
        Collections.sort(matriculas, Comparator.comparing(Matricula::getFecha));
        Consola.mostrarMatriculas(matriculas);
    }

    // Métodos para mostrar datos específicos
    public void mostrarAlumnos() {
        System.out.println("Mostrando información de los alumnos...");
        listarAlumnos();
    }

    public void mostrarMatriculasAlumno() {
        Alumno alumno = Consola.getAlumnoPorDni();
        List<Matricula> matriculas = controlador.getMatriculasPorAlumno(alumno);
        Consola.mostrarMatriculas(matriculas);
    }

    public void mostrarMatriculasCiclo() {
        CicloFormativo ciclo = Consola.getCicloPorCodigo();
        List<Matricula> matriculas = controlador.getMatriculasPorCiclo(ciclo);
        Consola.mostrarMatriculas(matriculas);
    }

    public void mostrarMatriculasCurso() {
        int curso = Consola.leerCurso().ordinal();
        List<Matricula> matriculas = controlador.getMatriculasPorCurso(curso);
        Consola.mostrarMatriculas(matriculas);
    }

    public void terminar() {
        System.out.println("Gracias por utilizar la aplicación. ¡Hasta pronto!");
    }

    public void matricularAlumno() {
        Alumno alumno = Consola.getAlumnoPorDni();
        List<Asignatura> asignaturasElegidas = Consola.elegirAsignaturasMatricula(controlador.getAsignaturas());
        Matricula matricula = Consola.leerMatricula(alumno, asignaturasElegidas);
        controlador.insertarMatricula(matricula);
        System.out.println("Matrícula realizada correctamente.");
    }

    public void listarCiclos() {
        List<CicloFormativo> ciclosFormativos = new ArrayList<>(controlador.getCiclosFormativos());
        ciclosFormativos.sort(Comparator.comparing(CicloFormativo::getCodigo)); // Ordenar por código
        Consola.mostrarCiclosFormativos(ciclosFormativos);
    }

}

