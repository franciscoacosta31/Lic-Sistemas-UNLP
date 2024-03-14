 package Practicas.Practica3.Ej1;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;


public class ejercicio1 {


    public static void main(String[] args) {
        
        double unLado1,unLado2,unLado3;
        String unColorRelleno, unColorLinea;
        
        System.out.println("Ingrese los valores de los 3 lados");
        
        unLado1 = Lector.leerDouble();
        unLado2 = Lector.leerDouble();
        unLado3 = Lector.leerDouble();
        
        System.out.println("Ingrese el color de relleno y el color de la linea");
        unColorRelleno = Lector.leerString();
        unColorLinea = Lector.leerString();
        
        Triangulo t = new Triangulo(unLado1,unLado2,unLado3,unColorRelleno,unColorLinea);
        
        System.out.println("El perimetro del triangulo es "+t.calcularPerimetro());
        System.out.println("El area del triangulo es "+t.calcularArea(unLado1, unLado2, unLado3));
        
    }
    
}
