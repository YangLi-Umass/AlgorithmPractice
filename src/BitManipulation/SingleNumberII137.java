package BitManipulation;

/**
 * Created by li on 11/17/2016.
 */
public class SingleNumberII137 {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int temp:nums) {
            twos = (twos & (~ones) & (~temp)) | ((~twos) & ones & temp);
            ones = (~twos) & (ones ^ temp);
        }
        return ones;
    }
}
