package org.iesalandalus.programacion.matriculacion.modelo.negocio;

import org.iesalandalus.programacion.matriculacion.modelo.dominio.Alumno;
import org.iesalandalus.programacion.matriculacion.modelo.dominio.Asignatura;

import java.util.List;
import java.util.ArrayList;

public class Asignaturas {
    private List<Asignatura> listaAsignaturas;
    private int capacidad;


    public Asignaturas(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que cero.");
        }
        this.capacidad = capacidad;
        listaAsignaturas = new ArrayList<>(capacidad);
    }

    public List<Asignatura> getLista() {
        return new ArrayList<>(listaAsignaturas);
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

    public Asignatura buscar(String asignatura) {
        int indice = listaAsignaturas.indexOf(asignatura);
        return (indice != -1) ? listaAsignaturas.get(indice) : null;
    }

    public void borrar(String asignatura) {
        if (asignatura == null) {
            throw new NullPointerException("La asignatura no puede ser nula.");
        }
        if (!listaAsignaturas.remove(asignatura)) {
            throw new IllegalArgumentException("La asignatura no se encuentra en la lista.");
        }
    }

    private List<Asignatura> copiaProfundaAsignaturas() {
        List<Asignatura> copia = new ArrayList<>(listaAsignaturas.size());
        for (Asignatura asignatura : listaAsignaturas) {
            copia.add(new Asignatura(asignatura));
        }
        return copia;
    }
}
