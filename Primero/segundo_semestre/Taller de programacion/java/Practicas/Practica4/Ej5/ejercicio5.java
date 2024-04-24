package Practicas.Practica4.Ej5;
public class ejercicio5 {
    public static void main(String[] args) {
        
        VisorFigurasModificado visor = new VisorFigurasModificado();
        
        Cuadrado c = new Cuadrado(5,"Rojo","Azul");
        Cuadrado c2 = new Cuadrado(10,"amarillo","verde");
        Rectangulo r = new Rectangulo(10, 20, "celeste", "blanco");
        
        visor.guardar(c);
        visor.guardar(c2);
        visor.guardar(r);
        
        System.out.println(visor.mostrar());
    }
}
