/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author rober
 */
public class Main {

    /**
     * @param args the command line arguments
     */
        
    public static void main(String[] args) {
        
        Lista ma = new Lista();
        boolean bandera = true;
        while(bandera){
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
        
        
        
        
            int cedula;
            String nombre;
            String apellido;
            int edad;
        switch (opcion){
            
            case 1:
                Persona persona;
                cedula = Integer.parseInt(JOptionPane.showInputDialog(
                        "Digite la cedula"));
                nombre = JOptionPane.showInputDialog("Ingrese el "
                        + "nombre");
                apellido = JOptionPane.showInputDialog("Ingrese el "
                        + "apellido");
                edad = Integer.parseInt(JOptionPane.showInputDialog(
                        "Digite la edad"));
                
                persona = new Persona(cedula, nombre, apellido, edad);
                ma.agregarPersona(persona);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, ma.imprimirAtras());
                break;
            case 3:
                JOptionPane.showMessageDialog(null, ma.imprimirDelante());
                break;
            case 4:
                cedula = Integer.parseInt(JOptionPane.showInputDialog(
                        "Digite la cedula"));
                {
                    try {
                        JOptionPane.showMessageDialog(null, ma.consultaCedula(
                                cedula));
                    } catch (ExcepcionGeneral ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                break;

            case 5:
                apellido = JOptionPane.showInputDialog("Ingrese el "
                        + "apellido");
               try {
                        JOptionPane.showMessageDialog(null, ma.consultaApellido(
                                apellido));
                    } catch (ExcepcionGeneral ex) {
                        System.out.println(ex.getMessage());
                    }
                break;
            case 6:
               cedula = Integer.parseInt(JOptionPane.showInputDialog(
                        "Digite la cedula"));
                
                    try {
                        JOptionPane.showMessageDialog(null, ma.eliminarCedula(
                                cedula));
                    } catch (ExcepcionGeneral ex) {
                        System.out.println(ex.getMessage());
                    }
                break;
            case 7:
                apellido = JOptionPane.showInputDialog("Ingrese el "
                        + "apellido");
                try {
                        JOptionPane.showMessageDialog(null, ma.eliminarApellido(
                                apellido));
                    } catch (ExcepcionGeneral ex) {
                        System.out.println(ex.getMessage());
                    }
                break;
            case 8:
                {
                    try {
                        JOptionPane.showMessageDialog(null, ma.calculoPromedioEdad());
                    } catch (ExcepcionGeneral ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

            case 9:
            {
                try {
                    ma.solicitarArchivo();
                } catch (ExcepcionGeneral ex) {
                    System.out.println(ex.getMessage());
                }
            }
                break;

            case 10:
                bandera=false;
                break;
            default:
               
                break;
        }

        }
        
    }
    
}
