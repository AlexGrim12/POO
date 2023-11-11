package Tarea7;

abstract class Tarjeta {
    protected double saldo;

    public Tarjeta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public abstract void verificarNIP(String nip) throws NIPIncorrectoException;

    public double getSaldo() {
        return saldo;
    }
}