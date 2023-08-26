import java.util.Scanner;

public class p1e3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cantidadNumeros = 0;

        // Solicitamos al usuario que ingrese la cantidad de números y validamos que esté entre 2 y 6
        System.out.println("¿Cuántos números desea ingresar? (Entre 2 y 6)");
        while (cantidadNumeros < 2 || cantidadNumeros > 6) {
            cantidadNumeros = scanner.nextInt();
            if (cantidadNumeros < 2 || cantidadNumeros > 6) {
                System.out.println("El número debe estar entre 2 y 6, ingrese nuevamente:");
            }
        }
        switch (cantidadNumeros) {
            case 2:
                int numero1 = 0;
                int numero2 = 0;
                System.out.println("Ingrese el primer número:");
                numero1 = scanner.nextInt();
                System.out.println("Ingrese el segundo número:");
                numero2 = scanner.nextInt();
                //mayor menor y mediana
                if (numero1 > numero2) {
                    System.out.println("El mayor es: " + numero1);
                    System.out.println("El menor es: " + numero2);
                } else if (numero1 < numero2) {
                    System.out.println("El mayor es: " + numero2);
                    System.out.println("El menor es: " + numero1);
                } else {
                    System.out.println("Los números son iguales");
                }
                break;
            case 3:

                int numero1 = 0;
                int numero2 = 0;
                int numero3 = 0;
                System.out.println("Ingrese el primer número:");
                numero1 = scanner.nextInt();
                System.out.println("Ingrese el segundo número:");
                numero2 = scanner.nextInt();
                System.out.println("Ingrese el tercer número:");
                numero3 = scanner.nextInt();
                //mayor menor y mediana
                if (numero1 > numero2 && numero1 > numero3) {
                    System.out.println("El mayor es: " + numero1);
                    if (numero2 > numero3) {
                        System.out.println("El menor es: " + numero3);
                        System.out.println("El de en medio es: " + numero2);
                    } else if (numero2 < numero3) {
                        System.out.println("El menor es: " + numero2);
                        System.out.println("El de en medio es: " + numero3);
                    } else {
                        System.out.println("Los números son iguales");
                    }
                } else if (numero2 > numero1 && numero2 > numero3) {
                    System.out.println("El mayor es: " + numero2);
                    if (numero1 > numero3) {
                        System.out.println("El menor es: " + numero3);
                        System.out.println("El de en medio es: " + numero1);
                    } else if (numero1 < numero3) {
                        System.out.println("El menor es: " + numero1);
                        System.out.println("El de en medio es: " + numero3);
                    } else {
                        System.out.println("Los números son iguales");
                    }
                } else if (numero3 > numero1 && numero3 > numero2) {
                    System.out.println("El mayor es: " + numero3);
                    if (numero1 > numero2) {
                        System.out.println("El menor es: " + numero2);
                        System.out.println("El de en medio es: " + numero1);
                    } else if (numero1 < numero2) {
                        System.out.println("El menor es: " + numero1);
                        System.out.println("El de en medio es: " + numero2);
                    } else {
                        System.out.println("Los números son iguales");
                    }
                } else {
                    System.out.println("Los números son iguales");
                }
                break;
            case 4:
                int numero1 = 0;
                int numero2 = 0;
                int numero3 = 0;
                int numero4 = 0;
                System.out.println("Ingrese el primer número:");
                numero1 = scanner.nextInt();
                System.out.println("Ingrese el segundo número:");
                numero2 = scanner.nextInt();
                System.out.println("Ingrese el tercer número:");
                numero3 = scanner.nextInt();
                System.out.println("Ingrese el cuarto número:");
                numero4 = scanner.nextInt();
                //mayor menor y mediana
                if (numero1 > numero2 && numero1 > numero3 && numero1 > numero4) {
                    System.out.println("El mayor es: " + numero1);
                    if (numero2 > numero3 && numero2 > numero4) {
                        System.out.println("El menor es: " + numero4);
                        if (numero3 > numero4) {
                            System.out.println("El de en medio es: " + numero3);
                        } else if (numero3 < numero4) {
                            System.out.println("El de en medio es: " + numero4);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else if (numero3 > numero2 && numero3 > numero4) {
                        System.out.println("El menor es: " + numero2);
                        if (numero2 > numero4) {
                            System.out.println("El de en medio es: " + numero4);
                        } else if (numero2 < numero4) {
                            System.out.println("El de en medio es: " + numero2);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else if (numero4 > numero2 && numero4 > numero3) {
                        System.out.println("El menor es: " + numero2);
                        if (numero2 > numero3) {
                            System.out.println("El de en medio es: " + numero3);
                        } else if (numero2 < numero3) {
                            System.out.println("El de en medio es: " + numero2);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else {
                        System.out.println("Los números son iguales");
                    }
                } else if (numero2 > numero1 && numero2 > numero3 && numero2 > numero4) {
                    System.out.println("El mayor es: " + numero2);
                    if (numero1 > numero3 && numero1 > numero4) {
                        System.out.println("El menor es: " + numero4);
                        if (numero3 > numero4) {
                            System.out.println("El de en medio es: " + numero3);
                        } else if (numero3 < numero4) {
                            System.out.println("El de en medio es: " + numero4);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else if (numero3 > numero1 && numero3 > numero4) {
                        System.out.println("El menor es: " + numero1);
                        if (numero1 > numero4) {
                            System.out.println("El de en medio es: " + numero4);
                        } else if (numero1 < numero4) {
                            System.out.println("El de en medio es: " + numero1);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else if (numero4 > numero1 && numero4 > numero3) {
                        System.out.println("El menor es: " + numero1);
                        if (numero1 > numero3) {
                            System.out.println("El de en medio es: " + numero3);
                        } else if (numero1 < numero3) {
                            System.out.println("El de en medio es: " + numero1);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else {
                        System.out.println("Los números son iguales");
                    }
                } else if (numero3 > numero1 && numero3 > numero2 && numero3 > numero4) {
                    System.out.println("El mayor es: " + numero3);
                    if (numero1 > numero2 && numero1 > numero4) {
                        System.out.println("El menor es: " + numero4);
                        if (numero2 > numero4) {
                            System.out.println("El de en medio es: " + numero2);
                        } else if (numero2 < numero4) {
                            System.out.println("El de en medio es: " + numero4);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else if (numero2 > numero1 && numero2 > numero4) {
                        System.out.println("El menor es: " + numero1);
                        if (numero1 > numero4) {
                            System.out.println("El de en medio es: " + numero4);
                        } else if (numero1 < numero4) {
                            System.out.println("El de en medio es: " + numero1);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else if (numero4 > numero1 && numero4 > numero2) {
                        System.out.println("El menor es: " + numero1);
                        if (numero1 > numero2) {
                            System.out.println("El de en medio es: " + numero2);
                        } else if (numero1 < numero2) {
                            System.out.println("El de en medio es: " + numero1);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else {
                        System.out.println("Los números son iguales");
                    }
                } else if (numero4 > numero1 && numero4 > numero2 && numero4 > numero3) {
                    System.out.println("El mayor es: " + numero4);
                    if (numero1 > numero2 && numero1 > numero3) {
                        System.out.println("El menor es: " + numero3);
                        if (numero2 > numero3) {
                            System.out.println("El de en medio es: " + numero2);
                        } else if (numero2 < numero3) {
                            System.out.println("El de en medio es: " + numero3);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else if (numero2 > numero1 && numero2 > numero3) {
                        System.out.println
                        ("El menor es: " + numero1);
                        if (numero1 > numero3) {
                            System.out.println("El de en medio es: " + numero3);
                        } else if (numero1 < numero3) {
                            System.out.println("El de en medio es: " + numero1);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else if (numero3 > numero1 && numero3 > numero2) {
                        System.out.println("El menor es: " + numero1);
                        if (numero1 > numero2) {
                            System.out.println("El de en medio es: " + numero2);
                        } else if (numero1 < numero2) {
                            System.out.println("El de en medio es: " + numero1);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else {
                        System.out.println("Los números son iguales");
                    }
                } else {
                    System.out.println("Los números son iguales");
                }
                break;
            case 5:
                int numero1 = 0;
                int numero2 = 0;
                int numero3 = 0;
                int numero4 = 0;
                int numero5 = 0;
                System.out.println("Ingrese el primer número:");
                numero1 = scanner.nextInt();
                System.out.println("Ingrese el segundo número:");
                numero2 = scanner.nextInt();
                System.out.println("Ingrese el tercer número:");
                numero3 = scanner.nextInt();
                System.out.println("Ingrese el cuarto número:");
                numero4 = scanner.nextInt();
                System.out.println("Ingrese el quinto número:");
                numero5 = scanner.nextInt();
                //mayor menor y mediana
                if (numero1 > numero2 && numero1 > numero3 && numero1 > numero4 && numero1 > numero5) {
                    System.out.println("El mayor es: " + numero1);
                    if (numero2 > numero3 && numero2 > numero4 && numero2 > numero5) {
                        System.out.println("El menor es: " + numero5);
                        if (numero3 > numero4 && numero3 > numero5) {
                            System.out.println("El de en medio es: " + numero4);
                        } else if (numero4 > numero3 && numero4 > numero5) {
                            System.out.println("El de en medio es: " + numero3);
                        } else if (numero5 > numero3 && numero5 > numero4) {
                            System.out.println("El de en medio es: " + numero3);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else if (numero3 > numero2 && numero3 > numero4 && numero3 > numero5) {
                        System.out.println("El menor es: " + numero2);
                        if (numero2 > numero4 && numero2 > numero5) {
                            System.out.println("El de en medio es: " + numero4);
                        } else if (numero4 > numero2 && numero4 > numero5) {
                            System.out.println("El de en medio es: " + numero2);
                        } else if (numero5 > numero2 && numero5 > numero4) {
                            System.out.println("El de en medio es: " + numero2);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else if (numero4 > numero2 && numero4 > numero3 && numero4 > numero5) {
                        System.out.println("El menor es: " + numero2);
                        if (numero2 > numero3 && numero2 > numero5) {
                            System.out.println("El de en medio es: " + numero3);
                        } else if (numero3 > numero2 && numero3 > numero5) {
                            System.out.println("El de en medio es: " + numero2);
                        } else if (numero5 > numero2 && numero5 > numero3) {
                            System.out.println("El de en medio es: " + numero2);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else if (numero5 > numero2 && numero5 > numero3 && numero5 > numero4) {
                        System.out.println("El menor es: " + numero2);
                        if (numero2 > numero3 && numero2 > numero4) {
                            System.out.println("El de en medio es: " + numero3);
                        } else if (numero3 > numero2 && numero3 > numero4) {
                            System.out.println("El de en medio es: " + numero2);
                        } else if (numero4 > numero2 && numero4 > numero3) {
                            System.out.println("El de en medio es: " + numero2);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else {
                        System.out.println("Los números son iguales");
                    }
                } else if (numero2 > numero1 && numero2 > numero3 && numero2 > numero4 && numero2 > numero5) {
                    System.out.println("El mayor es: " + numero2);
                    if (numero1 > numero3 && numero1 > numero4 && numero1 > numero5) {
                        System.out.println("El menor es: " + numero5);
                        if (numero3 > numero4 && numero3 > numero5) {
                            System.out.println("El de en medio es: " + numero4);
                        } else if (numero4 > numero3 && numero4 > numero5) {
                            System.out.println("El de en medio es: " + numero3);
                        } else if (numero5 > numero3 && numero5 > numero4) {
                            System.out.println("El de en medio es: " + numero3);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else if (numero3 > numero1 && numero3 > numero4 && numero3 > numero5) {
                        System.out.println("El menor es: " + numero1);
                        if (numero1 > numero4 && numero1 > numero5) {
                            System.out.println("El de en medio es: " + numero4);
                        } else if (numero4 > numero1 && numero4 > numero5) {
                            System.out.println("El de en medio es: " + numero1);
                        } else if (numero5 > numero1 && numero5 > numero4) {
                            System.out.println("El de en medio es: " + numero1);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else if (numero4 > numero1 && numero4 > numero3 && numero4 > numero5) {
                        System.out.println("El menor es: " + numero1);
                        if (numero1 > numero3 && numero1 > numero5) {
                            System.out.println("El de en medio es: " + numero3);
                        } else if (numero3 > numero1 && numero3 > numero5) {
                            System.out.println("El de en medio es: " + numero1);
                        } else if (numero5 > numero1 && numero5 > numero3) {
                            System.out.println("El de en medio es: " + numero1);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else if (numero5 > numero1 && numero5 > numero3 && numero5 > numero4) {
                        System.out.println("El menor es: " + numero1);
                        if (numero1 > numero3 && numero1 > numero4) {
                            System.out.println("El de en medio es: " + numero3);
                        } else if (numero3 > numero1 && numero3 > numero4) {
                            System.out.println("El de en medio es: " + numero1);
                        } else if (numero4 > numero1 && numero4 > numero3) {
                            System.out.println("El de en medio es: " + numero1);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else {
                        System.out.println("Los números son iguales");
                    }
                } else if (numero3 > numero1 && numero3 > numero2 && numero3 > numero4 && numero3 > numero5) {
                    System.out.println("El mayor es: " + numero3);
                    if (numero1 > numero2 && numero1 > numero4 && numero1 > numero5) {
                        System.out.println("El menor es: " + numero5);
                        if (numero2 > numero4 && numero2 > numero5) {
                            System.out.println("El de en medio es: " + numero4);
                        } else if (numero4 > numero2 && numero4 > numero5) {
                            System.out.println("El de en medio es: " + numero2);
                        } else if (numero5 > numero2 && numero5 > numero4) {
                            System.out.println("El de en medio es: " + numero2);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else if (numero2 > numero1 && numero2 > numero4 && numero2 > numero5) {
                        System.out.println("El menor es: " + numero1);
                        if (numero1 > numero4 && numero1 > numero5) {
                            System.out.println("El de en medio es: " + numero4);
                        } else if (numero4 > numero1 && numero4 > numero5) {
                            System.out.println("El de en medio es: " + numero1);
                        } else if (numero5 > numero1 && numero5 > numero4) {
                            System.out.println("El de en medio es: " + numero1);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else if (numero4 > numero1 && numero4 > numero2 && numero4 > numero5) {
                        System.out.println("El menor es: " + numero1);
                        if (numero1 > numero2 && numero1 > numero5) {
                            System.out.println("El de en medio es: " + numero2);
                        } else if (numero2 > numero1 && numero2 > numero5) {
                            System.out.println("El de en medio es: " + numero1);
                        } else if (numero5 > numero1 && numero5 > numero2) {
                            System.out.println("El de en medio es: " + numero1);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else if (numero5 > numero1 && numero5 > numero2 && numero5 > numero4) {
                        System.out.println("El menor es: " + numero1);
                        if (numero1 > numero2 && numero1 > numero4) {
                            System.out.println("El de en medio es: " + numero2);
                        } else if (numero2 > numero1 && numero2 > numero4) {
                            System.out.println("El de en medio es: " + numero1);
                        } else if (numero4 > numero1 && numero4 > numero2) {
                            System.out.println("El de en medio es: " + numero1);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else {
                        System.out.println("Los números son iguales");
                    }
                } else if (numero4 > numero1 && numero4 > numero2 && numero4 > numero3 && numero4 > numero5) {
                    System.out.println("El mayor es: " + numero4);
                    if (numero1 > numero2 && numero1 > numero3 && numero1 > numero5) {
                        System.out.println("El menor es: " + numero5);
                        if (numero2 > numero3 && numero2 > numero5) {
                            System.out.println("El de en medio es: " + numero3);
                        } else if (numero3 > numero2 && numero3 > numero5) {
                            System.out.println("El de en medio es: " + numero2);
                        } else if (numero5 > numero2 && numero5 > numero3) {
                            System.out.println("El de en medio es: " + numero2);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else if (numero2 > numero1 && numero2 > numero3 && numero2 > numero5) {
                        System.out.println("El menor es: " + numero1);
                        if (numero1 > numero3 && numero1 > numero5) {
                            System.out.println("El de en medio es: " + numero3);
                        } else if (numero3 > numero1 && numero3 > numero5) {
                            System.out.println("El de en medio es: " + numero1);
                        } else if (numero5 > numero1 && numero5 > numero3) {
                            System.out.println("El de en medio es: " + numero1);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else if (numero3 > numero1 && numero3 > numero2 && numero3 > numero5) {
                        System.out.println("El menor es: " + numero1);
                        if (numero1 > numero2 && numero1 > numero5) {
                            System.out.println("El de en medio es: " + numero2);
                        } else if (numero2 > numero1 && numero2 > numero5) {
                            System.out.println("El de en medio es: " + numero1);
                        } else if (numero5 > numero1 && numero5 > numero2) {
                            System.out.println("El de en medio es: " + numero1);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else if (numero5 > numero1 && numero5 > numero2 && numero5 > numero3) {
                        System.out.println("El menor es: " + numero1);
                        if (numero1 > numero2 && numero1 > numero3) {
                            System.out.println("El de en medio es: " + numero2);
                        } else if (numero2 > numero1 && numero2 > numero3) {
                            System.out.println("El de en medio es: " + numero1);
                        } else if (numero3 > numero1 && numero3 > numero2) {
                            System.out.println("El de en medio es: " + numero1);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else {
                        System.out.println("Los números son iguales");
                    }
                } else if (numero5 > numero1 && numero5 > numero2 && numero5 > numero3 && numero5 > numero4) {
                    System.out.println("El mayor es: " + numero5);
                    if (numero1 > numero2 && numero1 > numero3 && numero1 > numero4) {
                        System.out.println("El menor es: " + numero4);
                        if (numero2 > numero3 && numero2 > numero4) {
                            System.out.println("El de en medio es: " + numero3);
                        } else if (numero3 > numero2 && numero3 > numero4) {
                            System.out.println("El de en medio es: " + numero2);
                        } else if (numero4 > numero2 && numero4 > numero3) {
                            System.out.println("El de en medio es: " + numero2);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else if (numero2 > numero1 && numero2 > numero3 && numero2 > numero4) {
                        System.out.println("El menor es: " + numero1);
                        if (numero1 > numero3 && numero1 > numero4) {
                            System.out.println("El de en medio es: " + numero3);
                        } else if (numero3 > numero1 && numero3 > numero4) {
                            System.out.println("El de en medio es: " + numero1);
                        } else if (numero4 > numero1 && numero4 > numero3) {
                            System.out.println("El de en medio es: " + numero1);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else if (numero3 > numero1 && numero3 > numero2 && numero3 > numero4) {
                        System.out.println("El menor es: " + numero1);
                        if (numero1 > numero2 && numero1 > numero4) {
                            System.out.println("El de en medio es: " + numero2);
                        } else if (numero2 > numero1 && numero2 > numero4) {
                            System.out.println("El de en medio es: " + numero1);
                        } else if (numero4 > numero1 && numero4 > numero2) {
                            System.out.println("El de en medio es: " + numero1);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else if (numero4 > numero1 && numero4 > numero2 && numero4 > numero3) {
                        System.out.println("El menor es: " + numero1);
                        if (numero1 > numero2 && numero1 > numero3) {
                            System.out.println("El de en medio es: " + numero2);
                        } else if (numero2 > numero1 && numero2 > numero3) {
                            System.out.println("El de en medio es: " + numero1);
                        } else if (numero3 > numero1 && numero3 > numero2) {
                            System.out.println("El de en medio es: " + numero1);
                        } else {
                            System.out.println("Los números son iguales");
                        }
                    } else {
                        System.out.println("Los números son iguales");
                    }
                } else {
                    System.out.println("Los números son iguales");
                }
                break;
            
            default:
                break;
        }

        
    }
}
