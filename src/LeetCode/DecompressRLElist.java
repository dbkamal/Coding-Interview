package LeetCode;

/**
 * Leetcode Problem 1313
 *
 * Given a list of pairs, generate a decompressed list.
 *
 * Input: nums = [1,2,3,4]
 * Output: [2,4,4,4]
 * Explanation: The first pair [1,2] means we have freq = 1 and val = 2 so we generate the array [2].
 * The second pair [3,4] means we have freq = 3 and val = 4 so we generate [4,4,4].
 * At the end the concatenation [2] + [4,4,4] is [2,4,4,4].
 *
 * Algorithm:
 * 1. Count the output array length by scanning the pair
 * 2. Add the values to the final output array based on number of element occurances.
 */

public class DecompressRLElist {
    public int[] decompressRLElist(int[] nums) {
        int len = 0, N = nums.length;
        // calculate output array length
        for (int i = 0; i < N; i += 2) {
            len += nums[i];
        }

        int[] out = new int[len];
        int t = 0;

        for (int i = 0; i < N; i += 2) {
            int freq = nums[i], val = nums[i + 1];
            while (freq-- > 0) {
                out[t++] = val;
            }
        }

        return out;
    }
}
