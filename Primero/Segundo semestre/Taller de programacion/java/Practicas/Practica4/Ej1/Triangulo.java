
package tema4;


public class Triangulo extends Figura {

    private double base;
    private double lado1;
    private double lado2;
    
    
    public Triangulo(double unaBase,double unLado1,double unLado2, String unColorR, String unColorL){
        super(unColorR,unColorL);
        setBase(unaBase);
        setLado1(unLado1);
        setLado2(unLado2);
    }
    
    public double getBase(){
        return base;
    }
    
public double getLado1(){
        return lado1;
    }

public double getLado2(){
        return lado2;
    
}

public void setBase(double unaBase){
        base = unaBase;
    }

public void setLado1 (double unLado1){
        lado1 = unLado1;
    }

public void setLado2 (double unLado2){
        lado2 = unLado2;
    }


public double calcularPerimetro(){
    double per = (getBase() + getLado1() + getLado2());
    return per;
    }


public double calcularArea(){
    double s = ((getBase() + getLado1() + getLado2()) / 2);
    double s1 = s - getBase();
    double s2 = s - getLado1();
    double s3 = s - getLado2();
    double a = s * s1 * s2 * s3;
    double area = Math.sqrt(a);
    return area;
}

    public String toString(){
       String aux = super.toString() + 
                    " Base: " + getBase() +               
                    " Lado1: " + getLado1() +
                    " Lado2: " + getLado2();
       return aux;
    }


}