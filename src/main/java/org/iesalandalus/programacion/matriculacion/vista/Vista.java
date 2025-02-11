package org.iesalandalus.programacion.matriculacion.vista;

import org.iesalandalus.programacion.matriculacion.controlador.Controlador;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
                case LISTAR_CICLOS -> listarCiclosFormativos();
                case LISTAR_MATRICULAS -> listarMatriculas();
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
        ArrayList<List<Asignatura>> asignaturasElegidas = new ArrayList<>(List.of(Consola.elegirAsignaturasMatricula(controlador.getAsignaturas())));
        Matricula matricula = Consola.leerMatricula(alumno, asignaturasElegidas);
        controlador.insertarMatricula(matricula);
        System.out.println("Matrícula insertada correctamente.");
    }

    // Métodos para buscar datos
    private void buscarAlumno() {
        Alumno alumno = Consola.getAlumnoPorDni();
        Alumno encontrado = controlador.buscarAlumno(alumno.getDni());
        if (encontrado != null) {
            System.out.println(STR."Alumno encontrado: \{encontrado}");
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
        List<Alumno> alumnos = new ArrayList<>(controlador.getAlumnos());
        // Ordenamos la lista de alumnos por nombre (o cualquier otro criterio)
        Collections.sort(alumnos, Comparator.comparing(Alumno::getNombre));  // Asumiendo que la clase Alumno tiene un método getNombre
        Consola.mostrarAlumnos(alumnos);
    }

    private void listarAsignaturas() {
        ArrayList asignaturas = new ArrayList<>(List.of(controlador.getAsignaturas()));
        // Ordenamos la lista de asignaturas por código (o cualquier otro criterio)
        Collections.sort(asignaturas, Comparator.comparing(Asignatura::getCodigo));  // Asumiendo que la clase Asignatura tiene un método getCodigo
        Consola.mostrarAsignaturas(asignaturas);
    }

    private void listarCiclosFormativos() {
        List<CicloFormativo> ciclosFormativos = new ArrayList<>(controlador.getCiclosFormativos());
        // Ordenamos la lista de ciclos formativos por código (o cualquier otro criterio)
        Collections.sort(ciclosFormativos, Comparator.comparing(CicloFormativo::getCodigo));  // Asumiendo que la clase CicloFormativo tiene un método getCodigo
        Consola.mostrarCiclosFormativos(ciclosFormativos);
    }

    private void listarMatriculas() {
        List<Matricula> matriculas = new ArrayList<>(controlador.getMatriculas());
        // Ordenamos la lista de matrículas por fecha (o cualquier otro criterio)
        Collections.sort(matriculas, Comparator.comparing(Matricula::getFecha));  // Asumiendo que la clase Matricula tiene un método getFecha
        Consola.mostrarMatriculas(matriculas);
    }
}
