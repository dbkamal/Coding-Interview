package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Sort a large set of floating point numbers which are in range from 0.0 to 1.0 and are uniformly distributed
 * across the range. How do we sort the numbers efficiently?
 *
 * Algorithm:
 *
 * The idea is to use Bucket sort as we can't employ Counting sort here as these are floating number. The core idea of
 * the Bucket sort is
 *
 * 1. Create a list of buckets e.g. bucket of 10 list
 * 2. Store element into respective bucket. So {0.72, 0.79} goes to the same bucket
 * 3. Sort individual bucket in ascending order. We can use any sorting algorithm like insertion sort
 * 4. Concatenate all the buckets
 *
 * Runtime: O(N) as mostly the insertion would take O(1) for linked list for sorting small data
 *
 * Author: Kamal Debnath
 */

public class BucketSort {
    public static void main(String[] args) {
        double[] arr = {0.72, 0.11, 0.68, 0.79, 0.12, 0.23, 0.34, 0.30};

        System.out.println("Initial Array");
        System.out.println(Arrays.toString(arr));

        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(bucketSort(arr)));
    }

    private static double[] bucketSort(double[] arr) {
        int len = arr.length;
        ArrayList<Double>[] bucket = new ArrayList[len];

        for (int i = 0; i < len; i++) {
            bucket[i] = new ArrayList<>();
        }

        // place each element into right bucket
        for (double val : arr) {
            bucket[(int) val * len].add(val);
        }

        // sort each bucket
        for (int i = 0; i < len; i++) {
            if (bucket[i] == null)
                continue;
            Collections.sort(bucket[i]);
        }

        // concat into final output array
        double[] res = new double[len];
        int t = 0;

        for (int i = 0; i < len; i++) {
            if (bucket[i] == null)
                continue;

            for (int j = 0; j < bucket[i].size(); j++) {
                res[t++] = bucket[i].get(j);
            }
        }

        return res;
    }
}
