package earth.bermuda.leetcode.may;

public class FirstBadVersion extends VersionControl {

    public FirstBadVersion(int n, int max) {
        super(n, max);
    }

    public int firstBadVersion(int n) {
        int max = n;
        int delta = n;
        while (delta > 1) {
            delta = delta % 2 + delta / 2;
            if (isBadVersion(n)) {
                n -= delta;
            }
            else {
                n = Math.min(max, n + delta);
            }
        }
        return isBadVersion(n) ? n: n + 1;
    }
}

class VersionControl {

    private final int badVersion;
    private final int maxVersion;

    VersionControl(int n, int max) {
        this.badVersion = n;
        this.maxVersion = max;
    }

    boolean isBadVersion(int version) {
        if (version > maxVersion) {
            throw new ArrayIndexOutOfBoundsException(version);
        }
        return  version >= badVersion;
    }
}