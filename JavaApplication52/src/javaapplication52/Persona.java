package javaapplication52;

import java.util.ArrayList;
import java.util.List;

public class Persona {

    private String nombre;
    private String documento;
    private List<Persona> conexiones;
    private List<CuentaBancaria> cuentas;

    public Persona(String nombre, String documento) {
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
        cuentas.add(cuenta);
    }

    public void agregarConexion(Persona persona) {
        if (!conexiones.contains(persona)) {
            conexiones.add(persona);
        }
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", documento=" + documento + '}';
    }
}
