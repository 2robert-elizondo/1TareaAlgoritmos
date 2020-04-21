/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



/**
 *
 * @author rober
 */
public class Lista {
    
    
     private BufferedReader bf;
     private Nodo primero, ultimo;

    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }
    
    public void agregarPersona(Persona persona){
        Nodo nuevo = new Nodo();
        nuevo.setPersona(persona);
        if(primero == null)
            primero = ultimo = nuevo;
        else{
        ultimo.setSiguiente(nuevo);
        ultimo = nuevo;
        }
            
    }
    
    public String imprimirDelante(){
        String txt = "";
        Nodo actual = primero;
        while(actual != null){
            txt += actual.getPersona().toString() + "\n";
            actual = actual.getSiguiente();
        }
        return txt;
    }
            
    public String imprimirAtras(){
        String txt = "";
        Nodo actual = ultimo;
        while(actual != null){
            txt += actual.getPersona().toString() + "\n";
            actual = actual.getAnterior();
        }
        return txt;
    }
    
    public String consultaCedula(int cedula) throws ExcepcionGeneral{
        Persona personaAuxiliar;
        String txt = "La persona buscada no existe en la lista.";
        int CEDULA_MAXIMA = 999999999;
        int CEDULA_MINIMA = 000000000;
        if(cedula < CEDULA_MINIMA || cedula > CEDULA_MAXIMA)
            throw new ExcepcionGeneral("La cedula es invalida");
        if(primero == null)
            throw new ExcepcionGeneral("La lista esta vacia");
        
        Nodo actual = primero;

        while(actual != null){
            personaAuxiliar = actual.getPersona();
            if(personaAuxiliar.getCedula() == cedula){
                return actual.getPersona().toString();
            }
            actual = actual.getSiguiente();
        }
        return txt;
    }
    public String consultaApellido(String apellido) throws ExcepcionGeneral{
        Persona personaAuxiliar;
        String txt = "";
        Nodo actual = primero;

        while(actual != null){
            personaAuxiliar = actual.getPersona();
            if(personaAuxiliar.getApellido().equalsIgnoreCase(apellido)){
                txt += "\n" +  actual.getPersona().toString();
            }
            actual = actual.getSiguiente();
        }
        if(txt.equals(""))
            txt = "El apellido " + apellido + " no existe en la lista.";
        return txt;
    }
    
    public String eliminarCedula(int cedula) throws ExcepcionGeneral{
        Persona personaAuxiliar;
        String txt = "La persona buscada no existe en la lista.";
        int CEDULA_MAXIMA = 999999999;
        int CEDULA_MINIMA = 000000000;
        if(cedula < CEDULA_MINIMA || cedula > CEDULA_MAXIMA)
            throw new ExcepcionGeneral("La cedula es invalida");
        if(primero == null)
            throw new ExcepcionGeneral("La lista esta vacia");
      
        if(primero.getPersona().getCedula() == cedula){
            personaAuxiliar = primero.getPersona();
            if(primero == ultimo)
                primero = null;
            else{
                primero.getSiguiente().setAnterior(null);
                primero = primero.getSiguiente();
            }
            return personaAuxiliar.toString();
        }
        
        Nodo actual = primero;
        while(actual.getSiguiente() != null){
            personaAuxiliar = actual.getSiguiente().getPersona();
            if(personaAuxiliar.getCedula() == cedula){
                txt = personaAuxiliar.toString();
                actual.getSiguiente().getSiguiente().setAnterior(actual);
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return txt;
            }
            actual = actual.getSiguiente();
        }
        if(actual == ultimo){
            if(actual.getPersona().getCedula() == cedula){
                txt = actual.getPersona().toString();
                ultimo = null;
                return txt;
            }
        }
        return txt;
    }
            
    
    public String eliminarApellido(String apellido) throws ExcepcionGeneral{
        Persona personaAuxiliar;
        String txt = "";

        if(primero.getPersona().getApellido().equalsIgnoreCase(apellido)){
            personaAuxiliar = primero.getPersona();
            if(primero == ultimo)
                primero = null;
            else{
                primero.getSiguiente().setAnterior(null);
                primero = primero.getSiguiente();
            }
            txt = personaAuxiliar.toString();
        }
        
        Nodo actual = primero;
        while(actual != null && actual.getSiguiente() != null){
            personaAuxiliar = actual.getSiguiente().getPersona();
            if(personaAuxiliar.getApellido().equalsIgnoreCase(apellido)){
                if(txt.equals("")){
                    txt = personaAuxiliar.toString();
                    actual.getSiguiente().getSiguiente().setAnterior(actual);
                    actual.setSiguiente(actual.getSiguiente().getSiguiente());
                }
                else{
                txt += personaAuxiliar.toString();
                actual.getSiguiente().getSiguiente().setAnterior(actual);
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                
                }
            }
            actual = actual.getSiguiente();
        }
        if(actual == ultimo){
            if(actual != null && actual.getPersona().getApellido().equalsIgnoreCase(apellido)){
                txt += actual.getPersona().toString();
                ultimo = null;
                return txt;
            }
        }
        if(txt.equals(""))
            txt = "El apellido " + apellido + " no existe en la lista.";
        return txt;
    }
    
    public double calculoPromedioEdad() throws ExcepcionGeneral{
        if(primero == null)
            throw new ExcepcionGeneral("La lista esta vacia");
        double promedioTotal = -1;
        Nodo actual = primero;
        Persona persona;
        ArrayList<Integer> edades = new ArrayList<>();
        while(actual != null){
            persona = actual.getPersona();
            edades.add(persona.getEdad());
            actual = actual.getSiguiente();
        }
            
        if(!edades.isEmpty()){
            promedioTotal = 0;
            for (Integer edad : edades) {
                promedioTotal += edad;
            }
            promedioTotal = promedioTotal / edades.size();
        }
         return promedioTotal;   
    }

    public void solicitarArchivo() throws ExcepcionGeneral{
        JFileChooser fc = new JFileChooser();
        
        int elegir = fc.showOpenDialog(JOptionPane.getRootFrame());
        if(JFileChooser.APPROVE_OPTION == elegir){
            File archivo = fc.getSelectedFile();
            
            try (FileReader lector = new FileReader(archivo)){
                 bf = new BufferedReader(lector);
                 String lineaLeida;
                 
                while((lineaLeida = bf.readLine()) != null){
                    System.out.println("La linea leida dice: " + lineaLeida);
                    String[] datosPersona = lineaLeida.split(",");
                    Persona personaAux = new Persona();
                    
                    for (int i = 0; i < datosPersona.length; i++) {
                        String info = datosPersona[i];
                        char[] letras = info.toCharArray();
                        
                        
                        switch(i){
                            
                            case 0:
                                System.out.println("length: " + info.length());
                                System.out.println("cedula:" + info);
                                if(info.length() != 9)
                                    throw new ExcepcionGeneral("Existe un valor"
                                            + " invalido en la cedula");
                                
                                for (char letra : letras) {
                                    if(!Character.isDigit(letra))
                                        throw new ExcepcionGeneral("Existe un"
                                              + " valor invalido en la cedula");
                                }
                                
                                personaAux.setCedula(Integer.parseInt(info));
                                break;
                                
                            case 1:
                                if(info.length() == 0)
                                    throw new ExcepcionGeneral(
                                            "No existe un nombre");
                                for (char letra : letras) {
                                    if(letra != ' '){
                                    if(!Character.isUpperCase(letra) && 
                                            !Character.isLowerCase(letra))
                                        throw new ExcepcionGeneral
                                        ("El apellido tiene caracteres invaidos");
                                    }
                                }
                                
                                personaAux.setNombre(info);
                                
                                break;
                                
                            case 2:
                                if(info.length() == 0)
                                    throw new ExcepcionGeneral(
                                            "No existe un apellido");
                                 for (char letra : letras) {
                                    if(letra != ' '){
                                    if(!Character.isUpperCase(letra) && 
                                            !Character.isLowerCase(letra))
                                        throw new ExcepcionGeneral
                                        ("El apellido tiene caracteres invaidos");
                                    }
                                }
                                
                                personaAux.setApellido(info);
                                break;
                                
                            case 3:
                                if(info.length() == 0 || info.length() > 3)
                                    throw new ExcepcionGeneral("La edad es "
                                            + "invalida, hay un numero excesivo"
                                            + " no correspondiente a una edad "
                                            + "natural");
                                for (char letra : letras) {
                                    if(!Character.isDigit(letra))
                                        throw new ExcepcionGeneral("Existe un"
                                              + " valor invalido en la cedula");
                                }
                                
                                personaAux.setEdad(Integer.parseInt(info));
                                break;
                        }
                        
                    }
                    Nodo nuevo = new Nodo();
                    nuevo.setPersona(personaAux);
                    if(primero == null)
                        primero = ultimo =  nuevo;
                    else{
                            ultimo.setSiguiente(nuevo);
                            nuevo.setAnterior(ultimo);
                            ultimo = nuevo;
                        }
                }
            } catch (FileNotFoundException ex) {
                throw new ExcepcionGeneral(ex.getMessage() +
                        "El archivo no existe");
            } catch (IOException ex) {
                throw new ExcepcionGeneral(ex.getMessage() +
                        "Error de entrada o salida");
            }
            
            
        }
        
    }
    
        
    
}
