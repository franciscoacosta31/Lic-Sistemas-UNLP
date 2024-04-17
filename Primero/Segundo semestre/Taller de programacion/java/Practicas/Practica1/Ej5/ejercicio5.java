// El dueño de un restaurante entrevista a cinco clientes y les pide que califiquen (con puntaje de 1 a 10)
// los siguientes aspectos: (0) Atención al cliente (1) Calidad de la comida (2)Precio  (3)Ambiente. 
// Escriba un programa que lea desde teclado las calificaciones de los cinco clientes para cada uno
// de los aspectos y almacene la información en una estructura. Luego imprima la calificación
// promedio obtenida por cada aspecto.
package Practicas.Practica1.Ej5;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class ejercicio5 {

    public static void main(String[] args) {
        // inicializaciones y declaraciones
        GeneradorAleatorio.iniciar();
        int[][] entrevista = new int[5][4];
        
        // Leer calificaciones de clientes
        for (int i =0;i<5;i++){
            System.out.println("Califique la atención al cliente");
            entrevista[i][0] = Lector.leerInt();            
            System.out.println("Califique la calidad de la comida");
            entrevista[i][1] = Lector.leerInt();
            System.out.println("Califique el precio");
            entrevista[i][2] = Lector.leerInt();
            System.out.println("Califique el ambiente");
            entrevista[i][3] = Lector.leerInt();
        }
        
        // imprimir promedio de aspectos
        int suma = 0;
        for(int j=0;j<4;j++){
            for(int i=0;i<5;i++)
                suma += entrevista[i][j];
            System.out.println("El promedio de calificaiones de el aspecto "+j+ " es = "+suma/5);
            suma = 0;
        }
    }
}
