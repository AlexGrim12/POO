
public class Grupo extends Thread {
    public Grupo(ThreadGroup G, String nombre) {
        super(G, nombre);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf(getName());
        }
    }

    public static void listarHilos(ThreadGroup grupoActual) {
        int numhilos;
        Thread[] listaDeHilos;

        numhilos = grupoActual.activeCount();
        listaDeHilos = new Thread[numhilos];
        System.out.println("Numero de hilos activos en el grupo: " + numhilos);
        for (int i = 0; i < numhilos; i++) {
            System.out.println("Hilo activo: " + listaDeHilos[i].getName());
        }
    }

    public static void main(String[] args) {
        ThreadGroup grupoH = new ThreadGroup("Grupo de hilos prioridad normal");
        Thread hilo1 = new Grupo(grupoH, "Hilo 1 con prioridad normal\n");
        Thread hilo2 = new Grupo(grupoH, "Hilo 2 con prioridad normal\n");
        Thread hilo3 = new Grupo(grupoH, "Hilo 3 con prioridad normal\n");
        Thread hilo4 = new Grupo(grupoH, "Hilo 4 con prioridad normal\n");
        Thread hilo5 = new Grupo(grupoH, "Hilo 5 con prioridad normal\n");
        Thread hilo6 = new Grupo(grupoH, "Hilo 6 con prioridad normal\n");
        Thread hilo7 = new Grupo(grupoH, "Hilo 7 con prioridad normal\n");
        Thread hilo8 = new Grupo(grupoH, "Hilo 8 con prioridad normal\n");
        Thread hilo9 = new Grupo(grupoH, "Hilo 9 con prioridad normal\n");
        Thread hilo10 = new Grupo(grupoH, "Hilo 10 con prioridad normal\n");

        hilo7.setPriority(Thread.MAX_PRIORITY);
        hilo10.setPriority(Thread.MIN_PRIORITY);
        grupoH.setMaxPriority(Thread.NORM_PRIORITY);

        System.out.println("Prioridad del grupo: " + grupoH.getMaxPriority());

        System.out.println("Prioridad del hilo 1: " + hilo1.getPriority());
        System.out.println("Prioridad del hilo 2: " + hilo2.getPriority());
        System.out.println("Prioridad del hilo 3: " + hilo3.getPriority());
        System.out.println("Prioridad del hilo 4: " + hilo4.getPriority());
        System.out.println("Prioridad del hilo 5: " + hilo5.getPriority());
        System.out.println("Prioridad del hilo 6: " + hilo6.getPriority());
        System.out.println("Prioridad del hilo 7: " + hilo7.getPriority());
        System.out.println("Prioridad del hilo 8: " + hilo8.getPriority());
        System.out.println("Prioridad del hilo 9: " + hilo9.getPriority());
        System.out.println("Prioridad del hilo 10: " + hilo10.getPriority());

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        hilo6.start();
        hilo7.start();
        hilo8.start();
        hilo9.start();
        hilo10.start();

        listarHilos(grupoH);
    }
}
