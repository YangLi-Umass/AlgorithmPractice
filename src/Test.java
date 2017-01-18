import BinarySearch.BinarySearchBaseSituation;
import BinarySearch.Search2dMatrixII240Dec9;
import BitManipulation.SingleNumberII137;
import BreadthFirstSearch.PerfectSquares279;
import Contest.ZumaGame488Jan14;
import Graph.AlineDictionary269;
import Graph.CourseSchedule207;
import Graph.ReconstructItinerary332;
import HelperUtility.Search;
import MyString.ValidParentheses20Dec11;
import SortAndSelection.KthLargestElementInAnArray215Dec7;
import SortAndSelection.LinearTimeSorting;
import SortAndSelection.QuickSort;
import SortAndSelection.WiggleSortII324Dec7;


import java.util.Arrays;
import java.util.Collections;

/**
 * Created by li on 7/14/2016.
 */
public class Test {
    public static void main(String[] args) {
/*        int[] num = {-2,0,3,-5,2,-1};
        RangeSumQueryImmutable303 a = new RangeSumQueryImmutable303(num);
        System.out.println(a.dp[0]);
        System.out.println(a.dp[1]);
        System.out.println(a.dp[2]);
        System.out.println(a.dp[3]);
        System.out.println(a.dp[4]);
        System.out.println(a.dp[5]);


        System.out.println(a.sumRange(0,2));
        System.out.println(a.sumRange(2,5));
        System.out.println(a.sumRange(0,5));*/

/*        CombinationSum39Dec11 combinationSum39 = new CombinationSum39Dec11();
        int[] candidates  = {2,6,3,7};
        List<List<Integer>> result;
        result = combinationSum39.combinationSum(candidates, 7);*/

/*        CombinationSumIV377 combinationSumIV377 = new CombinationSumIV377();
        int[] nums = {4,2,1};
        Arrays.sort(nums);
        //combinationSumIV377.combinationSum4(nums, 32);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(2);
        arrayList.add(4);
        arrayList.add(4);
        arrayList.add(4);
        arrayList.add(4);
        arrayList.add(4);
        arrayList.add(4);
        arrayList.add(4);
        arrayList.add(4);
        arrayList.add(4);

        combinationSumIV377.computePermutations(nums, arrayList);*/

/*        MaximalSquare221Oct11 maximalSquare221Oct11 = new MaximalSquare221Oct11();
        int[][] nums = {{1,0,1,0,0}, {1,0,1,1,1}, {1,1,1,1,1}, {1,0,0,1,0}};
        int result = maximalSquare221Oct11.maximalSquare(nums);
        System.out.println(result);*/

/*        MaximumProductSubarray152Otc12 m = new MaximumProductSubarray152Otc12();
        int[] nums = {2,-5,-2,-4,3};
        int result = m.maxProduct(nums);
        System.out.println(result);*/

/*        TwoSum1Otc12 t = new TwoSum1Otc12();
        int[] nums = {3,2,3,5};
        t.twoSumHashtable(nums, 6);*/

/*        MedianOfTwoArrays4Dec8 m = new MedianOfTwoArrays4Dec8();
        int[] num1 = {2};
        int[] num2 = {};
        double result = m.findMedianSortedArraysFinalVersion(num1,num2);
        System.out.println(result);*/

/*        ThreeSum15Otc14 t = new ThreeSum15Otc14();
        int[] nums = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
        t.threeSum(nums);*/

/*        MoveZeros283Otc14 m = new MoveZeros283Otc14();
        int[] nums = {0,1,0,3,12};
        m.moveZeroes(nums);*/

/*        TrappingRainWater42Otc15 t = new TrappingRainWater42Otc15();
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        t.trap(nums);*/

/*        CourseSchedule207 c = new CourseSchedule207();
        int[][] e = {{1,2},{2,3},{3,4},{2,5},{4,5},{5,1}};
        System.out.println(c.canFinish(6,e));*/

/*        AlineDictionary269 a = new AlineDictionary269();
        MyString[] w = {"za","zb","ca","cb"};
        a.alienOrder(w);
        StringBuilder sb = new StringBuilder();*/

/*        ReconstructItinerary332 r = new ReconstructItinerary332();
        MyString[][] t = {{"JFK","SFO"}, {"JFK","ATL"}, {"SFO","ATL"}, {"ATL","JFK"}, {"ATL","SFO"}};
        MyString[][] t2 = {{"JFK","KUL"}, {"JFK","NRT"}, {"NRT","JFK"}};
        r.findItineraryBest(t2);*/

/*        PerfectSquares279 p = new PerfectSquares279();
        p.numSquares(15);*/

        /*SingleNumberII137 s = new SingleNumberII137();
        int[] n = {1,1,1,1,1,1,1};
        s.singleNumber(n);*/
/*        int twos = 1, ones = 0, temp = 1;
        twos = (twos & (~ones) & (~temp)) | ((~twos) & ones & temp);
        ones = (~twos) & (ones ^ temp);
        System.out.println(twos + ";" + ones);*/

        /**
         * Quick sort test
         *
         * */
/*        int[] nums = {9,1,7,2,8,3,4,6,7,1,5};
        QuickSort.quickSortBetter(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));*/

        /**
         * Find kth largest element
         *
         * */
/*        int[] nums = {9,1,7,2,8,3,4,6,7,1,5};
        int r = KthLargestElementInAnArray215Dec7.findKthLargest(nums, 7);
        System.out.println(r);*/

        /**
         * Wiggle Sort II 324
         *
         * */
/*        int[] nums = {4,5,5,6};

        WiggleSortII324Dec7 w = new WiggleSortII324Dec7();
        w.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));*/

        /**
         * Test Counting Sort
         *
         * */
/*        int[] a = {1,5,8,14,97,52,5,4,2,4493,335,41,1};
        LinearTimeSorting.countingSort0to9(a,2);
        System.out.println(Arrays.toString(a));*/

        /**
         * Test Radix Sort
         *
         * */
/*        int[] a = {1,5,8,14,97,52,5,4,2,4493,335,41,1};
        LinearTimeSorting.radixSortBase10Digits(a);
        System.out.println(Arrays.toString(a));*/

        /**
         * Test 2D matrix search
         *
         * */
/*        int[][] m = {{5},{6}};
        Search2dMatrixII240Dec9 s = new Search2dMatrixII240Dec9();
        System.out.println(s.searchMatrix(m,6));*/

        /**
         * Test Valid Parentheses
         *
         * */
/*        String s = "([)]";
        ValidParentheses20Dec11 v = new ValidParentheses20Dec11();
        System.out.println(v.isValid(s));*/
        /**
         * Test basic binary search
         *
         */
/*        int[] a = {-2,1,2,5,9,12,14,18,22,25};
        BinarySearchBaseSituation b = new BinarySearchBaseSituation();
        System.out.println(b.binarySearch(a,8));*/

        /**
         * Test find ceiling
         *
         * */
/*        int[] a  = {6, 6, 6, 8, 8, 9};
        BinarySearchBaseSituation b = new BinarySearchBaseSituation();
        System.out.println(b.findLossCeiling(a,9));*/

        /**
         * Test zuma Game
         *
         *
         * */

        String board = "WWRRBBWW", hand = "WRBRW";
        ZumaGame488Jan14 zuma = new ZumaGame488Jan14();
        System.out.println(zuma.findMinStep(board,hand));


    }

}
