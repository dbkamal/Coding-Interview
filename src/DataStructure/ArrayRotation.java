package DataStructure;

import Algorithm.Util;

import java.util.Arrays;

/**
 * Rotate an array of size n by d elements. For example arr = {1, 2, 3, 4} and d = 2. After
 * rotation array becomes {3, 4, 1, 2}
 *
 * Ref: https://www.geeksforgeeks.org/array-rotation/
 *
 * Algorithm:
 *
 * Reverse Array: Reverse array of d elements and reverse (n - d) elements in place. Finally do the reversal
 * of the array.
 * {1, 2 --- 3, 4} => {2, 1 --- 4, 3} => {3, 4, 1, 2}
 *
 * Runtime:O(D) + O(N - D) + O(N) ~ O(N). This is a two-pass process.
 */

public class ArrayRotation {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int rotation_num = 6; //d value

        System.out.println("Initial Array");
        System.out.println(Arrays.toString(arr));

        arrayRotation(arr, rotation_num);

        System.out.println("Array Rotation");
        System.out.println(Arrays.toString(arr));
    }

    private static void arrayRotation(int[] arr, int rotation_num) {
        // handle if rotation is larger than array size
        rotation_num %= arr.length;

        Util.reverseArray(arr, 0, rotation_num - 1);
        Util.reverseArray(arr, rotation_num, arr.length - 1);
        Util.reverseArray(arr, 0, arr.length - 1);
    }
}