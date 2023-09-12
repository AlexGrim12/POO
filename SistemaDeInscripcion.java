import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

class Alumno {
    private String nombre;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String numeroCuenta;
    private int edad;
    private String sexo;

    public Alumno(String nombre, String apellidoMaterno, String apellidoPaterno, String numeroCuenta, int edad,
            String sexo) {
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.numeroCuenta = numeroCuenta;
        this.edad = edad;
        this.sexo = sexo;
    }

    // Getters y setters para los atributos de Alumno
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}

class Materia {
    private String claveMateria;
    private String nombreMateria;
    private int creditos;
    private int cupo;
    private int cupoDisponible;

    public Materia(String claveMateria, String nombreMateria, int creditos, int cupo) {
        this.claveMateria = claveMateria;
        this.nombreMateria = nombreMateria;
        this.creditos = creditos;
        this.cupo = cupo;
        this.cupoDisponible = cupo;
    }

    // Getters para los atributos de Materia
    public String getClaveMateria() {
        return claveMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public int getCreditos() {
        return creditos;
    }

    public int getCupo() {
        return cupo;
    }

    public int getCupoDisponible() {
        return cupoDisponible;
    }

    // Método para inscribir a un alumno en la materia
    public boolean inscribirAlumno() {
        if (cupoDisponible > 0) {
            cupoDisponible--;
            return true;
        } else {
            System.out.println("CUPO LLENO para la materia " + nombreMateria);
            return false;
        }
    }
}

class SistemaDeInscripcion {
    private Hashtable<String, Materia> materias;
    private ArrayList<Alumno> alumnos;

    public SistemaDeInscripcion() {
        materias = new Hashtable<>();
        alumnos = new ArrayList<>();
    }

    // Método para agregar una materia al sistema
    public void agregarMateria(Materia materia) {
        materias.put(materia.getClaveMateria(), materia);
    }

    // Método para dar de alta a un alumno en el sistema
    public void darDeAltaAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    // Método para buscar un alumno por su numero de cuenta
    public Alumno buscarAlumnoPorNumeroCuenta(String numeroCuenta) {
        for (Alumno alumno : alumnos) {
            if (alumno.getNumeroCuenta().equals(numeroCuenta)) {
                return alumno;
            }
        }
        return null;
    }

    // Método para inscribir a un alumno en una materia
    public void inscribirAlumnoEnMateria(Alumno alumno, String claveMateria) {
        Materia materia = materias.get(claveMateria);
        if (materia != null) {
            if (materia.inscribirAlumno()) {
                System.out.println("El alumno " + alumno.getNombre() + " ha sido inscrito en la materia "
                        + materia.getNombreMateria());
            }
        } else {
            System.out.println("La materia con clave " + claveMateria + " no existe.");
        }
    }

    // Método para dar de baja a un alumno de una materia
    public void darDeBajaAlumnoEnMateria(Alumno alumno, String claveMateria) {
        Materia materia = materias.get(claveMateria);
        if (materia != null) {
            if (alumnoEnMateria(alumno, claveMateria)) {
                materia.getCupoDisponible();
                System.out.println("El alumno " + alumno.getNombre() + " ha sido dado de baja en la materia "
                        + materia.getNombreMateria());
            }
        } else {
            System.out.println("La materia con clave " + claveMateria + " no existe.");
        }
    }

    // Método para verificar si un alumno está inscrito en una materia
    public boolean alumnoEnMateria(Alumno alumno, String claveMateria) {
        Materia materia = materias.get(claveMateria);
        if (materia != null) {
            return true;
        }
        return false;
    }

    // Método para mostrar el historial de inscripciones de un alumno
    public void verHistorialInscripciones(Alumno alumno) {
        System.out.println("Historial de inscripciones para el alumno " + alumno.getNombre() + ":");
        for (Materia materia : materias.values()) {
            if (alumnoEnMateria(alumno, materia.getClaveMateria())) {
                System.out.println("Materia: " + materia.getNombreMateria());
            }
        }
    }

    // Método para mostrar un resumen de inscripciones para todos los alumnos
    public void mostrarResumenInscripciones() {
        System.out.println("Resumen de inscripciones:");
        for (Alumno alumno : alumnos) {
            System.out.println("Alumno: " + alumno.getNombre());
            System.out.println("Inscripciones:");
            for (Materia materia : materias.values()) {
                if (alumnoEnMateria(alumno, materia.getClaveMateria())) {
                    System.out.println("- " + materia.getNombreMateria());
                }
            }
            System.out.println();
        }
    }

