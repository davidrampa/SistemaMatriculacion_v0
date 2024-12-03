package org.iesalandalus.programacion.matriculacion.negocio;

import org.iesalandalus.programacion.matriculacion.dominio.Alumno;

import java.util.ArrayList;
import java.util.List;

public class Alumnos {
    //Atributos
    private List<Alumno> alumnos;
    private int capacidad;

    //Constructor
    public Alumnos(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que 0.");
        }
        this.capacidad = capacidad;
        this.alumnos = new ArrayList<>(capacidad);
    }

    //Metodos

    public List<Alumno> get() {
        return copiaProfundaAlumnos(alumnos);
    }

    private List<Alumno> copiaProfundaAlumnos(List<Alumno> original) {
        List<Alumno> copia = new ArrayList<>(original.size());
        for (Alumno alumno : original) {
            copia.add(new Alumno(alumno));
        }
        return copia;
    }

    public void insertar(Alumno alumno) {
        if (alumno == null) {
            throw new IllegalArgumentException("El alumno no puede ser nulo.");
        }
        if (alumnos.contains(alumno)) {
            throw new IllegalArgumentException("El alumno ya esta en la coleccion.");
        }
        if (alumnos.size() >= capacidad) {
            throw new IllegalArgumentException("No se pueden insertar mas alumnos, la capacidad maxima esta completa.");
        }
        alumnos.add(alumno);
    }

    public Alumno buscar(Alumno alumno) {
        int index = alumnos.indexOf(alumno);
        return (index != -1) ? alumnos.get(index) : null;
    }

    public boolean borrar(Alumno alumno) {
        return alumnos.remove(alumno);
    }

    public int getTamano() {
        return alumnos.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Lista de alumnos: \n");
        for (Alumno alumno : alumnos) {
            sb.append(alumno.toString()).append("\n");
        }
        return sb.toString().trim();
    }
}
