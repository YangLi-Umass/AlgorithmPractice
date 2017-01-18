package SortAndSelection;

/**
 * Created by li on 12/7/2016.
 */
public class QuickSort {
    public static void solution (int[] nums) {
        quickSortHelper(nums, 0, nums.length-1);
    }

    /**
     * 第一次实现的有瑕疵
     * */
    public static void quickSortHelper(int[] nums, int start, int end) {
        int pivot = nums[end];
        int left = start, right = end-1;
        while (true) {
            while (nums[left] < pivot) left++;
            while (right >= start && nums[right] > pivot) right--;
            if(left > right) break;
            else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        //接下来一段可以优化，因为我们存了pivot的值
        int temp = nums[left];
        nums[left] = pivot;
        nums[end] = temp;
        if(start < left-1) quickSortHelper(nums,start,left-1);
        if(left+1 < end) quickSortHelper(nums,left+1,end);
    }

    /**
     * 参考第六版算法书的实现
     * */
    public static void quickSortBetter(int[] nums, int start, int end) {
        if(start >= end) return;
        int pivot = nums[end];
        int left = start, right = end-1;
        int temp;
        while (left <= right) {
            while (left <= right && nums[left] < pivot) left++;
            while (left <= right && nums[right] > pivot) right--;
            if(left <= right) {
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++; right--;
            }
        }
        nums[end] = nums[left];
        nums[left] = pivot;
        quickSortHelper(nums, start, left-1);
        quickSortHelper(nums, left+1, end);
    }
}
