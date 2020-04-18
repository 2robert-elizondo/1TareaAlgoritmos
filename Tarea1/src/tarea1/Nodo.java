/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;

import tarea1.Persona;

/**
 *
 * @author Fer Alvarado
 */
public class Nodo {
   private Persona person;
   private int dato;
   private Nodo siguiente;

    public Nodo(Persona person, int dato, Nodo siguiente) {
        this.person = person;
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public Nodo() {
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
    
   
           
    
}
