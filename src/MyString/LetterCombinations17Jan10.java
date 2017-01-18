package MyString;
import java.util.*;
/**
 * Created by li on 1/10/2017.
 */
public class LetterCombinations17Jan10 {
    /**
     * Backtracking
     * */
    public List<String> letterCombinations(String digits) {
        List<String> r = new LinkedList<>();
        if(digits.length() == 0 || digits.contains("0") || digits.contains("1")) return r;
        StringBuilder sb = new StringBuilder();
        helper(r, sb, digits, 0);
        return r;
    }

    public char[] loopUp(char c){
        if(c == '2') return new char[] {'a','b','c'};
        else if(c == '3') return new char[] {'d', 'e', 'f'};
        else if(c == '4') return new char[] {'g', 'h', 'i'};
        else if(c == '5') return new char[] {'j', 'k', 'l'};
        else if(c == '6') return new char[] {'m', 'n', 'o'};
        else if(c == '7') return new char[] {'p', 'q', 'r', 's'};
        else if(c == '8') return new char[] {'t', 'u', 'v'};
        else if(c == '9') return new char[] {'w', 'x', 'y', 'z'};
        else return new char[0];
    }
    public char[] loopUp2(char c){
        String[] strs = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return strs[c-'2'].toCharArray();
    }


    public void helper(List<String> r, StringBuilder sb, String digits, int i){
        if(i == digits.length()) r.add(sb.toString());
        else {
            char[] c = loopUp(digits.charAt(i));
            for(char temp:c) {
                sb.append(temp);
                helper(r, sb, digits, i+1);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
