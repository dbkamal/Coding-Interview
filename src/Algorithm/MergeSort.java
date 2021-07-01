package Algorithm;

import java.util.Arrays;

/**
 * Sort the array element in ascending order.
 *
 * Merge sort is a "Divide and Conquer" algorithm, which divides the input array into two equal halves and
 * call it recursively. In the "conquer" step, it basically merges two sorted array.
 *
 * MergeSort(arr[], l,  r)
 * If r > l
 *      1. Find the middle point to divide the array into two halves:
 *              middle m = l + (r - l) / 2
 *      2. Call mergeSort for first half:
 *              Call mergeSort(arr, l, m)
 *      3. Call mergeSort for second half:
 *              Call mergeSort(arr, m + 1, r)
 *      4. Merge the two halves sorted in step 2 and 3:
 *              Call merge(arr, l, m, r)
 *
 * Runtime: O(N log N), Space: O(log N)
 */

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {10, 2, 6, 1, -10, 200, 120, -90};
        System.out.println("Initial Array");
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);

            System.out.println("Recursive call merging");
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int len = right - left + 1;
        int[] temp = new int[len];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right && k < len) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            }
            else {
                temp[k++] = arr[j++];
            }
        }

        // exhaust the [i.. mid] and dump into right side of temp array;
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // exhaust the [mid + 1..right] and dump into right side of temp array;
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // update the original array
        k = 0;
        for (i = left; i <= right; i++) {
            arr[i] = temp[k++];
        }
    }
}
