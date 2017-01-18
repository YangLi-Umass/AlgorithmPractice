package BinarySearch;

/**
 * Created by li on 12/20/2016.
 */
public class SearchInRotatedSortedArray33Dec20 {

    public int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length-1);
    }

    public int helper(int[] nums, int target, int left, int right) {
        if(left == right) {
            if(nums[left] == target) return left;
            else return -1;
        }

        int mid = (left+right)/2;
        if(nums[mid] == target) return mid;

        if(nums[left] <= nums[mid]) {
            if(target >= nums[left] && target <= nums[mid]) return helper(nums, target, left, mid-1);
            else return helper(nums, target, mid+1, right);
        } else {
            if(target >= nums[mid] && target <= nums[right]) return helper(nums, target, mid+1, right);
            else return helper(nums, target, left, mid-1);
        }

    }

    /**
     * 第二种 iteration
     *
     * */

    public int search2(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length-1;
        int mid;
        while( l <= r) {
            mid = l + (r-l)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] >= nums[l]) {     //注意这里是大于等于
                if(nums[mid] > target && target >= nums[l]) {
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            } else {
                if(nums[mid] < target && target <= nums[r]) {
                    l = mid+1;
                } else {
                    r = mid-1;
                }
            }
        }
        return -1;
    }
}
