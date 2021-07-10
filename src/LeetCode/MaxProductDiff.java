package LeetCode;

/**
 * Leetcode Product 1913
 *
 * The product difference between two pairs (a, b) and (c, d) is defined as (a * b) - (c * d).
 * For example, the product difference between (5, 6) and (2, 7) is (5 * 6) - (2 * 7) = 16.
 *
 * Given an integer array nums, choose four distinct indices w, x, y, and z such that the product difference
 * between pairs (nums[w], nums[x]) and (nums[y], nums[z]) is maximized. Return the maximum such product difference.
 *
 * Input: nums = [5,6,2,7,4]
 * Output: 34
 * Explanation: We can choose indices 1 and 3 for the first pair (6, 7) and indices 2 and 4 for the second pair (2, 4).
 * The product difference is (6 * 7) - (2 * 4) = 34.
 *
 * **Approach: Linear Solution**
 *
 * Use four variable, two for max and two for min value. Scan the array and check if the current max_1 is the
 * smaller than the current nums[i]. If yes, place the max_1 value to max_2 and update max_1 with nums[i].
 * Similarly, if the min_1 is larger than current nums[i], then place the min_1 to min_2 and update min_1 with nums[i].
 */

public class MaxProductDiff {
    public int maxProductDifference(int[] nums) {
        int min_1 = Integer.MAX_VALUE, min_2 = Integer.MAX_VALUE,
                max_1 = Integer.MIN_VALUE, max_2 = Integer.MIN_VALUE;

        for (int val : nums) {
            /* set the two max value */
            if (val > max_1) {
                max_2 = max_1;
                max_1 = val;
            }
            else if (val > max_2)
                max_2 = val;

            /* set the two min value */
            if (val < min_1) {
                min_2 = min_1;
                min_1 = val;
            }
            else if (val < min_2)
                min_2 = val;
        }

        return max_1 * max_2 - min_1 * min_2;
    }
}
