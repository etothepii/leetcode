package earth.bermuda.leetcode;

public class ValidNumber {

    public boolean isNumber(String s) {
        boolean seen_e = false;
        boolean seen_dot = false;
        boolean seen_sign = false;
        boolean seen_digit = false;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                if (!(seen_digit || seen_dot || seen_sign)) {
                    continue;
                }
                while (++i < length) {
                    if (s.charAt(i) != ' ') {
                        return false;
                    }
                }
            } else if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                if (seen_e || !seen_digit) {
                    return false;
                }
                seen_e = true;
                if (++i >= length) {
                    return false;
                }
                if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                    if (++i >= length) {
                        return false;
                    }
                }
                if (s.charAt(i) < 48 || s.charAt(i) > 57) {
                    return false;
                }
            } else if (s.charAt(i) == '.') {
                if (seen_dot || seen_e) {
                    return false;
                }
                seen_dot = true;
            } else if (s.charAt(i) >=48 && s.charAt(i) <= 57) {
                seen_digit = true;
            } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                if (seen_digit || seen_dot || seen_sign) {
                    return false;
                }
                seen_sign = true;
            } else {
                return false;
            }
        }
        return seen_digit;
    }
}
