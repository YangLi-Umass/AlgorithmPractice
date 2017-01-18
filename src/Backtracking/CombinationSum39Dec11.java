package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by li on 9/13/2016.
 */
public class CombinationSum39Dec11 {

    /**
     * 这一边应该是按照cc150上的思路写的 Sep11
     * */
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        //1.SortAndSelection candidates
        //2.Target minus a candidate(from small to large)
        if (candidates.length == 0) return null;
        Arrays.sort(candidates);
        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> currentList = new ArrayList<>();
        helper(candidates, target, 0, currentList, result);
        return result;
    }

    public void helper(int[] candidates, int currentTarget, int candidateIndex, ArrayList<Integer> currentList, ArrayList<List<Integer>> lists) {
        for (int i = candidateIndex; i < candidates.length; i++) {
            if (currentTarget - candidates[i] < 0) return;
            else if (currentTarget - candidates[i] == 0) {
                currentList.add(candidates[i]);
                lists.add(currentList);
            } else {
                ArrayList<Integer> newList = (ArrayList<Integer>) currentList.clone();
                newList.add(candidates[i]);
                helper(candidates, currentTarget-candidates[i], i, newList, lists);
            }
        }
    }

    /**
     * Dec11
     *
     *
     * */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> l = new ArrayList<>();
        List<List<Integer>> r = new ArrayList<>();
        helper(candidates, target, 0, l, r);
        return r;
    }

    public void helper(int[] c, int nowT, int lowBound, List<Integer> l, List<List<Integer>> r) {
        for(int i = lowBound; i < c.length; i++) {
            if(nowT > c[i]) {
                l.add(c[i]);
                helper(c, nowT-c[i], i, l, r);
                l.remove(l.size()-1);
            } else if(nowT == c[i]) {
                l.add(c[i]);
                r.add(new ArrayList<>(l));
                l.remove(l.size()-1);
            } else {
                break;
            }

        }
    }
}
