package ar.edu.unlp.objetos.dos.Ejercicio01;

import java.io.PrintWriter;
import java.util.Random;

public class PasswordServer extends SingleThreadTCPServer {	
    private Random random = new Random();

	@Override
	public void handleMessage(String message, PrintWriter out) {
		// Dividir el mensaje en argumentos (separados por espacios)
        String[] args = message.trim().split("\\s+");

        // Validar que se recibieron exactamente 3 argumentos
        if (args.length != 3) {
            out.println("ERROR: Se requieren exactamente 3 argumentos (letras, numeros, caracteres especiales)");
            return;
        }

        String letters = args[0];
        String numbers = args[1];
        String specialChars = args[2];

        // Validar que las cadenas no estén vacías
        if (letters.isEmpty() || numbers.isEmpty() || specialChars.isEmpty()) {
            out.println("ERROR: Las cadenas de letras, numeros y caracteres especiales no pueden estar vacías");
            return;
        }

        // Generar la contraseña
        String password = generatePassword(letters, numbers, specialChars);
        out.println("Password generada: " + password);
	}
	
	private String generatePassword(String letters, String numbers, String specialChars) {
        StringBuilder password = new StringBuilder();

        // Asegurar 1 carácter especial
        password.append(specialChars.charAt(random.nextInt(specialChars.length())));

        // Asegurar al menos 1 letra
        password.append(letters.charAt(random.nextInt(letters.length())));

        // Asegurar al menos 1 número
        password.append(numbers.charAt(random.nextInt(numbers.length())));

        // Llenar las 5 posiciones restantes con letras o números aleatorios
        String allChars = letters + numbers; // Combinar letras y números
        for (int i = 0; i < 5; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        // Mezclar los caracteres para que no sigan un orden predecible
        char[] passwordArray = password.toString().toCharArray();
        for (int i = passwordArray.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = passwordArray[i];
            passwordArray[i] = passwordArray[j];
            passwordArray[j] = temp;
        }

        return new String(passwordArray);
    }
	
	public static void main(String[] args) {

        new PasswordServer().startLoop(args);

    }
}
