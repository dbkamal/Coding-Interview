package LeetCode;

/**
 * Leetcode Problem Number 1480.
 *
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 * Return the running sum of nums.
 *
 * Input: nums = [1,2,3,4]
 * Output: [1,3,6,10]
 * Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 *
 * Algorithm:
 *
 * Do cumulative sum. Runtime O(N), Space O(N) depends on the specs.
 */

public class RunningSum1DArray {
    public int[] runningSum(int[] nums) {
        if (nums.length == 0)
            return new int[] {};

        // do in-place if stated in the problem, otherwise allocate aux space
        int[] out = new int[nums.length];
        out[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            out[i] = out[i - 1] + nums[i];
        }

        return out;
    }
}
