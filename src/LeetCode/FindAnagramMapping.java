package LeetCode;

import java.util.Map;
import java.util.HashMap;

/**
 * Leetcode Program 760
 *
 * Given two anagram integer array return an index mapping array mapping from nums1 to nums2 where mapping[i] = j
 * means the ith element in nums1 appears in nums2 at index j. If there are multiple answers, return any of them.
 *
 * An array a is an anagram of an array b means b is made by randomizing the order of the elements in a.
 *
 * Input: nums1 = [12,28,46,32,50], nums2 = [50,12,32,46,28]
 * Output: [1,4,3,2,0]
 * Explanation: As mapping[0] = 1 because the 0th element of nums1 appears at nums2[1],
 * and mapping[1] = 4 because the 1st element of nums1 appears at nums2[4], and so on.
 *
 * Approach: HashMap
 * Store the nums2 value as key and index as value in the map. Then iterate nums1 and look up the index value based on
 * nums1[i]
 *
 * Runtime & Space O(N)
 */

public class FindAnagramMapping {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] result = new int[n];
        Map<Integer, Integer> valueToIndexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            valueToIndexMap.put(nums2[i], i);
        }

        for (int i = 0; i < n; i++) {
            result[i] = valueToIndexMap.get(nums1[i]);
        }

        return result;
    }
}
