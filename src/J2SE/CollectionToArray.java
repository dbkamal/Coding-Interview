package J2SE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionToArray {
    public static void main(String[] args) {
        System.out.println("Collection to Array:");
        System.out.println(Arrays.toString(collectionToArray()));
    }

    private static int[] collectionToArray() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));

        // for primitive type there is NO direct way to converting collection to Array
        // return out.toArray(new int[out.size()]); // this line will throw error

        int[] out = new int[list.size()];
        int t = 0;

        for (int val : list)
            out[t++] = val;

        return out;
    }
}
