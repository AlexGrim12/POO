import java.io.Console;
import java.io.IOException;

class PasswordInput {

    public static String main(String[] args) throws IOException {
        Console console = System.console();
        if (console == null) {
            System.out.println("No se puede obtener la consola");
            System.exit(0);
        }

        String contraseña = new String(console.readPassword("Ingrese su contraseña: "));

        return contraseña;
    }
}

public class Password {

    private String contraseña;
    private static final String CARACTERES_ESPECIALES = "!@#$%^&*()-_=+[]{};:'\",.<>/?|\n";
    protected static final int MIN_LONGITUD = 8;
    protected static final int MAX_LONGITUD = 16;

    public Password(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public static String validar(String contraseña) {
        int longitud = contraseña.length();
        boolean tieneCaracterEspecial = false;
        boolean tieneNumero = false;
        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;

        for (int i = 0; i < longitud; i++) {
            char c = contraseña.charAt(i);

            if (!tieneCaracterEspecial && CARACTERES_ESPECIALES.indexOf(c) != -1) {
                tieneCaracterEspecial = true;
            }
            if (!tieneNumero && Character.isDigit(c)) {
                tieneNumero = true;
            }
            if (!tieneMayuscula && Character.isUpperCase(c)) {
                tieneMayuscula = true;
            }
            if (!tieneMinuscula && Character.isLowerCase(c)) {
                tieneMinuscula = true;
            }
        }

        if (longitud <= MAX_LONGITUD && longitud > MIN_LONGITUD && tieneCaracterEspecial && tieneNumero
                && tieneMayuscula && tieneMinuscula) {
            return "Fuerte";
        } else if (longitud >= 8
                && ((tieneMayuscula && tieneMinuscula) || (tieneMayuscula || tieneMinuscula) && tieneNumero)
                && tieneCaracterEspecial) {
            return "Media";
        } else {
            return "Débil";
        }

    }

    public static String ocultarContraseña(String contraseña) {
        return "*".repeat(contraseña.length());
    }

    public static void main(String[] args) throws IOException {

        String constraseña = PasswordInput.main(args);

        Password password = new Password(constraseña);
        System.out.println("Contraseña oculta: " + ocultarContraseña(password.getContraseña()));
        System.out.println("Seguridad de la contraseña: " + validar(password.getContraseña()));

    }
}