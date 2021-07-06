package LeetCode;

/**
 * Leetcode Problem 1512
 * Given an array of integers nums. A pair (i,j) is called good if nums[i] == nums[j] and i < j. Return the number of good pairs.
 *
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 *
 * Single Pass: count` the occurrence of the same elements. For each new element a, there will be more count[a] pairs, with A[i] == A[j] and i < j.
 */

public class CountGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        int res = 0;
        int[] countArray = new int[101];

        for (int val : nums) {
            res += countArray[val]++;
        }

        return res;
    }
}
