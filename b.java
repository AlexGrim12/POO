import java.util.Scanner;

public class b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa el numero n: ");
        int n = sc.nextInt();
        // imprimir los numeros primos entre 1 y n
        for (int i = 1; i <= n; i++) {
            boolean a = true;
            for (int j = 1; j <= i; j++) {
                a = (i % j == 0 && i != j) ? false : true;
                if(!a) continue;
            }
            System.out.print((a) ? i + " " : "");
        }
    }
}