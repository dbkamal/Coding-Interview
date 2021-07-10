package DataStructure;

import java.util.Arrays;

/**
 * Segment Tree
 * ------------
 * buildSegmentTree(): The method builds the entire `tree` in a bottom up fashion. When the condition low = hi
 * is satisfied, we are left with a range comprising of just a single element (which happens to be `arr[lo]`).
 * This constitutes a leaf of the tree. The rest of the nodes are built by merging the results of their two children.
 * `treeIndex` is the index of the current node of the segment tree which is being processed.
 *
 * querySegmentTree(): The method checks if the query range is outside of the range then return null or zero.
 * If the segment completely inside the range and it covers [low:hi] range then return the tree node value.
 * Otherwise, recursively try to find whether the range is left side of the mid or right side of the mid or
 * overlaps the mid. The method returns a result when the queried range matches exactly with the range represented
 * by a current node. Else it digs deeper into the tree to find nodes which match a portion of the node exactly.
 *
 * updateSegmentTree(): This is similar to `buildSegTree`. We update the value of the leaf node of our
 * tree which corresponds to the updated element. Later the changes are propagated through the upper levels
 * of the tree straight to the root.
 */

public class SegmentTree {

    private static int[] tree;

    public SegmentTree(int N) {
        tree = new int[N];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int len = arr.length - 1;
        tree = new int[(int) Math.pow(2, len)];
        buildSegmentTree(arr, 0, 0, len);

        System.out.println("Segment Tree");
        System.out.println(Arrays.toString(tree));

        System.out.println("Range sum query");
        System.out.println(querySegmentTree(0, 0, len, 1, 2));

        System.out.println("Update Segment Tree");
        updateSegmentTree(0, 0, len, 2, 5);
        System.out.println(Arrays.toString(tree));

        System.out.println("Range sum query");
        System.out.println(querySegmentTree(0, 0, len, 1, 2));
    }

    public static void buildSegmentTree(int[] arr, int treeIndex, int low, int hi) {
        if (low == hi) {
            tree[treeIndex] = arr[low];
            return;
        }

        int mid = low + (hi - low) / 2;
        buildSegmentTree(arr, 2 * treeIndex + 1, low, mid);
        buildSegmentTree(arr, 2 * treeIndex + 2, mid + 1, hi);

        tree[treeIndex] = merge(tree[2 * treeIndex + 1], tree[2 * treeIndex + 2]);
    }

    public static int querySegmentTree(int treeIndex, int low, int hi, int i, int j) {
        if (low > j || hi < i) // out of range
            return 0;

        if (i <= low && j >= hi) // within range and return root
            return tree[treeIndex];

        int mid = low + (hi - low) / 2;

        if (i > mid) // query range must be in right subarray
            return querySegmentTree(2 * treeIndex + 2, mid + 1, hi, i, j);
        else if (j < mid) // query range must be in left subarray
            return querySegmentTree(2 * treeIndex + 1, low, mid, i, j);

        int leftQuery = querySegmentTree(2 * treeIndex + 1, low, mid, i, mid);
        int rightQuery = querySegmentTree(2 * treeIndex + 2, mid + 1, hi, mid + 1, j);

        return merge(leftQuery, rightQuery);
    }

    public static void updateSegmentTree(int treeIndex, int low, int hi, int arrayIndex, int val) {
        if (low == hi) { // update the leaf node
            tree[treeIndex] = val;
            return;
        }

        int mid = low + (hi - low) / 2;

        if (arrayIndex > mid)
            updateSegmentTree(2 * treeIndex + 2, mid + 1, hi, arrayIndex, val);
        else if (arrayIndex <= mid) {
            updateSegmentTree(2 * treeIndex + 1, low, mid, arrayIndex, val);
        }

        tree[treeIndex] = merge(tree[2 * treeIndex + 1], tree[2 * treeIndex + 2]);
    }

    private static int merge(int num1, int num2) {
        return num1 + num2;
    }
}
