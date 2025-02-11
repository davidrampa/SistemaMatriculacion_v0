package org.iesalandalus.programacion.matriculacion.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Alumno {

    // Constantes
    public static final String FORMATO_FECHA = "dd/MM/yyyy";
    public static final int MIN_EDAD_ALUMNADO = 16;
    private static final String REGEX_DNI = "^(\\d{8})([A-Za-z])$";
    private static final String REGEX_TELEFONO = "^\\d{9}$";
    private static final String REGEX_EMAIL = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    // Atributos
    private String nombre;
    private String telefono;
    private String email;
    private String dni;
    private LocalDate fechaNacimiento;
    private String nia;

    // Constructor con parámetros
    public Alumno(String nombre, String telefono, String email, String dni, LocalDate fechaNacimiento) {
        setNombre(nombre);
        setTelefono(telefono);
        setEmail(email);
        setDni(dni);
        setFechaNacimiento(fechaNacimiento);
        generarNia();
    }

    // Constructor copia
    public Alumno(Alumno otro) {
        this(otro.nombre, otro.telefono, otro.email, otro.dni, otro.fechaNacimiento);
    }

    public Alumno(String nombreFicticio, String apellidoFicticio, String dni) {

    }

    public Alumno() {

    }

    // Métodos de acceso y modificación
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = formateaNombre(nombre);
        generarNia();
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (!Pattern.matches(REGEX_TELEFONO, telefono)) {
            throw new IllegalArgumentException("Teléfono no válido.");
        }
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!Pattern.matches(REGEX_EMAIL, email)) {
            throw new IllegalArgumentException("Correo no válido.");
        }
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if (!Pattern.matches(REGEX_DNI, dni) || !comprobarLetraDni(dni)) {
            throw new IllegalArgumentException("DNI no válido.");
        }
        this.dni = dni;
        generarNia();
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if (fechaNacimiento.plusYears(MIN_EDAD_ALUMNADO).isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("El alumno debe tener al menos 16 años.");
        }
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNia() {
        return nia;
    }

    // Métodos adicionales
    private void generarNia() {
        if (nombre != null && dni != null) {
            String nombrePart = nombre.toLowerCase().replaceAll("\\s+", "").substring(0, Math.min(4, nombre.length()));
            String dniPart = dni.substring(dni.length() - 3);
            this.nia = nombrePart + dniPart;
        }
    }

    public static String formateaNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        String[] palabras = nombre.trim().split("\\s+");
        StringBuilder formateado = new StringBuilder();
        for (String palabra : palabras) {
            formateado.append(Character.toUpperCase(palabra.charAt(0)))
                    .append(palabra.substring(1).toLowerCase())
                    .append(" ");
        }
        return formateado.toString().trim();
    }

    private boolean comprobarLetraDni(String dni) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        Matcher matcher = Pattern.compile(REGEX_DNI).matcher(dni);
        if (matcher.matches()) {
            int numero = Integer.parseInt(matcher.group(1));
            char letraCalculada = letras.charAt(numero % 23);
            return letraCalculada == Character.toUpperCase(matcher.group(2).charAt(0));
        }
        return false;
    }

    public String getIniciales() {
        StringBuilder iniciales = new StringBuilder();
        for (String palabra : nombre.split("\\s+")) {
            iniciales.append(Character.toUpperCase(palabra.charAt(0)));
        }
        return iniciales.toString();
    }

    // Métodos equals y hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Alumno alumno = (Alumno) obj;
        return dni.equals(alumno.dni);
    }

    @Override
    public int hashCode() {
        return dni.hashCode();
    }

    //Metodo to String
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATO_FECHA);
        return String.format("Alumno[nombre=%s, telefono=%s, email=%s, dni=%s, fechaNacimiento=%s, nia=%s]",
                nombre, telefono, email, dni, fechaNacimiento.format(formatter), nia);
    }

    public ScopedValue<Object> map(Object o) {
        return null;
    }
}
