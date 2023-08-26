import java.util.Random; // Importa la clase Random para generar números aleatorios

public class p1e5 {
    public static void main(String[] args) {
        Random random = new Random(); // Crea una instancia de la clase Random para generar números aleatorios
        int randomNumber = random.nextInt(10000) + 1; // Genera un número aleatorio entre 1 y 10000 inclusive
        
        int digitCount = 0; // Inicializa una variable para contar la cantidad de dígitos
        int number = randomNumber; // Crea una copia del número generado para no modificar el original
        
        if (number == 0) {
            digitCount = 1; // Si el número es 0, tiene un dígito
        } else {
            while (number != 0) { // Bucle que se ejecuta mientras el número no sea 0
                digitCount++; // Incrementa el contador de dígitos
                number /= 10; // Divide el número por 10 para eliminar el último dígito
            }
        }
        
        // Imprime el número generado y la cantidad de dígitos que tiene
        System.out.println("Número generado: " + randomNumber);
        System.out.println("Cantidad de dígitos: " + digitCount);
    }
}

        

