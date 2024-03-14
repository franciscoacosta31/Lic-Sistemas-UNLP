// Un edificio de oficinas está conformado por 8 pisos (1..8) y 4 oficinas por piso (1..4). Realice
// un programa que permita informar la cantidad de personas que concurrieron a cada oficina de cada piso. 
// Para esto, simule la llegada de personas al edificio de la siguiente manera: a cada persona
// se le pide el nro. de piso y nro. de oficina a la cual quiere concurrir. La llegada de personas
// finaliza al indicar un nro. de piso 9. Al finalizar la llegada de personas, informe lo pedido. 
package Practicas.Practica1.Ej4;
import PaqueteLectura.GeneradorAleatorio;

public class ejercicio4 {
    public static void main(String[] args) {
        
        // inicializaciones y declaraciones
        int[][] edificio = new int[8][4];
        int piso, oficina, i, j;
        GeneradorAleatorio.iniciar();
        
        // inicializado todo el edificio en 0
        for (i=0;i<8;i++)
            for (j=0;j<4;j++)
                edificio[i][j] = 0;
        
        // primer valor de piso y oficina
        piso = GeneradorAleatorio.generarInt(10);
        oficina = GeneradorAleatorio.generarInt(4);
        
        // mientras el piso no sea 9 ni mayor a 8, se completa el edificio
        while ((piso != 9)&&(piso < 8)) {
            edificio[piso][oficina]++;
            piso = GeneradorAleatorio.generarInt(10);
            oficina = GeneradorAleatorio.generarInt(4);
        }
        
        // informar
        for (i=0;i<8;i++){
            for (j=0;j<4;j++)
                System.out.print("("+i+","+j+") "+edificio[i][j] + " | ");
            System.out.println();
        }
    }
    
}
