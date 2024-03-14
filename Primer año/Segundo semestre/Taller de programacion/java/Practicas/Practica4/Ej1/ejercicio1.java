
package tema4;

public class ejercicio1 {
    public static void main(String[] args) {
               
        String unColorL = "rojo";
        String unColorR = "azul";
        
        double unRadio = 5;
      
        Circulo c = new Circulo (unRadio, unColorL, unColorR);
        
        double unaBase = 7;
        double unLado1 = 4;
        double unLado2 = 5;
      
        Triangulo t = new Triangulo(unaBase, unLado1, unLado2, unColorL, unColorR);
        
        System.out.println(c.toString());
        System.out.println(t.toString());
        
        c.despintar();
        t.despintar();
        
        System.out.println(c.toString());
        System.out.println(t.toString());
    }
}
