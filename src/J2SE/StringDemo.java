package J2SE;

import java.util.Arrays;

public class StringDemo {
    public static void main(String[] args) {
        String[] items = new String[10];
        items[2] = "Google";

        System.out.println(Arrays.toString(items));
        System.out.println(items[0] == null); // check string null condition
    }
}
