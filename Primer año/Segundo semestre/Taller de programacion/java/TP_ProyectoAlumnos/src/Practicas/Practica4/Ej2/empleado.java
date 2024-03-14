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
public abstract class empleado {
    String nombre;
    double sueldo;
    double antiguedad;

    public empleado(String nombre, double sueldo, double antiguedad) {
        this.setNombre(nombre);
        this.setSueldo(sueldo);
        this.setAntiguedad(antiguedad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(double antiguedad) {
        this.antiguedad = antiguedad;
    }
    
    
    public abstract double calcularEfectividad();
    public abstract double calcularSueldoACobrar();
    public String toString(){
        String aux;
        
        aux = this.getNombre() + " "+ this.calcularSueldoACobrar() + " " + this.calcularEfectividad();
        
        return aux;
    }
}
