package Practicas.Practica2.Ej5;
import PaqueteLectura.Lector;
import tema2.Partido;

public class ejercicio5 {
    public static void main(String[] args) {
        int golLocal = 0;int golVisitante = 0;
        int DL = 0; int DF = 20;
        String local,visitante;
        
        Partido[] vec = new Partido[DF];
        
        // completa primer espacio del vector
        System.out.println("Ingrese el nombre del local");
        local = Lector.leerString();
        System.out.println("Ingrese el nombre del visitante");
        visitante = Lector.leerString();
        if (!(visitante.equals("ZZZ"))){
            System.out.println("Ingrese los goles del local");
            golLocal = Lector.leerInt();
            System.out.println("Ingrese los goles del visitante");
            golVisitante = Lector.leerInt();
        }
        // cargar vector
        while ((!(visitante.equals("ZZZ") && (DL<DF)))    ) {
            vec[DL] = new Partido(local,visitante,golLocal,golVisitante);
            DL++;
            System.out.println("Ingrese el nombre del local");
            local = Lector.leerString();
            System.out.println("Ingrese el nombre del visitante");
            visitante = Lector.leerString();
            if (!(visitante.equals("ZZZ"))){
                System.out.println("Ingrese los goles del local");
                golLocal = Lector.leerInt();
                System.out.println("Ingrese los goles del visitante");
                golVisitante = Lector.leerInt();
            }
        }
        
    int i = 0; int cantRiver = 0; int golesBoca = 0;
    while(i < DL){
        System.out.println(vec[i].getLocal()+" "+vec[i].getGolesLocal()+" VS "+vec[i].getVisitante()+" "+vec[i].getGolesVisitante());
       
        if(vec[i].getGanador().equals("River"))
            cantRiver++;
        
        if(vec[i].getLocal().equals("Boca"))
            golesBoca += vec[i].getGolesLocal();
        
        i++;
    }
    // informar
    System.out.println("La cantidad de partidos que gano river es "+cantRiver);
    System.out.println("La cantidad de goles que metio boca es "+golesBoca);
}
}