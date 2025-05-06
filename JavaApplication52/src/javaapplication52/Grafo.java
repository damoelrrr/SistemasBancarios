package javaapplication52;

import java.util.ArrayList;
import java.util.List;

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
        personas.add(persona);
    }

    public void conectarPersonas(Persona a, Persona b) {
        a.agregarConexion(b);
        b.agregarConexion(a); // grafo no dirigido
    }

}
