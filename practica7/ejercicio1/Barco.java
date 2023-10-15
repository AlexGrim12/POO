package practica7.ejercicio1;

public class Barco extends Vehiculo {
    @Override
    public String toString() {
        //System.out.println(super.toString());
        return "Barco{" + "numSerie=" + getNumSerie() + '}';
    }
}
