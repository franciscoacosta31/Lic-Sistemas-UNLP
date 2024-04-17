package Practicas.Practica4.Ej5;
public class VisorFigurasModificado {
    
    private int guardadas;
    private int capacidadMaxima = 5;
    private Figura [] vector;
    
    public VisorFigurasModificado(){
        this.guardadas = 0;
        this.vector = new Figura[capacidadMaxima];
    }
    
    public void guardar(Figura f){
        int i = 0;
        while((vector[i] != null) && (i<capacidadMaxima)){
            i++;
        }
        if (i<capacidadMaxima){
            vector[i] = f;
            guardadas++;
        }
    }
    
    public boolean quedaEspacio(){
        return (guardadas < capacidadMaxima);
    }
    
    public String mostrar(){
        
        String aux = "";
        for(int i = 0;i<guardadas;i++)
            aux += vector[i].toString();
        
        return aux; 
    }
    
    public int getGuardadas(){
        return this.guardadas;
    }
    
    
    
}