    // metodo de menu
    public void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de inscripciones");
        System.out.println("1. Agregar materia");
        System.out.println("2. Dar de alta alumno");
        System.out.println("3. Inscribir alumno en materia");
        System.out.println("4. Dar de baja alumno en materia");
        System.out.println("5. Ver historial de inscripciones de un alumno");
        System.out.println("6. Mostrar resumen de inscripciones");
        System.out.println("7. Salir");
        System.out.print("Ingresa una opcion: ");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Agregar materia");
                menuAgregarMateria();
                break;
            case 2:
                System.out.println("Dar de alta alumno");
                menuInscripcionAlumno();
                break;
            case 3:
                System.out.println("Inscribir alumno en materia");
                menuInscripcionAlumnoEnMateria();
                break;
            case 4:
                System.out.println("Dar de baja alumno en materia");
                menuDarDeBajaAlumnoEnMateria();
                break;
            case 5:
                System.out.println("Ver historial de inscripciones de un alumno");

                break;
            case 6:
                System.out.println("Mostrar resumen de inscripciones");
                mostrarResumenInscripciones();
                break;
            case 7:
                System.out.println("Las materias disponibles son las siguientes: ");
                for (Materia materia : materias.values()) {
                    System.out.println(materia.getClaveMateria() + " - " + materia.getNombreMateria());
                }
                break;
            case 8:
                System.out.println("Salir");
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
        sc.close();
    }

