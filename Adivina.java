import java.util.Scanner;
import java.util.Random;

public class Adivina {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int n = r.nextInt(100) + 1;
        int x = 0;
        int i = 0;
        while (x != n) {
            System.out.print("Introduce un número: ");
            x = s.nextInt();
            if (x < n) {
                System.out.println("El número es mayor");
            } else if (x > n) {
                System.out.println("El número es menor");
            }
            i++;
        }
        System.out.println("Has acertado en " + i + " intentos");
        s.close();
    }
}