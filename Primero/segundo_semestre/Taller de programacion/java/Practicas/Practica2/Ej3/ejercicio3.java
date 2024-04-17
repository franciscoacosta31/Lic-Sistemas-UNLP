/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practicas.Practica2.Ej3;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
import tema2.Persona;
/**
 *
 * @author Frann
 */
public class ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int unDNI, unaEdad; String unNom;
       GeneradorAleatorio.iniciar();

       Persona[][] casting = new Persona[5][8]; 
       
       unDNI = GeneradorAleatorio.generarInt(99999999);
       unaEdad = GeneradorAleatorio.generarInt(99);
       unNom = GeneradorAleatorio.generarString(20);
       int cant = 0;         
       int i = 0; int j = 0; int m = 0;
       while(!(unNom.equals("ZZZ")) && (i<5)){
           j = 0;
            while(!(unNom.equals("ZZZ")) && (j<8)){
                   casting[i][j] = new Persona(unNom,unDNI,unaEdad);
                   unDNI = GeneradorAleatorio.generarInt(99999999);
                   unaEdad = GeneradorAleatorio.generarInt(99);
                   unNom = GeneradorAleatorio.generarString(20);
                   j++;
                   cant++;
            } 
            i++;
        }
    
       int columns = 8;
       for (int x = 0; x < i; x++) {
           // si es la ultima fila, columnas = j, esto recorre hasta j (ultimo ingresado)
           if (x == i - 1) {
               columns = j;
                for (int y = 0; y < columns; y++) {
                    if (casting[x][y] != null)
                          System.out.println(casting[x][y].getNombre());
                }
           }    
           else
               for (int y = 0; y < columns; y++)                
                    System.out.println(casting[x][y].getNombre());
       }
    }
}    