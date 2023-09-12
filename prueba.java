import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class SistemaDeInscripcion {
    private Hashtable<String, Materia> materias;
    private ArrayList<Alumno> alumnos;

    public SistemaDeInscripcion() {
        materias = new Hashtable<>();
        alumnos = new ArrayList<>();
    }

    public void agregarMateria(Materia materia) {
        materias.put(materia.getClaveMateria(), materia);
    }

    public void darDeAltaAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    public void inscribirAlumnoEnMateria(Alumno alumno, String claveMateria) {
        Materia materia = materias.get(claveMateria);
        if (materia != null) {
            if (materia.inscribirAlumno()) {
                alumno.inscribirMateria(materia);
                System.out.println("El alumno " + alumno.getNombre() + " ha sido inscrito en la materia " + materia.getNombreMateria());
            }
        } else {
            System.out.println("La materia con clave " + claveMateria + " no existe.");
        }
    }

    public void darDeBajaAlumnoEnMateria(Alumno alumno, String claveMateria) {
        Materia materia = materias.get(claveMateria);
        if (materia != null) {
            if (alumnoEnMateria(alumno, claveMateria)) {
                alumno.darDeBajaMateria(materia);
                System.out.println("El alumno " + alumno.getNombre() + " ha sido dado de baja en la materia " + materia.getNombreMateria());
            }
        } else {
            System.out.println("La materia con clave " + claveMateria + " no existe.");
        }
    }

    public boolean alumnoEnMateria(Alumno alumno, String claveMateria) {
        Materia materia = materias.get(claveMateria);
        return materia != null && alumno.estaInscritoEnMateria(materia);
    }

    public void verHistorialInscripciones(Alumno alumno) {
        System.out.println("Historial de inscripciones para el alumno " + alumno.getNombre() + ":");
        for (Materia materia : alumno.getMateriasInscritas()) {
            System.out.println("Materia: " + materia.getNombreMateria());
        }
    }

    public void mostrarResumenInscripciones() {
        System.out.println("Resumen de inscripciones:");
        for (Alumno alumno : alumnos) {
            System.out.println("Alumno: " + alumno.getNombre());
            System.out.println("Inscripciones:");
            for (Materia materia : alumno.getMateriasInscritas()) {
                System.out.println("- " + materia.getNombreMateria());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SistemaDeInscripcion sistema = new SistemaDeInscripcion();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Agregar materia");
            System.out.println("2. Dar de alta alumno");
            System.out.println("3. Inscribir alumno en materia");
            System.out.println("4. Dar de baja alumno en materia");
            System.out.println("5. Ver historial de inscripciones de un alumno");
            System.out.println("6. Mostrar resumen de inscripciones de todos los alumnos");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la clave de la materia: ");
                    String claveMateria = scanner.nextLine();
                    System.out.print("Ingrese el nombre de la materia: ");
                    String nombreMateria = scanner.nextLine();
                    System.out.print("Ingrese los créditos de la materia: ");
                    int creditos = scanner.nextInt();
                    System.out.print("Ingrese el cupo de la materia: ");
                    int cupo = scanner.nextInt();
                    Materia nuevaMateria = new Materia(claveMateria, nombreMateria, creditos, cupo);
                    sistema.agregarMateria(nuevaMateria);
                    System.out.println("Materia agregada con éxito.");
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del alumno: ");
                    String nombreAlumno = scanner.nextLine();
                    System.out.print("Ingrese el apellido materno del alumno: ");
                    String apellidoMaternoAlumno = scanner.nextLine();
                    System.out.print("Ingrese el apellido paterno del alumno: ");
                    String apellidoPaternoAlumno = scanner.nextLine();
                    System.out.print("Ingrese el número de cuenta del alumno: ");
                    String numeroCuenta = scanner.nextLine();
                    System.out.print("Ingrese la edad del alumno: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.print("Ingrese el sexo del alumno: ");
                    String sexo = scanner.nextLine();
                    Alumno nuevoAlumno = new Alumno(nombreAlumno, apellidoMaternoAlumno, apellidoPaternoAlumno, numeroCuenta, edad, sexo);
                    sistema.darDeAltaAlumno(nuevoAlumno);
                    System.out.println("Alumno dado de alta con éxito.");
                    break;

                case 3:
                    System.out.print("Ingrese el número de cuenta del alumno: ");
                    String numeroCuentaAlumno = scanner.nextLine();
                    System.out.print("Ingrese la clave de la materia: ");
                    String claveMateriaInscripcion = scanner.nextLine();
                    Alumno alumnoInscripcion = sistema.buscarAlumnoPorNumeroCuenta(numeroCuentaAlumno);
                    if (alumnoInscripcion != null) {
                        sistema.inscribirAlumnoEnMateria(alumnoInscripcion, claveMateriaInscripcion);
                    } else {
                        System.out.println("El alumno con número de cuenta " + numeroCuentaAlumno + " no existe.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el número de cuenta del alumno: ");
                    String numeroCuentaBaja = scanner.nextLine();
                    System.out.print("Ingrese la clave de la materia: ");
                    String claveMateriaBaja = scanner.nextLine();
                    Alumno alumnoBaja = sistema.buscarAlumnoPorNumeroCuenta(numeroCuentaBaja);
                    if (alumnoBaja != null) {
                        sistema.darDeBajaAlumnoEnMateria(alumnoBaja, claveMateriaBaja);
                    } else {
                        System.out.println("El alumno con número de cuenta " + numeroCuentaBaja + " no existe.");
                    }
                    break;

                case 5:
                    System.out.print("Ingrese el número de cuenta del alumno: ");
                    String numeroCuentaHistorial = scanner.nextLine();
                    Alumno alumnoHistorial = sistema.buscarAlumnoPorNumeroCuenta(numeroCuentaHistorial);
                    if (alumnoHistorial != null
