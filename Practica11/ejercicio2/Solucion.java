import java.io.Serializable;

public class Solucion implements Serializable {
    private static final long serialVersionUID = 1L;

    private int numero;
    private int pasos;

    public Solucion(int numero, int pasos) {
        this.numero = numero;
        this.pasos = pasos;
    }

    // Getters y setters

    @Override
    public String toString() {
        return "Solucion{" +
                "numero=" + numero +
                ", pasos=" + pasos +
                "}\n";
    }
}
