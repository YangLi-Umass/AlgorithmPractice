package BinarySearch;

/**
 * Created by li on 12/8/2016.
 */
public class FindMinimumInRotatedSortedArray153Dec8 {
    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    public int helper(int[] nums, int start, int end) {
        if(start == end) return nums[start];
        if(end - start == 1) return Math.min(nums[start], nums[end]);
        int mid = (start+end)/2;

        if(nums[mid] < nums[mid-1]) return nums[mid];
        else if(nums[mid] > nums[start] && nums[mid] > nums[end]) return helper(nums, mid+1, end);
        else if (nums[mid] < nums[start] && nums[mid] < nums[end]) return helper(nums, start, mid-1);
        else return nums[start];
    }

    public int findMin2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int l = 0, r = nums.length-1;
        int mid;
        while(l < r) {
            mid = l + (r-l)/2;
            if(mid == l) return Math.min(nums[l],nums[r]);
            else if(nums[mid] < nums[mid-1]) return nums[mid];
            else if(nums[mid] < nums[l] && nums[mid] < nums[r]) r = mid-1;
            else if(nums[mid] > nums[l] && nums[mid] > nums[r]) l = mid+1;
            else {
                return nums[l];
            }
        }
        return nums[l];

    }

    /**
     * more concise
     *
     *
     * @param nums
     * @return
     */
    public int findMin3(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int l = 0, r = nums.length-1;
        int mid;
        while(l < r && nums[l] > nums[r]) {
            mid = l + (r-l)/2;
            if(nums[mid] >= nums[l]) {
                l = mid+1;
            } else {
                r= mid;
            }
        }
        return nums[l];

    }


}
