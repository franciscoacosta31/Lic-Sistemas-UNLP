package Practicas.Practica4.Ej2;
public class ejercicio2 {
    public static void main(String[] args) {
        
        jugador j = new jugador(50,25,"mati rulos",15000,2);
        entrenador e = new entrenador(10,"francisco",30000,2);
        
        System.out.println(j.toString());
        
        System.out.println(e.toString());
    }
}
