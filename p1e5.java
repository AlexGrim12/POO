// Importa la clase Random para generar números aleatorios
import java.util.Random;

public class p1e5 {
    public static void main(String[] args) {
        // Crea una instancia de la clase Random para generar números aleatorios
        Random random = new Random();
        // Genera un número aleatorio entre 1 y 10000 inclusive
        int randomNumber = random.nextInt(10000) + 1;
        
        // Inicializa una variable para contar la cantidad de dígitos
        int digitCount = 0;
        // Crea una copia del número generado para no modificar el original
        int number = randomNumber;
        
        if (number == 0) {
            // Si el número es 0, tiene un dígito
            digitCount = 1;
        } else {
            // Bucle que se ejecuta mientras el número no sea 0
            while (number != 0) {
                // Incrementa el contador de dígitos
                digitCount++;
                // Divide el número por 10 para eliminar el último dígito
                number /= 10;
            }
        }
        
        // Imprime el número generado y la cantidad de dígitos que tiene
        System.out.println("Número generado: " + randomNumber);
        System.out.println("Cantidad de dígitos: " + digitCount);
    }
}

        

