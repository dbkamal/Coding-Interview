package Algorithm;

import java.util.Arrays;

/**
 * Given a array sort the element in ascending order.
 *
 * Algorithm:
 * ---------
 * Heap Sort: The idea is the create a Max Heap where root contains max element than its left and right child.
 * Delete the root element i.e. max value from the Max Heap and put into the end of the data structure (array) and do
 * the max heap-ify again. Continue to do that until the heap size becomes 1.
 *
 * Heap Representation: Heap is a complete Binary Tree so it can be stored into array data structure and follow
 * below relationship: if parent node is at index i, then left child is at index 2*i + 1 and right child is at
 * index 2*i + 2.
 *
 * Heap-ify process takes height of the binary tree i.e. O(log N)
 * Runtime of Heap Sort: O(N log N)
 *
 * Author: Kamal Debnath
 */

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {40, 10, 2, 30, 5};
        int n = arr.length;

        System.out.println("Initial Array");
        System.out.println(Arrays.toString(arr));

        // create max heap. bottom-up order
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }

        System.out.println("Initial Max Heap");
        System.out.println(Arrays.toString(arr));

        // delete from root of the heap and re-balance the tree
        for (int i = n - 1; i >= 0; i--) {
            // swap with root with last element in the array
            int maxVal = arr[0];
            arr[0] = arr[i];
            arr[i] = maxVal;

            // Re-balance the binary tree but with reduce heap size
            maxHeapify(arr, i, 0);

            System.out.println("Heap Sort Steps");
            System.out.println(Arrays.toString(arr));
        }
    }

    // n = size of the heap, i = parent node index location
    private static void maxHeapify(int[] arr, int n, int i) {
        int largest = i;
        int leftIndex = 2 * i + 1;
        int rightIndex = 2 * i + 2;

        if (leftIndex < n && arr[largest] < arr[leftIndex])
            largest = leftIndex;

        if (rightIndex < n && arr[largest] < arr[rightIndex])
            largest = rightIndex;

        // current parent node is smaller than its child node
        if (largest != i) {
            //swap parent with child node
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

            // recursively heap-ify
            maxHeapify(arr, n, largest);
        }
    }
}
