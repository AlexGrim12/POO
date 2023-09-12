import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class p3a1 {
    public static void main(String[] args) {
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i * 2;
        }
        for (int k : nums) {
            System.out.println(k);
        }
        int[][] m = new int[5][5];
        for (int i = 0; i < m.length; i++) {
            for (int k = 0; k < m[i].length; k++) {
                if (i == k) {
                    m[i][k] = 1;
                }
            }
        }
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.printf("%d ", m[i][j]);
            }
            System.out.println();
        }
        String a = args[0];
        int n = Integer.parseInt(args[1]);

        System.out.println("el GOAT es " + a + " : " + n + " anillos");

        String s = "Samuel el reprobado de POO Grupo 3";

        s = s.toUpperCase();
        System.out.println(s);

        StringBuilder sb = new StringBuilder(s);
        sb = sb.append(" por irle a Messi");
        System.out.println(sb);

        Hashtable<String, String> atlas = new Hashtable<String, String>();
        atlas.put("Mexico", "CDMX");
        atlas.put("Rusia", "Moscú");
        atlas.put("Etiopia", "Adis Abeba");
        atlas.put("Marruecos", "Rabat");
        atlas.put("Sudafrica", "Pretoria");

        String pais;
        String capital;

        Enumeration<String> llaves = atlas.keys();
        while (llaves.hasMoreElements()) {
            pais = llaves.nextElement();
            capital = atlas.get(pais);
            System.out.println("La capital de " + pais + " es " + capital);
        }

        ArrayList<String> programastv = new ArrayList<String>();
        programastv.add("Tortugas Ninja");
        programastv.add("Hey Arnold");
        programastv.add("Los Chicos del Barrio");
        programastv.add("Los Cuentos de la Calle Broca");
        programastv.add("Zabomafuu y los hermanos krat");
        programastv.add("Power Rangers");

        programastv.remove(0);

        for (String palabra : programastv) {
            System.out.println(palabra);
        }
    }
}
