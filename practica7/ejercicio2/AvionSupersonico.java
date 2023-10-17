package practica7.ejercicio2;

import java.util.Random;

class AvionSupersonico extends Avion{
    private int velocidadInicial;
    private int aceleracionDesaceleracion;

    public AvionSupersonico() {
        Random rand = new Random();
        velocidadInicial = rand.nextInt(100) + 1;
        aceleracionDesaceleracion = rand.nextInt(20) - 10;
    }

    public int getVelocidadInicial() {
        return velocidadInicial;
    }

    public int getAceleracionDesaceleracion() {
        return aceleracionDesaceleracion;
    }
}