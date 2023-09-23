// Clase Persona
public class Persona {

    private String nombre;
    private int edad;
    private String correo;

    public Persona(String nombre, int edad, String correo) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", correo='" + correo + '\'' +
                '}';
    }
}

// Clase Cliente
public class Cliente extends Persona {

    private String tarjetaDeCredito;

    public Cliente(String nombre, int edad, String correo, String tarjetaDeCredito) {
        super(nombre, edad, correo);
        this.tarjetaDeCredito = tarjetaDeCredito;
    }

    public String getTarjetaDeCredito() {
        return tarjetaDeCredito;
    }

    public void setTarjetaDeCredito(String tarjetaDeCredito) {
        this.tarjetaDeCredito = tarjetaDeCredito;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                super.toString() +
                ", tarjetaDeCredito='" + tarjetaDeCredito + '\'' +
                '}';
    }
}

// Clase Empleado
public class Empleado extends Persona {

    private String puesto;
    private double salario;

    public Empleado(String nombre, int edad, String correo, String puesto, double salario) {
        super(nombre, edad, correo);
        this.puesto = puesto;
        this.salario = salario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                super.toString() +
                ", puesto='" + puesto + '\'' +
                ", salario=" + salario +
                '}';
    }
}

// Clase Empresa
public class Empresa {

    private String nombre;
    private List<Departamento> departamentos;

    public Empresa(String nombre) {
        this.nombre = nombre;
        departamentos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void addDepartamento(Departamento departamento) {
        departamentos.add(departamento);
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", departamentos=" + departamentos +
                '}';
    }
}

// Clase Departamento
public class Departamento {

    private String nombre;
    private List<Empleado> empleados;

    public Departamento(String nombre) {
        this.

        