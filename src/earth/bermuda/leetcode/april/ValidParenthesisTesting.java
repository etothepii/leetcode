package earth.bermuda.leetcode.april;

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
                if (open > 0) {
                    open--;
                }
                else if (open_asterisk > 0) {
                    open_asterisk--;
                }
                else {
                    return false;
                }
            }
            else if (c == '*') {
                asterisk++;
            }
            while (open < asterisk && asterisk > 0) {
                asterisk--;
                open_asterisk++;
            }
        }
        return open <= asterisk;
    }

}
