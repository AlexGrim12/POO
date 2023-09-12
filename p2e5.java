import java.util.Scanner;

public class p2e5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa el numero n: ");
        int n = sc.nextInt();
        // imprimir los numeros primos entre 1 y n
        for (int i = 2; i <= n; i++) {
            System.out.print((i <= 10 && i == 2 || i == 3 || i == 5 || i == 7) ? i + " " : "");
            System.out.print((i > 10 && i == 1 || i % 2 == 0 || i % 3 == 0 || i % 5 == 0 || i % 7 == 0) ? "" : i + " ");
        }
        sc.close();
    }
}