package Practicas.Practica4.Ej3;
public class trabajador extends Persona1{
    String tareaRealizada;

    public trabajador(String tareaRealizada, String nombre, int dni, int edad) {
        super(nombre, dni, edad);
        this.setTareaRealizada(tareaRealizada);
    }    
    
    public String getTareaRealizada() {
        return tareaRealizada;
    }

    public void setTareaRealizada(String tareaRealizada) {
        this.tareaRealizada = tareaRealizada;
    }
    
    public String toString(){
        String aux = super.toString() + " Soy "+this.getTareaRealizada();
        return aux;
    }
    
    
}
