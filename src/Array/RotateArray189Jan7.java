package Array;

/**
 * Created by li on 1/7/2017.
 */
public class RotateArray189Jan7 {
    /**
     * 4种解法
     * 第一种brute force
     * 第二种用额外的空间
     * 第三种直接把数放到该去的地方  注意会有几次循环？ 每次循环的中止条件是什么
     *
     * */
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) return;
        k = k%nums.length;
        if(k == 0) return;
        int passNo = findGCD(nums.length,k);

        for(int i = 0; i < passNo; i++) {
            int val = nums[i];
            int des = (i+k)%nums.length;
            while(true){
                int temp = nums[des];
                nums[des] = val;
                if(des == i) break;
                des = (des+k)%nums.length;
                val = temp;
            }
        }
    }

    public int findGCD(int a, int b) {
        return a == 0 || b == 0 ? a+b : findGCD(b, a%b);
    }

    /**
     * 通过reverse数组的方法来实现
     *
     * */

    public void rotate1(int[] nums, int k) {
        if(nums == null || nums.length == 0) return;
        k = k % nums.length;
        if(k == 0) return;
        revise(nums, 0, nums.length-1);
        revise(nums, 0, k-1);
        revise(nums, k, nums.length-1);
    }

    public void revise(int[] nums, int l, int r) {
        if(l >= r) return;
        int time = (r-l+1)/2;
        for(int i = 0; i < time; i++) {
            int temp = nums[l+i];
            nums[l+i] = nums[r-i];
            nums[r-i] = temp;

            //位运算交换两个数 也许更快 也许更慢
            //nums[l+i] = nums[l+i] ^ nums[r-i];
            //nums[r-i] = nums[l+i] ^ nums[r-i];
            //nums[l+i] = nums[l+i] ^ nums[r-i];
        }
    }
}
