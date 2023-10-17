public abstract class AbstractAnimal implements LifeForm {
    static private int maxId = 0;
    private int hunger;
    private String name;
    private int id;
    private int year;

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Sobre carga de metodos
    // Esto es polimorfismo estatico
    AbstractAnimal(String name, int year, int hunger) {
        maxId++;
        this.id = maxId;
        this.hunger = hunger;
        this.year = year;
        this.name = name;
    }

    AbstractAnimal(String name, int year) {
        this(name, year, 0);
    }

    public void eat(int quantity) {
        hunger -= quantity;
        hunger = hunger < 0 ? 0 : hunger;
    }

    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    abstract public String move();

    abstract public String breathe();

    abstract public String reproduce();

    abstract public Boolean sleep();
}
