package practica12;

public class Cuenta extends Thread {
    private static long saldo = 0;

    public Cuenta(String nombre) {
        super(nombre);
    }

    @Override
    public void run() {
        if (getName().equals("Deposito 1") || getName().equals("Deposito 2")) {
            this.depositarDinero(100);
        } else {
            this.extraerDinero(50);
        }
    }

    public synchronized void extraerDinero(long cantidad) {

        try{
            if (saldo <= 0) {
                System.out.printf("Saldo insuficiente para %s\n", getName());
                wait();
            }
        } catch (InterruptedException e) {
            System.out.println("Error en la espera: " + e.getMessage());
        }
        saldo -= cantidad;
        System.out.printf("%s retiro %d, saldo actual: %d\n", getName(), cantidad, saldo);
        notifyAll();
    }
    
    public synchronized void depositarDinero(long cantidad) {
        System.out.printf("Iniciando %s\n", getName());
        System.out.printf("%s realizando operacion, saldo actual: %d\n", getName(), saldo);
        saldo += cantidad;
        System.out.printf("%s terminado, saldo final: %d\n", getName(), saldo);
        notifyAll();
    }

    public static void main(String[] args) {
        new Cuenta("Acceso A").start();
        new Cuenta("Acceso B").start();
        new Cuenta("Deposito 1").start();
        new Cuenta("Deposito 2").start();
        System.out.println("Hilo principal terminado");
    }
}
