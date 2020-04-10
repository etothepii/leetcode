package earth.bermuda.leetcode;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        int s_pointer = S.length() - 1;
        int t_pointer = T.length() - 1;
        while (true) {
            while (s_pointer >= 0 && S.charAt(s_pointer) == '#') {
                int skip = 0;
                while (s_pointer >= 0 && S.charAt(s_pointer) == '#') {
                    s_pointer--;
                    skip++;
                }
                for (int i = 0; i < skip; i++) {
                    if (s_pointer >= 0 && S.charAt(s_pointer--) == '#') {
                        skip += 2;
                    }
                }
            }
            while (t_pointer >= 0 && T.charAt(t_pointer) == '#') {
                int skip = 0;
                while (t_pointer >= 0 && T.charAt(t_pointer) == '#') {
                    t_pointer--;
                    skip++;
                }
                for (int i = 0; i < skip; i++) {
                    if (t_pointer >= 0 && T.charAt(t_pointer--) == '#') {
                        skip += 2;
                    }
                }
            }
            if (s_pointer >= 0 && t_pointer >= 0) {
                if (S.charAt(s_pointer--) != T.charAt(t_pointer--)) {
                    return false;
                }
            } else if (s_pointer < 0 && t_pointer < 0) {
                return true;
            } else {
                return false;
            }
        }
    }
}
