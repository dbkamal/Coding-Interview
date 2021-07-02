package Algorithm;

import java.util.Arrays;

/**
 * Sort the given array into ascending order.
 * Ref: https://www.geeksforgeeks.org/quick-sort/
 *
 * Algorithm:
 * ---------
 * Quick Sort: QuickSort is a "Divide and Conquer" algorithm. It picks an element as pivot and partitions the given
 * array around the picked pivot. There are many different versions of quickSort that pick pivot in different ways.
 *
 * - Always pick first element as pivot.
 * - Always pick last element as pivot (implemented below)
 * - Pick a random element as pivot.
 * - Pick median as pivot.
 *
 * Partition: The idea of partition is to place the pivot element into correct place, i.e. all larger value than
 * pivot must be in right side and all smaller value must be in left side.
 *
 * Now, based on the partition index, recursively or iteratively divide the array and in the conquer step the subarray
 * are already sorted.
 *
 * Runtime: Partition takes O(N) and so the worst case runtime O(N ^ 2), Space O(1) but recursive call will have some space
 * overhead. Avg. time complexity is O(N log N)
 *
 * Author: Kamal Debnath
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 60, 2, 1, -30, 20, 70};

        System.out.println("Initial Array");
        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Initial Array");
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            // int pivotIndex = partition(arr, left, right);
            int pivotIndex = partitionCLRS(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr,pivotIndex + 1, right);
        }
    }

    // swapping element from both sides
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left]; // choose first element as pivot

        while (left < right) {
            while (left < right && arr[right] > pivot)
                right--;
            arr[left] = arr[right];

            while (left < right && arr[left] <= pivot)
                left++;
            arr[right] = arr[left];
        }

        arr[left] = pivot;

        return left;
    }

    // Partition logic based out of CLRS. swapping element from one side
    private static int partitionCLRS(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j <= right - 1; j++) {
            if (arr[j] < pivot) {
                i++;

                if (i != j) {
                    //swap arr[i] arr[j] as j-th position has larger value than the pivot
                    Util.swap(arr, i, j);
                }
            }
        }

        // swap the position (i + 1) with right-end
        Util.swap(arr, i + 1, right);
        return i + 1;
    }
}
