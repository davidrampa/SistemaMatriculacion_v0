package org.iesalandalus.programacion.matriculacion.vista;

public enum Opcion {

    SALIR("Salir de la aplicación") {
        @Override
        public void ejecutar() {
            vista.salir();
        }
    },
    INSERTAR_ALUMNO("Insertar un alumno") {
        @Override
        public void ejecutar() {
            vista.insertarAlumno();
        }
    },
    BORRAR_ALUMNO("Borrar un alumno") {
        @Override
        public void ejecutar() {
            vista.borrarAlumno();
        }
    },
    LISTAR_ALUMNOS("Listar todos los alumnos") {
        @Override
        public void ejecutar() {
            vista.listarAlumnos();
        }
    },
    INSERTAR_ASIGNATURA("Insertar una asignatura") {
        @Override
        public void ejecutar() {
            vista.insertarAsignatura();
        }
    },
    BORRAR_ASIGNATURA("Borrar una asignatura") {
        @Override
        public void ejecutar() {
            vista.borrarAsignatura();
        }
    },
    LISTAR_ASIGNATURAS("Listar todas las asignaturas") {
        @Override
        public void ejecutar() {
            vista.listarAsignaturas();
        }
    },
    INSERTAR_CICLO_FORMATIVO("Insertar un ciclo formativo") {
        @Override
        public void ejecutar() {
            vista.insertarCicloFormativo();
        }
    },
    BORRAR_CICLO_FORMATIVO("Borrar un ciclo formativo") {
        @Override
        public void ejecutar() {
            vista.borrarCicloFormativo();
        }
    },
    LISTAR_CICLOS_FORMATIVOS("Listar todos los ciclos formativos") {
        @Override
        public void ejecutar() {
            vista.listarCiclosFormativos();
        }
    },
    MATRICULAR_ALUMNO("Matricular un alumno en una asignatura") {
        @Override
        public void ejecutar() {
            vista.matricularAlumno();
        }
    },
    BORRAR_MATRICULA("Borrar una matrícula") {
        @Override
        public void ejecutar() {
            vista.borrarMatricula();
        }
    },
    LISTAR_MATRICULAS("Listar todas las matrículas") {
        @Override
        public void ejecutar() {
            vista.listarMatriculas();
        }
    },
    BUSCAR_ALUMNO("Buscar un alumno") {
        @Override
        public void ejecutar() {
            vista.buscarAlumno();
        }
    },
    MOSTRAR_ALUMNOS("Mostrar alumnos") {
        @Override
        public void ejecutar() {
            vista.mostrarAlumnos();
        }
    },
    BUSCAR_ASIGNATURA("Buscar una asignatura") {
        @Override
        public void ejecutar() {
            vista.buscarAsignatura();
        }
    },
    BUSCAR_MATRICULA("Buscar una matrícula") {
        @Override
        public void ejecutar() {
            vista.buscarMatricula();
        }
    },
    BUSCAR_CICLOS_FORMATIVOS("Buscar ciclos formativos") {
        @Override
        public void ejecutar() {
            vista.buscarCicloFormativo();
        }
    },
    MOSTRAR_MATRICULAS_ALUMNO("Mostrar las matrículas de un alumno") {
        @Override
        public void ejecutar() {
            vista.mostrarMatriculasAlumno();
        }
    },
    MOSTRAR_MATRICULAS_CICLO("Mostrar las matrículas de un ciclo") {
        @Override
        public void ejecutar() {
            vista.mostrarMatriculasCiclo();
        }
    },
    MOSTRAR_MATRICULAS_CURSO("Mostrar las matrículas de un curso") {
        @Override
        public void ejecutar() {
            vista.mostrarMatriculasCurso();
        }
    },
    INSERTAR_MATRICULA("Insertar una matrícula") {
        @Override
        public void ejecutar() {
            vista.insertarMatricula();
        }
    },
    LISTAR_CICLOS("Listar los ciclos formativos") {
        @Override
        public void ejecutar() {
            vista.listarCiclos();
        }
    };

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

    // Atributo estático de tipo Vista
    private static Vista vista;

    // Metodo para asignar la vista
    public static void setVista(Vista v) {
        vista = v;
    }

    // Metodo abstracto que ejecutará la opción
    public abstract void ejecutar();
}
