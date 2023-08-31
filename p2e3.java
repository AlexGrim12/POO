import java.util.Scanner;

public class p2e3 {
    public static void main(String[] args) {
        float area;
        int opcion;
        final float PI = 3.1416f;

        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Ingrese la opcion deseada: \n");
            System.out.println("1. Calcular el area de un circulo");
            System.out.println("2. Calcular el area de un triangulo");
            System.out.println("3. Calcular el area de un cuadrado");
            System.out.println("4. Salir\n");
            opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    //circulo
                    float radio = 15;
                    area = PI * radio * radio;
                break;
                case 2:
                    float base = 8, altura = 5;
                    area = ( base * altura ) / 2;
                break;
                case 3:
                    float lado = 10;
                    area = lado * lado;
                break;
                case 4:
                    System.out.print("bye!\n");
                continue;
                default:
                    System.out.print("Su eleccion no es valida\n");
                continue;
            }
            System.out.print("\nEl area es: " + area + "\n\n");
        }
        while (opcion != 4);
        sc.close();
    }
}