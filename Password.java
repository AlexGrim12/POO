import java.io.Console;
import java.io.IOException;

class PasswordInput {

    public static String main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.out.println("No se puede obtener la consola");
            System.exit(0);
        }

        String password = new String(console.readPassword("Ingresa la password: "));

        return password;
    }
}

public class Password {

    private String password;
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{};:'\",.<>/?|\n";
    protected static final int MIN_LENGTH = 8;
    protected static final int MAX_LENGTH = 16;

    public Password(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String validate(String password) {
        int length = password.length();
        boolean hasSpecialCharacter = false;
        boolean hasNumber = false;
        boolean hasUppercase = false;
        boolean hasLowercase = false;

        for (int i = 0; i < length; i++) {
            char c = password.charAt(i);

            if (!hasSpecialCharacter && SPECIAL_CHARACTERS.indexOf(c) != -1) {
                hasSpecialCharacter = true;
            }
            if (!hasNumber && Character.isDigit(c)) {
                hasNumber = true;
            }
            if (!hasUppercase && Character.isUpperCase(c)) {
                hasUppercase = true;
            }
            if (!hasLowercase && Character.isLowerCase(c)) {
                hasLowercase = true;
            }
        }

        if (length <= MAX_LENGTH && length > MIN_LENGTH && hasSpecialCharacter && hasNumber
                && hasUppercase && hasLowercase) {
            return "Fuerte";
        } else if (length >= 8
                && ((hasUppercase && hasLowercase) || (hasUppercase || hasLowercase) && hasNumber)
                && hasSpecialCharacter) {
            return "Media";
        } else {
            return "Debil";
        }

    }

    public static String hidePassword(String password) {
        return "*".repeat(password.length());
    }

    public static void main(String[] args) throws IOException {

        String password = PasswordInput.main(args);

        Password pwd = new Password(password);
        System.out.println("Password oculta: " + hidePassword(pwd.getPassword()));
        System.out.println("La Password es de nivel: " + validate(pwd.getPassword()));

    }
}