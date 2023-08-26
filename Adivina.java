import java.util.Scanner;
import java.util.Random;

public class Adivina {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); //mala cohesion porque se escanea un numer y busca un numero aleatorio
        Random r = new Random();
        int n = r.nextInt(100) + 1; //offset de 1 para que no salga el 0
        int x = 0;
        int i = 4; //cuatro intentos
        while (i > 0) {
            System.out.print("Adivina el numero: ");
            x = s.nextInt();
            if (x == n) {
                System.out.println("Has acertado!");
                break;
            } else if (x < n) {
                System.out.println("El numero es mayor");
            } else {
                System.out.println("El numero es menor");
            }
            i--;
        }
        if (i == 0) {
            System.out.println("Has perdido el numero era: " + n);
        }
        s.close();
    }
}