import 'dart:io';
import 'dart:math';

void main() {
    bool salir = false;
    // Menu
    while (!salir) {
        print("Bienvenido al juego de Gato.");
        print("Selecciona una opción para continuar");
        print("1. Empezar juego");
        print("2. Salir");
        print("");
        String? opc = stdin.readLineSync();
        // opcion 1 - Empezar juego
        switch (opc) {
        case '1':
            Jugador j1 = Jugador();
            j1.numero = 1;
            j1.simbolo = "X";
            Jugador j2 = Jugador();
            j2.numero = 2;
            j2.simbolo = "O";
            var tablero = Tablero();
            var espera = const Duration(seconds:3);
            for (int i=1; i<10; i++) {
                int turno = i%2;
                if (turno == 0) {
                    print("Turno de ${j1.simbolo}");
                    tablero.movimiento(j1);
                } else if (turno == 1) {
                    print("Turno de ${j2.simbolo}");
                    tablero.movimiento(j2);
                }
                tablero.imprimirTablero();
                print("");
                sleep(espera);

                if (tablero.Ganador(j1.simbolo!)) {
                    print("El jugador ${j1.numero} de simbolo: ${j1.simbolo} es el ganador");
                    print("");
                    break;
                } else if (tablero.Ganador(j2.simbolo!)) {
                    print("El jugador ${j2.numero} de simbolo: ${j2.simbolo} es el ganador");
                    print("");
                    break;
                } else if (i==9) {
                    print("El juego ha terminado en empate");
                }
            }
            break;
// opcion - 2. Salir
        case '2':
            print("Gracias por jugar");
            salir = true;
            break;
// Cualquier otra cosa
        default:
            print("Opción no válida");
            print("Presione enter para continuar");
            stdin.readLineSync();
            break;
        }
    }
}

class Jugador {
    int? numero;
    String? simbolo;
}

class Tablero {
    String p1 = '';
    String p2 = '';
    String p3 = '';
    String p4 = '';
    String p5 = '';
    String p6 = '';
    String p7 = '';
    String p8 = '';
    String p9 = '';

    void imprimirTablero() {
        print(' ${p1} | ${p2} | ${p3} ');
        print('-----------');
        print(' ${p4} | ${p5} | ${p6} ');
        print('-----------');
        print(' ${p7} | ${p8} | ${p9} ');
    }

    void movimiento(Jugador j) {
        var random = Random();
        int posicion;
        do {
            posicion = random.nextInt(9) + 1;
        } while (!esPosicionValida(posicion));

        switch (posicion) {
        case 1:
            p1 = j.simbolo!;
            break;
        case 2:
            p2 = j.simbolo!;
            break;
        case 3:
            p3 = j.simbolo!;
            break;
        case 4:
            p4 = j.simbolo!;
            break;
        case 5:
            p5 = j.simbolo!;
            break;
        case 6:
            p6 = j.simbolo!;
            break;
        case 7:
            p7 = j.simbolo!;
            break;
        case 8:
            p8 = j.simbolo!;
            break;
        case 9:
            p9 = j.simbolo!;
            break;
        }
    }

    bool esPosicionValida(int posicion) {
        switch (posicion) {
        case 1:
            return p1.isEmpty;
        case 2:
            return p2.isEmpty;
        case 3:
            return p3.isEmpty;
        case 4:
            return p4.isEmpty;
        case 5:
            return p5.isEmpty;
        case 6:
            return p6.isEmpty;
        case 7:
            return p7.isEmpty;
        case 8:
            return p8.isEmpty;
        case 9:
            return p9.isEmpty;
        default:
            return false;
        }
    }

    bool Ganador(String simbolo) {
        return (p1 == simbolo && p2 == simbolo && p3 == simbolo) ||
               (p4 == simbolo && p5 == simbolo && p6 == simbolo) ||
               (p7 == simbolo && p8 == simbolo && p9 == simbolo) ||
               (p1 == simbolo && p4 == simbolo && p7 == simbolo) ||
               (p2 == simbolo && p5 == simbolo && p8 == simbolo) ||
               (p3 == simbolo && p6 == simbolo && p9 == simbolo) ||
               (p1 == simbolo && p5 == simbolo && p9 == simbolo) ||
               (p3 == simbolo && p5 == simbolo && p7 == simbolo);
    }
}