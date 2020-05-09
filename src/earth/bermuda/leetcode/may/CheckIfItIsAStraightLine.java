package earth.bermuda.leetcode.may;

public class CheckIfItIsAStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        int[] first = null;
        int[] second = null;
        int dx = 0;
        int dy = 0;
        for (int[] coordinate : coordinates) {
            if (first == null) {
                first = coordinate;
                continue;
            }
            if (second == null) {
                dx = coordinate[0] - first[0];
                dy = coordinate[1] - first[1];
                if (dx != 0 || dy != 0) {
                    second = coordinate;
                }
                continue;
            }
            if (dx == 0) {
                if (coordinate[0] != first[0]) {
                    return false;
                }
            }
            if (dy == 0) {
                if (coordinate[1] != first[1]) {
                    return false;
                }
            }
            int p = coordinate[0] - first[0];
            int q = coordinate[1] - first[1];
            if (p * dy != q * dx) {
                return false;
            }
        }
        return first != null && second != null;
    }
}
