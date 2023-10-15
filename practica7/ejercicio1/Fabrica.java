package practica7.ejercicio1;

public class Fabrica {
    public static void main(String[] args) {
        
        //Avion supersonico
        Avion caza = new Avion(Avion.TipoAvion.supersonico);
        caza.setNumSerie("CAZ0009101");
        System.out.println(caza);
        if (caza instanceof Avion) {
            System.out.println("caza es una instancia de Avion");
        }
        if (caza instanceof Vehiculo) {
            System.out.println("caza es una instancia de Vehiculo");
        }

        // Avion militar
        Avion concorde = new Avion(Avion.TipoAvion.militar);
        concorde.setNumSerie("CON0009101");
        System.out.println(concorde);
        if (concorde instanceof Avion) {
            System.out.println("concorde es una instancia de Avion");
        }
        if (concorde instanceof Vehiculo) {
            System.out.println("concorde es una instancia de Vehiculo");
        }

        // Avion turistico
        Avion boeing = new Avion(Avion.TipoAvion.turustico);
        boeing.setNumSerie("BOE0009101");
        System.out.println(boeing);
        if (boeing instanceof Avion) {
            System.out.println("boeing es una instancia de Avion");
        }
        if (boeing instanceof Vehiculo) {
            System.out.println("boeing es una instancia de Vehiculo");
        }

        //Avion de carga
        Avion airbus = new Avion(Avion.TipoAvion.carga);
        airbus.setNumSerie("AIR0009101");
        System.out.println(airbus);
        if (airbus instanceof Avion) {
            System.out.println("airbus es una instancia de Avion");
        }
        if (airbus instanceof Vehiculo) {
            System.out.println("airbus es una instancia de Vehiculo");
        }   
    }
}
