/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// MEJOR USAR VECTOR DE DIML
package Practicas.Practica2.Ej4;
import PaqueteLectura.GeneradorAleatorio;
import tema2.Persona;
public class ejercicio4 {
    public static void main(String[] args) {
       int unDNI, unaEdad, unDia; String unNom; 
       GeneradorAleatorio.iniciar();

       Persona[][] casting = new Persona[5][8]; 
       
       unDNI = GeneradorAleatorio.generarInt(99999999);
       unaEdad = GeneradorAleatorio.generarInt(99);
       unNom = GeneradorAleatorio.generarString(20);
       unDia = GeneradorAleatorio.generarInt(5);
       int cant = 0;         
       int i = 0; int j = 0; int m = 0; boolean libre = false;
       int x = 0; int y = 0; boolean flag = false; boolean flag2 = false;
       int dimL = 0;
       // DIa = Fila , Turno = Columna
       // Dado un dia guardar la persona. En que turno?
    
      
            while(!(unNom.equals("ZZZ")) && (dimL<40)){
                        y=0;
                        while(y<8){
                            // Si esta ocupado
                            if(casting[unDia][y] != null){
                                y++;   
                            }
                            else
                                // si encontre un turno disponible en ese dia
                                casting[unDia][y] = new Persona(unNom,unDNI,unaEdad);
                                System.out.println("se encontro");
                                dimL++;
                        }
                        // si no hay ningun turno disponible y = 8
                        if (y == 8){
                        System.out.println("No se encontro un turno disponible para ese dia");
                        }   
                        
                unDNI = GeneradorAleatorio.generarInt(99999999);
                unaEdad = GeneradorAleatorio.generarInt(99);
                unNom = GeneradorAleatorio.generarString(20);
                unDia = GeneradorAleatorio.generarInt(5);
            }
            
            
       int columns = 8; int cant2 = 0;
       for (int k = 0; k < i; k++) {
           // si es la ultima fila, columnas = j, esto recorre hasta j (ultimo ingresado)
           if (k == i - 1) {
               columns = j;
                for (int l = 0; l < columns; l++) {
                    if (casting[k][l] != null){
                          cant2++;
                          System.out.println("En el dia "+k+" turno "+l+" se entrevisto a "+casting[k][l]);
                    }
                }
                System.out.println("La cantidad de inscriptos en el dia "+k+" es "+cant2);
                cant2=0;
           }    
           else
               for (int l = 0; l < columns; l++){                
                    cant2++;
                    System.out.println("En el dia "+k+" turno "+l+" se entrevisto a "+casting[k][l].getNombre());
               }     
                System.out.println("La cantidad de inscriptos en el dia "+k+" es "+cant2);
                cant2=0;
       }
    }
}