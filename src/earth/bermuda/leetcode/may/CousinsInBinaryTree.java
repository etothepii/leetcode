package earth.bermuda.leetcode.may;

import java.util.ArrayList;

public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        EnurableTreeNode enurableTreeNode = new EnurableTreeNode(root);
        int x_depth = -1;
        int y_depth = -1;
        TreeNode x_parent = null;
        TreeNode y_parent = null;
        while (enurableTreeNode.next()) {
            if (enurableTreeNode.soFarLength < 2) {
                continue;
            }
            if (enurableTreeNode.last().val == x) {
                x_depth = enurableTreeNode.soFarLength;
                x_parent = enurableTreeNode.parent();
            }
            if (enurableTreeNode.last().val == y) {
                y_depth = enurableTreeNode.soFarLength;
                y_parent = enurableTreeNode.parent();
            }
        }
        return x_parent != null && y_parent != null && x_parent != y_parent && x_depth == y_depth;
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

    public TreeNode last() {
        return stack.get(stack.size() - 1);
    }

    public TreeNode parent() {
        return stack.get(stack.size() - 2);
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
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }