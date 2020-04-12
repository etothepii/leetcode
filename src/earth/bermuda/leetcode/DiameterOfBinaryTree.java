package earth.bermuda.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        EnurableTreeNode enurableTreeNode = new EnurableTreeNode(root);
        int[] current = null;
        int[] extrema_1 = enurableTreeNode.soFar;
        int[] extrema_2 = enurableTreeNode.soFar;
        int max = 0;
        while ((current = enurableTreeNode.next() ) != null) {
            int diameter;
            if ((diameter = d(extrema_1, current)) > max) {
                extrema_2 = current;
                max = diameter;
            }
            else if ((diameter = d(extrema_2, current)) > max) {
                extrema_1 = current;
                max = diameter;
            }
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

class EnurableTreeNode {

    private int count = 0;
    private final ArrayList<TreeNode> stack = new ArrayList<>(1000);
    public int[] soFar = new int[0];

    public EnurableTreeNode(TreeNode root) {
        stack.add(root);
        addNewNode();
    }

    private TreeNode last() {
        return stack.get(stack.size() - 1);
    }

    public int[] next() {
        if (last().left != null) {
            stack.add(last().left);
            addNewNode();
            return soFar;
        }
        else if (last().right != null) {
            stack.add(last().right);
            addNewNode();
            return soFar;
        }
        TreeNode terminus = stack.remove(stack.size() - 1);
        soFar = Arrays.copyOf(soFar, soFar.length - 1);
        if (soFar.length == 0) {
            return null;
        }
        if (last().left == terminus) {
            last().left = null;
        }
        else if (last().right == terminus) {
            last().right = null;
        }
        return next();
    }

    private void addNewNode() {
        soFar = Arrays.copyOf(soFar, soFar.length + 1);
        soFar[soFar.length - 1] = count++;
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
