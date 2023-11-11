package Practica10;

abstract class Persona {
    String nombre;
    Integer edad;
    Sx sexo;
    String nacionalidad;

    abstract boolean votar();

    abstract boolean servicioMilitar();

    abstract boolean serPresident();

    String getNombre() {
        return this.nombre;
    }

    Integer getEdad() {
        return this.edad;
    }

    Sx getSexo() {
        return this.sexo;
    }

    String getNacionalidad() {
        return this.nacionalidad;
    }

}

/**
 * Mexicano
 */
class Mexicano extends Persona {

    Mexicano(String nombre, int edad, Sx sexo) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;

    }

    @Override
    boolean votar() {
        return this.edad >= 18;
    }

    @Override
    boolean servicioMilitar() {
        return this.edad >= 18;
    }

    @Override
    boolean serPresident() {
        return this.edad >= 35;
    }

}

/*
 * Extranjero
 */
class Extranjero extends Persona {

    Extranjero(String nombre, int edad, Sx sexo) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;

    }

    @Override
    boolean votar() {
        return false;
    }

    @Override
    boolean servicioMilitar() {
        return false;
    }

    @Override
    boolean serPresident() {
        return false;
    }
}