package org.iesalandalus.programacion.matriculacion.vista;

import org.iesalandalus.programacion.matriculacion.dominio.*;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;

public class Consola {

    private static final Scanner entrada = new Scanner(System.in);

    // Constructor privado para evitar la instanciación.
    private Consola() {
        throw new UnsupportedOperationException("La clase Consola no puede ser instanciada.");
    }

    public static void mostrarMenu() {
        System.out.println("Opciones disponibles:");
        for (Opcion opcion : Opcion.values()) {
            System.out.println(opcion);
        }
    }

    public static Opcion elegirOpcion() {
        Opcion opcion = null;
        do {
            try {
                System.out.print("Elige una opción: ");
                int eleccion = Integer.parseInt(entrada.nextLine());
                opcion = Opcion.values()[eleccion];
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Opción no válida, inténtalo de nuevo.");
            }
        } while (opcion == null);
        return opcion;
    }

    public static Alumno leerAlumno() {
        System.out.print("Introduce el nombre del alumno: ");
        String nombre = entrada.nextLine();
        System.out.print("Introduce el apellido del alumno: ");
        String apellido = entrada.nextLine();
        System.out.print("Introduce el DNI del alumno: ");
        String dni = entrada.nextLine();
        return new Alumno(nombre, apellido, dni);
    }

    public static Alumno getAlumnoPorDni() {
        System.out.print("Introduce el DNI del alumno: ");
        String dni = entrada.nextLine();
        return new Alumno("NombreFicticio", "ApellidoFicticio", dni);
    }

    public static LocalDate leerFecha() {
        LocalDate fecha = null;
        do {
            try {
                System.out.print("Introduce una fecha (dd/MM/yyyy): ");
                String fechaStr = entrada.nextLine();
                fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha incorrecto. Inténtalo de nuevo.");
            }
        } while (fecha == null);
        return fecha;
    }

    public static Grado leerGrado() {
        System.out.println("Selecciona un grado:");
        for (Grado grado : Grado.values()) {
            System.out.println(grado);
        }
        int eleccion = Integer.parseInt(entrada.nextLine());
        return Grado.values()[eleccion];
    }

    public static CicloFormativo leerCicloFormativo() {
        System.out.print("Introduce el código del ciclo formativo: ");
        String codigo = entrada.nextLine();
        System.out.print("Introduce el nombre del ciclo formativo: ");
        String nombre = entrada.nextLine();
        return new CicloFormativo(codigo, nombre);
    }

    public static void mostrarCiclosFormativos() {
        System.out.println("Ciclos formativos registrados:");
        for (CicloFormativo ciclo : ciclos) {
            System.out.println(ciclo);
        }
    }

    public static CicloFormativo getCicloFormativoPorCodigo() {
        System.out.print("Introduce el código del ciclo formativo: ");
        String codigo = entrada.nextLine();
        return new CicloFormativo(codigo, "NombreFicticio");
    }

    public static Curso leerCurso() {
        System.out.println("Selecciona un curso:");
        for (Curso curso : Curso.values()) {
            System.out.println(curso);
        }
        int eleccion = Integer.parseInt(entrada.nextLine());
        return Curso.values()[eleccion];
    }

    public static Asignatura leerAsignatura() {
        System.out.print("Introduce el código de la asignatura: ");
        String codigo = entrada.nextLine();
        System.out.print("Introduce el nombre de la asignatura: ");
        String nombre = entrada.nextLine();
        return new Asignatura(codigo, nombre);
    }

    public static void mostrarAsignaturas(List<Asignatura> asignaturas) {
        System.out.println("Asignaturas registradas:");
        for (Asignatura asignatura : asignaturas) {
            System.out.println(asignatura);
        }
    }

    public static boolean asignaturaYaMatriculada(List<Asignatura> listaAsignaturas, Asignatura asignatura) {
        return listaAsignaturas.contains(asignatura);
    }

    public static Matricula leerMatricula() {
        try {
            // Leer datos básicos para la matrícula.
            System.out.println("Introduce los datos para la matrícula:");
            Alumno alumno = leerAlumno(); // Llama al método leerAlumno para pedir los datos del alumno.
            LocalDate fechaMatricula = leerFecha(); // Llama al método leerFecha para obtener la fecha.

            // Crear una lista de asignaturas para la matrícula.
            List<Asignatura> asignaturas = new ArrayList<>();
            boolean continuar;
            do {
                Asignatura asignatura = leerAsignatura(); // Pide los datos de una asignatura.
                if (asignaturaYaMatriculada(asignaturas, asignatura)) {
                    System.out.println("La asignatura ya está matriculada. No se añadirá.");
                } else {
                    asignaturas.add(asignatura);
                    System.out.println("Asignatura añadida.");
                }

                System.out.print("¿Deseas añadir otra asignatura? (s/n): ");
                continuar = entrada.nextLine().equalsIgnoreCase("s");
            } while (continuar);

            // Crear y devolver la matrícula.
            return new Matricula(alumno, fechaMatricula, asignaturas);
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al crear la matrícula: " + e.getMessage());
            return null; // En caso de error, devuelve null.
        }
    }

    public static Matricula getMatriculaPorIdentificador() {
        System.out.print("Introduce el identificador de la matrícula: ");
        int id = Integer.parseInt(entrada.nextLine());
        return new Matricula(id);
    }

    public static Asignatura getAsignaturaPorCodigo() {
        try {
            // Solicitar el código de la asignatura al usuario
            System.out.print("Introduce el código de la asignatura: ");
            String codigo = entrada.nextLine().trim();

            // Validar el formato del código (si aplica alguna regla)
            if (codigo.isEmpty()) {
                throw new IllegalArgumentException("El código de la asignatura no puede estar vacío.");
            }

            return new Asignatura(codigo, "nombre", 100,);
        } catch (Exception e) {
            System.out.println("Error al obtener la asignatura por código: " + e.getMessage());
            return null;
        }
    }
}
