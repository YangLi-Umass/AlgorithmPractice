package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by li on 10/12/2016.
 */
public class TwoSum1Otc12 {
    /**
     * Dec21
     *
     * */
    public int[] twoSum(int[] nums, int target) {
        int[] r = {-1,-1};
        if(nums == null || nums.length < 2) return r;
        Map<Integer,Integer> m = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(m.containsKey(target-nums[i])){
                r[0] = m.get(target-nums[i]);
                r[1] = i;
                return r;
            } else {
                m.put(nums[i], i);
            }
        }
        return r;
    }



    public int[] twoSum1(int[] nums, int target) {
        //本种思路，先对原来数组排序。时间复杂度 O(nlog(n))。
        //然后对排完序的数组采用从两边相加与target比较的方法来找complement。时间复杂度 O(n)。
        //最后在原数组中找到对应的原下标
        int[] oriNums = nums.clone();
        Arrays.sort(nums);
        int i = 0, j = nums.length -1;
        while (i < j) {
            if(nums[i] + nums[j] > target) {
                j--;
            } else if(nums[i] + nums[j] < target) {
                i++;
            } else {
                if(nums[i] == nums[j]) {
                    int k = 0;
                    for (; k < nums.length; k++){
                        if (oriNums[k] == nums[i]){
                            i = k;
                            break;
                        }
                    }
                    for (k=k+1; k < nums.length; k++){
                        if (oriNums[k] == nums[i]){
                            j = k;
                            break;
                        }
                    }
                } else {
                    for (int k = 0; k < nums.length; k++) {
                        if(oriNums[k] == nums[i]) {
                            i=k;
                            break;
                        }
                    }

                    for (int k = 0; k < nums.length; k++) {
                        if (oriNums[k] == nums[j]) {
                            j=k;
                            break;
                        }
                    }

                    if (i>j) {
                        int temp = i;
                        i=j;
                        j=temp;
                    }
                }

                int[] result = {i,j};
                return result;
            }
        }
        int[] result = {-1,-1};
        return result;
    }

    public int[] twoSumHashtable(int[] nums, int target) {
        //用Hashtable在找complement的时候，注意只有一个3目标是6的这种情况。
        //这种用到了更加复杂的数据结构，虽然时间复杂度看起来是O(n)，但是当数据量较小的时候，
        //实际的运行时间可能比上边的长一点。

        //白板错误：
        //1. import java.util.Hashtable;
        //2. Hashtable 拼写，其是一个单词，t要小写
        //3. Hashtable 类的method，get，put，containsKey。
        //4. 注意变量的初始化问题
        Hashtable<Integer,Integer> h = new Hashtable<>();
        for(int i = 0; i < nums.length; i++) {
            h.put(nums[i],i);
        }
        int complement;
        int complementIndex = -1;
        int i = 0;
        for(; i < nums.length; i++) {
            complement = target - nums[i];
            if(h.containsKey(complement)) {
                complementIndex = h.get(complement);
                if (i == complementIndex) {
                    continue;
                } else {
                    break;
                }

            }
        }
        int[] result = {Math.min(i,complementIndex),Math.max(i,complementIndex)};
        return result;
    }


}
