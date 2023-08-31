import java.util.Random;

public class p2e1 {
    public static void main(String[] args) {
        int a;
        a = 10;

        Random y;
        y = new Random(); //un metodo es una funcion que pertenece a una clase y se llama con un objeto de esa clase (new),
        Random x = y;

        for (int i = 0; i <= 10; i++) {
            if(i == 2 || i == 3)
                break;
            System.out.println(i);
        }
    }
}