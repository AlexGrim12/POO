import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Ingrese una palabra: ");
            String str = sc.nextLine();
            Boolean ans = true;
            Integer n = str.length() % 2 == 0 ? str.length() : (str.length() - 1);
            for (int i = 0; i <= n / 2; i++) {
                int j = str.length() - 1 - i;
                if (str.charAt(i) == str.charAt(j)) {
                    ans = true;
                    j--;
                } else {
                    ans = false;
                    break;
                }
            }
            System.out.println((ans) ? "La palabra ingresada es un palindromo" : "La palabra ingresada no es un palindromo");
            System.out.println("Desea ingresar otra palabra? (s/n)");
            String res = sc.nextLine();
            if (res.equals("n")) {
                break;
            }
        } while (true);
        sc.close();
        System.out.println("Adios!");
    }
}
