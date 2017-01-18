package Contest;
import java.util.*;
/**
 * Created by li on 1/15/2017.
 */

/*
        Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.

        Example 1:
        Input: [1,0,1,1,0]
        Output: 4
        Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
        After flipping, the maximum number of consecutive 1s is 4.
        Note:

        The input array will only contain 0 and 1.
        The length of input array is a positive integer and will not exceed 10,000
        Follow up:
        What if the input numbers come in one by one as an infinite stream? In other words, you can't store all numbers
        coming from the stream as it's too large to hold in memory. Could you solve it efficiently?
*/

public class MaxConsecutiveOnesII {

    /**
     * Contest solution
     *
     * */
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null) return 0;
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for(int temp:nums) {
            if(temp == 1) count++;
            else {
                if(count != 0) list.add(count);
                list.add(0);
                count = 0;
            }
        }
        if(count != 0) list.add(count);

        int max = 1;
        for(int i = 0; i < list.size(); i++) {

            if(list.get(i) != 0) {
                if(((i - 1 >= 0) && (list.get(i-1) == 0)) || ((i + 1 < list.size()) && (list.get(i+1) == 0))) {
                    max = Math.max(max, list.get(i)+1);
                }
                else max = Math.max(max, list.get(i));
            } else {
                if((i - 1 >= 0) && (list.get(i-1) != 0) && (i + 1 < list.size()) && (list.get(i+1) != 0)) {

                    max = Math.max(max, list.get(i-1) + list.get(i+1) + 1);
                }
            }
        }
        return max;
    }

    /**
     * 牛逼的解法，只需要两个，因为可以有一个0 flip成1
     * 所以遇到数先把两个count都加1
     * 如果遇到1，没事继续向下走
     * 如果遇到0，tot1里包含了两个0，所以要舍去。tot2因为遇到上一个0时清零了，所以tot1现在应设为tot2。tot2 = 0。
     * */

    public int findMaxConsecutiveOnes1(int[] nums) {
        int tot1 = 0, tot2 = 0;
        int max = 0;
        for(int temp:nums) {
            tot1++;
            tot2++;

            if(temp == 0) {
                tot1 = tot2;
                tot2 = 0;
            }
            max = Math.max(max, tot1);
        }
        return max;
    }
}
