import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class KaprekarServer {
    private static final String SOLUCIONES_FILE = "Soluciones.txt";
    private static Map<Integer, Integer> solucionesCache = new HashMap<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Servidor esperando conexiones...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado: " + clientSocket.getInetAddress());

                try (ObjectInputStream input = new ObjectInputStream(clientSocket.getInputStream());
                        ObjectOutputStream output = new ObjectOutputStream(clientSocket.getOutputStream())) {

                    int numero = input.readInt();
                    int pasos = calcularPasosKaprekar(numero);

                    output.writeInt(pasos);
                    output.flush();

                    guardarEnArchivo(numero, pasos);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int convertirDigitosEnNumero(int[] digitos) {
        int numero = 0;
        for (int i = 0; i < digitos.length; i++) {
            numero = numero * 10 + digitos[i];
        }
        return numero;
    }

    private static int calcularPasosKaprekar(int numero) {
        int pasos = 0;

        while (numero != 6174) {
            // Obtener los dígitos del número
            int[] digitos = new int[4];
            for (int i = 3; i >= 0; i--) {
                digitos[i] = numero % 10;
                numero /= 10;
            }

            // Ordenar los dígitos de forma ascendente y descendente
            int[] ascendente = digitos.clone();
            Arrays.sort(ascendente);
            int[] descendente = new int[4];
            for (int i = 0, j = 3; i < 4; i++, j--) {
                descendente[i] = ascendente[j];
            }

            // Calcular la diferencia y actualizar el número
            int menor = convertirDigitosEnNumero(ascendente);
            int mayor = convertirDigitosEnNumero(descendente);
            numero = mayor - menor;
            pasos++;
        }

        return pasos;
    }

    private static void guardarEnArchivo(int numero, int pasos) {
        try (ObjectOutputStream fileOutput = new ObjectOutputStream(new FileOutputStream(SOLUCIONES_FILE, true))) {
            // Añadir el nuevo par número-pasos al archivo
            fileOutput.writeObject(new Solucion(numero, pasos));
            System.out.println("El numero: " + numero + " se tardo " + pasos
                    + " pasos en llegar a 6174 y se guardo en el archivo");
            // System.out.println(new Solucion(numero, pasos));
            fileOutput.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
