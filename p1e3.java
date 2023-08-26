import java.util.Scanner;

public class p1e3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numeros = new int[6]; // Creamos un arreglo para almacenar los números
        int cantidadNumeros = 0;

        // Solicitamos al usuario que ingrese la cantidad de números y validamos que esté entre 2 y 6
        System.out.println("¿Cuántos números desea ingresar? (Entre 2 y 6)");
        while (cantidadNumeros < 2 || cantidadNumeros > 6) {
            cantidadNumeros = scanner.nextInt();
            if (cantidadNumeros < 2 || cantidadNumeros > 6) {
                System.out.println("El número debe estar entre 2 y 6, ingrese nuevamente:");
            }
        }

        // Capturamos los números ingresados por el usuario
        for (int i = 0; i < cantidadNumeros; i++) {
            System.out.println("Ingrese el número " + (i + 1));
            numeros[i] = scanner.nextInt();
        }

        // Inicializamos las variables que almacenarán el número menor, mayor y la mediana
        int menor = numeros[0];
        int mayor = numeros[0];
        int mediana = numeros[0];

        // Encontramos el número menor y el número mayor entre los ingresados
        for (int i = 1; i < cantidadNumeros; i++) {
            if (numeros[i] < menor) {
                menor = numeros[i];
            }
            if (numeros[i] > mayor) {
                mayor = numeros[i];
            }
        }

        // Calculamos la mediana dependiendo de si la cantidad de números es par o impar
        if (cantidadNumeros % 2 == 1) {
            mediana = numeros[cantidadNumeros / 2];
        } else {
            mediana = (numeros[cantidadNumeros / 2 - 1] + numeros[cantidadNumeros / 2]) / 2;
        }

        // Mostramos los resultados al usuario
        System.out.println("\nSalida:");
        System.out.println("Mayor: " + mayor);
        System.out.println("Menor: " + menor);
        System.out.println("Mediana: " + mediana);

        // Cerramos el Scanner para liberar recursos
        scanner.close(); 
    }
}
