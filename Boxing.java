public class Boxing {
    public static void main(String[] args) {
        String x = "apple";
        //unboxing
        char y = Character.valueOf(x);
        char z = Character.valueOf(x.charAt(0));
        System.out.println(y);
    }
}
