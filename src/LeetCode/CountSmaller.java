package LeetCode;

import java.util.List;
import java.util.ArrayList;

/**
 * Leetcode Problem 315
 *
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property
 * where counts[i] is the number of smaller elements to the right of nums[i].
 *
 * Input: nums = [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 *
 * Algorithm:
 * ---------
 *
 * Merge Sort: What we have to find is the number of smaller element present from the self.
 * We shouldn't sort directly the input `nums` rather use an `index` array which will be sorted based on `nums`.
 *
 * While sorting the index array based on nums, keeps counting the number of smaller element jump from right to left
 * and keep adding that into result array.
 *
 * Runtime - O(N log N), Space - O(N)
 *
 */

public class CountSmaller {

    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        int[] indices = new int[len]; //sort indices based on nums
        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            indices[i] = i;
        }

        mergeSort(indices, 0, len - 1, nums, result);

        List<Integer> list = new ArrayList<>();

        for (int val : result) {
            list.add(val);
        }

        return list;
    }

    private void mergeSort(int[] indices, int left, int right, int[] nums, int[] result) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(indices, left, mid, nums, result);
            mergeSort(indices, mid + 1, right, nums, result);
            merge(indices, left, mid, right, nums, result);
        }
    }

    private void merge(int[] indices, int left, int mid, int right, int[] nums, int[] result) {
        int len = right - left + 1;
        int[] temp = new int[len];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right && k < len) {
            if (nums[indices[i]] <= nums[indices[j]]) {
                result[indices[i]] += j - mid - 1;
                temp[k++] = indices[i++];
            }
            else {
                temp[k++] = indices[j++];
            }
        }

        while (i <= mid) {
            result[indices[i]] += j - mid - 1;
            temp[k++] = indices[i++];
        }

        while (j <= right) {
            temp[k++] = indices[j++];
        }

        i = left;
        for (int val : temp) {
            indices[i++] = val;
        }
    }
}
