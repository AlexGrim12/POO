import java.util.Scanner;

public class p2e2 {
    public static void main(String[] args) {
        int n1, n2;
        int suma = 0;
        int mayor, menor;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero entero: ");
        n1 = sc.nextInt();
        System.out.println("Ingrese otro numero entero: ");
        n2 = sc.nextInt();
        sc.close();
        if (n1 > n2) {
            mayor = n1;
            menor = n2;
        } else {
            mayor = n2;
            menor = n1;
        }
        for (int i = menor; i <= mayor; i++)
            suma = (i % 2 == 0) ? suma + i : suma;

        System.out.println("La suma de los numeros pares entre " + menor + " y " + mayor + " es: " + suma);
    }
}