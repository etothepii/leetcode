package earth.bermuda.leetcode.april;

import java.util.ArrayList;
import java.util.Arrays;

class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        EnurableTreeNode enurableTreeNode = new EnurableTreeNode(root);
        int[] extrema_1 = Arrays.copyOf(enurableTreeNode.soFar, enurableTreeNode.soFarLength);
        int[] extrema_2 = Arrays.copyOf(enurableTreeNode.soFar, enurableTreeNode.soFarLength);
        int max = 0;
        while (enurableTreeNode.next()) {
            int diameter;
            if ((diameter = d(extrema_1, enurableTreeNode)) > max) {
                extrema_2 = Arrays.copyOf(enurableTreeNode.soFar, enurableTreeNode.soFarLength);
                max = diameter;
            }
            else if ((diameter = d(extrema_2, enurableTreeNode)) > max) {
                extrema_1 = Arrays.copyOf(enurableTreeNode.soFar, enurableTreeNode.soFarLength);
                max = diameter;
            }
        }
        return max;
    }

    private int d(int[] a, EnurableTreeNode enurableTreeNode) {
        int similar;
        for (similar = 0; similar < Math.min(a.length, enurableTreeNode.soFarLength); similar++) {
            if (a[similar] != enurableTreeNode.soFar[similar]) {
                break;
            }
        }
        return a.length + enurableTreeNode.soFarLength - 2 * similar;
    }
}

class EnurableTreeNode {

    private int count = 0;
    private final ArrayList<TreeNode> stack = new ArrayList<>(1000);
    public int[] soFar = new int[1000];
    public int soFarLength = 0;

    public EnurableTreeNode(TreeNode root) {
        stack.add(root);
        soFar[soFarLength++] = count++;
    }

    private TreeNode last() {
        return stack.get(stack.size() - 1);
    }

    public boolean next() {
        if (last().left != null) {
            stack.add(last().left);
            soFar[soFarLength++] = count++;
            return true;
        }
        else if (last().right != null) {
            stack.add(last().right);
            soFar[soFarLength++] = count++;
            return true;
        }
        TreeNode terminus = stack.remove(stack.size() - 1);
        soFarLength--;
        if (soFarLength == 0) {
            return false;
        }
        if (last().left == terminus) {
            last().left = null;
        }
        else if (last().right == terminus) {
            last().right = null;
        }
        return next();
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
