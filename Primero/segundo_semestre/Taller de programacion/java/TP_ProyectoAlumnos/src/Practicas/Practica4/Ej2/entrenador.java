/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practicas.Practica4.Ej2;

/**
 *
 * @author Frann
 */
public class entrenador extends empleado{
    
    int campeonatosGanados;

    public entrenador(int campeonatosGanados, String nombre, double sueldo, double antiguedad) {
        super(nombre, sueldo, antiguedad);
        this.setCampeonatosGanados(campeonatosGanados);
    }

    
    public int getCampeonatosGanados() {
        return campeonatosGanados;
    }

    public void setCampeonatosGanados(int campeonatosGanados) {
        this.campeonatosGanados = campeonatosGanados;
    }
    
    public double calcularEfectividad(){
        double aux;
        aux = this.getCampeonatosGanados()/this.getAntiguedad();
        return aux;
    }
    
    public double calcularSueldoACobrar(){
        double aux = 0;
        
        if ((this.getCampeonatosGanados() >= 1) && (this.getCampeonatosGanados() <= 4))
            aux = this.getSueldo() + (0.10 * this.getSueldo()) * this.getAntiguedad() +
                  5000;  
        if ((this.getCampeonatosGanados() >= 5) && (this.getCampeonatosGanados() <= 10))
            aux = this.getSueldo() + (0.10 * this.getSueldo()) * this.getAntiguedad() +
                  30000;  
        if (this.getCampeonatosGanados() > 10)
            aux = this.getSueldo() + (0.10 * this.getSueldo()) * this.getAntiguedad() +
                  50000;  
                   
        return aux;            
    }
}
