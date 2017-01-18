package BinarySearch;

/**
 * Created by li on 12/9/2016.
 */
public class FindTheDuplicateNumber287Dec9 {
    /**
     * Cycle detection
     * 一个数组有n个数，每个数从[1,n-1]里面取值
     *
     *
     * */
    public int findDuplicate1(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }

    /**
     * 用binary search
     * 记录小于等于mid的数，如果其个数小于等于mid，说明范围变为[mid+1,end]
     * 否则[start,mid] 这样子mid变成上界，不会重复取mid。
     * */
    public int findDuplicate2(int[] nums) {
        return helper(nums, 1, nums.length-1);
    }

    public int helper(int[] nums, int start, int end) {
        if(start == end) return start;
        int mid = (start+end)/2;
        int count = 0;
        for(int temp:nums) {
            if(temp<=mid) count++;
        }

        if(count <= mid) return helper(nums, mid+1, end);
        else return helper(nums, start, mid);
    }

    /**
     * Binary search
     * 用iterator的方法写一遍
     *
     * */
    public int findDuplicate(int[] nums) {
        int low = 1, high = nums.length-1;
        while (low < high) {
            int mid = (low+high)/2;
            int count = 0;
            for(int temp:nums) {
                if(temp<=mid) count++;
            }
            if(count <= mid) low = mid+1;
            else high = mid;
        }
        return low;
    }
}
