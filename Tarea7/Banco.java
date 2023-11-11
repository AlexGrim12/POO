package Tarea7;

interface Banco {
    void retirar(double monto) throws OperacionNoValidaException;

    void abonar(double monto) throws OperacionNoValidaException;

    double consultarSaldo();
}