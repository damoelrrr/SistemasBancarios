package javaapplication52;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Persona {

    private String nombre;
    private String documento;
    private List<Persona> conexiones;
    private List<CuentaBancaria> cuentas;

    public Persona(String nombre, String documento, int edad, String documento1, String correo, String telefono, String direccion) {
        if (nombre == null || nombre.isEmpty() || documento == null || documento.isEmpty()) {
            throw new IllegalArgumentException("Nombre y documento no pueden ser nulos o vacíos.");
        }
        this.nombre = nombre;
        this.documento = documento;
        this.conexiones = new ArrayList<>();
        this.cuentas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public List<Persona> getConexiones() {
        return conexiones;
    }

    public List<CuentaBancaria> getCuentas() {
        return cuentas;
    }

    public void agregarCuenta(CuentaBancaria cuenta) {
        if (cuenta != null && !cuentas.contains(cuenta)) {
            cuentas.add(cuenta);
        } else {
            System.out.println("La cuenta ya existe o es nula.");
        }
    }

    public void eliminarCuenta(CuentaBancaria cuenta) {
        cuentas.remove(cuenta);
    }

    public void agregarConexion(Persona persona) {
        if (persona != null && !conexiones.contains(persona)) {
            conexiones.add(persona);
        } else {
            System.out.println("Ya está conectada con esta persona o la persona es nula.");
        }
    }

    public void eliminarConexion(Persona persona) {
        conexiones.remove(persona);
    }

    public void mostrarCuentas() {
        for (CuentaBancaria cuenta : cuentas) {
            System.out.println(cuenta);
        }
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", documento=" + documento + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Persona)) {
            return false;
        }
        Persona persona = (Persona) o;
        return documento.equals(persona.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documento);
    }

    CuentaBancaria getCuentaBancaria(String numeroCuenta) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
        
    }
}
