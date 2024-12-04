package org.iesalandalus.programacion.matriculacion;

import org.iesalandalus.programacion.matriculacion.dominio.Asignatura;
import org.iesalandalus.programacion.matriculacion.dominio.CicloFormativo;
import org.iesalandalus.programacion.matriculacion.dominio.Matricula;
import org.iesalandalus.programacion.matriculacion.dominio.Alumno;
import org.iesalandalus.programacion.matriculacion.vista.Consola;
import org.iesalandalus.programacion.matriculacion.vista.Opcion;

import java.util.List;
import java.util.ArrayList;

import static org.iesalandalus.programacion.matriculacion.vista.Consola.mostrarCiclosFormativos;

public class MainApp {

    // Atributos
    private static final List<Alumno> alumnos = new ArrayList<>();
    private static final List<Asignatura> asignaturas = new ArrayList<>();
    private static final List<CicloFormativo> ciclosFormativos = new ArrayList<>();
    private static final List<Matricula> matriculas = new ArrayList<>();

    // Metodo ejecutarOpcion
    private static void ejecutarOpcion(Opcion opcion) {
        switch (opcion) {
            case INSERTAR_ALUMNO -> insertarAlumno();
            case BUSCAR_ALUMNO -> buscarAlumno();
            case BORRAR_ALUMNO -> borrarAlumno();
            case MOSTRAR_ALUMNOS -> mostrarAlumnos();
            case INSERTAR_ASIGNATURA -> insertarAsignatura();
            case BUSCAR_ASIGNATURA -> buscarAsignatura();
            case BORRAR_ASIGNATURA -> borrarAsignatura();
            case LISTAR_ASIGNATURAS -> mostrarAsignaturas();
            case INSERTAR_CICLO_FORMATIVO -> insertarCicloFormativo();
            case BUSCAR_CICLOS_FORMATIVOS -> buscarCicloFormativo();
            case BORRAR_CICLO_FORMATIVO -> borrarCicloFormativo();
            case LISTAR_CICLOS_FORMATIVOS -> mostrarCiclosFormativos();
            case MATRICULAR_ALUMNO -> insertarMatricula();
            case BUSCAR_MATRICULA -> buscarMatricula();
            case BORRAR_MATRICULA -> anularMatricula();
            case LISTAR_MATRICULAS -> mostrarMatriculas();
            case MOSTRAR_MATRICULAS_ALUMNO -> mostrarMatriculasPorAlumno();
            case MOSTRAR_MATRICULAS_CICLO -> mostrarMatriculasPorCicloFormativo();
            case MOSTRAR_MATRICULAS_CURSO -> mostrarMatriculasPorCursoAcademico();
            case SALIR -> System.out.println("Gracias por usar la aplicación. ¡Adiós!");
        }
    }

