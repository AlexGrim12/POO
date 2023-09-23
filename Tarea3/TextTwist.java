import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TextTwist {
    static Random generadorAleatorio = new Random();

    public static class Palabra {
        public String palabraOriginal;
        public String palabraRevuelta;
        public ArrayList<String> soluciones = new ArrayList<String>();

        public Palabra(String palabraOriginal, String solucion1, String solucion2, String solucion3, String solucion4, String solucion5) {
            this.palabraOriginal = palabraOriginal;
            this.palabraRevuelta = mezclarPalabra(palabraOriginal);
            this.soluciones.add(solucion1);
            this.soluciones.add(solucion2);
            this.soluciones.add(solucion3);
            this.soluciones.add(solucion4);
            this.soluciones.add(solucion5);
            this.soluciones.add(palabraOriginal);
        }

        public String mezclarPalabra(String palabra) {
            StringBuilder palabraMezclada = new StringBuilder(palabra);
            int longitud = palabraMezclada.length();

            for (int i = 0; i < longitud; i++) {
                int indiceAleatorio = generadorAleatorio.nextInt(longitud);
                char caracterActual = palabraMezclada.charAt(i);
                palabraMezclada.setCharAt(i, palabraMezclada.charAt(indiceAleatorio));
                palabraMezclada.setCharAt(indiceAleatorio, caracterActual);
            }

            if (palabraMezclada.toString().equals(palabra))
                return mezclarPalabra(palabra);
            else
                return palabraMezclada.toString();
        }

        public int calcularPuntos(String respuesta) {
            String respuestaEnMayusculas = respuesta.toUpperCase();

            if (esSolucionValida(respuestaEnMayusculas)) {
                switch (respuestaEnMayusculas.length()) {
                    case 3:
                        return 1;
                    case 4:
                        return 2;
                    case 5:
                        return 3;
                    case 6:
                        if (palabraOriginal.equals(respuestaEnMayusculas))
                            return 54;
                        else
                            return 4;
                    default:
                        return 0;
                }
            } else
                return 0;
        }

        public boolean esSolucionValida(String respuesta) {
            respuesta = respuesta.toUpperCase();
            for (int i = 0; i < this.soluciones.size(); i++) {
                if (this.soluciones.get(i).equals(respuesta)) {
                    this.soluciones.remove(i);
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int indicePalabra = generadorAleatorio.nextInt(5);
        int intentosRestantes = 10;
        int puntaje = 0;

        Palabra palabraActual;
        switch (indicePalabra) {
            case 0:
                palabraActual = new Palabra("PROGRA", "PY", "JS", "CPP", "C", "JAVA");
                break;
            case 1:
                palabraActual = new Palabra("COMPU", "RAM", "SSD", "GPU", "CPU", "WIFI");
                break;
            case 2:
                palabraActual = new Palabra("CASA", "PUERTA", "SILLON", "TECHO", "PISO", "PARED");
                break;
            case 3:
                palabraActual = new Palabra("ANIMAL", "PERRO", "GATO", "CONEJO", "PATO", "VACA");
                break;
            default:
                palabraActual = new Palabra("FRUTA", "FRESA", "PERA", "UVA", "CEREZA", "SANDIA");
                break;
        }

        System.out.println("Juego de Texto Revuelto");
        System.out.println("Tienes 10 intentos para adivinar las 5 palabras.");
        System.out.println("La palabra revuelta es: " + palabraActual.palabraRevuelta);

        while (intentosRestantes > 0 && palabraActual.soluciones.size() > 0) {
            System.out.println("\nTe quedan " + intentosRestantes + " intentos.");

            System.out.print("Ingresa tu respuesta: ");
            String respuestaUsuario = scanner.nextLine();

            int puntosObtenidos = palabraActual.calcularPuntos(respuestaUsuario);
            puntaje += puntosObtenidos;

            System.out.println("Ganaste " + puntosObtenidos + " puntos.\n");
            intentosRestantes--;
        }

        if (intentosRestantes == 0)
            System.out.println("Se te han agotado los intentos.");
        else
            System.out.println("¡Ganaste! ¡Felicidades!");

        System.out.println("\nTu puntaje final es: " + puntaje);
        scanner.close();
    }
}
