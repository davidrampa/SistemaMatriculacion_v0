package org.iesalandalus.programacion.matriculacion.vista;

import org.iesalandalus.programacion.matriculacion.controlador.Controlador;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.*;
import java.util.List;

public class Vista {
    private Controlador controlador;

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
            switch (opcion) {
                case INSERTAR_ALUMNO -> insertarAlumno();
                case INSERTAR_ASIGNATURA -> insertarAsignatura();
                case INSERTAR_MATRICULA -> insertarMatricula();
                case BUSCAR_ALUMNO -> buscarAlumno();
                case BORRAR_ALUMNO -> borrarAlumno();
                case LISTAR_ALUMNOS -> listarAlumnos();
                case LISTAR_ASIGNATURAS -> listarAsignaturas();
                case SALIR -> salir = true;
                default -> System.out.println("Opción no reconocida.");
            }
        } while (!salir);
    }

    // Metodo para mostrar un mensaje de despedida
    public void terminar() {
        System.out.println("Gracias por utilizar la aplicación. ¡Hasta pronto!");
    }

    // Métodos para insertar datos
    private void insertarAlumno() {
        Alumno alumno = Consola.leerAlumno();
        controlador.insertarAlumno(alumno);
        System.out.println("Alumno insertado correctamente.");
    }

    private void insertarAsignatura() {
        Asignatura asignatura = Consola.leerAsignatura();
        controlador.insertarAsignatura(asignatura);
        System.out.println("Asignatura insertada correctamente.");
    }

    private void insertarMatricula() {
        Alumno alumno = Consola.getAlumnoPorDni();
        List<Asignatura> asignaturasElegidas = List.of(Consola.elegirAsignaturasMatricula(controlador.getAsignaturas()));
        Matricula matricula = Consola.leerMatricula(alumno, asignaturasElegidas);
        controlador.insertarMatricula(matricula);
        System.out.println("Matrícula insertada correctamente.");
    }

    // Métodos para buscar datos
    private void buscarAlumno() {
        Alumno alumno = Consola.getAlumnoPorDni();
        Alumno encontrado = controlador.buscarAlumno(alumno.getDni());
        if (encontrado != null) {
            System.out.println("Alumno encontrado: " + encontrado);
        } else {
            System.out.println("No se ha encontrado el alumno.");
        }
    }

    // Métodos para borrar datos
    private void borrarAlumno() {
        Alumno alumno = Consola.getAlumnoPorDni();
        controlador.borrarAlumno(alumno.getDni());
        System.out.println("Alumno borrado correctamente.");
    }

    // Métodos para listar datos
    private void listarAlumnos() {
        List<Alumno> alumnos = controlador.getAlumnos();
        Consola.mostrarAlumnos(alumnos);
    }

    private void listarAsignaturas() {
        List<Asignatura> asignaturas = List.of(controlador.getAsignaturas());
        Consola.mostrarAsignaturas(asignaturas);
    }
}