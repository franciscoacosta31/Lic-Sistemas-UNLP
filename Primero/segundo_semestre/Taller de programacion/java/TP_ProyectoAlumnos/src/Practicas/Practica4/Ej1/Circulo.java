package tema4;


public class Circulo extends Figura{
    
    private double radio;
    
    
    public Circulo(double unRadio, String unColorR, String unColorL){
        super(unColorR,unColorL);
        setRadio(unRadio);

    } 
    
    public double getRadio(){
        return radio;       
    }
  
    public void setRadio(double unRadio){
        radio=unRadio;
    }

    public double calcularArea(){
       return (Math.PI * getRadio() * getRadio());
    }
    
    public double calcularPerimetro(){
       return (2 * Math.PI * getRadio());
    }
    
    public String toString(){
       String aux = super.toString() + 
                    " Radio: " + getRadio();
       return aux;
    } 
}
