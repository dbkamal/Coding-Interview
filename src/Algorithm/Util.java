package Algorithm;

/**
 * This is common utility programs that contains
 * 1. Swap between two numbers in an array
 *
 * Author: Kamal Debnath
 */

public class Util {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
