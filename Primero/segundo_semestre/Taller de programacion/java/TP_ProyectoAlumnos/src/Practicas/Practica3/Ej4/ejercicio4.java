package Practicas.Practica3.Ej4;
public class ejercicio4 {
    public static void main(String[] args) {
        int max = 5;
        
        // ingreso 3 clientes
        cliente unCliente = new cliente("Matias",46787876,18);
        cliente unCliente2 = new cliente("Pancho",56787876,28);       
        cliente unCliente3 = new cliente("Angel",66787876,38);   
       
        
        hotel h = new hotel(max);
        
        h.ingresarCliente(unCliente, 0);
        h.ingresarCliente(unCliente2, 1);
        h.ingresarCliente(unCliente3, 2);
        
        // hotel + costo + ocupacion + cliente
        System.out.println(h.toString());
        
        h.aumentarMonto(5000);
        
        System.out.println(h.toString());
    }
}
