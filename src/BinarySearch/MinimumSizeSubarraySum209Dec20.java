package BinarySearch;

/**
 * Created by li on 12/20/2016.
 */
public class MinimumSizeSubarraySum209Dec20 {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int l = 0, r = 0, sum = nums[0];
        int min = Integer.MAX_VALUE;
        while(r < nums.length) {
            while(r < nums.length-1 && sum < s) {
                sum += nums[++r];
            }

            if(sum < s) break;
            while(l < r && sum >= s) {
                sum -= nums[l++];
            }
            if(sum >= s) return 1;
            if(r-l+2 < min) min = r-l+2;
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    /**
     * NlogN算法
     *
     *
     * */
    public int minSubArrayLenLogN(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] sums = new int[nums.length+1];
        for(int i = 0; i < nums.length; i++) {
            sums[i+1] = sums[i] + nums[i];
        }
        int min = Integer.MAX_VALUE;
        int j;
        for(int i = 0; i < nums.length; i++) {
            j = helper(sums, sums[i]+s);
            if(sums[j] >= sums[i]+s) {
                if(j-i < min) min = j-i;
            } else {
                break;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int helper(int[] a, int t) {
        int l = 0, r = a.length-1;
        int mid;
        while(l < r) {
            mid = l + (r-l)/2;
            if(a[mid] >= t) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return l;
    }
}
