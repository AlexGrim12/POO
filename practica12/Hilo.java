package practica12;

public class Hilo extends Thread {
    public Hilo(String nombre) {
        super(nombre);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.printf("Iteracion %d de %s\n", i, getName());
        }
        System.out.printf("Hilo %s terminado\n", getName());
    }

    public static void main(String[] args) {
        new Hilo("Mi primer hilo").start();
        new Hilo("Mi segundo hilo").start();

        System.out.println("Hilo principal terminado");
    }
}
