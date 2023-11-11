package Tarea7;


class Cliente implements Banco {
    private Tarjeta tarjeta;

    public Cliente(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public void retirar(double monto) throws OperacionNoValidaException {
        if (monto > tarjeta.getSaldo()) {
            throw new OperacionNoValidaException("Saldo insuficiente");
        }

        tarjeta.saldo -= monto;
        System.out.println("Retiro exitoso. Saldo actual: " + tarjeta.getSaldo());
    }

    @Override
    public void abonar(double monto) throws OperacionNoValidaException {
        if (monto <= 0) {
            throw new OperacionNoValidaException("Monto de abono no válido");
        }

        tarjeta.saldo += monto;
        System.out.println("Abono exitoso. Saldo actual: " + tarjeta.getSaldo());
    }

    @Override
    public double consultarSaldo() {
        return tarjeta.getSaldo();
    }
}