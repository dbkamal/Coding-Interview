package Algorithm;

import java.util.Arrays;

/**
 * Given an array find the number of inversion points. The inversion point counts 1 if arr[i] > arr[j] where i < j.
 * Ref: https://www.geeksforgeeks.org/counting-inversions/
 *
 * Example: {3, 1, 2}, number of inversion point is 2 as {3, 1} and {3, 2}
 *
 * Algorithm:
 * ---------
 * Brute-force: Use two FOR loops to iterate all the elements by keeping one left side element fixed. Do compare as per
 * the definition arr[i] > arr[j] where i < j and increment the count.
 * Runtime: O(N ^ 2), Space: O(1)
 *
 * Optimized Solution using Merge Sort: Continue with "Divide" the array into two subarray and do modified "Conquer"
 * step. If the element is picked up from right subarray before left subarray then count equals
 * "Number of element left in the left subarray". As, the right subarray has smaller element than left side.
 *
 * Example: {4, 3, 2, 1} => {4, 3} and {2, 1}
 * Conquer:
 * Step 1: {4}, {3} number of inversion = 1 as 3 is in right subarray and 1 element left in the left subarray {4}
 * Step 2: {2}, {1} number of inversion = 2 as 1 is in right subarray and 1 element left in the left subarray {2}
 * Step 3: {3, 4}, {1, 2} number of inversion = 4 as 1 is in right subarray and 2 element left in the left subarray {3, 4}
 * Step 4: {3, 4}, {1, 2} number of inversion = 6 as 2 is in right subarray and 2 element left in the left subarray {3, 4}
 *
 * Runtime: O(N log N), Space: O(N)
 */

public class CountInversion {

    public static void main(String[] args) {
        int[] arr =  {4, 3, 2, 1}; //{3, 1, 2};
        System.out.println("Number of inversion point is : " + countInversion(arr));

        System.out.println("Initial Array");
        System.out.println(Arrays.toString(arr));
        System.out.println("Number of inversion point is : " + countInversionRecursive(arr, 0, arr.length - 1));
    }

    private static int countInversion(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j])
                    count++;
            }
        }

        return count;
    }

    private static int countInversionRecursive(int[] arr, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            count += countInversionRecursive(arr, left, mid);
            count += countInversionRecursive(arr, mid + 1, right);
            count += conquer(arr, left, mid, right, arr.length);
        }
        return count;
    }

    private static int conquer(int[] arr, int left, int mid, int right, int originalLen) {
        int len = right - left + 1;
        int[] temp = new int[len];
        int i = left, j = mid + 1, k = 0, count = 0;

        // choose the smallest value from the two sorted set
        while (i <= mid && j <= right && k < len) {
            if (arr[i] >= arr[j]) {
                temp[k++] = arr[j++];
                count += mid - i + 1;
            }
            else {
                temp[k++] = arr[i++];
            }
        }

        // left subarray is not exhausted
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // right subarray is not exhausted
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // update the original array
        k = 0;
        for (i = left; i <= right; i++)
            arr[i] = temp[k++];

        System.out.println("Recursive call merging");
        System.out.println(Arrays.toString(arr));

        return count;
    }
}
