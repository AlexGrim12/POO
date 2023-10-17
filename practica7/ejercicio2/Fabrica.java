package practica7.ejercicio2;

import java.util.Hashtable;

public class Fabrica {
    public static void main(String[] args) {
        // Crear un objeto de cada tipo de vehículo
        Avion avion = new Avion();
        Barco barco = new Barco();
        AvionSupersonico avionSupersonico = new AvionSupersonico();
        Automovil automovil = new Automovil();

        // Crear un arreglo de vehículos
        Vehiculo[] vehículos = { avion, barco, avionSupersonico, automovil };

        // Crear un hash table de vehículos
        Hashtable<String, Vehiculo> vehículosHash = new Hashtable<>();

        // Agregar los vehículos al hash table
        vehículosHash.put(avion.getNumSerie(), avion);
        vehículosHash.put(barco.getNumSerie(), barco);
        vehículosHash.put(avionSupersonico.getNumSerie(), avionSupersonico);
        vehículosHash.put(automovil.getNumSerie(), automovil);

        int longitudPista = 20;
        Vehiculo ganador = null;
        int tiempoGanador = Integer.MAX_VALUE;

        // Simulación de la carrera
        int tiempo = 0;

        while (ganador == null) {
            System.out.printf("MAPA DE LA PISTA");
            System.out.println("Instante de tiempo: " + tiempo + " min");
            System.out.println("0.............20 meta");
            System.out.println("-------------------------");
            boolean todosLlegaron = true;
            for (int i = 0; i < vehículos.length; i++) {
                Vehiculo vehículo = vehículos[i];

                int aceleraciónAleatoria = vehículo.getAceleracionDesaceleracion(); // Número aleatorio entre -5 y 5
                int nuevaVelocidad = vehículo.getVelocidadInicial() + aceleraciónAleatoria;

                // Verificar que la velocidad no sea negativa
                if (nuevaVelocidad < 0) {
                    nuevaVelocidad = 0;
                }

                int distanciaRecorrida = (nuevaVelocidad * tiempo) / 60; // Convertir de km/h a km/min

                if (distanciaRecorrida < longitudPista) {
                    todosLlegaron = false;
                }

                // Crear un diagrama de la pista
                StringBuilder pista = new StringBuilder("...................."); // 20 puntos (sin espacios)
                char etiqueta = (char) ('a' + i);
                pista.setCharAt(distanciaRecorrida >= 19 ? 19 : distanciaRecorrida, etiqueta);

                // Imprimir el diagrama de la pista y el estado del vehículo
                String nombreVehículo = vehículo.getClass().getSimpleName();
                String distanciaRecorridaStr = String.valueOf(distanciaRecorrida);
                String velocidadStr = String.valueOf(nuevaVelocidad);
                System.out.printf("%s\n", pista);
                System.out.printf("%c -> Objeto tipo %s: Vi = %s km/h Distancia recorrida Actualmente = %s km\n",
                        etiqueta, nombreVehículo, velocidadStr, distanciaRecorridaStr);

                if (distanciaRecorrida >= longitudPista) {
                    if (tiempo < tiempoGanador) {
                        ganador = vehículo;
                        tiempoGanador = tiempo;
                    }
                }
            }

            if (todosLlegaron) {
                break; // Todos los vehículos han llegado, sal del bucle
            }

            tiempo += 1; // Avanzar un minuto en el tiempo
            try {
                Thread.sleep(1000); // Esperar 1 segundo para que se vea la actualización en la consola
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("\033[H\033[2J"); // Limpiar la pantalla en la consola
            System.out.flush();
        }

        System.out.println("-------------------------");
        if (ganador != null) {
            System.out.println("El ganador es: " + ganador.getClass().getSimpleName());
            System.out.println("Tiempo del ganador: " + tiempoGanador + " min");
        }
    }
}
