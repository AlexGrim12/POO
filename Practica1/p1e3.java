import java.util.Scanner;

public class p1e3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cantidadNumeros = 0;

        System.out.println("¿Cuántos números desea ingresar? (Entre 2 y 6)");
        while (cantidadNumeros < 2 || cantidadNumeros > 6) {
            cantidadNumeros = scanner.nextInt();
            if (cantidadNumeros < 2 || cantidadNumeros > 6) {
                System.out.println("El número debe estar entre 2 y 6, ingrese nuevamente:");
            }
        }

        int numero1 = 0;
        int numero2 = 0;
        int numero3 = 0;
        int numero4 = 0;
        int numero5 = 0;
        int numero6 = 0;
        int tmp = 0;

        System.out.println("Ingrese los números:");
        numero1 = scanner.nextInt();
        tmp = numero1;
        numero2 = scanner.nextInt();
        if (numero2 < tmp) {
            numero1 = numero2;
            numero2 = tmp;
        }
        tmp = numero2;
        numero3 = (cantidadNumeros > 2) ? scanner.nextInt() : 0;
        if (numero3 < tmp && cantidadNumeros > 2) {
            numero2 = numero3;
            numero3 = tmp;
            if (numero2 < numero1) {
                tmp = numero1;
                numero1 = numero2;
                numero2 = tmp;
            }
        }
        tmp = numero3;
        numero4 = (cantidadNumeros > 3) ? scanner.nextInt() : 0;
        if (numero4 < tmp && cantidadNumeros > 3) {
            numero3 = numero4;
            numero4 = tmp;
            if (numero3 < numero2) {
                tmp = numero2;
                numero2 = numero3;
                numero3 = tmp;
                if (numero2 < numero1) {
                    tmp = numero1;
                    numero1 = numero2;
                    numero2 = tmp;
                }
            }
        }
        tmp = numero4;
        numero5 = (cantidadNumeros > 4) ? scanner.nextInt() : 0;
        if (numero5 < tmp && cantidadNumeros > 4) {
            numero4 = numero5;
            numero5 = tmp;
            if (numero4 < numero3) {
                tmp = numero3;
                numero3 = numero4;
                numero4 = tmp;
                if (numero3 < numero2) {
                    tmp = numero2;
                    numero2 = numero3;
                    numero3 = tmp;
                    if (numero2 < numero1) {
                        tmp = numero1;
                        numero1 = numero2;
                        numero2 = tmp;
                    }
                }
            }
        }
        tmp = numero5;
        numero6 = (cantidadNumeros > 5) ? scanner.nextInt() : 0;
        if (numero6 < tmp && cantidadNumeros > 5) {
            numero5 = numero6;
            numero6 = tmp;
            if (numero5 < numero4) {
                tmp = numero4;
                numero4 = numero5;
                numero5 = tmp;
                if (numero4 < numero3) {
                    tmp = numero3;
                    numero3 = numero4;
                    numero4 = tmp;
                    if (numero3 < numero2) {
                        tmp = numero2;
                        numero2 = numero3;
                        numero3 = tmp;
                        if (numero2 < numero1) {
                            tmp = numero1;
                            numero1 = numero2;
                            numero2 = tmp;
                        }
                    }
                }
            }
        }
        scanner.close();

        // Acomodar los numeros en orden
        int maximo = 0;
        if (cantidadNumeros == 6) {
            maximo = numero6;
        } else if (cantidadNumeros == 5) {
            maximo = numero5;
        } else if (cantidadNumeros == 4) {
            maximo = numero4;
        } else if (cantidadNumeros == 3) {
            maximo = numero3;
        } else if (cantidadNumeros == 2) {
            maximo = numero2;
        }
        int minimo = numero1;
        int mediana = 0;

        // Calculamos la mediana

        if (cantidadNumeros == 2) {
            mediana = (numero1 + numero2) / 2;
        }
        else if (cantidadNumeros == 3) {
            mediana = numero2;
        }
        else if (cantidadNumeros == 4) {
            mediana = (numero2 + numero3) / 2;
        }
        else if (cantidadNumeros == 5) {
            mediana = numero3;
        }
        else if (cantidadNumeros == 6) {
            mediana = (numero3 + numero4) / 2;
        }    
        
        // Imprimimos los resultados
        System.out.println("Máximo: " + maximo);
        System.out.println("Mínimo: " + minimo);
        System.out.println("Mediana: " + mediana);


    }
}
