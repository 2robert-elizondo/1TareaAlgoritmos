/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea;

import javax.swing.JOptionPane;


/**
 *
 * @author rober
 */
public class Main {

    /**
     * @param args the command line arguments
     */
        
              Lista ma = new Lista();
    
        int opcion=Integer.parseInt(JOptionPane.showInputDialog(null, "Digite la opcion que desea realizar\n"+
"1.              Ingresar persona\n" +
"2.              Mostrar lista de personas del primero al Ãºltimo elemento\n" +
"3.              Mostrar lista de personas del Ãºltimo al primer elemento\n" +
"4.              Consultar por nÃºmero de cÃ©dula\n" +
"5.              Listar personas por apellido\n" +
"6.              Eliminar personas por numero de cÃ©dula\n" +
"7.              Eliminar personas por apellido\n" +
"8.              Calcular el promedio de edad\n" +
"9.              Cargar datos de un archivo\n" +
"10.            Salir"));
        
        boolean bandera=true;
        
        while(bandera){

        switch (opcion){
            case 1:
               
                break;
            case 2:
               
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 5:
               
                break;
            case 6:
               
                break;
            case 7:
                
                break;
            case 8:
                
                break;
            case 9:
           
                break;
            case 10:
                bandera=false;
                break;
            default:
               
                break;
        }

        }
   
       //try {
         //   ma.solicitarArchivo();
           // System.out.println(ma.imprimirLista());
        //} catch (ExcepcionGeneral ex) {
          //  System.out.println(ex.getMessage());
        //}
      



        
   
        try {
            ma.solicitarArchivo();
            System.out.println(ma.imprimirDelante());
            System.out.println(ma.imprimirAtras());
            
            System.out.println("\nConsullta apellido: " + ma.consultaApellido("Arias"));
            
            System.out.println("\nConsulta cedula" + ma.consultaCedula(202400119));
            
            System.out.println("\nEliminar Arias" + ma.eliminarApellido("Arias"));
            System.out.println(ma.imprimirDelante());
            System.out.println(ma.imprimirAtras());
            
            System.out.println("\nEliminar Arias de nuevo: " + ma.eliminarCedula(202400119));
            System.out.println("\nEliminar otro: " +ma.eliminarCedula(111110011));
            System.out.println(ma.imprimirDelante());
            System.out.println(ma.imprimirAtras());
            
            
        } catch (ExcepcionGeneral ex) {
            System.out.println(ex.getMessage());
        }
        catch (NullPointerException ex) {
            System.out.println(ex.getMessage() + ex.getStackTrace());
        }
        
    }
    
}
