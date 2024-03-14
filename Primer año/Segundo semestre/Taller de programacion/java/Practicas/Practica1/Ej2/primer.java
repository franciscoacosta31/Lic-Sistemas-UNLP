package Practicas.Practica1.Ej2;

import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author Frann
 */
public class primer {
public static void main(String[] args) {
       
    int[] alturas = new int[15];
    int altura,promedio,cant;
    promedio = 0; cant = 0;
    
    
    for (int i=0;i<15;i++){
        System.out.println("ingrese la altura");
        altura = Lector.leerInt();
        alturas[i] = altura;
        promedio = promedio + altura;
    }
    promedio = promedio/15;
    System.out.println("el promedio de las alturas es "+promedio);
    
    for (int i=0;i<15;i++)
        if (alturas[i] > promedio)
            cant++;
    System.out.println("la cantidad de jugadores con altura mayor al promedio es "+cant);
    
        }
}
