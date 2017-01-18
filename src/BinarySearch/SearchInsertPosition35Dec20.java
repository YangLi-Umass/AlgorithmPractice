package BinarySearch;

/**
 * Created by li on 12/20/2016.
 */
public class SearchInsertPosition35Dec20 {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int l = 0, r = nums.length-1;
        int mid;
        while(l <= r) {
            mid = l + (r-l)/2;
            if(nums[mid] > target) {
                r = mid-1;
            } else if(nums[mid] < target) {
                l = mid+1;
            } else {
                return mid;
            }
        }
        return l;
    }
}
