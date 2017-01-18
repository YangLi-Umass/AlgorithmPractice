package TwoPointer;

/**
 * Created by li on 12/10/2016.
 */
public class MoveZeros283Dec10 {
    public void moveZeroes(int[] nums) {
        int zeroPointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                if(i != zeroPointer) {
                    nums[zeroPointer] = nums[i];
                    nums[i] = 0;

                }
                zeroPointer++;
            }
        }
    }

    public void moveZeroesXiaoLaJi(int[] nums) {
        int countZero = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) countZero++;
            else {
                nums[i-countZero] = nums[i];
            }
        }

        for(int i = nums.length - countZero; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroesLaJi(int[] nums) {
        int len = nums.length;
        int countZero = 0;
        for(int i = len-1; i >= 0; i--){
            if(nums[i] != 0) continue;
            else {
                countZero++;
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
