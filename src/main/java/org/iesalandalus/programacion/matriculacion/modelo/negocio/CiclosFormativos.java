package org.iesalandalus.programacion.matriculacion.modelo.negocio;

import org.iesalandalus.programacion.matriculacion.modelo.dominio.CicloFormativo;

import java.util.ArrayList;
import java.util.List;

public class CiclosFormativos {
    // Atributos
    private List<CicloFormativo> ciclosFormativos;
    private int capacidad;
    int listaCicloFormativo;

    // Constructor
    public CiclosFormativos(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que 0.");
        }
        this.capacidad = capacidad;
        this.ciclosFormativos = new ArrayList<>(capacidad);
    }

    // Métodos
    public List<CicloFormativo> getLista() {
        return new ArrayList<>(listaCicloFormativo);
    }



    private List<CicloFormativo> copiaProfundaCiclosFormativos(List<CicloFormativo> original) {
        List<CicloFormativo> copia = new ArrayList<>(original.size());
        for (CicloFormativo ciclo : original) {
            copia.add(new CicloFormativo(ciclo)); // Constructor copia en la clase CicloFormativo.
        }
        return copia;
    }


    public void insertar(CicloFormativo ciclo) {
        if (ciclo == null) {
            throw new NullPointerException("El ciclo formativo no puede ser nulo.");
        }
        if (ciclosFormativos.contains(ciclo)) {
            throw new IllegalArgumentException("El ciclo formativo ya está en la colección.");
        }
        if (ciclosFormativos.size() >= capacidad) {
            throw new IllegalStateException("No se pueden insertar más ciclos formativos, la capacidad máxima está completa.");
        }
        ciclosFormativos.add(ciclo);
    }


    public CicloFormativo buscar(String ciclo) {
        int index = ciclosFormativos.indexOf(ciclo);
        return (index != -1) ? ciclosFormativos.get(index) : null;
    }


    public boolean borrar(String ciclo) {
        return ciclosFormativos.remove(ciclo);
    }


    public int getTamano() {
        return ciclosFormativos.size();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Lista de ciclos formativos:\n");
        for (CicloFormativo ciclo : ciclosFormativos) {
            sb.append(ciclo.toString()).append("\n");
        }
        return sb.toString().trim();
    }
}
