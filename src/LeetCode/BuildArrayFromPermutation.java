package LeetCode;

/**
 * Leetcode Problem 1920
 *
 * Given a zero-based permutation nums (0-indexed), build an array ans of the same length where ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it. A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).
 *
 * Input: nums = [0,2,1,5,3,4]
 * Output: [0,1,2,4,5,3]
 * Explanation: The array ans is built as follows:
 * ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
 *     = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]
 *     = [0,1,2,4,5,3]
 *
 * Approach Modulo Operation:
 * 1. update nums[i] using `nums[i] = nums[i] + n * (nums[nums[i]] % n)` to store both old and new value.
 * This modulo operation is very important (nums[nums[i]] % n) to get the original value.
 * 2. divide each num[i] by n to get the new value.
 */

public class BuildArrayFromPermutation {
    public int[] buildArray(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] + n * (nums[nums[i]] % n);
        }

        for (int i = 0; i < n; i++) {
            nums[i] /= n;
        }

        return nums;
    }
}
