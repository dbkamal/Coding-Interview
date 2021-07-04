package Algorithm;

import java.util.Arrays;

/**
 * Sort the array in ascending order.
 *
 * Algorithm:
 * Counting Sort: This is not comparison based algorithm like Merge, Quick or Heap sort and its only runs in linear time.
 * Constraint: Array should be some number range like [0..9], and small range is much preferable. It works better if the
 * data has lots of repeated values.
 *
 * The problem with the previous counting sort was that we could not sort the elements if we have negative numbers in it.
 * Because there are no negative array indices. So what we do is, we find the minimum element and we will store count
 * of that minimum element at zero index.
 *
 * Process: create a count array of size Max(arr) + 1 i.e. max element in the array + 1 as the count array will act as
 * an index and store the number of occurances.
 *
 * arr = {1, 3, 2, 3, 4, 1, 6, 4, 3}
 * count = {0, 2, 1, 3, 2, 0, 1} # number of occurances
 * do cumulative sum
 * count = {0, 2, 3, 6, 8, 8, 9} # get the index position of each original array element
 * iterate the original array from right side, choose the value as index in the count array, reduce the value
 * by 1 and use that value as the new position in the output array for that array element.
 *
 * Ref: https://www.geeksforgeeks.org/counting-sort/
 * Runtime: O(N + K), Space O(N + K) where K is the range of input
 *
 * Author: Kamal Debnath
 */

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 3, 4, 1, 6, 4, 3};
        char[] seq = { 'g', 'e', 'e', 'k', 's', 'f', 'o', 'r', 'g', 'e', 'e', 'k', 's'};

        System.out.println("Initial Array");
        System.out.println(Arrays.toString(arr));

        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(countingSort(arr)));

        System.out.println("Initial Char Array");
        System.out.println(Arrays.toString(seq));

        System.out.println("Sorted Char Array");
        System.out.println(Arrays.toString(countingSortChar(seq)));
    }

    private static int[] countingSort(int[] arr) {
        int[] res = new int[arr.length];
        // find max element
        int max = Integer.MIN_VALUE; // or 0
        for (int val : arr) {
            max = Math.max(max, val);
        }

        int[] count = new int[max + 1];

        // collect the occurances
        for (int val : arr) {
            count[val]++;
        }

        // do the cumulative sum
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // iterate the original array from right side, choose the value as index in the count array, reduce the value
        // by 1 and use that value as the new position in the output array for that array element
        for (int i = arr.length - 1; i >= 0; i--) {
            count[arr[i]] -= 1;
            res[count[arr[i]]] = arr[i];
        }

        return res;
    }

    // sort the char seq
    private static char[] countingSortChar(char[] seq) {
        char[] res = new char[seq.length];
        int[] count = new int[256];

        // collect the occurances
        for (char ch : seq) {
            count[ch]++;
        }

        // do the cumulative sum
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // iterate the original array from right side, choose the value as index in the count array, reduce the value
        // by 1 and use that value as the new position in the output array for that array element
        for (int i = seq.length - 1; i >= 0; i--) {
            char ch = seq[i];
            count[ch] -= 1;
            res[count[ch]] = ch;
        }

        return res;
    }
}
