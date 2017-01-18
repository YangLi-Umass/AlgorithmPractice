package Backtracking;

import java.util.*;
/**
 * Created by li on 12/13/2016.
 */
public class Permutation46Dec13 {

    /***
     * 用了一个额外的Set，主要想依靠于contains() method
     * @param nums
     * @return
     */
    public List<List<Integer>> permute1(int[] nums) {
        Set<Integer> s = new HashSet<>();
        List<List<Integer>> r = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        helper(nums, s, r, l);
        return r;
    }

    public void helper(int[] nums, Set<Integer> s, List<List<Integer>> r, List<Integer> l) {
        if(s.size() == nums.length) {
            r.add(new ArrayList<>(l));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(s.contains(nums[i])) continue;
            l.add(nums[i]);
            s.add(nums[i]);
            helper(nums, s, r, l);
            l.remove(l.size() - 1);
            s.remove(nums[i]);
        }

    }

    /***
     * Better solution
     * ArrayList自己也有contains() method
     */

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> r = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        helper(nums, r, l);
        return r;
    }

    public void helper(int[] nums, List<List<Integer>> r, List<Integer> l) {
        if(l.size() == nums.length) {
            r.add(new ArrayList<>(l));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(l.contains(nums[i])) continue;
            l.add(nums[i]);
            helper(nums, r, l);
            l.remove(l.size() - 1);
        }

    }
}
