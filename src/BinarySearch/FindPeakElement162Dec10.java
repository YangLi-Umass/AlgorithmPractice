package BinarySearch;

/**
 * Created by li on 12/10/2016.
 */
public class FindPeakElement162Dec10 {
    public int findPeakElement1(int[] nums) {
        for(int i = 0; i < nums.length-1; i++) {
            if(nums[i] > nums[i+1]) {
                return i;
            }
        }
        return nums.length-1;
    }

    public int findPeakElement2(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    public int helper(int[] nums, int l, int r) {
        if(l == r) return l;
        int mid = l + (r-l)/2;
        if(nums[mid] > nums[mid+1]) {
            return helper(nums, l, mid);
        } else {
            return helper(nums,mid+1,r);
        }
    }

    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length-1;
        while(l < r) {
            int mid = l + (r-l)/2;
            if(nums[mid] > nums[mid+1]) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return l;
    }
}
