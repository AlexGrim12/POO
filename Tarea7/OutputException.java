package Tarea7;

class OperacionNoValidaException extends Exception {
    public OperacionNoValidaException(String mensaje) {
        super(mensaje);
    }
}

class NIPIncorrectoException extends Exception {
    public NIPIncorrectoException(String mensaje) {
        super(mensaje);
    }
}

class TarjetaNoValidaException extends Exception {
    public TarjetaNoValidaException(String mensaje) {
        super(mensaje);
    }
}
