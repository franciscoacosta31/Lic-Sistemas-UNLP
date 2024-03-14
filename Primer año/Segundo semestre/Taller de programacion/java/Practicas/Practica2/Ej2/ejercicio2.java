/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practicas.Practica2.Ej2;
import PaqueteLectura.GeneradorAleatorio;
import tema2.Persona;
/**
 *
 * @author Frann
 */
public class ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // crear vector e inicializar variable
        GeneradorAleatorio.iniciar();
        Persona[] v = new Persona[15];
        int i = 0; int cant = 0; int DF = 15; int DL = 0; 
        int minDNI = 999999999; int DNI, Edad; String Nom;
        Persona personaDniMin = new Persona();
        
    
        // completar la primer persona
        Nom = GeneradorAleatorio.generarString(15); 
        DNI = GeneradorAleatorio.generarInt(99999999);
        Edad = GeneradorAleatorio.generarInt(99);
        // completar vector
        while ((Edad != 0) && (DL<DF)) {
            v[DL] = new Persona(Nom, DNI, Edad);
            DL++;
            Nom = GeneradorAleatorio.generarString(15); 
            DNI = GeneradorAleatorio.generarInt(99999999);
            Edad = (GeneradorAleatorio.generarInt(99));
        }
        
        // conseguir cantidad de personas mayores a 65 años y los datos de la persona con el dni mas chico
        for(i=0;i<DL;i++){
            if (v[i].getEdad() > 65)
                cant++;
            if ((v[i].getDNI() < minDNI) && (DL >= 0)){
                personaDniMin = v[i];
                minDNI = personaDniMin.getDNI();
            }       
        }
        
        System.out.println("La cantidad de personas mayores de 65 años es "+cant);
        System.out.println(personaDniMin.toString());
    }
}

