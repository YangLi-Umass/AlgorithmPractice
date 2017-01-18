package Contest;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by li on 1/9/2017.
 */
/*    Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value.
      So the median is the mean of the two middle value.

            Examples:
            [2,3,4] , the median is 3

            [2,3], the median is (2 + 3) / 2 = 2.5

    Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
    You can only see the k numbers in the window. Each time the sliding window moves right by one position.
    Your job is to output the median array for each window in the original array.

    For example,
    Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

        Window position                 Median
        ---------------                 -----
        [1  3  -1] -3  5  3  6  7       1
         1 [3  -1  -3] 5  3  6  7       -1
         1  3 [-1  -3  5] 3  6  7       -1
         1  3  -1 [-3  5  3] 6  7       3
         1  3  -1  -3 [5  3  6] 7       5
         1  3  -1  -3  5 [3  6  7]      6
    Therefore, return the median sliding window as [1,-1,-1,3,5,6].

    Note:
    You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.*/


public class SlidingWindowMedian480Jan9 {

    /**
     * Faster than OO design
     *
     * */
    public double[] medianSlidingWindow(int[] nums, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for(int i = 0; i < k; i++) {
            maxHeap.offer(nums[i]);
        }

        while(maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }

        double[] r = new double[nums.length-k+1];

        r[0] = getM(maxHeap, minHeap, k);
        int j = 1;

        for(int i = k; i < nums.length; i++) {
            if(!maxHeap.isEmpty() && nums[i-k] <= maxHeap.peek()){
                maxHeap.remove(nums[i-k]);
            } else {
                minHeap.remove(nums[i-k]);
            }
            if(!maxHeap.isEmpty() && nums[i] <= maxHeap.peek()){
                maxHeap.offer(nums[i]);
            } else {
                minHeap.offer(nums[i]);
            }


            while(maxHeap.size() > minHeap.size()) {
                minHeap.offer(maxHeap.poll());
            }

            while(minHeap.size() - maxHeap.size() > 1) {
                maxHeap.offer(minHeap.poll());
            }

            r[j] = getM(maxHeap,minHeap,k);
            j++;

        }
        return r;

    }

    public double getM(PriorityQueue<Integer> max, PriorityQueue<Integer> min, int k) {
        double median = min.peek();
        if(k % 2 == 0) median = median + (double)(max.peek() - median)/2;
        return median;
    }


    /**
     * Object orientated design
     *
     * */
    private static class Helper{
        int size;
        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;

        Helper(int[] nums, int l, int r) {
            // r must be larger than or equal to l
            size = r-l+1;
            maxHeap = new PriorityQueue<>(size, Collections.reverseOrder());
            minHeap = new PriorityQueue<>();
            for(int i = l; i <= r; i++) {
                maxHeap.offer(nums[i]);
            }
            balance();
        }

        void add(int a) {
            if(!maxHeap.isEmpty() && a <= maxHeap.peek()) {
                maxHeap.offer(a);
            } else {
                minHeap.offer(a);
            }
            balance();
            size++;
        }

        void remove(int b) {
            if(!maxHeap.isEmpty() && b <= maxHeap.peek()){
                maxHeap.remove(b);
            } else {
                minHeap.remove(b);
            }
            balance();
            size--;
        }

        double getMedian(){
            if(size % 2 == 1) return minHeap.peek();
            else return maxHeap.peek() + ((double)minHeap.peek() - maxHeap.peek())/2;
        }


        void balance(){
            while(maxHeap.size() > minHeap.size()){
                minHeap.offer(maxHeap.poll());
            }

            while(minHeap.size() - maxHeap.size() > 1) {
                maxHeap.offer(minHeap.poll());
            }

        }

    }


    public double[] medianSlidingWindow1(int[] nums, int k) {
        if(k == 0 || nums == null || nums.length < k) return null;
        Helper h = new Helper(nums, 0, k-1);
        double[] r = new double[nums.length-k+1];
        r[0] = h.getMedian();
        for(int i = k; i < nums.length; i++) {
            h.remove(nums[i-k]);
            h.add(nums[i]);
            r[i-k+1] = h.getMedian();
        }
        return r;

    }
}
