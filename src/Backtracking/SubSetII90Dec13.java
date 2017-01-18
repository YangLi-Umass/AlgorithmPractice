package Backtracking;

import java.util.*;

/**
 * Created by li on 12/13/2016.
 */
public class SubSetII90Dec13 {
    /**
     * 先排序，然后用set去重
     *
     * */

    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> s = new HashSet<>();
        List<Integer> l = new ArrayList<>();
        helper(nums, 0, s, l);
        return new ArrayList<>(s);
    }

    public void helper(int[] nums, int lowBound, Set<List<Integer>> s, List<Integer> l) {
        s.add(new ArrayList<>(l));
        for(int i = lowBound; i < nums.length; i++) {
            l.add(nums[i]);
            helper(nums, i+1, s, l);
            l.remove(l.size() - 1);
        }
    }

    /**
     * faster implementation
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> r = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        helper(nums, 0, r, l);
        return r;
    }

    public void helper(int[] nums, int lowBound, List<List<Integer>> r, List<Integer> l) {
        r.add(new ArrayList<>(l));
        for(int i = lowBound; i < nums.length; i++) {
            if(i > lowBound && nums[i] == nums[i-1]) {
                continue;
            }
            l.add(nums[i]);
            helper(nums, i+1, r, l);
            l.remove(l.size()-1);
        }
    }
}
