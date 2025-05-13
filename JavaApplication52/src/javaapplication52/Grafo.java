package javaapplication52;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Grafo {

    private List<Persona> personas;

    public Grafo() {
        this.personas = new ArrayList<>();
    }

    public Grafo(List<Persona> personas) {
        this.personas = personas;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public void agregarPersona(Persona persona) {
        if (!personas.contains(persona)) {
            personas.add(persona);
        } else {
            System.out.println("La persona ya existe en el grafo.");
        }
    }

    public void conectarPersonas(Persona a, Persona b) {
        if (a != null && b != null && !a.equals(b)) {
            a.agregarConexion(b);
            b.agregarConexion(a);
        } else {
            System.out.println("No se puede conectar a la misma persona o alguna de las personas es nula.");
        }
    }

    public void desconectarPersonas(Persona a, Persona b) {
        if (a != null && b != null) {
            a.eliminarConexion(b);
            b.eliminarConexion(a);
        } else {
            System.out.println("No se puede desconectar si alguna de las personas es nula.");
        }
    }

    public void mostrarGrafo() {
        for (Persona p : personas) {
            System.out.print(p.getNombre() + " está conectado con: ");
            for (Persona con : p.getConexiones()) {
                System.out.print(con.getNombre() + " ");
            }
            System.out.println();
        }
    }

    public static Persona buscarPersonaPorDocumento(Grafo grafo, String documento) {
        Persona persona = null;
        for (Persona p : grafo.getPersonas()) {
            if (p.getDocumento().equals(documento)) {
                persona = p;
                break;
            }
        }
        if (persona == null) {
            System.out.println("Persona con documento " + documento + " no encontrada.");
        }
        return persona;
    }

}
