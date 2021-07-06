package LeetCode;

import java.util.List;
import java.util.ArrayList;

/**
 * Leetcode Problem Number 1431.
 *
 * Given the array candies and the integer extraCandies, where candies[i] represents
 * the number of candies that the ith kid has. For each kid check if there is a way to distribute
 * extraCandies among the kids such that he or she can have the greatest number of candies
 * among them. Notice that multiple kids can have the greatest number of candies.
 *
 * Input: candies = [2,3,5,1,3], extraCandies = 3
 * Output: [true,true,true,false,true]
 *
 * Algorithm:
 *
 * 1. Find the maximum number of candy in the array
 * 2. if the current candy + extraCandies >= the max candy then add boolean true otherwise false
 *
 * Runtime O(N)
 */

public class KidWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // find maximum candies
        int maxCandies = 0;

        for (int candy : candies) {
            maxCandies = Math.max(maxCandies, candy);
        }

        List<Boolean> out = new ArrayList<>();

        // find the greatest number of candies by adding extraCandies
        for (int candy : candies) {
            if (candy + extraCandies >= maxCandies)
                out.add(true);
            else
                out.add(false);
        }

        return out;
    }
}
