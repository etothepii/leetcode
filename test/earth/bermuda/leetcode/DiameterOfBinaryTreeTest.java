package earth.bermuda.leetcode;

import com.sun.source.tree.Tree;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void can_find_diameter_5() {

//          0
//         / \
//        0   0
//       / \
//      0   0

        TreeNode[] treeNodes = createTreeNones(5);
        for (TreeNode node : treeNodes) {
            node.val = 0;
        }
        treeNodes[0].left = treeNodes[1];
        treeNodes[0].right = treeNodes[2];
        treeNodes[1].left = treeNodes[3];
        treeNodes[1].right = treeNodes[4];

        int expected = 3;
        int actual = new DiameterOfBinaryTree().diameterOfBinaryTree(treeNodes[0]);
        assertEquals(expected, actual);

    }


    @Test
    public void can_find_diameter_6() {

//          1

        TreeNode[] treeNodes = createTreeNones(1);

        int expected = 0;
        int actual = new DiameterOfBinaryTree().diameterOfBinaryTree(treeNodes[0]);
        assertEquals(expected, actual);
    }


    @Test
    public void can_find_diameter_7() {

//

        int expected = 0;
        int actual = new DiameterOfBinaryTree().diameterOfBinaryTree(null);
        assertEquals(expected, actual);
    }


    @Test
    public void can_find_random_1_000() {
        DiameterOfBinaryTree solution = new DiameterOfBinaryTree();
        NiaveDiameterOfBinaryTree expectedSolution = new NiaveDiameterOfBinaryTree();
        for (int i = 0; i < 1_000; i++) {
            TreeNode[] nodes = createTreeNones(Math.max(1, (int) (Math.random() * 100)));
            int nextChild = 0;
            for (int node = 0; node < nodes.length; node++) {
                if (Math.random() < .8 && ++nextChild < nodes.length) {
                    nodes[node].left = nodes[nextChild];
                }
                if (Math.random() < .8 && ++nextChild < nodes.length) {
                    nodes[node].right = nodes[nextChild];
                }
            }
            int expected = expectedSolution.diameterOfBinaryTree(nodes[0]);
            int actual = solution.diameterOfBinaryTree(nodes[0]);
            assertEquals(expected, actual);
        }
    }

//    @Test
    public void can_profile_random_100_000() {
        DiameterOfBinaryTree solution = new DiameterOfBinaryTree();
        NiaveDiameterOfBinaryTree expectedSolution = new NiaveDiameterOfBinaryTree();
        double target = 5000;
        double sum = 0;
        double sum_squares = 0;
        int iterations = 100;
        int loop = 1_000;
        for (int j = 0; j < iterations; j++) {
            long time = 0;
            for (int i = 0; i < loop; i++) {
                TreeNode[] nodes = createTreeNones(Math.max(1, (int) (Math.random() * 100)));
                int nextChild = 0;
                for (int node = 0; node < nodes.length; node++) {
                    if (Math.random() < .8 && ++nextChild < nodes.length) {
                        nodes[node].left = nodes[nextChild];
                    }
                    if (Math.random() < .8 && ++nextChild < nodes.length) {
                        nodes[node].right = nodes[nextChild];
                    }
                }
                long start = System.nanoTime();
                solution.diameterOfBinaryTree(nodes[0]);
                time += System.nanoTime() - start;
            }
            long mean = time / loop;
            sum += mean;
            sum_squares += mean * mean;
        }
        double mean = sum / iterations;
        double std = Math.sqrt(sum_squares / iterations - mean * mean);
        assertTrue(mean + 2 * std < target, String.format("mean: %.2fns std: %.2fns => 2 std > %.2fns", mean, std, target));
    }

}

class NiaveDiameterOfBinaryTree {

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
        for (int[] a : strings) {
            for (int[] b : strings) {
                max = Math.max(max, d(a, b));
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