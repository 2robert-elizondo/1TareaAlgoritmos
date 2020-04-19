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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ManejoArchivos ma = new ManejoArchivos();

        
   
        try {
            ma.solicitarArchivo();
            System.out.println(ma.imprimirLista());
        } catch (ExcepcionGeneral ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
