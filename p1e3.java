import java.util.Scanner;

public class p1e3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cantidadNumeros = 0;

        // Solicitamos al usuario que ingrese la cantidad de números y validamos que esté entre 2 y 6
        System.out.println("¿Cuántos números desea ingresar? (Entre 2 y 6)");
        while (cantidadNumeros < 2 || cantidadNumeros > 6) {
            cantidadNumeros = scanner.nextInt();
            if (cantidadNumeros < 2 || cantidadNumeros > 6) {
                System.out.println("El número debe estar entre 2 y 6, ingrese nuevamente:");
            }
        }
        switch (cantidadNumeros) {
            case 2:
                int numero1 = 0;
                int numero2 = 0;
                System.out.println("Ingrese el primer número:");
                numero1 = scanner.nextInt();
                System.out.println("Ingrese el segundo número:");
                numero2 = scanner.nextInt();
                System.out.println((numero1 > numero2) ? "El mayor es: " + numero1 : "El mayor es: " + numero2);
                System.out.println((numero1 < numero2) ? "El menor es: " + numero1 : "El menor es: " + numero2);
                break;
            
            case 3:
                int numero3 = 0;
                int numero4 = 0;
                int numero5 = 0;
                System.out.println("Ingrese el primer número:");
                numero3 = scanner.nextInt();
                System.out.println("Ingrese el segundo número:");
                numero4 = scanner.nextInt();
                System.out.println("Ingrese el tercer número:");
                numero5 = scanner.nextInt();
                System.out.println((numero3 > numero4 && numero3 > numero5) ? "El mayor es: " + numero3 : (numero4 > numero3 && numero4 > numero5) ? "El mayor es: " + numero4 : "El mayor es: " + numero5);
                System.out.println((numero3 < numero4 && numero3 < numero5) ? "El menor es: " + numero3 : (numero4 < numero3 && numero4 < numero5) ? "El menor es: " + numero4 : "El menor es: " + numero5);
                System.out.println((numero3 > numero4 && numero3 < numero5) || (numero3 < numero4 && numero3 > numero5) ? "La mediana es: " + numero3 : (numero4 > numero3 && numero4 < numero5) || (numero4 < numero3 && numero4 > numero5) ? "La mediana es: " + numero4 : "La mediana es: " + numero5);
                break;
            case 4:
                int numero6 = 0;
                int numero7 = 0;
                int numero8 = 0;
                int numero9 = 0;
                System.out.println("Ingrese el primer número:");
                numero6 = scanner.nextInt();
                System.out.println("Ingrese el segundo número:");
                numero7 = scanner.nextInt();
                System.out.println("Ingrese el tercer número:");
                numero8 = scanner.nextInt();
                System.out.println("Ingrese el cuarto número:");
                numero9 = scanner.nextInt();
                System.out.println((numero6 > numero7 && numero6 > numero8 && numero6 > numero9) ? "El mayor es: " + numero6 : (numero7 > numero6 && numero7 > numero8 && numero7 > numero9) ? "El mayor es: " + numero7 : (numero8 > numero6 && numero8 > numero7 && numero8 > numero9) ? "El mayor es: " + numero8 : "El mayor es: " + numero9);
                System.out.println((numero6 < numero7 && numero6 < numero8 && numero6 < numero9) ? "El menor es: " + numero6 : (numero7 < numero6 && numero7 < numero8 && numero7 < numero9) ? "El menor es: " + numero7 : (numero8 < numero6 && numero8 < numero7 && numero8 < numero9) ? "El menor es: " + numero8 : "El menor es: " + numero9);
                System.out.println((numero6 > numero7 && numero6 < numero8 && numero6 < numero9)
                        || (numero6 < numero7 && numero6 > numero8 && numero6 < numero9)
                        || (numero6 < numero7 && numero6 < numero8 && numero6 > numero9)
                                ? "La mediana es: " + numero6
                                : (numero7 > numero6 && numero7 < numero8 && numero7 < numero9)
                                        || (numero7 < numero6 && numero7 > numero8 && numero7 < numero9)
                                        || (numero7 < numero6 && numero7 < numero8 && numero7 > numero9)
                                                ? "La mediana es: " + numero7
                                                : (numero8 > numero6 && numero8 < numero7 && numero8 < numero9)
                                                        || (numero8 < numero6 && numero8 > numero7 && numero8 < numero9)
                                                        || (numero8 < numero6 && numero8 < numero7 && numero8 > numero9)
                                                                ? "La mediana es: " + numero8
                                                                : "La mediana es: " + numero9);
                break;
            case 5:
                int numero10 = 0;
                int numero11 = 0;
                int numero12 = 0;
                int numero13 = 0;
                int numero14 = 0;
                System.out.println("Ingrese el primer número:");
                numero10 = scanner.nextInt();
                System.out.println("Ingrese el segundo número:");
                numero11 = scanner.nextInt();
                System.out.println("Ingrese el tercer número:");
                numero12 = scanner.nextInt();
                System.out.println("Ingrese el cuarto número:");
                numero13 = scanner.nextInt();
                System.out.println("Ingrese el quinto número:");
                numero14 = scanner.nextInt();
                System.out.println((numero10 > numero11 && numero10 > numero12 && numero10 > numero13 && numero10 > numero14) ? "El mayor es: " + numero10 : (numero11 > numero10 && numero11 > numero12 && numero11 > numero13 && numero11 > numero14) ? "El mayor es: " + numero11 : (numero12 > numero10 && numero12 > numero11 && numero12 > numero13 && numero12 > numero14) ? "El mayor es: " + numero12 : (numero13 > numero10 && numero13 > numero11 && numero13 > numero12 && numero13 > numero14) ? "El mayor es: " + numero13 : "El mayor es: " + numero14);
                System.out.println((numero10 < numero11 && numero10 < numero12 && numero10 < numero13 && numero10 < numero14) ? "El menor es: " + numero10 : (numero11 < numero10 && numero11 < numero12 && numero11 < numero13 && numero11 < numero14) ? "El menor es: " + numero11 : (numero12 < numero10 && numero12 < numero11 && numero12 < numero13 && numero12 < numero14) ? "El menor es: " + numero12 : (numero13 < numero10 && numero13 < numero11 && numero13 < numero12 && numero13 < numero14) ? "El menor es: " + numero13 : "El menor es: " + numero14);
                System.out.println((numero10 > numero11 && numero10 < numero12 && numero10 < numero13 && numero10 < numero14)
                        || (numero10 < numero11 && numero10 > numero12 && numero10 < numero13 && numero10 < numero14)
                        || (numero10 < numero11 && numero10 < numero12 && numero10 > numero13 && numero10 < numero14)
                        || (numero10 < numero11 && numero10 < numero12 && numero10 < numero13 && numero10 > numero14)
                                ? "La mediana es: " + numero10
                                : (numero11 > numero10 && numero11 < numero12 && numero11 < numero13
                                        && numero11 < numero14)
                                        || (numero11 < numero10 && numero11 > numero12 && numero11 < numero13
                                                && numero11 < numero14)
                                        || (numero11 < numero10 && numero11 < numero12 && numero11 > numero13
                                                && numero11 < numero14)
                                        || (numero11 < numero10 && numero11 < numero12 && numero11 < numero13
                                                && numero11 > numero14)
                                                        ? "La mediana es: " + numero11
                                                        : (numero12 > numero10 && numero12 < numero11
                                                                && numero12 < numero13 && numero12 < numero14)
                                                                || (numero12 < numero10 && numero12 > numero11
                                                                        && numero12 < numero13 && numero12 < numero14)
                                                                || (numero12 < numero10 && numero12 < numero11
                                                                        && numero12 > numero13 && numero12 < numero14)
                                                                || (numero12 < numero10 && numero12 < numero11
                                                                        && numero12 < numero13 && numero12 > numero14)
                                                                                ? "La mediana es: " + numero12
                                                                                : (numero13 > numero10
                                                                                        && numero13 < numero11
                                                                                        && numero13 < numero12
                                                                                        && numero13 < numero14)
                                                                                        || (numero13 < numero10
                                                                                                && numero13 > numero11
                                                                                                && numero13 < numero12
                                                                                                && numero13 < numero14)
                                                                                        || (numero13 < numero10
                                                                                                && numero13 < numero11
                                                                                                && numero13 > numero12
                                                                                                && numero13 < numero14)
                                                                                        || (numero13 < numero10
                                                                                                && numero13 < numero11
                                                                                                && numero13 < numero12
                                                                                                && numero13 > numero14)
                                                                                                        ? "La mediana es: "
                                                                                                                + numero13
                                                                                                        : "La mediana es: "
                                                                                                                + numero14);
                break;
            default:
                break;
        }
scanner.close();
        
    }
}
