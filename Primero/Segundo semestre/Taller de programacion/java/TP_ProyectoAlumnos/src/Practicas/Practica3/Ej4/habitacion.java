package Practicas.Practica3.Ej4;

import PaqueteLectura.GeneradorAleatorio;

public class habitacion {
    
    private int costo;
    private boolean ocupada;
    private cliente c;

    public habitacion(cliente c) {
        this.costo = GeneradorAleatorio.generarInt(8001);
        this.ocupada = false;
        this.c = c;
        
    }

    
    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public boolean getOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public cliente getC() {
        return c;
    }

    public void setC(cliente c) {
        this.c = c;
    }
    
}
