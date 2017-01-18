package SortAndSelection;

import java.util.AbstractCollection;
import java.util.Arrays;

/**
 * Created by li on 12/8/2016.
 */
public class MaximalGap164Dec8 {
    public int maximumGap(int[] nums) {
        /**
         * 本题实现要点
         * 1. 如果去计算答案的最小可能值？ ceil(最大数-最小数然后除以n-1) 注意double int类型的转变
         * 2. 答案最小可能值即bucket的大小，一共有n-1个bucket，不用吧min和max放入其中
         * 3. 注意要跳过空的bucket
         * 4. 遍历结束后记得还要 max-previous
         *
         * Runtiem 9s,6s Dec8
         * */



        if(nums == null || nums.length < 2) return 0;
        int max = nums[0],min = nums[0];
        for(int temp:nums) {
            max = Math.max(max, temp);
            min = Math.min(min,temp);
        }
        int aveGap = (int)Math.ceil(((double)(max-min))/(nums.length-1));
        int[] minBucket = new int[nums.length-1];
        int[] maxBucket = new int[nums.length-1];
        Arrays.fill(minBucket,Integer.MAX_VALUE);
        Arrays.fill(maxBucket,Integer.MIN_VALUE);
        for(int temp:nums) {
            if(temp == min || temp == max) continue;
            int index = (temp-min)/aveGap;
            minBucket[index] = Math.min(temp, minBucket[index]);
            maxBucket[index] = Math.max(temp, maxBucket[index]);
        }

        int maxGap = aveGap;
        int previous = min;
        for(int i = 0; i < nums.length-1; i++) {
            if(minBucket[i] == Integer.MAX_VALUE && maxBucket[i] == Integer.MIN_VALUE) continue;
            maxGap = Math.max(maxGap, minBucket[i]-previous);
            previous = maxBucket[i];
        }

        maxGap = Math.max(maxGap, max-previous);

        return maxGap;
    }
}
