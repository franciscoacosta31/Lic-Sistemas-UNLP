package Practicas.Practica3.Ej4;
public class hotel {
    
    private habitacion[] h;
    private int max;
    
    
    public hotel(int n) {
        this.max = n;
        this.h = new habitacion[this.max];
    }
    
    public void ingresarCliente(cliente unCliente, int x){
         this.h[x] = new habitacion(unCliente);
         this.h[x].setOcupada(true);
    }
    
    public void aumentarMonto(int x){
        int i = 0;
        while(this.h[i] != null){
            this.h[i].setCosto(this.h[i].getCosto()+ x);
            i++;
        }
    }
    
    public String imprimir(int i){
        String aux = "";
        if (this.h[i] != null){
            if (this.h[i].getOcupada() == true)
                aux = "Habitacion:"+i+ " costo:"+ this.h[i].getCosto()+ " ocupada "+this.h[i].getC().toString();
            else
                aux = "Habitacion:"+i+ " costo:"+ this.h[i].getCosto() + " libre";
        }
        return aux;
    }
    
    
    public habitacion getHabitacion(int x){
        return h[x];
    }
    
    /* public String Concatenador(){
        String aux = "";
        int i;
        for(i=0;i<max;i++){
            aux = aux + this.h[i].toString() + " ";
        }
       return aux;
    } */
    
    public String toString(){
        String aux = "";
        int i;
        for(i=0;i<max;i++){
            if (h[i] != null)
                aux += this.imprimir(i) + " ";
        }
        return aux;
    }
    
}
