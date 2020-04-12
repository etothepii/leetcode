package earth.bermuda.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiameterOfBinaryTreeTest {

    private static TreeNode[] createTreeNones(int n) {
        TreeNode[] nodes = new TreeNode[n];
        for (int i = 1; i <= n; i++) {
            nodes[i - 1] = new TreeNode(i);
        }
        return nodes;
    }

    @Test
    public void can_find_diameter_1() {

//          1
//         / \
//        2   3
//       / \
//      4   5

        TreeNode[] treeNodes = createTreeNones(5);
        treeNodes[0].left = treeNodes[1];
        treeNodes[0].right = treeNodes[2];
        treeNodes[1].left = treeNodes[3];
        treeNodes[1].right = treeNodes[4];

        int expected = 3;
        int actual = new DiameterOfBinaryTree().diameterOfBinaryTree(treeNodes[0]);
        assertEquals(expected, actual);

    }

    @Test
    public void can_find_diameter_2() {

//          7
//          |
//          6
//          |
//          1
//         / \
//        2   3
//       / \
//      4   5

        TreeNode[] treeNodes = createTreeNones(7);
        treeNodes[0].left = treeNodes[1];
        treeNodes[0].right = treeNodes[2];
        treeNodes[1].left = treeNodes[3];
        treeNodes[1].right = treeNodes[4];
        treeNodes[5].left = treeNodes[0];
        treeNodes[6].right = treeNodes[5];

        int expected = 4;
        int actual = new DiameterOfBinaryTree().diameterOfBinaryTree(treeNodes[6]);
        assertEquals(expected, actual);

    }

    @Test
    public void can_find_diameter_3() {

//          1
//          |
//          2
//          |
//          3
//         / \
//        4   5
//       / \
//      6   7

        TreeNode[] treeNodes = createTreeNones(7);
        treeNodes[0].left = treeNodes[1];
        treeNodes[1].right = treeNodes[2];
        treeNodes[2].left = treeNodes[3];
        treeNodes[2].right = treeNodes[4];
        treeNodes[3].left = treeNodes[5];
        treeNodes[3].right = treeNodes[6];

        int expected = 4;
        int actual = new DiameterOfBinaryTree().diameterOfBinaryTree(treeNodes[0]);
        assertEquals(expected, actual);

    }

    @Test
    public void can_find_diameter_4() {

//           1
//          / \
//          2  9
//          |   \
//          3    10
//         / \    \
//        4   5    11
//       / \      /  \
//      6   7   12    13
//          |        /  \
//          8      14    15

        TreeNode[] treeNodes = createTreeNones(15);
        treeNodes[0].left = treeNodes[1];
        treeNodes[0].right = treeNodes[8];
        treeNodes[1].left = treeNodes[2];
        treeNodes[2].left = treeNodes[3];
        treeNodes[2].right = treeNodes[4];
        treeNodes[3].left = treeNodes[5];
        treeNodes[3].right = treeNodes[6];
        treeNodes[6].right = treeNodes[7];
        treeNodes[8].right = treeNodes[9];
        treeNodes[9].left = treeNodes[10];
        treeNodes[10].left = treeNodes[11];
        treeNodes[10].right = treeNodes[12];
        treeNodes[12].left = treeNodes[13];
        treeNodes[12].right = treeNodes[14];

        int expected = 10;
        int actual = new DiameterOfBinaryTree().diameterOfBinaryTree(treeNodes[0]);
        assertEquals(expected, actual);

    }

}