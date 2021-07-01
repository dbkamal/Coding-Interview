package Algorithm;

/**
 * Given a monotonically increasing array, find the index of the first positive element
 * Ref: https://www.geeksforgeeks.org/find-the-point-where-a-function-becomes-negative/
 *
 * Algorithm:
 *
 * Option 1: As we don't know exactly the target value, we can employ Linear Search. O(N)
 * Option 2: Employ Unbounded Binary Search a.k.a Exponential Search to find the subarray of size i
 * which contains the first positive value.
 *
 * Start with subarray size of 1 and if the last element is >= 0 then stop the process and do
 * Binary Search within [i/2, i] range. Otherwise double the subarray size (i * 2) and repeat the process.
 *
 * O(log N)
 *
 * Author: Kamal Debnath
 */

public class FindFirstPositive {
    public static void main(String[] args) {
        int[] arr = {-7, -4, - 3, -2, 6, 8};
        int index = findFirstPositive(arr);

        if (index >= 0)
            System.out.println("First positive found at index location : " + index + " value : " + arr[index]);
        else
            System.out.println("No positive element is present in the array");
    }

    private static int findFirstPositive(int[] arr) {
        if (arr.length == 1 && arr[0] >= 0) // only one positive element in the array
            return 0;

        if (arr.length == 0) // empty array
            return -1;

        int i = 1; // subarray size of i

        while (i < arr.length && arr[i] <= 0) {
            i *= 2;
        }

        // Do modified binary search. Reduce the search space to the left side if the arr[mid] is still positive
        int left = i/2, right = Math.min(i, arr.length - 1);

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > 0 && (mid == left || arr[mid - 1] <= 0))
                return mid;
            else if (arr[mid] >= 0)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left < arr.length && arr[left] >= 0 ? left : -1;
    }
}
