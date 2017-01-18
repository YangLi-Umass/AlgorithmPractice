package Array;
import java.util.*;
/**
 * Created by li on 1/12/2017.
 */
public class ContainsDuplicateII {
    public class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            if(nums == null) return false;
            Map<Integer,Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++) {
                if(!map.containsKey(nums[i])) map.put(nums[i],i);
                else {
                    if(i - map.get(nums[i]) <= k) return true;
                    else map.put(nums[i],i);
                }
            }
            return false;
        }
    }


    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null) return false;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(i > k) set.remove(nums[i-k-1]);
            if(set.contains(nums[i])) return true;
            else set.add(nums[i]);

            //one line code if(!set.add(nums[j]))  return true;
        }
        return false;
    }
}
