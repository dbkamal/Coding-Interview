package Algorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given an array of n elements, where each element is at most k away from its target position,
 * devise an algorithm that sorts in O(N log K) time.
 *
 * For example, let us consider k is 2, an element at index 7 in the sorted array, can be at indexes
 * 5, 6, 7, 8, 9 in the given array.
 *
 * Algorithm:
 * ---------
 * Create a Min Heap of size (K + 1) and insert first K + 1 element from the array. Remove the element from the root
 * of the heap and put it into the result array and insert a new element from the input array into heap. Adding and
 * removing elements into Min heap will cost O(log K)
 *
 * Runtime: O(K log K) + O( (N - K) * log K) = O(N log K)
 */

public class SortNearlySortedArray {
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int K = 3;

        System.out.println("Initial Array");
        System.out.println(Arrays.toString(arr));

        sortNearlySortedArray(arr, K);
    }

    private static void sortNearlySortedArray(int[] arr, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(K + 1);
        int[] out = new int[arr.length];

        // build the min heap of size K + 1
        int i = 0, j = 0;
        while (i < Math.min(K + 1, arr.length)) {
            pq.offer(arr[i++]);
        }

        while (!pq.isEmpty() && i < arr.length) {
            out[j++] = pq.poll();
            pq.offer(arr[i++]);
        }

        while (!pq.isEmpty()) {
            out[j++] = pq.poll();
        }

        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(out));
    }
}
