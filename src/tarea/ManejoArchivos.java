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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



/**
 *
 * @author rober
 */
public class ManejoArchivos {
    
    
     BufferedReader bf;
     ArrayList<Persona> personas = new ArrayList<>();

    public void solicitarArchivo() throws ExcepcionGeneral{
        JFileChooser fc = new JFileChooser();
        
        int elegir = fc.showOpenDialog(JOptionPane.getRootFrame());
        if(JFileChooser.APPROVE_OPTION == elegir){
            File archivo = fc.getSelectedFile();
            
            try (FileReader lector = new FileReader(archivo)){
                 bf = new BufferedReader(lector);
                 String lineaLeida;
                 
                while((lineaLeida = bf.readLine()) != null){
                    String[] datosPersona = lineaLeida.split(",");
                    Persona personaAux = new Persona();
                    
                    for (int i = 0; i < datosPersona.length; i++) {
                        String info = datosPersona[i];
                        char[] letras = info.toCharArray();
                        switch(i){
                            
                            case 0:
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
                                    if(!Character.isUpperCase(letra) && !Character.isLowerCase(letra))
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
                                    if(!Character.isUpperCase(letra) && !Character.isLowerCase(letra))
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
                    personas.add(personaAux);
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
    
    public String imprimirLista(){
        String txt = "";
        Iterator it = personas.iterator();
        while(it.hasNext()){
            txt += it.next().toString() + "\n";
        }
        return txt;
    }
            
            
}
