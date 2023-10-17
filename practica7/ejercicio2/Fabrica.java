package practica7.ejercicio2;

import java.util.Hashtable;

public class Fabrica {
    public static void main(String[] args) {
        Avion avion = new Avion();
        Barco barco = new Barco();
        AvionSupersonico avionSupersonico = new AvionSupersonico();
        Automovil automovil = new Automovil();

        Vehiculo[] vehiculos = { avion, barco, avionSupersonico, automovil };

        Hashtable<String, Vehiculo> vehículosHash = new Hashtable<>();

        vehículosHash.put(avion.getNumSerie(), avion);
        vehículosHash.put(barco.getNumSerie(), barco);
        vehículosHash.put(avionSupersonico.getNumSerie(), avionSupersonico);
        vehículosHash.put(automovil.getNumSerie(), automovil);

        int longitudPista = 20;
        Vehiculo ganador = null;
        int tiempoGanador = Integer.MAX_VALUE;

        int tiempo = 0;

        while (ganador == null) {
            System.out.println("MAPA DE LA PISTA");
            System.out.println("Instante de tiempo: " + tiempo + " min");
            System.out.println("0...................20 meta");
            System.out.println("-------------------------");
            boolean todosLlegaron = true;
            for (int i = 0; i < vehiculos.length; i++) {
                Vehiculo vehiculo = vehiculos[i];

                int aceleracionAleatoria = vehiculo.getAceleracionDesaceleracion(); // Número aleatorio entre -5 y 5
                int nuevaVelocidad = vehiculo.getVelocidadInicial() + aceleracionAleatoria;

                if (nuevaVelocidad < 0) {
                    nuevaVelocidad = 0;
                }

                int distanciaRecorrida = (nuevaVelocidad * tiempo) / 60; // Convertir de km/h a km/min

                if (distanciaRecorrida < longitudPista) {
                    todosLlegaron = false;
                }

                StringBuilder pista = new StringBuilder("...................."); // 20 puntos (sin espacios)
                char etiqueta = (char) ('a' + i);
                pista.setCharAt(distanciaRecorrida >= 19 ? 19 : distanciaRecorrida, etiqueta);

                String nombreVehículo = vehiculo.getClass().getSimpleName();
                String distanciaRecorridaStr = String.valueOf(distanciaRecorrida);
                String velocidadStr = String.valueOf(nuevaVelocidad);
                System.out.printf("%s\n", pista);
                System.out.printf("%c -> Objeto tipo %s: Vi = %s km/h Distancia recorrida Actualmente = %s km\n",
                        etiqueta, nombreVehículo, velocidadStr, distanciaRecorridaStr);

                if (distanciaRecorrida >= longitudPista) {
                    if (tiempo < tiempoGanador) {
                        ganador = vehiculo;
                        tiempoGanador = tiempo;
                    }
                }
            }

            if (todosLlegaron) {
                break;
            }

            tiempo += 1;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

        System.out.println("MAPA DE LA PISTA");
        System.out.println("Instante de tiempo: " + tiempo + " min");
        System.out.println("0.............20 meta");

        for (int i = 0; i < vehiculos.length; i++) {
            Vehiculo vehiculo = vehiculos[i];

            int aceleracionAleatoria = vehiculo.getAceleracionDesaceleracion();
            int nuevaVelocidad = vehiculo.getVelocidadInicial() + aceleracionAleatoria;

            if (nuevaVelocidad < 0) {
                nuevaVelocidad = 0;
            }

            int distanciaRecorrida = (nuevaVelocidad * (tiempo - 1)) / 60;

            // Crear un diagrama de la pista
            StringBuilder pista = new StringBuilder("....................");
            char etiqueta = (char) ('a' + i);
            pista.setCharAt(distanciaRecorrida >= 19 ? 19 : distanciaRecorrida, etiqueta);

            // Imprimir el diagrama de la pista y el estado del vehiculo
            String nombreVehículo = vehiculo.getClass().getSimpleName();
            String distanciaRecorridaStr = String.valueOf(distanciaRecorrida);
            String velocidadStr = String.valueOf(nuevaVelocidad);
            System.out.printf("%s\n", pista);
            System.out.printf("%c -> Objeto tipo %s: Vi = %s km/h Distancia recorrida Actualmente = %s km\n",
                    etiqueta, nombreVehículo, velocidadStr, distanciaRecorridaStr);
        }

        System.out.println("-------------------------");
        if (ganador != null) {
            System.out.println("El ganador es: " + ganador.getClass().getSimpleName());
            System.out.println("Tiempo del ganador: " + tiempoGanador + " min");
        }
    }
}
