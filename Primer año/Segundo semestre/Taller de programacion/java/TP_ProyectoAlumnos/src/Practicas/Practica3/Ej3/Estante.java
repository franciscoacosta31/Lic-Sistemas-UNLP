package Practicas.Practica3.Ej3;
class Estante {
    
    private final Libro[] libros;
    private int max;

    public Estante() {
        max = 20;
        this.libros  = new Libro[max];
    }
    
    public Estante(int cant){
        max = cant;
        this.libros = new Libro[max];
    }
            
    
    // i
    public int devolverCantLibros(){
        int cant = 0;
        int i = 0;
        
        // mientras haya un libro en el estante, cuento y avanzo
        while((i<max) && (this.libros[i] != null)){
            cant++;
            i++;
        }
        
        return cant;
    }
    
    // ii
    public boolean estanteLleno(){
        return (this.devolverCantLibros() == max);
    }
    
    // iii
    public void agregarLibro(Libro unLibro){
        int i = 0;
        while ((i<max) && (!(this.libros[i] == null))){
            i++; 
        }
        if (i<max)
            this.libros[i] = unLibro;
    } 
    
    
    // iii
    public Libro buscarLibro(String unLibro){
        int i = 0;
        
        while ((i<max) && (!(this.libros[i] == null))){
            // si el titulo de algun libro del estante coincide con el titulo pasado, devuelve ese libro
            if (this.libros[i].getTitulo().equals(unLibro)){
                return this.libros[i];
            }
            else 
                i++;
        }
        
        return null;
    }
    
}
