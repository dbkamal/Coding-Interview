package Algorithm;

import java.util.Arrays;

/**
 * Sort the array in ascending order in-place
 *
 * Algorithm:
 * ---------
 * Employ Insertion Sort which compare the current element with left sorted subarray and place the current
 * element at the correct position and move the rest of element to the right.
 * Repeat this step until all elements are sorted. This works similar to the way you sort playing cards in your hands.
 *
 * O(N ^ 2), but space is constant O(1)
 *
 * Author: Kamal Debnath
 */

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 11, 3, 0, 7};
        insertionSort(arr);
    }

    private static void insertionSort(int[] arr) {

        System.out.println("Initial Array");
        System.out.println(Arrays.toString(arr));

        for (int i = 1; i < arr.length; i++) {

            // check if any element is larger than current element arr[i] is left-side
            boolean isLargerElementFound = false;
            int j = i - 1;
            while (j >= 0 && arr[i] <= arr[j]) {
                j--;
                isLargerElementFound = true;
            }

            j++;

            // right shift all element from index position j
            if (isLargerElementFound) {
                int pivot = arr[i];

                for (int k = i - 1; k >= j; k--)
                    arr[k + 1] = arr[k];

                arr[j] = pivot;
            }

            System.out.println("Iteration : " + i);
            System.out.println(Arrays.toString(arr));
        }
    }
}
