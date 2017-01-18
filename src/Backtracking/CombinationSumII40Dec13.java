package Backtracking;
import java.util.*;
/**
 * Created by li on 12/13/2016.
 */
public class CombinationSumII40Dec13 {
    /**
     *
     *
     * */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> r = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        helper(candidates, 0, target, l, r);
        return r;
    }

    public void helper(int[] n, int start, int remainT, List<Integer> l, List<List<Integer>> r) {
        for(int i = start; i < n.length; i++) {
            if(i > start && n[i] == n[i-1]) continue;
            if(n[i] < remainT) {
                l.add(n[i]);
                helper(n, i+1, remainT-n[i], l, r);     //注意这一句里面是i+1而不是start+1
                l.remove(l.size() - 1);
            } else if (n[i] == remainT) {
                l.add(n[i]);
                r.add(new ArrayList<>(l));
                l.remove(l.size() - 1);
                return;
            } else {
                return;
            }
        }
    }
}
