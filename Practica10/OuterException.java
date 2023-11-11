package Practica10;

public class OuterException extends Exception {
    OuterException(){
        super();
    }
    public String getMessage() {
        return "No puede votar";
    }

    public String NoMilitar() {
        return "No puede ser militar";
    }
}
