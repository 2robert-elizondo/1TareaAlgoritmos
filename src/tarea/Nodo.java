/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea;

/**
 *
 * @author rober
 */
public class Nodo {
    private Persona person;

   private int dato;
   private Nodo siguiente;
   private Nodo anterior;

   public Nodo() {
       this(null, 0, null, null);
    }
   
    public Nodo(Persona person, int dato, Nodo siguiente, Nodo anterior) {
        this.person = person;
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public Persona getPerson() {
        return person;
    }

    public void setPerson(Persona person) {
        this.person = person;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    

    
}
