package Practicas.Practica4.Ej2;
public class jugador extends empleado{
    
    int partidosJugados;
    int golesAnotados;

    public jugador(int partidosJugados, int golesAnotados, String nombre, double sueldo, double antiguedad) {
        super(nombre, sueldo, antiguedad);
        this.setPartidosJugados(partidosJugados);
        this.setGolesAnotados(golesAnotados);
    }

   
    // getters y setters
    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getGolesAnotados() {
        return golesAnotados;
    }

    public void setGolesAnotados(int golesAnotados) {
        this.golesAnotados = golesAnotados;
    }
    //
    
    public double calcularEfectividad(){
        double aux;
        aux = (double) this.getGolesAnotados()/this.getPartidosJugados();    
        return aux;
}
    
        public double calcularSueldoACobrar(){
        double aux;
        
        if (this.calcularEfectividad() > 0.5)
            aux = this.getSueldo() + (1.10 * this.getAntiguedad()) + 
                  this.getSueldo();
        else
            aux = this.getSueldo() + (1.10 * this.getAntiguedad());
        
        return aux;
        }
}