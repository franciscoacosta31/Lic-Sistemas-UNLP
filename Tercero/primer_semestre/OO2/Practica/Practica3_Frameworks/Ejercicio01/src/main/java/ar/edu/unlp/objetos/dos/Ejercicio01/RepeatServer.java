package ar.edu.unlp.objetos.dos.Ejercicio01;

import java.io.PrintWriter;

public class RepeatServer extends SingleThreadTCPServer {

	@Override
	public void handleMessage(String message, PrintWriter out) {
		// Dividir el mensaje en argumentos (separados por espacios)
        String[] args = message.trim().split("\\s+");

        // Validar que se recibieron al menos 2 argumentos
        if (args.length < 2) {
            out.println("ERROR: Se requieren al menos 2 argumentos (string, cantidad de repeticiones, delimitador(opcional))");
            return;
        }
        if (args.length > 3) {
        	out.println("ERROR: Se permiten máximo 3 argumentos (string, cantidad de repeticiones, delimitador)");
             return;
        }

        String stringToRepeat = args[0];

        // Validar que el string a repetir no esté vacío
        if (stringToRepeat.isEmpty()) {
            out.println("ERROR: El string a repetir no puede estar vacío");
            return;
        }
        
        // Validar y convertir la cantidad de repeticiones
        int repeatCount;
        try {
            repeatCount = Integer.parseInt(args[1]);
            if (repeatCount <= 0) {
                out.println("ERROR: La cantidad de repeticiones debe ser mayor a 0");
                return;
            }
        } catch (NumberFormatException e) {
            out.println("ERROR: La cantidad de repeticiones debe ser un numero entero valido");
            return;
        }
        
        // Obtener el delimitador (opcional, por defecto espacio)
        String delimiter = " ";
        if (args.length == 3) {
            if (args[2].length() != 1) {
                out.println("ERROR: El delimitador debe ser un solo caracter");
                return;
            }
            delimiter = args[2];
        }
			
        // Generar la cadena repetida
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < repeatCount; i++) {
            if (i > 0) {
                result.append(delimiter);
            }
            result.append(stringToRepeat);
        }
        
        // Enviar la respuesta al cliente
        out.println("Resultado: " + result.toString());
	}
	
	public static void main(String[] args) {

        new RepeatServer().startLoop(args);

    }
}
