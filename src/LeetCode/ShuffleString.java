package LeetCode;

/** Leetcode Problem 1528
 *
 * Given a string s and an integer array indices of the same length. The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string. Return the shuffled string.
 *
 * Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
 * Output: "leetcode"
 * Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.
 *
 * **Approach: Use Cyclic Sort**
 *
 * 1. We can use cyclic sort as the indices range is within the bound of [0.. n - 1]
 * 2. Swap the element until it places into correct position
 *
 * String =  [a,i,o,h,n]
 * Indices = [3,1,4,2,0]
 *
 * when i = 0, the inner loop iterates until the correct index element placed under the expected position i.e. char = 'n'
 *
 * i = 0, swap a, h and index value 3, 2
 * String =  [h,i,o,a,n]
 * Indices = [2,1,4,3,0]
 *
 * while condition is still true, so swap one more time, now swap h, o and index 2, 4
 * String =  [o,i,h,a,n]
 * Indices = [4,1,2,3,0]
 *
 * while condition is still true, so swap one more time, now swap o, n and index 4, 0
 * String =  [n,i,h,a,o]
 * Indices = [0,1,2,3,4]
 *
 * Now, inner loop stops and outer loop started into moving right side and check with inner loop condition.
 */

public class ShuffleString {
    public String restoreString(String s, int[] indices) {
        char[] charSeq = s.toCharArray();

        for (int i = 0; i < indices.length; i++) {
            while (i != indices[i]) {
                swapChar(charSeq, i, indices[i]);
                swapInt(indices, i, indices[i]);
            }
        }

        return new String(charSeq);
    }

    private void swapChar(char[] charSeq, int a, int b) {
        char temp = charSeq[a];
        charSeq[a] = charSeq[b];
        charSeq[b] = temp;
    }

    private void swapInt(int[] indices, int a, int b) {
        int temp = indices[a];
        indices[a] = indices[b];
        indices[b] = temp;
    }
}
