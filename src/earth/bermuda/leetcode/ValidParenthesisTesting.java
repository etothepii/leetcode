package earth.bermuda.leetcode;

public class ValidParenthesisTesting {

    public boolean checkValidString(String s) {
        byte asterisk = 0;
        byte open_asterisk = 0;
        byte open = 0;
        for (char c : s.toCharArray()){
            if (c == '(') {
                open++;
            }
            else if (c == ')') {
                open--;
            }
            else if (c == '*') {
                asterisk++;
            }
            if (open + open_asterisk < -asterisk) {
                return false;
            }
            while (open < asterisk && asterisk > 0) {
                asterisk--;
                open_asterisk++;
            }
        }
        return open <= asterisk;
    }

}
