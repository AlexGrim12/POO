interface Poligono {
    void getArea(int a, int b);
}

class Rectangulo implements Poligono {
    public void getArea(int a, int b) {
        System.out.println("El area es: " + (a * b));
    }
}

class Main {
    public static void main(String[] args) {
        Rectangulo r = new Rectangulo();
        r.getArea(5, 6);

    }
}

