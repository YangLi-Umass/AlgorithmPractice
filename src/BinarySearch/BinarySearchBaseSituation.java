package BinarySearch;

/**
 * Created by li on 12/19/2016.
 */
public class BinarySearchBaseSituation {

    /**
     * Assumption: the input is sorted in ascending order
     * 如果没找到，那么返回不满足条件的第一个index上，即应插入的位置，为了区分找到没找到，返回-(index+1)；
     * */
    public int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        int mid;
        while (l <= r) {
            mid = l + (r-l)/2;
            if(nums[mid] > target) {
                r = mid-1;
            } else if(nums[mid] < target) {
                l = mid+1;
            } else {
                return mid;
            }
        }
        return -(l+1);
    }

    /***
     * 找到第一个大于target数的下标。
     *
     *
     */
    public int findCeiling(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        int mid;
        while (l < r) {
            mid = l + (r-l)/2;
            if(nums[mid] > target) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return l;
    }

    /***
     * 找到第一个大于等于target数的下标。
     *
     *
     */
    public int findLossCeiling(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        int mid;
        while (l < r) {
            mid = l + (r-l)/2;
            if(nums[mid] >= target) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return l;
    }

    /**
     * find floor
     * 找到最后一个小于target的数
     *
     * */
    public int findFloor(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        int mid;
        while (l < r) {
            mid = l + (r-l+1)/2;
            if(nums[mid] < target) {
                l = mid;
            } else {
                r = mid-1;
            }
        }
        return l;
    }

    /**
     * 找到最后一个小于等于target的数
     *
     * */
    public int findLossFloor(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        int mid;
        while (l < r) {
            mid = l + (r-l+1)/2;
            if(nums[mid] <= target) {
                l = mid;
            } else {
                r = mid-1;
            }
        }
        return l;
    }
}
