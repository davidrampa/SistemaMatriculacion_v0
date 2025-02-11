package org.iesalandalus.programacion.matriculacion.modelo.negocio;

import org.iesalandalus.programacion.matriculacion.modelo.dominio.Alumno;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.CicloFormativo;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.Matricula;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Matriculas {
    private List<Matricula> listaMatriculas;

    // Constructor sin capacidad fija
    public Matriculas() {
        this.listaMatriculas = new ArrayList<>();
    }

    public List<Matricula> getLista() {
        return new ArrayList<>(listaMatriculas); // Copia segura para evitar modificaciones externas
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

    public Matricula buscar(int id) {
        return listaMatriculas.stream()
                .filter(matricula -> matricula.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void borrar(int id) {
        Matricula matricula = buscar(id);
        if (matricula == null) {
            throw new IllegalArgumentException("La matrícula no se encuentra en la lista.");
        }
        listaMatriculas.remove(matricula);
    }

    private List<Matricula> copiaProfundaMatriculas() {
        return listaMatriculas.stream()
                .map(matricula -> new Matricula(new Alumno(), matricula)) // Copia profunda
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Lista de matrículas:\n");
        for (Matricula matricula : listaMatriculas) {
            sb.append(matricula).append("\n");
        }
        return sb.toString().trim();
    }
}

