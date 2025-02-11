package org.iesalandalus.programacion.matriculacion.modelo.negocio;

import org.iesalandalus.programacion.matriculacion.modelo.dominio.Alumno;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Alumnos {
    // Atributo
    private List<Alumno> alumnos;

    // Constructor
    public Alumnos() {
        this.alumnos = new ArrayList<>();
    }

    // Métodos

    public List<Alumno> getLista() {
        return new ArrayList<>(alumnos); // Copia segura de la lista
    }

    public void insertar(Alumno alumno) {
        if (alumno == null) {
            throw new IllegalArgumentException("El alumno no puede ser nulo.");
        }
        if (alumnos.contains(alumno)) {
            throw new IllegalArgumentException("El alumno ya está en la colección.");
        }
        alumnos.add(alumno);
    }

    public Alumno buscar(String nombreAlumno) {
        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equalsIgnoreCase(nombreAlumno)) {
                return alumno;
            }
        }
        return null; // Si no se encuentra
    }

    public boolean borrar(String nombreAlumno) {
        Alumno alumno = buscar(nombreAlumno);
        return alumno != null && alumnos.remove(alumno);
    }

    public int getTamano() {
        return alumnos.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Lista de alumnos:\n");
        for (Alumno alumno : alumnos) {
            sb.append(alumno).append("\n");
        }
        return sb.toString().trim();
    }

    public Optional<Object> stream() {
        return null;
    }
}
