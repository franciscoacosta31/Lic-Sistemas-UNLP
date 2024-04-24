/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practicas.Practica2.Ej1;

import PaqueteLectura.Lector;
import tema2.Persona;
/**
 *
 * @author Frann
 */
public class ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        String nom;
        int dni,edad;
       
        System.out.println("ingrese el nombre");
        nom = Lector.leerString();
        
        System.out.println("Ingrese el dni");
        dni = Lector.leerInt();
        
        System.out.println("Ingrese la edad");
        edad = Lector.leerInt();
        
        Persona p = new Persona(nom,dni,edad);
        
        System.out.println(p.toString());
        
        
        
        
    }
    
}
