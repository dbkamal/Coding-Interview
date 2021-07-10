package LeetCode;

import java.util.List;

/**
 * Leetcode Problem 1773
 *
 * Given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and
 * name of the ith item and given a rule represented by two strings, ruleKey and ruleValue.
 * Return the number of items that match the given rule.
 *
 * The ith item is said to match the rule if one of the following is true:
 *
 * ruleKey == "type" and ruleValue == typei.
 * ruleKey == "color" and ruleValue == colori.
 * ruleKey == "name" and ruleValue == namei.
 *
 * Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]],
 * ruleKey = "color", ruleValue = "silver"
 * Output: 1
 * Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].
 */

public class CountItemMatchingRule {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        // get the index position as per rule key
        int index = ruleKey.equals("type") ? 0 : ruleKey.equals("color") ? 1 : 2;
        int count = 0;

        for (List<String> item : items) {
            if (ruleValue.equals(item.get(index)))
                count++;
        }

        return count;
    }
}
