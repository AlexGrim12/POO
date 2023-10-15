package practica7.ejercicio1;


public class Avion extends Vehiculo{
    //enum some differents kinds of airplanes
    public enum TipoAvion {
        supersonico, militar, turustico, carga
    }

    private TipoAvion tipo;

    public Avion(TipoAvion tipo) {
        this.tipo = tipo;
    }

    public TipoAvion getTipo() {
        return tipo;
    }

    public void setTipo(TipoAvion tipo) {
        this.tipo = tipo;
    } 
}
