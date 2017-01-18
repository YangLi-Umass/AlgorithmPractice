package MyString;

import java.util.Stack;

/**
 * Created by li on 12/11/2016.
 */
public class ValidParentheses20Dec11 {
    /**
     * 错误的解法
     * 注意这样的输入"([)]"  应该返回false
     *
     * */


    public boolean isValid1(String s) {
        int leftP = 0, leftB = 0, leftBraket = 0;
        for(int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(' : leftP++;
                    break;
                case ')' : if(leftP > 0) {leftP--;break;}
                else return false;
                case '{' : leftB++;
                    break;
                case '}' : if(leftB > 0) {leftB--;break;}
                else return false;
                case '[' : leftBraket++;
                    break;
                case ']' : if(leftBraket > 0) {leftBraket--;break;}
                else return false;
            }

        }
        if(leftP == 0 && leftB == 0 && leftBraket == 0) {
            return true;
        }
        return false;
    }

    /**
     * My solution
     *
     * */

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else if (c == ')') {
                if (!st.isEmpty() && st.peek() == '(') st.pop();
                else return false;
            } else if (c == ']') {
                if (!st.isEmpty() && st.peek() == '[') st.pop();
                else return false;
            } else {
                if (!st.isEmpty() && st.peek() == '{') st.pop();
                else return false;
            }
        }
        if(st.isEmpty()) return true;
        return false;

    }

    /**
     * More Elegant
     *
     * */
    public boolean isValid3(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else if (c == ')' && !st.isEmpty() && st.peek() == '(') {
                st.pop();
            } else if (c == ']' && !st.isEmpty() && st.peek() == '[') {
                st.pop();
            } else if (c == '}' && !st.isEmpty() && st.peek() == '{'){
                st.pop();
            } else {
                return false;
            }
        }
        if(st.isEmpty()) return true;
        return false;
    }

}
