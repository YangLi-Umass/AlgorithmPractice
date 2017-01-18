package Array;

/**
 * Created by li on 10/14/2016.
 */
public class MoveZeros283Otc14 {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        for(int i = len-1; i >= 0; i--){
            if(nums[i] != 0) continue;
            else {
                for(int j = i+1; j < len; j++) {
                    if(nums[j] != 0) {
                        int temp = nums[j];
                        nums[j] = nums[j-1];
                        nums[j-1] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
