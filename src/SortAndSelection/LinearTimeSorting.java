package SortAndSelection;

import java.util.Arrays;

/**
 * Created by li on 12/8/2016.
 */
public class LinearTimeSorting {

    private static int transfer(int oriNum, int k) {
        /**
         * Get the kth digits
         *
         * */
        int base = 1;
        for (int i = 1; i < k; i++) {
            base *= 10;
        }
        return (oriNum/base) % 10;

    }

    public static void countingSort0to9(int[] nums, int k) {
        int[] counts = new int[10];

        for(int temp:nums) {
            counts[transfer(temp,k)]++;
        }
        int total = 0;
        for(int i = 0; i < counts.length; i++) {
            int temp = counts[i];
            counts[i] = total;
            total += temp;
        }

        int[] helper = Arrays.copyOf(nums,nums.length);
        for(int temp:helper) {
            nums[counts[transfer(temp,k)]++] = temp;
        }
    }

    public static void radixSortBase10Digits(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int temp:nums) {
            max = Math.max(temp,max);
        }
        int digits = 1, base = 1;
        while (max > base) {
            countingSort0to9(nums, digits);
            digits++;
            base *= 10;
        }
    }
}
