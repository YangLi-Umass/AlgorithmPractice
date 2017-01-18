package BinarySearch;

/**
 * Created by li on 12/20/2016.
 */
public class SearchInRotatedSortedArrayII81Dec20 {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int l = 0, r = nums.length-1;
        int mid;
        while( l <= r) {
            mid = l + (r-l)/2;
            if(nums[mid] == target) return true;
            else if(nums[mid] > nums[l]) {
                if(nums[mid] > target && target >= nums[l]) {
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            } else if (nums[mid] < nums[l]){   //都只和left比较
                if(nums[mid] < target && target <= nums[r]) {
                    l = mid+1;
                } else {
                    r = mid-1;
                }
            } else {
                l++;
            }
        }
        return false;
    }


}
