package Algorithm;

/**
 * Given a sorted array arr[] of n elements, write a function to search a given element x in arr[].
 *
 * Algorithm:
 * ---------
 * As the data is sorted order, use two pointer from both side of the array and either iteratively
 * or recursively find the middle element and if the middle element is target and then return the index,
 * or if the middle element is larger than target then check the left side otherwise check right side.
 * O(log N)
 */

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 8, 11, 19};
        int target = 19;
        int index = binarySearch(arr, target);

        // Iterative Solution
        if (index >= 0)
            System.out.println(target + " Target found at index location : " + index);
        else
            System.out.println(target + " is not present in the array");

        // Recursive Solution
        index = binarySearchRecursive(arr, 0, arr.length - 1, target);
        if (index >= 0)
            System.out.println(target + " Target found at index location : " + index);
        else
            System.out.println(target + " is not present in the array");
    }

    private static int binarySearch(int[] arr, int target) {

        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2; // avoid left + right overflow from INT boundary

            if (arr[middle] == target)
                return middle;
            else if (arr[middle] > target)
                right = middle - 1;
            else
                left = middle + 1;
        }

        return arr[left] == target ? left : -1; // if the target is not present in the array
    }

    private static int binarySearchRecursive(int[] arr, int left, int right, int target) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
                return binarySearchRecursive(arr, left, mid - 1, target);
            else
                return binarySearchRecursive(arr, mid + 1, right, target);
        }
        return -1;
    }
}