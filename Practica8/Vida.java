import java.util.ArrayList;
import java.util.List;

public class Vida {
    public static void main(String[] args) {
        List<AbstractAnimal> animals = new ArrayList<AbstractAnimal>();
        animals.add(new Mammal("Panda", 1869));
        animals.add(new Mammal("Zebra", 1778));
        animals.add(new Mammal("Koala", 1816));
        animals.add(new Mammal("Sloth", 1804));
        animals.add(new Mammal("Armadillo", 1758));
        animals.add(new Mammal("Raccoon", 1758));
        animals.add(new Mammal("Bigfoot", 2021));

        animals.add(new Bird("Toucan", 1758));
        animals.add(new Bird("Swan", 1758));
        animals.add(new Bird("Parrot", 1824));
        animals.add(new Bird("Peacock", 1821));

        animals.add(new Fish("Salmon", 1758));
        animals.add(new Fish("Catfish", 1817));
        animals.add(new Fish("Perch", 1758));

        animals.sort((animal1, animal2) -> animal2.getYear() - animal1.getYear());

        animals.forEach(animal -> System.out.println(animal.getName() + " " + animal.getYear()));

        System.out.println("\n*** List all the animals alphabetically ***");
        animals.sort((animal1, animal2) -> animal1.getName().compareToIgnoreCase(animal2.getName()));
        animals.forEach(animal -> System.out.println(animal.getName()));

        System.out.println("\n*** List all the animals order by how they move ***");
        animals.sort((animal1, animal2) -> animal1.move().compareToIgnoreCase(animal2.move()));
        animals.forEach(animal -> System.out.println(animal.getName() + " " + animal.move()));

    }
}
