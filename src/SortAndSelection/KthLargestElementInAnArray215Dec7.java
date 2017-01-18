package SortAndSelection;

import java.util.Random;

/**
 * Created by li on 12/7/2016.
 */
public class KthLargestElementInAnArray215Dec7 {

    /**
     * 第一次写的
     * */
    public int quickSortSelectionHelper(int[] nums, int start, int end, int k) {
        if(start == end) {
            if(start == k-1) return nums[start];
            else return -909;
        }
        int pivot = nums[end];
        int left = start, right = end-1;
        while (left <= right) {
            while (nums[left] < pivot) left++;
            while (nums[right] > pivot) right--;
            if(left > right) break;
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        if(left == k-1) return pivot;
        else {
            int temp = nums[left];
            nums[left] = pivot;
            nums[end] = temp;
            if(left < k-1) return   quickSortSelectionHelper(nums, start, left-1, k);
            else return  quickSortSelectionHelper(nums, left+1, end, k);
        }

    }
    /**
     * 第二次写的
     *
     * 改进，如果只选择最后一位作为pivot， 在原数组应经排好序的情况下run time is quadratic
     * 用Random来随机选取pivot
     * */

    public static int findKthLargest1(int[] nums, int k) {
        return helper1(nums, 0, nums.length-1, nums.length-k+1);
    }

    public static int helper1(int[] nums, int start, int end, int k) {
        if(start == end && start == k-1) return nums[start];

        Random r = new Random();
        int pivotIndex = r.nextInt(end-start+1)+start;

        int pivot = nums[pivotIndex];
        nums[pivotIndex] = nums[end];
        nums[end] = pivot;

        int left = start, right = end-1;
        int temp;
        while (left <= right) {
            while (left <= right && nums[left] < pivot) left++;
            while (left <= right && nums[right] > pivot) right--;
            if(left <= right) {
                temp = nums[left]; nums[left] = nums[right]; nums[right] = temp;
                left++; right--;
            }
        }
        if(left == k-1) return pivot;
        else {
            nums[end] = nums[left];
            nums[left] = pivot;
            if(left < k-1) return helper1(nums, left+1, end, k);
            else return helper1(nums, start, left-1, k);
        }

    }

    /**
     * Leetcode上的解法
     * 用median of three来handle 原数组早已经排好顺序的情况
     * 1ms
     * */
    public static int findKthLargest(int[] nums, int k) {
        return helper(nums, 0, nums.length-1, nums.length-k+1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int choosePivotIndex(int[] nums, int start, int end) {
        int mid = (start+end)/2;
        if(nums[start] > nums[end]) swap(nums, start, end);
        if(nums[mid] > nums[end]) swap(nums, mid, end);
        if(nums[start] > nums[mid]) swap(nums, start, mid);
        return mid;
    }

    public static int helper(int[] nums, int start, int end, int k) {
        if(start == end && start == k-1) return nums[start];


        int pivotIndex = choosePivotIndex(nums, start, end);

        int pivot = nums[pivotIndex];
        nums[pivotIndex] = nums[end];
        nums[end] = pivot;

        int left = start, right = end-1;
        int temp;
        while (left <= right) {
            while (left <= right && nums[left] < pivot) left++;
            while (left <= right && nums[right] > pivot) right--;
            if(left <= right) {
                temp = nums[left]; nums[left] = nums[right]; nums[right] = temp;
                left++; right--;
            }
        }
        if(left == k-1) return pivot;
        else {
            nums[end] = nums[left];
            nums[left] = pivot;
            if(left < k-1) return helper(nums, left+1, end, k);
            else return helper(nums, start, left-1, k);
        }

    }

}
