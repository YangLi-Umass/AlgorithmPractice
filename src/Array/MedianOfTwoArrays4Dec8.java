package Array;

/**
 * Created by li on 10/13/2016.
 */
public class MedianOfTwoArrays4Dec8 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length+nums2.length;
        int firstMedian = helper(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, (len+1)/2);
        if(len % 2 == 1) return firstMedian;
        else {
            int secondMedian = helper(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, len/2+1);
            return (double)(firstMedian+secondMedian)/2;
        }

    }

    /**
     * find the median 只管一边，找第K个元素
     *
     * 编写的时候注意前面的几行
     * 1. 先计算两个数组当前的长度
     * 2. 保证nums1的长度小，如果不满足，交换
     * 3. 如果nums1的长度为0，那么直接从nums2里面找相应的数
     * 4. 如果K==1，直接比较两个数组strat位置的数。
     *
     * 可以改进的地方，其实end1和end2不需要，可以调用相应的length，但根据leetcode实验表明这样速度慢一些。
     * */
    private int helper(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1-start1+1;
        int len2 = end2-start2+1;
        if(len1 > len2) return helper(nums2,start2,end2,nums1,start1,end1,k);
        if(len1 == 0) return nums2[start2 + k - 1];
        if(k == 1) return Math.min(nums1[start1], nums2[start2]);

        int index1 = start1 + Math.min(len1, k/2) -1;
        int index2 = start2 + Math.min(len2, k/2) -1;
        if(nums1[index1] < nums2[index2]) {
            return helper(nums1, index1+1, end1, nums2, start2, end2, k-(index1-start1+1));
        } else {
            return helper(nums1, start1, end1, nums2, index2+1, end2, k-(index2-start2+1));
        }


    }

    /**
     * 另一种方法 通过把数组分成两部分
     *
     * */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        int len1 = nums1.length, len2 = nums2.length;
        if(len1 < len2) return findI(nums1, 0, len1, nums2);        //注意这个地方end是长度 即 i和j的取值范围[0，length]
        else return findI(nums2, 0, len2, nums1);

    }

    public double findI(int[] n1, int start1, int end1, int[] n2) {
        int i = (start1 + end1)/2;
        int j = (n1.length + n2.length + 1)/2 - i;
        if((i == 0 || j == n2.length || n1[i-1] <= n2[j]) && (j == 0 || i == n1.length || n2[j-1] <= n1[i])) {
            int maxLeft;
            if(i == 0) maxLeft = n2[j-1];
            else if( j == 0) maxLeft = n1[i-1];
            else maxLeft = Math.max(n2[j-1],n1[i-1]);
            if((n1.length+n2.length) % 2 == 1) return maxLeft;

            int minRight;
            if(j == n2.length) minRight = n1[i];
            else if( i == n1.length) minRight = n2[j];
            else minRight = Math.min(n1[i], n2[j]);
            return (double) (maxLeft + minRight)/2;

        } else if (i != 0 && j != n2.length && n1[i-1] > n2[j]) {
            return findI(n1, start1, i-1, n2);
        } else {
            return findI(n1, i+1, end1, n2);
        }
    }

}
