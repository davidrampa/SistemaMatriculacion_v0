package org.iesalandalus.programacion.matriculacion.vista;

import org.iesalandalus.programacion.matriculacion.modelo.dominio.*;

import java.util.Scanner;

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

    public static String leerTipoGrado() {
        String tipoGrado;
        do {
            System.out.print("Elige el tipo de Grado (D/E): ");
            tipoGrado = entrada.nextLine().trim().toUpperCase();
        } while (!tipoGrado.equals("D") && !tipoGrado.equals("E"));
        return tipoGrado;
    }

    public static String leerModalidad() {
        String modalidad;
        do {
            System.out.print("Elige la modalidad (Presencial/Semipresencial): ");
            modalidad = entrada.nextLine().trim().toUpperCase();
        } while (!modalidad.equals("PRESENCIAL") && !modalidad.equals("SEMIPRESENCIAL"));
        return modalidad;
    }

    public static Grado leerGrado() {
        String tipoGrado = leerTipoGrado();
        String modalidad = leerModalidad();
        if (tipoGrado.equals("D")) {
            return new GradoD(modalidad);
        } else {
            return new GradoE(modalidad);
        }
    }


    public static CicloFormativo leerCicloFormativo() {
        System.out.print("Introduce el código del ciclo formativo: ");
        String codigo = entrada.nextLine();
        System.out.print("Introduce el nombre del ciclo formativo: ");
        String nombre = entrada.nextLine();
        Grado grado = leerGrado();
        return new CicloFormativo(codigo, nombre, grado);
    }

    public static CicloFormativo getCicloFormativoPorCodigo() {
        System.out.print("Introduce el código del ciclo formativo: ");
        String codigo = entrada.nextLine();
        return new CicloFormativo(codigo, "NombreFicticio", new GradoD("Presencial"));
    }

    public static Asignatura getAsignaturaPorCodigo() {
        try {
            System.out.print("Introduce el código de la asignatura: ");
            String codigo = entrada.nextLine().trim();

            if (codigo.isEmpty()) {
                throw new IllegalArgumentException("El código de la asignatura no puede estar vacío.");
            }

            return new Asignatura(codigo, "NombreFicticio");
        } catch (Exception e) {
            System.out.println(STR."Error al obtener la asignatura por código: \{e.getMessage()}");
            return null;
        }
    }
}
