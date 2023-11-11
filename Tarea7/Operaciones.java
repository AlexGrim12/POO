package Tarea7;

import java.util.Scanner;

public class Operaciones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TarjetaDebito tarjetaDebito = new TarjetaDebito(1000);

        Cliente cliente = new Cliente(tarjetaDebito);

        ATM atm = new ATM();

        try {
            // Cliente ingresa NIP
            System.out.print("Ingrese su NIP: ");
            String nip = scanner.nextLine();

            if (nip.length() != 4) {
                throw new NIPIncorrectoException("NIP incorrecto");
            }

            // Cliente verifica NIP
            tarjetaDebito.verificarNIP(nip);

            int opcion = 0;

            do {
                System.out.println("1. Retirar");
                System.out.println("2. Abonar");
                System.out.println("3. Consultar saldo");
                System.out.println("4. Salir");
                System.out.print("Opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.print("Monto a retirar: ");
                        double montoRetiro = scanner.nextDouble();
                        atm.verificarSaldo(cliente.consultarSaldo() - montoRetiro);
                        cliente.retirar(montoRetiro);
                        break;
                    case 2:
                        System.out.print("Monto a abonar: ");
                        double montoAbono = scanner.nextDouble();
                        cliente.abonar(montoAbono);
                        break;
                    case 3:
                        System.out.println("Saldo actual: " + cliente.consultarSaldo());
                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            } while (opcion != 4);

        } catch (OperacionNoValidaException | TarjetaNoValidaException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}