package org.iesalandalus.programacion.matriculacion.modelo.negocio;

import org.iesalandalus.programacion.matriculacion.modelo.dominio.Alumno;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.Asignatura;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.CicloFormativo;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.Matricula;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Matriculas {

    private List<Matricula> listaMatriculas;

    /**
     * Constructor con capacidad inicial.
     *
     * @param capacidad Capacidad inicial de la lista de matrículas.
     */
    public Matriculas(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que cero.");
        }
        this.listaMatriculas = new ArrayList<>(capacidad);
    }

    public List<Matricula> getLista() {
        return new ArrayList<>(listaMatriculas);
    }

    public List<Matricula> get(Alumno alumno) {
        if (alumno == null) {
            throw new NullPointerException("El alumno no puede ser nulo.");
        }
        return listaMatriculas.stream()
                .filter(matricula -> matricula.getAlumno().equals(alumno))
                .collect(Collectors.toList());
    }

    public List<Matricula> get(String curso) {
        if (curso == null || !curso.matches("\\d{2}-\\d{2}")) {
            throw new IllegalArgumentException("El formato del curso académico es inválido.");
        }
        return listaMatriculas.stream()
                .filter(matricula -> matricula.getCursoAcademico().equals(curso))
                .collect(Collectors.toList());
    }

    public List<Matricula> get(CicloFormativo ciclo) {
        if (ciclo == null) {
            throw new NullPointerException("El ciclo formativo no puede ser nulo.");
        }
        return listaMatriculas.stream()
                .filter(matricula -> matricula.getCicloFormativo().equals(ciclo))
                .collect(Collectors.toList());
    }

    public void insertar(Matricula matricula) {
        if (matricula == null) {
            throw new NullPointerException("La matrícula no puede ser nula.");
        }
        if (listaMatriculas.contains(matricula)) {
            throw new IllegalArgumentException("La matrícula ya está en la lista.");
        }
        listaMatriculas.add(matricula);
    }

    public Matricula buscar(String matricula) {
        int index = listaMatriculas.indexOf(matricula);
        return (index != -1) ? listaMatriculas.get(index) : null;
    }

    public void borrar(String matricula) {
        if (matricula == null) {
            throw new NullPointerException("La matrícula no puede ser nula.");
        }
        if (!listaMatriculas.remove(matricula)) {
            throw new IllegalArgumentException("La matrícula no se encuentra en la lista.");
        }
    }

    private List<Matricula> copiaProfundaMatriculas() {
        List<Matricula> copia = new ArrayList<>();
        for (Matricula matricula : listaMatriculas) {
            copia.add(new Matricula(matricula.getId()));
        }
        return copia;
    }
}
