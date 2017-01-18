package Backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by li on 12/11/2016.
 */
public class GenerateParentheses22Dec11 {
    public List<String> generateParenthesis(int n) {
        List<String> r = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        helper(n,0,sb,r);
        return r;
    }

    public void helper(int remainLeft, int nowLeft, StringBuilder sb, List<String> r) {
        if(remainLeft == 0) {
            while(nowLeft > 0) {
                sb.append(')');
                nowLeft--;
            }
            r.add(sb.toString());
        } else {
            if(nowLeft > 0) {
                StringBuilder sb1 = new StringBuilder(sb);
                sb1.append(')');
                helper(remainLeft, nowLeft-1, sb1, r);
            }

            sb.append('(');
            helper(remainLeft-1, nowLeft+1, sb, r);
        }
    }

    /***
     * 如果不想new StringBuilder
     * 多调用几层其实关系不大
     */

    public void helper2(int remainLeft, int nowLeft, StringBuilder sb, List<String> r) {
        if(remainLeft == 0 && nowLeft == 0) {
            r.add(sb.toString());
        }
        if(remainLeft > 0) {
            sb.append('(');
            helper2(remainLeft-1, nowLeft+1, sb, r);
            sb.deleteCharAt(sb.length()-1);
        }
        if(nowLeft > 0) {
            sb.append(')');
            helper2(remainLeft, nowLeft-1, sb, r);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
