package Practicas.Practica1.Ej1;

import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author Frann
 */
public class Primer {
public static void main(String[] args) {
        int DF=11;  
        int [] tabla2 = new int[DF]; // indices de 0 a 10
        int i,j;
        for (i=0;i<DF;i++) 
            tabla2[i]=2*i;
        System.out.println("2x" + "5" + "="+ tabla2[5]);
        
        GeneradorAleatorio.iniciar();
        j = GeneradorAleatorio.generarInt(12);
        
        while(j!=11){
            System.out.println(j);
            System.out.println("2x" + j + "=" + tabla2[j]);
            j = GeneradorAleatorio.generarInt(12);
        }
    }
    
}
