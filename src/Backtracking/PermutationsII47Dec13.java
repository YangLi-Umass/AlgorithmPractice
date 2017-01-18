package Backtracking;
import java.util.*;
/**
 * Created by li on 12/13/2016.
 */
public class PermutationsII47Dec13 {
    /**
     * 当有duplicate之后，跳过重复的条件很关键
     * 第一当这个元素用过的时候不能用了
     * 第二当这个元素何其之前元素相等且！！！！其之前的元素没有被用过的时候不能用！！！！
     *
     * */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> r = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        helper(nums, flag, l, r);
        return r;
    }

    public void helper(int[] nums, boolean[] flag, List<Integer> l, List<List<Integer>> r) {
        if(l.size() == nums.length){
            r.add(new ArrayList<>(l));

            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(flag[i] || (i > 0 && nums[i] == nums[i-1] && !flag[i - 1])) continue;
            l.add(nums[i]);
            flag[i] = true;
            helper(nums, flag, l, r);
            l.remove(l.size()-1);
            flag[i] = false;
        }
    }
}
