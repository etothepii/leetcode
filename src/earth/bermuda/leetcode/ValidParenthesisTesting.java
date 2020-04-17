package earth.bermuda.leetcode;

public class ValidParenthesisTesting {

    public boolean checkValidString(String s) {
        byte asterisk = 0;
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
            if (open < -asterisk) {
                return false;
            }
        }
        return open <= asterisk;
    }

}
