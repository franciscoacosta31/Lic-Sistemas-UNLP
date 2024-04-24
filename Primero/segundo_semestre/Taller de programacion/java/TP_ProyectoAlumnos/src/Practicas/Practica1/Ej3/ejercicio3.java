package Practicas.Practica1.Ej3;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
        
        
public class ejercicio3 {

    public static void main(String[] args) {
	//Paso 2. iniciar el generador aleatorio   
        
	GeneradorAleatorio.iniciar();
        
        //Paso 3. definir la matriz de enteros de 5x5 e iniciarla con nros. aleatorios 
        
        int[][] matriz = new int[5][5];
        
        int i,j;
        for (i=0;i<5;i++)
            for(j=0;j<5;j++)
                matriz[i][j] = GeneradorAleatorio.generarInt(31);
        
        //Paso 4. mostrar el contenido de la matriz en consola
        
        System.out.println("-------------------------------------");
        for (i=0;i<5;i++){
            for(j=0;j<5;j++)
                 System.out.print("("+i+","+j+") "+matriz[i][j] + " | ");   
            System.out.println();
        }
        System.out.println("-------------------------------------");
        
        //Paso 5. calcular e informar la suma de los elementos de la fila 1
        
        i = 1;
        int suma = 0;
        for (j=0;j<5;j++)
            suma += matriz[i][j]; 
        System.out.println("la suma de los elementos de la fila 1 es igual a: " +suma);
        
        //Paso 6. generar un vector de 5 posiciones donde cada posición j contiene la suma de los elementos
        // de la columna j de la matriz. Luego, imprima el vector.
        
        int[] vector = new int[5];
        
        int suma2 = 0;
        for (j=0;j<5;j++){
            for (i=0;i<5;i++)
                suma2 += matriz[i][j];
            vector[j] = suma2;
            suma2 = 0;
        }
        
        for (j=0;j<5;j++)
            System.out.println(vector[j]);
        
        //Paso 7. lea un valor entero e indique si se encuentra o no en la matriz. En caso de encontrarse
        // indique su ubicación (fila y columna) y en caso contrario imprima "No se encontró el elemento".
        
        boolean encontre = false;
        int num = Lector.leerInt();
        for(i=0;i<5;i++)
            for(j=0;j<5;j++)
                if (num == matriz[i][j]){
                    System.out.println("El numero "+num+" se encuentra en la posicion ("+i+","+j+")");
                    encontre = true;
                }
        
        if (encontre == false) System.out.println("No se encontró el elemento");
    }
}
