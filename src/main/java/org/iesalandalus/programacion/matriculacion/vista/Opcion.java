package org.iesalandalus.programacion.matriculacion.vista;

public enum Opcion {

    SALIR("Salir de la aplicación"),
    INSERTAR_ALUMNO("Insertar un alumno"),
    BORRAR_ALUMNO("Borrar un alumno"),
    LISTAR_ALUMNOS("Listar todos los alumnos"),
    INSERTAR_ASIGNATURA("Insertar una asignatura"),
    BORRAR_ASIGNATURA("Borrar una asignatura"),
    LISTAR_ASIGNATURAS("Listar todas las asignaturas"),
    INSERTAR_CICLO_FORMATIVO("Insertar un ciclo formativo"),
    BORRAR_CICLO_FORMATIVO("Borrar un ciclo formativo"),
    LISTAR_CICLOS_FORMATIVOS("Listar todos los ciclos formativos"),
    MATRICULAR_ALUMNO("Matricular un alumno en una asignatura"),
    BORRAR_MATRICULA("Borrar una matrícula"),
    LISTAR_MATRICULAS("Listar todas las matrículas"),
    BUSCAR_ALUMNO("Buscar un alumno"),
    MOSTRAR_ALUMNOS("Mostar alumnos"),
    BUSCAR_ASIGNATURA("Buscar una asignatura"),
    BUSCAR_MATRICULA("Buscar una matricula"),
    BUSCAR_CICLOS_FORMATIVOS("Buscar ciclos formativos"),
    MOSTRAR_MATRICULAS_ALUMNO("Mostrar las matriculas de un alumno"),
    MOSTRAR_MATRICULAS_CICLO("Mostrar las matriculas de un ciclo"),
    MOSTRAR_MATRICULAS_CURSO("Mostrar las matriculas de un curso");

    private final String mensaje;

    Opcion(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    @Override
    public String toString() {
        return String.format("%d.- %s", ordinal(), mensaje);
    }
}
