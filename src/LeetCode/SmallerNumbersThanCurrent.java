package LeetCode;

/**
 * Leetcode Problem 1365
 *
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i]. Return the answer in an array.
 *
 * Input: nums = [8,1,2,2,3]
 * Output: [4,0,1,1,3]
 * Explanation:
 * For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
 * For nums[1]=1 does not exist any smaller number than it.
 * For nums[2]=2 there exist one smaller number than it (1).
 * For nums[3]=2 there exist one smaller number than it (1).
 * For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
 *
 * **Approach: Cumulative Sum**
 *
 * 1. count the number occurances and do the cumulative sum
 * 2. for each element A[i] check the count of the previous element in the occurances array for [A[i] - 1]
 *
 * Runtime O(N), Space O(1)
 */

public class SmallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] countArray = new int[101];

        for(int val : nums)
            countArray[val]++;

        for (int i = 1; i < countArray.length; i++)
            countArray[i] += countArray[i - 1];

        int[] out = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                out[i] = 0;
            else
                out[i] = countArray[nums[i] - 1];
        }

        return out;
    }
}