    public void menuAgregarMateria() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Ingresa la clave de la materia: ");
            String claveMateria = sc.nextLine();
            if (materias.containsKey(claveMateria)) {
                System.out.println("La clave de la materia ya existe.");
            } else {
                System.out.print("Ingresa el nombre de la materia: ");
                String nombreMateria = sc.nextLine();
                System.out.print("Ingresa el numero de creditos de la materia: ");
                int creditos = sc.nextInt();
                sc.nextLine();
                System.out.print("Ingresa el cupo de la materia: ");
                int cupo = sc.nextInt();
                sc.nextLine();
                Materia materia = new Materia(claveMateria, nombreMateria, creditos, cupo);
                agregarMateria(materia);
                System.out.println("La materia " + materia.getNombreMateria() + " ha sido agregada al sistema.");
            }
            System.out.print("¿Deseas agregar otra materia? (s/n): ");
            String respuesta = sc.nextLine();
            if (respuesta.equals("n")) {
                sc.close();
                break;
            }
        }
        sc.close();
    }

    public void menuInscripcionAlumno() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Ingresa el numero de cuenta del alumno: ");
            String numeroCuenta = sc.nextLine();
            boolean existeAlumno = false;
            for (Alumno alumno : alumnos) {
                if (alumno.getNumeroCuenta().equals(numeroCuenta)) {
                    System.out.println("El numero de cuenta ya existe.");
                    existeAlumno = true;
                    break;
                }
            }
            if (!existeAlumno) {
                System.out.print("Ingresa el nombre del alumno: ");
                String nombre = sc.nextLine();
                System.out.print("Ingresa el apellido paterno del alumno: ");
                String apellidoPaterno = sc.nextLine();
                System.out.print("Ingresa el apellido materno del alumno: ");
                String apellidoMaterno = sc.nextLine();
                System.out.print("Ingresa la edad del alumno: ");
                int edad = sc.nextInt();
                sc.nextLine();
                System.out.print("Ingresa el sexo del alumno (M/F): ");
                String sexo = sc.nextLine();
                Alumno alumno = new Alumno(nombre, apellidoMaterno, apellidoPaterno, numeroCuenta, edad, sexo);
                darDeAltaAlumno(alumno);
                System.out.println("El alumno " + alumno.getNombre() + " ha sido dado de alta en el sistema.");
            }
            System.out.print("¿Deseas inscribir a otro alumno? (s/n): ");
            String respuesta = sc.nextLine();
            if (respuesta.equals("n")) {
                break;
            }
        }
        sc.close();
    }

    public void menuInscripcionAlumnoEnMateria() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Ingresa el numero de cuenta del alumno: ");
            String numeroCuenta = sc.nextLine();

            Alumno alumno = buscarAlumnoPorNumeroCuenta(numeroCuenta); // Utilizamos el método
                                                                       // buscarAlumnoPorNumeroCuenta

            if (alumno == null) {
                System.out.println("El alumno con numero de cuenta " + numeroCuenta + " no existe en el sistema.");
                System.out.print("¿Deseas inscribir a otro alumno? (s/n): ");
                String respuesta = sc.nextLine();
                if (respuesta.equals("n")) {
                    break;
                }
                continue; // Salta a la siguiente iteración del bucle si el alumno no existe
            }

            System.out.print("Ingresa la clave de la materia: ");
            String claveMateria = sc.nextLine();

            if (!materias.containsKey(claveMateria)) {
                System.out.println("La materia con clave " + claveMateria + " no existe en el sistema.");
                System.out.print("¿Deseas inscribir al alumno en otra materia? (s/n): ");
                String respuesta = sc.nextLine();
                if (respuesta.equals("n")) {
                    break;
                }
                continue; // Salta a la siguiente iteración del bucle si la materia no existe
            }

            inscribirAlumnoEnMateria(alumno, claveMateria);

            System.out.print("¿Deseas inscribir al alumno en otra materia? (s/n): ");
            String respuesta = sc.nextLine();
            if (respuesta.equals("n")) {
                break;
            }
        }

        sc.close();
    }

    public void menuDarDeBajaAlumnoEnMateria() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Ingresa el numero de cuenta del alumno: ");
            String numeroCuenta = sc.nextLine();

            Alumno alumno = buscarAlumnoPorNumeroCuenta(numeroCuenta); // Utilizamos el método
                                                                       // buscarAlumnoPorNumeroCuenta
            if (alumno == null) {
                System.out.println("El alumno con numero de cuenta " + numeroCuenta + " no existe en el sistema.");
                System.out.print("¿Deseas inscribir a otro alumno? (s/n): ");
                String respuesta = sc.nextLine();
                if (respuesta.equals("n")) {
                    break;
                }
                continue; // Salta a la siguiente iteración del bucle si el alumno no existe
            }

            System.out.print("Ingresa la clave de la materia: ");
            String claveMateria = sc.nextLine();

            if (!alumnoEnMateria(alumno, claveMateria)) {
                System.out.println("La materia con clave " + claveMateria + " no existe en el sistema.");
                System.out.print("¿Deseas dar de baja al alumno en otra materia? (s/n): ");
                String respuesta = sc.nextLine();
                if (respuesta.equals("n")) {
                    break;
                }
                continue;
            }
            darDeBajaAlumnoEnMateria(alumno, claveMateria);
            System.out.print("¿Deseas dar de baja al alumno en otra materia? (s/n): ");
            String respuesta = sc.nextLine();
            if (respuesta.equals("n")) {
                break;
            }
        }
        sc.close();
    }

    public void menuVerHistorialInscripciones() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Ingresa el numero de cuenta del alumno: ");
            String numeroCuenta = sc.nextLine();

            Alumno alumno = buscarAlumnoPorNumeroCuenta(numeroCuenta); // Utilizamos el método
                                                                       // buscarAlumnoPorNumeroCuenta
            if (alumno == null) {
                System.out.println("El alumno con numero de cuenta " + numeroCuenta + " no existe en el sistema.");
                System.out.print("¿Deseas ver el historial de otro alumno? (s/n): ");
                String respuesta = sc.nextLine();
                if (respuesta.equals("n")) {
                    break;
                }
                continue; // Salta a la siguiente iteración del bucle si el alumno no existe
            }
            verHistorialInscripciones(alumno);
            System.out.print("¿Deseas ver el historial de otro alumno? (s/n): ");
            String respuesta = sc.nextLine();
            if (respuesta.equals("n")) {
                break;
            }
        }
        sc.close();
    }

    public static void main(String[] args) {
        SistemaDeInscripcion sistema = new SistemaDeInscripcion();

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Bienvenido al sistema de inscripciones");
            System.out.println("1. Agregar materia");
            System.out.println("2. Dar de alta alumno");
            System.out.println("3. Inscribir alumno en materia");
            System.out.println("4. Dar de baja alumno en materia");
            System.out.println("5. Ver historial de inscripciones de un alumno");
            System.out.println("6. Mostrar resumen de inscripciones");
            System.out.println("7. Salir");
            System.out.print("Ingresa una opcion: ");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Agregar materia");
                    sistema.menuAgregarMateria();
                    break;
                case 2:
                    System.out.println("Dar de alta alumno");
                    sistema.menuInscripcionAlumno();
                    break;
                case 3:
                    System.out.println("Inscribir alumno en materia");
                    sistema.menuInscripcionAlumnoEnMateria();
                    break;
                case 4:
                    System.out.println("Dar de baja alumno en materia");
                    sistema.menuDarDeBajaAlumnoEnMateria();
                    break;
                case 5:
                    System.out.println("Ver historial de inscripciones de un alumno");
                    sistema.menuVerHistorialInscripciones();
                    break;
                case 6:
                    System.out.println("Mostrar resumen de inscripciones");
                    sistema.mostrarResumenInscripciones();
                    break;
                case 7:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

            System.out.print("¿Deseas realizar otra operacion? (s/n): ");
            String respuesta = sc.nextLine();
            if (respuesta.equals("n")) {
                break;
            }
            sc.close();
        }

    }
}
