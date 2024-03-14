/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practicas.Practica3.Ej1;
/**
 *
 * @author Frann
 */
public class Triangulo {
    private double lado1;
    private double lado2;
    private double lado3;
    private String colorRelleno;
    private String colorLinea;
    
    
    public Triangulo(double unLado1,double unLado2,double unLado3, String unColorRelleno, String unColorLinea){
        this.lado1 = unLado1;
        this.lado2 = unLado2;
        this.lado3 = unLado3;
        this.colorRelleno = unColorRelleno;
        this.colorLinea = unColorLinea;
    }

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }

    public String getColorRelleno() {
        return colorRelleno;
    }

    public void setColorRelleno(String colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    public String getColorLinea() {
        return colorLinea;
    }

    public void setColorLinea(String colorLinea) {
        this.colorLinea = colorLinea;
    }
    
    public double calcularPerimetro(){
        return this.lado1 + this.lado2 + this.lado3;
    }
    
    public double calcularArea(double lado1, double lado2, double lado3){
        double s = (this.calcularPerimetro() /2);
        double s1 = s - lado1;
        double s2 = s - lado2;
        double s3 = s - lado3;
        double a = (s*s1*s2*s3);
        double aux = Math.sqrt(a);
        return aux;
    } 

    String calcularPerimetro(double unLado1, double unLado2, double unLado3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
