import java.util.Arrays;
import java.util.Scanner;

public class Anagrama {
    public static boolean esAnagrama(String palabra1, String palabra2) {

        palabra1 = palabra1.replaceAll("\\s", "").toLowerCase();
        palabra2 = palabra2.replaceAll("\\s", "").toLowerCase();

        if (palabra1.length() != palabra2.length()) {
            return false;
        }

        char[] arr1 = palabra1.toCharArray();
        char[] arr2 = palabra2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Ingrese la primera palabra: ");
            String palabra1 = sc.nextLine();

            System.out.println("Ingrese la segunda palabra: ");
            String palabra2 = sc.nextLine();

            if (esAnagrama(palabra1, palabra2)) {
                System.out.println("Las palabras ingresadas son anagramas");
            } else {
                System.out.println("Las palabras ingresadas NO son anagramas");
            }
            System.out.println("Desea ingresar otra palabra? (s/n)");
            String res = sc.nextLine();
            if (res.equals("n")) {
                break;
            }
        } while (true);

        sc.close();
    }
}