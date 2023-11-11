package Tarea7.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpresionesConLambda {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Usando una expresión lambda para filtrar números mayores que 5
        numeros = filtrarNumeros(numeros, numero -> numero > 5);

        System.out.println("Números mayores que 5: " + numeros);
    }

    interface Filtro {
        boolean cumpleCriterio(int numero);
    }

    static List<Integer> filtrarNumeros(List<Integer> numeros, Filtro filtro) {
        List<Integer> resultado = new ArrayList<>();
        for (int numero : numeros) {
            if (filtro.cumpleCriterio(numero)) {
                resultado.add(numero);
            }
        }
        return resultado;
    }
}
