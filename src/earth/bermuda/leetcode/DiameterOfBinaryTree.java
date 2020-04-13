package earth.bermuda.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DiameterOfBinaryTree {

    private int count = 0;

    private void getStrings(List<int[]> strings, int[] soFar, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        soFar = Arrays.copyOf(soFar, soFar.length + 1);
        soFar[soFar.length - 1] = count++;
        strings.add(soFar);
        getStrings(strings, soFar, treeNode.left);
        getStrings(strings, soFar, treeNode.right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        List<int[]> strings = new ArrayList<>();
        getStrings(strings, new int[0], root);
        int max = 0;
        int[] longest = null;
        for (int[] a : strings) {
            if (longest == null || a.length > longest.length) {
                longest = a;
            }
        }
        for (int[] b : strings) {
            max = Math.max(max, d(longest, b));
        }
        return max;
    }

    private int d(int[] a, int[] b) {
        int similar;
        for (similar = 0; similar < Math.min(a.length, b.length); similar++) {
            if (a[similar] != b[similar]) {
                break;
            }
        }
        return a.length + b.length - 2 * similar;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
