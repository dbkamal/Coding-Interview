package Algorithm;

import DataStructure.SegmentTree;

import java.util.List;
import java.util.ArrayList;

/**
 * Given an array of N elements and M number of query to find the range sum and update the input array.
 *
 * Example - A = [1,2,3,4,5], and Query = {sum(1, 2), A[2] = 10, sum(0,3), A[0] = -3, sum(0,3)}
 *
 * The result of the query is {5, null, 17, 14} and final input becomes [-3,2,10,4,5]
 *
 * **Approach: Prefix Sum**
 *
 * sum[i..j] = prefixSum[j] - prefixSum[i - 1] if i != 0 otherwise return prefixSum[j]
 *
 * So, prepare the prefix sum of A = [1,2,3,4,5] is [1,3,6,10,15] and the range sum is
 *
 * sum(1,2) = prefixSum(2) - prefixSum(0) = 6 - 1 = 5. However now the update process is bit challenging.
 * Once you update the original array, the prefix sum array needs to be updated with the new array value too.
 * So, now the time complexity has changed
 *
 * Runtime: Range Sum Query O(1), Update O(N)
 *
 * **Approach: Segment Tree**
 *
 * Segment tree builds the sum of the ranges in each node and each leaf node contains the single actual array element.
 * Once the segment tree is build, range query take O(log N) to traverse the binary tree and return the sum.
 * For the update operation, once the leaf node is updated, it also updates the tree node until root from left --> root
 * path, hence will have updated sum along all the ranges. So, the update operation costs O(log N) as well.
 */

public class RangeSumAndUpdate {

    static class Query {

        List<String> type = new ArrayList<>();
        List<String> range = new ArrayList<>();

        public void insert(String typeValue, String rangeValue) {
            type.add(typeValue);
            range.add(rangeValue);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Query query = new Query();
        query.insert("sum", "1,2");
        query.insert("update", "2,10");
        query.insert("sum", "0,3");
        query.insert("update", "0,-3");
        query.insert("sum", "0,3");

        List<Integer> result_prefix = rangeSumAndUpdate(arr.clone(), query);

        for (int val : result_prefix) {
            System.out.println("Sum : " + val);
        }

        List<Integer> result_segment_tree = rangeSumUsingSegmentTree(arr.clone(), query);

        for (int val : result_segment_tree) {
            System.out.println("Sum : " + val);
        }
    }

    private static List<Integer> rangeSumUsingSegmentTree(int[] arr, Query query) {
        List<Integer> result = new ArrayList<>();
        int len = arr.length - 1;
        SegmentTree segmentTree = new SegmentTree((int) Math.pow(2, len));
        segmentTree.buildSegmentTree(arr, 0, 0, len);

        List<String> typeList = query.type;
        List<String> rangeList = query.range;

        for (int i = 0; i < typeList.size(); i++) {
            String type = typeList.get(i);
            String range = rangeList.get(i);
            String[] tempRange = range.split(",");
            int startIndex = Integer.parseInt(tempRange[0]);
            int val = Integer.parseInt(tempRange[1]);

            if (type.equals("sum")) {
                result.add(segmentTree.querySegmentTree(0, 0, len, startIndex, val));
            }
            else {
                segmentTree.updateSegmentTree(0, 0, len, startIndex, val);
            }
        }

        return result;
    }

    private static List<Integer> rangeSumAndUpdate(int[] arr, Query query) {
        List<Integer> result = new ArrayList<>();
        int[] prefixSum = cumsum(arr);

        List<String> typeList = query.type;
        List<String> rangeList = query.range;

        for (int i = 0; i < typeList.size(); i++) {
            String type = typeList.get(i);
            String range = rangeList.get(i);
            String[] tempRange = range.split(",");
            int startIndex = Integer.parseInt(tempRange[0]);
            int val = Integer.parseInt(tempRange[1]);

            if (type.equals("sum")) {
                int sum = startIndex == 0 ? prefixSum[val] : prefixSum[val] - prefixSum[startIndex - 1];
                result.add(sum);
            }
            else {
                arr[startIndex] = val;
                prefixSum = cumsum(arr); //re-calculate prefix sum
            }
        }

        return result;
    }

    private static int[] cumsum(int[] arr) {
        int[] result = new int[arr.length];
        result[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            result[i] = result[i - 1] + arr[i];
        }

        return result;
    }
}
