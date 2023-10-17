package practica7.ejercicio2;

import java.util.Random;

public class Vehiculo {
    private String numSerie = "";
    private int velocidadInicial;
    private int aceleracionDesaceleracion;

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String a) {
        this.numSerie = a;
    }

    public Vehiculo() {
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

    @Override

    public String toString() {
        return "Vehiculo{" + "numSerie=" + numSerie + '}';
    }

}
