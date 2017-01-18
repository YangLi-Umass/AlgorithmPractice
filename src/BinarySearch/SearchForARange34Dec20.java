package BinarySearch;

/**
 * Created by li on 12/20/2016.
 */
public class SearchForARange34Dec20 {

    /**
     * 第一种方法 先找target的lossCeil 即第一个等于或大于target的数
     * 如果   找到的数不等于target，即数组中没有target，返回{-1，-1}
     *               等于target，那么这是下界
     * 下一步找第一个大于或等于target+1的数
     * 如果   找到的数大于target，那么其index-1即为上界，
     *       如果找到的数不大于target，那么index即为上界。因为数组里没有大于等于target+1的数
     *
     * */
    public int[] searchRange(int[] nums, int target) {
        int[] r = {-1,-1};
        if(nums == null || nums.length == 0) return r;
        int low = lossCeil(nums, target);
        if(nums[low] != target) return r;
        int high = lossCeil(nums, target+1);
        if(nums[high] > target) high--;
        r[0] = low; r[1] = high;
        return r;
    }

    public int lossCeil(int[] nums, int t) {
        int l = 0, r = nums.length-1;
        int mid;
        while(l < r) {
            mid = l + (r-l)/2;
            if(nums[mid] >= t) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return l;
    }

    /**
     * 第二种方法，先找打第一个大于等于target的数，再找到最后一个小于等于target的数。
     *
     * */

    public int[] searchRange2(int[] nums, int target) {
        int[] r = {-1,-1};
        if(nums == null || nums.length == 0) return r;
        int low = lossCeil(nums, target);
        if(nums[low] != target) return r;
        int high = lossFloor(nums, target);
        r[0] = low; r[1] = high;
        return r;
    }


    public int lossFloor(int[] nums, int t) {
        int l = 0, r = nums.length-1;
        int mid;
        while (l < r) {
            mid = l + (r-l+1)/2;
            if(nums[mid] <= t) {
                l = mid;
            } else {
                r = mid-1;
            }
        }
        return l;
    }
}
