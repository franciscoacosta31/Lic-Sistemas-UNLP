
package Practicas.Practica3.Ej5;
public class circulo {
    
    private double radio;
    private String colorRelleno;
    private String colorLinea;

    //constructor
    public circulo(double radio, String colorRelleno, String colorLinea) {
        this.radio = radio;
        this.colorRelleno = colorRelleno;
        this.colorLinea = colorLinea;
    }
    
    
    //getters y setters
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
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
    //
    
    //comportamiento
    
    public double calcularPerimetro(){
        return (2 * Math.PI * this.getRadio());
}
   
    public double calcularArea(){
        return (Math.PI * this.getRadio() * this.getRadio());
    }
    
}
