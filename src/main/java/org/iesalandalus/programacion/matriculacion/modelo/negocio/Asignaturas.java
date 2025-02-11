package org.iesalandalus.programacion.matriculacion.modelo.negocio;

import org.iesalandalus.programacion.matriculacion.modelo.dominio.Asignatura;
import java.util.ArrayList;
import java.util.List;

public class Asignaturas {
    private List<Asignatura> listaAsignaturas;

    public Asignaturas() {
        listaAsignaturas = new ArrayList<>();
    }

    public List<Asignatura> getLista() {
        return new ArrayList<>(listaAsignaturas); // Copia segura para evitar modificaciones externas
    }

    public void insertar(Asignatura asignatura) {
        if (asignatura == null) {
            throw new NullPointerException("La asignatura no puede ser nula.");
        }
        if (listaAsignaturas.contains(asignatura)) {
            throw new IllegalArgumentException("La asignatura ya está en la lista.");
        }
        listaAsignaturas.add(asignatura);
    }

    public Asignatura buscar(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la asignatura no puede estar vacío.");
        }
        return listaAsignaturas.stream()
                .filter(asignatura -> asignatura.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    public void borrar(String nombre) {
        Asignatura asignatura = buscar(nombre);
        if (asignatura == null) {
            throw new IllegalArgumentException("La asignatura no se encuentra en la lista.");
        }
        listaAsignaturas.remove(asignatura);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Lista de asignaturas:\n");
        for (Asignatura asignatura : listaAsignaturas) {
            sb.append(asignatura).append("\n");
        }
        return sb.toString().trim();
    }
}
