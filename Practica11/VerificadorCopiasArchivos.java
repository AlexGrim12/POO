
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class VerificadorCopiasArchivos {

    public static void main(String[] args) {
        String archivo1 = "./archivo1.txt";
        String archivo2 = "./archivo2.txt";

        try {
            double similitud = calcularSimilitud(archivo1, archivo2);
            System.out.println("La similitud entre los archivos es: " + String.format("%.2f", similitud * 100) + "%");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double calcularSimilitud(String archivo1, String archivo2) throws IOException {
        Set<String> conjunto1 = leerArchivo(archivo1);
        Set<String> conjunto2 = leerArchivo(archivo2);

        // Calcular la intersección
        Set<String> interseccion = new HashSet<>(conjunto1);
        interseccion.retainAll(conjunto2);

        // Calcular la unión
        Set<String> union = new HashSet<>(conjunto1);
        union.addAll(conjunto2);

        // Calcular el coeficiente de Jaccard
        return (double) interseccion.size() / union.size();
    }

    private static Set<String> leerArchivo(String archivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            // Utilizar una expresión lambda para leer las líneas del archivo y convertirlas
            // a minúsculas
            return br.lines().map(String::toLowerCase).collect(HashSet::new, Set::add, Set::addAll);
        }
    }
}
