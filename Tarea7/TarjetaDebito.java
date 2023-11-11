package Tarea7;

class TarjetaDebito extends Tarjeta {
    public TarjetaDebito(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public void verificarNIP(String nip) throws NIPIncorrectoException {
        // Simulación de verificación de NIP
        if (!nip.equals("1234")) {
            throw new NIPIncorrectoException("NIP incorrecto");
        }
    }
}