package Algorithm;

/**
 * Given a sorted array of n uniformly distributed values arr[],
 * write a function to search for a particular element x in the array.
 * Ref: https://www.geeksforgeeks.org/interpolation-search/
 *
 * Algorithm:
 * ---------
 * Improved binary search method. The idea is check if the target value is closer
 * to left end or closer to the right end of the array. We follow the exact search process
 * like Binary search, but rather than calculating middle index, we choose carefully the possible
 * best location of the index using below formula.
 *
 * possibleIndexPosition = left + (target - arr[left]) * (right - left) / (arr[right] - arr[left])
 *
 * Check the reference online material for the details of the above function.
 *
 * O(log N)
 */

public class InterpolationSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 8, 11, 19};
        int target = 200;
        int index = interpolationSearch(arr, target);

        if (index >= 0)
            System.out.println(target + " Target found at index location : " + index);
        else
            System.out.println(target + " is not present in the array");
    }

    private static int interpolationSearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int pos = left + (target - arr[left]) * (right - left) / (arr[right] - arr[left]);

            if (pos < 0 || pos >= arr.length) // check the extreme index value out the range
                return -1;
            else if (arr[pos] == target)
                return pos;
            else if (arr[pos] > target)
                right = pos - 1;
            else
                left = pos + 1;
        }

        return arr[left] == target ? left : -1;
    }
}
