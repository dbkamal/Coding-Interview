package Algorithm;

/**
 * Given a sorted array, and an element x to be searched, find position of x in the array.
 *
 * Algorithm:
 * ---------
 * Exponential search try to locate a range [i/2, i] where the target must lie and do the normal
 * Binary Search. It reduces the overall search space, however overall runtime stays at O(log N).
 *
 * Start with a subarray of size 1 and check the last element is less than the target. Then increment
 * the subarray size by twice of the size previous until the target become smaller or lie within [i/2, i] range
 * where i = subarray size.
 *
 * Author: Kamal Debnath
 */

public class ExponentialSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 8, 11, 19};
        int target = 19;
        int index = exponentialSearch(arr, target);

        if (index >= 0)
            System.out.println(target + " Target found at index location : " + index);
        else
            System.out.println(target + " is not present in the array");
    }

    private static int exponentialSearch(int[] arr, int target) {
        if (arr.length > 0 && arr[0] == target)
            return 0;

        // find the range [i/2, i] where target lies
        int i = 1;

        while (i < arr.length && arr[i] <= target) {
            i *= 2;
        }

        return BinarySearch.binarySearch(arr, target, i / 2, Math.min(i, arr.length - 1));
    }
}
