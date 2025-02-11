package org.iesalandalus.programacion.matriculacion.modelo.negocio;

import org.iesalandalus.programacion.matriculacion.modelo.dominio.CicloFormativo;
import java.util.ArrayList;
import java.util.List;

public class CiclosFormativos {
    // Lista de ciclos formativos
    private final List<CicloFormativo> ciclosFormativos;

    // Constructor sin capacidad fija
    public CiclosFormativos() {
        this.ciclosFormativos = new ArrayList<>();
    }

    public List<CicloFormativo> getLista() {
        return new ArrayList<>(ciclosFormativos);
    }

    public void insertar(CicloFormativo ciclo) {
        if (ciclo == null) {
            throw new NullPointerException("El ciclo formativo no puede ser nulo.");
        }
        if (ciclosFormativos.contains(ciclo)) {
            throw new IllegalArgumentException("El ciclo formativo ya está en la lista.");
        }
        ciclosFormativos.add(ciclo);
    }

    public CicloFormativo buscar(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del ciclo no puede estar vacío.");
        }
        return ciclosFormativos.stream()
                .filter(ciclo -> ciclo.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    public void borrar(String nombre) {
        CicloFormativo ciclo = buscar(nombre);
        if (ciclo == null) {
            throw new IllegalArgumentException("El ciclo formativo no se encuentra en la lista.");
        }
        ciclosFormativos.remove(ciclo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Lista de ciclos formativos:\n");
        for (CicloFormativo ciclo : ciclosFormativos) {
            sb.append(ciclo).append("\n");
        }
        return sb.toString().trim();
    }
}