    private static void mostrarMatriculasPorCursoAcademico() {
        try {
            String cursoAcademico = Consola.leerCurso();
            List<Matricula> matriculasCurso = new ArrayList<>();
            for (Matricula matricula : matriculas) {
                if (matricula.getCursoAcademico().equals(cursoAcademico)) {
                    matriculasCurso.add(matricula);
                }
            }

            if (matriculasCurso.isEmpty()) {
                System.out.println("No hay matrículas registradas para el curso académico " + cursoAcademico + ".");
            } else {
                System.out.println("Matrículas del curso académico " + cursoAcademico + ":");
                matriculasCurso.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar las matrículas por curso académico: " + e.getMessage());
        }
    }

    private static void mostrarMatriculasPorCicloFormativo() {
        try {
            Consola.mostrarCiclosFormativos();
            CicloFormativo cicloFormativo = Consola.getCicloFormativoPorCodigo();
            List<Matricula> matriculasCiclo = new ArrayList<>();
            for (Matricula matricula : matriculas) {
                if (matricula.getCicloFormativo().equals(cicloFormativo)) {
                    matriculasCiclo.add(matricula);
                }
            }

            if (matriculasCiclo.isEmpty()) {
                System.out.println("No hay matrículas registradas para el ciclo formativo con código " + cicloFormativo.getCodigo() + ".");
            } else {
                System.out.println("Matrículas del ciclo formativo con código " + cicloFormativo.getCodigo() + ":");
                matriculasCiclo.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar las matrículas del ciclo formativo: " + e.getMessage());
        }
    }

    private static void mostrarMatriculasPorAlumno() {
        try {
            Alumno alumno = Consola.getAlumnoPorDni();
            
            List<Matricula> matriculasAlumno = new ArrayList<>();
            for (Matricula matricula : matriculas) {
                if (matricula.getAlumno().equals(alumno)) {
                    matriculasAlumno.add(matricula);
                }
            }
            
            if (matriculasAlumno.isEmpty()) {
                System.out.println("El alumno con DNI " + alumno.getDni() + " no tiene matrículas registradas.");
            } else {
                System.out.println("Matrículas del alumno con DNI " + alumno.getDni() + ":");
                matriculasAlumno.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar las matrículas del alumno: " + e.getMessage());
        }
    }

    private static void mostrarMatriculas() {
        if (matriculas.isEmpty()) {
            System.out.println("No hay matriculas registradas.");
        } else {
            matriculas.forEach(System.out::println);
        }
    }

    private static void anularMatricula() {
        try {
            Matricula matricula = Consola.getMatriculaPorIdentificador();
            if (matriculas.remove(matricula)) {
                System.out.println("Matricula anulada correctamente.");
            } else {
                System.out.println("No existe una matricula por ese identificador.");
            }
        } catch (Exception e) {
            System.out.println("Error al anular matricula: " + e.getMessage());
        }
    }

    private static void borrarCicloFormativo() {
        try {
            CicloFormativo cicloFormativo = Consola.getCicloFormativoPorCodigo();
            if (ciclosFormativos.remove(cicloFormativo)) {
                System.out.println("Ciclo formativo borrado correctamente.");
            } else {
                System.out.println("No existe un ciclo formativo por ese codigo.");
            }
        } catch (Exception e) {
            System.out.println("Error al borrar ciclo formativo: " + e.getMessage());
        }
    }

    private static void buscarMatricula() {
        try {
            Matricula matricula = Consola.getMatriculaPorIdentificador();
            if (matriculas.contains(matricula)) {
                System.out.println(matricula);
            } else {
                System.out.println("No existe una matricula por ese identificiador.");
            }
        } catch (Exception e) {
            System.out.println("Error al buscar matricula: " + e.getMessage());
        }
    }

    private static void buscarCicloFormativo() {
        try {
            CicloFormativo cicloFormativo = Consola.getCicloFormativoPorCodigo();
            if (ciclosFormativos.contains(cicloFormativo)) {
                System.out.println(cicloFormativo);
            } else {
                System.out.println("No existe un ciclo formativo por ese codigo.");
            }
        } catch (Exception e) {
            System.out.println("Error al buscar ciclo formativo: " + e.getMessage());
        }
    }

    private static void insertarCicloFormativo() {
        try {
            CicloFormativo cicloFormativo = Consola.leerCicloFormativo();
            if (ciclosFormativos.contains(cicloFormativo)) {
                System.out.println("El ciclo formativo ya existe.");
            } else {
                ciclosFormativos.add(cicloFormativo);
                System.out.println("Ciclo formativo insertado correctamente.");
            }
        } catch (Exception e) {
            System.out.println("Error al insertar el ciclo formativo: " + e.getMessage());
        }
    }

    private static void insertarMatricula() {
        try {
            Matricula matricula = Consola.leerMatricula();
            if (matriculas.contains(matricula)) {
                System.out.println("La matricula ya existe.");
            } else {
                matriculas.add(matricula);
                System.out.println("Matricula insertada correctamente.");
            }
        } catch (Exception e) {
            System.out.println("Error al insertar matricula: " + e.getMessage());
        }
    }

    // Métodos para gestionar alumnos
    private static void insertarAlumno() {
        try {
            Alumno alumno = Consola.leerAlumno();
            if (alumnos.contains(alumno)) {
                System.out.println("El alumno ya existe.");
            } else {
                alumnos.add(alumno);
                System.out.println("Alumno insertado correctamente.");
            }
        } catch (Exception e) {
            System.out.println("Error al insertar alumno: " + e.getMessage());
        }
    }

    private static void buscarAlumno() {
        try {
            Alumno alumno = Consola.getAlumnoPorDni();
            if (alumnos.contains(alumno)) {
                System.out.println(alumno);
            } else {
                System.out.println("No existe un alumno con ese DNI.");
            }
        } catch (Exception e) {
            System.out.println("Error al buscar alumno: " + e.getMessage());
        }
    }

    private static void borrarAlumno() {
        try {
            Alumno alumno = Consola.getAlumnoPorDni();
            if (alumnos.remove(alumno)) {
                System.out.println("Alumno borrado correctamente.");
            } else {
                System.out.println("No existe un alumno con ese DNI.");
            }
        } catch (Exception e) {
            System.out.println("Error al borrar alumno: " + e.getMessage());
        }
    }

    private static void mostrarAlumnos() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
        } else {
            alumnos.forEach(System.out::println);
        }
    }

    // Métodos para gestionar asignaturas
    private static void insertarAsignatura() {
        try {
            Asignatura asignatura = Consola.leerAsignatura();
            if (asignaturas.contains(asignatura)) {
                System.out.println("La asignatura ya existe.");
            } else {
                asignaturas.add(asignatura);
                System.out.println("Asignatura insertada correctamente.");
            }
        } catch (Exception e) {
            System.out.println("Error al insertar asignatura: " + e.getMessage());
        }
    }

    private static void buscarAsignatura() {
        try {
            Asignatura asignatura = Consola.getAsignaturaPorCodigo();
            if (asignaturas.contains(asignatura)) {
                System.out.println(asignatura);
            } else {
                System.out.println("No existe una asignatura con ese código.");
            }
        } catch (Exception e) {
            System.out.println("Error al buscar asignatura: " + e.getMessage());
        }
    }

    private static void borrarAsignatura() {
        try {
            Asignatura asignatura = Consola.getAsignaturaPorCodigo();
            if (asignaturas.remove(asignatura)) {
                System.out.println("Asignatura borrada correctamente.");
            } else {
                System.out.println("No existe una asignatura con ese código.");
            }
        } catch (Exception e) {
            System.out.println("Error al borrar asignatura: " + e.getMessage());
        }
    }

    private static void mostrarAsignaturas() {
        if (asignaturas.isEmpty()) {
            System.out.println("No hay asignaturas registradas.");
        } else {
            asignaturas.forEach(System.out::println);
        }
    }

    // Métodos adicionales (Ciclos Formativos y Matrículas) son similares...

    // Metodo main
    public static void main(String[] args) {
        Opcion opcion;
        do {
            Consola.mostrarMenu();
            opcion = Consola.elegirOpcion();
            ejecutarOpcion(opcion);
        } while (opcion != Opcion.SALIR);
    }

}
