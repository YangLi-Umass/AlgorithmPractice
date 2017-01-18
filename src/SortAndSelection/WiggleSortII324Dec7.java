package SortAndSelection;

import java.util.Arrays;

/**
 * Created by li on 12/7/2016.
 */
public class WiggleSortII324Dec7 {

    /**
     * 简单的解法 Runtime O(nlogn) Space O(n)
     *
     * */
    public void wiggleSort1(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int[] helper = Arrays.copyOf(nums, nums.length);

        int j = len-1;
        for(int i = 0; 2*i+1 < len; i++) {
            nums[2*i+1] = helper[j];
            j--;
        }

        for(int i = 0; 2*i < len; i++) {
            nums[2*i] = helper[j];
            j--;
        }
    }
    /**
     * 复杂解法 RunTime O(n) Space O(1)
     * 运用了index transfer
     *
     * */


    public static int transfer(int i, int total) {
        return (2*i + 1) % (total | 1);
    }

    public void wiggleSort(int[] nums) {
        int median = findKthLargestElement(nums,0,nums.length-1,(nums.length+1)/2);
        System.out.println(median);
        int left = 0, mid = 0, right = nums.length-1;
        while (mid <= right) {
            if(nums[transfer(mid, nums.length)] > median) {
                swap(nums,transfer(mid,nums.length),transfer(left,nums.length));
                left++;
                mid++;
            } else if(nums[transfer(mid, nums.length)] < median) {
                swap(nums,transfer(mid,nums.length),transfer(right,nums.length));
                right--;
            } else {
                mid++;
            }

        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int choosePivotMedianOfThree(int[] nums, int start, int end) {
        int mid = (start+end)/2;
        if(nums[start] > nums[end]) swap(nums,start,end);
        if(nums[mid] > nums[end]) swap(nums,mid,end);
        if(nums[start] > nums[mid]) swap(nums,start,mid);
        return mid;
    }


    private int findKthLargestElement(int[] nums, int start, int end, int k) {
        int pivotIndex = choosePivotMedianOfThree(nums, start, end);
        swap(nums, pivotIndex, end);

        int pivot = nums[end];
        int left = start, right = end-1;
        while (left <= right) {
            while (left <= right && nums[left] > pivot) left++;
            while (left <= right && nums[right] < pivot) right--;
            if(left <= right) {
                swap(nums,left,right);
                left++; right--;
            }
        }
        if(left == k-1) return pivot;
        else {
            swap(nums,left,end);
            if(left < k-1) return findKthLargestElement(nums,left+1,end,k);
            else return findKthLargestElement(nums,start,left-1,k);
        }

    }
}
