package earth.bermuda.leetcode;

public class FirstBadVersion extends VersionControl {

    public FirstBadVersion(int n) {
        super(n);
    }

    public int firstBadVersion(int n) {
        return 0;
    }
}

class VersionControl {

    private final int badVersion;

    VersionControl(int n) {
        this.badVersion = n;
    }

    boolean isBadVersion(int version) {
        return  version < badVersion;
    }
}