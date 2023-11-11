package Practica10;

import java.util.HashMap;

import javax.print.attribute.standard.MediaSize.Other;

public class Principal {
    public static void main(String[] args) throws OuterException {
        HashMap<String, Persona> gente = new HashMap<String, Persona>();
        gente.put("GUGA021938019LKA", new Mexicano("Alex", 19, Sx.MASCULINO));
        gente.put("SAKDJAH921083908", new Mexicano("Saul", 16, Sx.MASCULINO));
        gente.put("AKSDJ23423094832", new Mexicano("Alberto", 19, Sx.MASCULINO));
        gente.put("ASDJKAH929384090", new Mexicano("Leonardo", 19, Sx.MASCULINO));

        gente.forEach((key, value) -> {
            System.out.println(key + ": \nNombre:" + value.getNombre() + "\nEdad:" + value.getEdad() + "\nSexo:"
                    + value.getSexo() + "\nNacionalidad:" + value.getNacionalidad() + "\n");
        });
        gente.forEach((key, value) -> {
            try {
                if (!value.votar()) {
                    throw new OuterException();
                }

            } catch (OuterException e) {
                System.out.println(e.getMessage());
            }
        });
    }
}