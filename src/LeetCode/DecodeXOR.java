package LeetCode;

/**
 * Leetcode Problem 1720
 *
 * Given an encoded array and first element, return the original array. The encoded
 * array is created by using XOR operation of the original array like encoded[i] = orig[i] ^ orig[i + 1]
 *
 * Input: encoded = [1,2,3], first = 1
 * Output: [1,0,2,1]
 * Explanation: If arr = [1,0,2,1], then first = 1 and encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
 *
 * Algorithm:
 *
 * 1. Use XOR property: a ^ a becomes 0 and a ^ 0 = a and a ^ b = c then c ^ a = b or c ^ b = a
 * 2. Iterate the output array and perform the XOR operation between encoded[i] and orig[i]
 *
 * Runtime: O(N), Space O(N)
 */

public class DecodeXOR {
    public int[] decode(int[] encoded, int first) {
        int[] out = new int[encoded.length + 1];
        out[0] = first;

        for (int i = 0; i < encoded.length; i++) {
            out[i + 1] = out[i] ^ encoded[i];
        }

        return out;
    }
}
