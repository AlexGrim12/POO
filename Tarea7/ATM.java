package Tarea7;


class ATM implements Banco {
    @Override
    public void retirar(double monto) throws OperacionNoValidaException {
        throw new OperacionNoValidaException("Operación no permitida en el ATM");
    }

    @Override
    public void abonar(double monto) throws OperacionNoValidaException {
        throw new OperacionNoValidaException("Operación no permitida en el ATM");
    }

    @Override
    public double consultarSaldo() {
        throw new UnsupportedOperationException("Operación no permitida en el ATM");
    }

    public void verificarSaldo(double saldo) throws TarjetaNoValidaException {
        if (saldo < 0) {
            throw new TarjetaNoValidaException("Tarjeta no válida");
        }
    }
}