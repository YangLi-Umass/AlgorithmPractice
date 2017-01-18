package Array;
import java.util.*;
/**
 * Created by li on 1/13/2017.
 */
public class SummaryRange228Jan13 {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new LinkedList<>();
        if(nums == null || nums.length == 0) return list;
        int head = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]+1) {
                //new head appears
                if(nums[i-1] == head) {
                    list.add(String.valueOf(head));
                } else {
                    list.add(head + "->" + nums[i-1]);
                }
                head = nums[i];
            }
        }

        if(nums[nums.length-1] == head) {
            list.add(String.valueOf(head));
        } else {
            list.add(head + "->" + nums[nums.length-1]);
        }
        return list;
    }

    /**
     * More concise
     * */

    public List<String> summaryRanges1(int[] nums) {
        List<String> list = new LinkedList<>();
        if(nums == null) return list;
        int i = 0;
        while(i < nums.length) {
            int head = nums[i++];
            while(i < nums.length && nums[i] - nums[i-1] == 1) i++;
            if(nums[i-1] == head) list.add(String.valueOf(head));
            else list.add(head + "->" + nums[i-1]);
        }
        return list;
    }
}
