package TwoPointer;

/**
 * Created by li on 1/6/2017.
 */
public class RemoveElement27Jan6 {
    /**
     * Concise but too much useless copy for example
     * [2,5,7,4,1,5,3] val = 3
     * but keep the original order
     * */
    public int removeElement1(int[] nums, int val) {
        int l = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) nums[l++] = nums[i];
        }
        return l;
    }

    /**
     * Better solution if the val is rare
     *
     * */
    public int removeElement2(int[] nums, int val) {
        int l = 0;
        int size = nums.length;
        while(l < size) {
            if(nums[l] == val) {
                nums[l] = nums[--size];
            } else {
                l++;
            }
        }

        return size;
    }

    /**
     * 比前面两个方法都快 避免了所有不必要的write
     *
     * */
    public int removeElement(int[] nums, int val) {
        int l = 0, r = nums.length-1;
        while(l < r) {
            while(l < nums.length && nums[l] != val) l++;
            while(r >= 0 && nums[r] == val) r--;
            if(l < r) {
                nums[l] = nums[r];
                nums[r] = val;
                l++;
                r--;
            } else break;
        }
        if(l == r && nums[l] != val) l++;
        return l;
    }

}
