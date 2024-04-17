
package Practicas.Practica3.Ej3;

public class ejercicio3 {
    public static void main(String[] args) {

        Estante e = new Estante(3);
        
        String titulo = "Mujercitas";
        Autor unAutor = new Autor("juanito","soy crack","argentino");
        
        Libro unLibro = new Libro("Mafalda","editorial",unAutor,"123");
        Libro unLibro2 = new Libro("Gaturro","editorial2",unAutor,"456");
        Libro unLibro3 = new Libro("Mujercitas","editorial3",unAutor,"789");
        
        e.agregarLibro(unLibro); e.agregarLibro(unLibro2);
        e.agregarLibro(unLibro3);
        
        System.out.println(e.buscarLibro("Mujercitas").getPrimerAutor().getNombre());
        
    }    
}
