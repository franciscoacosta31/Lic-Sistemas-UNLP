package Practicas.Practica3.Ej5;

import PaqueteLectura.Lector;

public class ejercicio5 {
    public static void main(String[] args) {
        
        double radio = Lector.leerDouble();
        String colorRelleno = Lector.leerString();
        String colorLinea = Lector.leerString();
        
        circulo c = new circulo(radio,colorRelleno,colorLinea);
        
        System.out.println("El perimetro del circulo es:"+c.calcularPerimetro());
        System.out.println("El area del circulo es:"+c.calcularArea());
    }
    
}
