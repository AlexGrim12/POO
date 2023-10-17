package practica7.ejercicio2;

import java.util.Random;

public class AutoElectrico extends Automovil {
    private int velocidadInicial;
    private int aceleracionDesaceleracion;

    public AutoElectrico() {
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