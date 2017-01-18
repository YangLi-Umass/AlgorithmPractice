package Array;

import java.util.*;

/**
 * Created by li on 10/14/2016.
 */
public class ThreeSum15Otc14 {

    public List<List<Integer>> threeSum(int[] nums) {
        int lens = nums.length;
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < lens-2; i++) {
            if (i == 0 || (nums[i] != nums[i-1])){
                int left = i+1, right = lens-1;
                int target = 0 - nums[i];
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        ArrayList<Integer> a = new ArrayList<>();
                        a.add(nums[i]);
                        a.add(nums[right]);
                        a.add(nums[left]);
                        result.add(a);
                        while (left<right && nums[left] == nums[left+1]) left++;        //关键
                        while (left<right && nums[right] == nums[right-1]) right--;
                        left++;right--;
                    }
                }
            }
        }
        return result;
    }


    public List<List<Integer>> threeSumLaji(int[] nums) {
        //第一次错误，循环跳出条件没写导致无限运行
        //第二次错误，没有把找到的组合放到result里
        //第三次错误，当输入数组长度小于3时，返回null还是一个空的arraylist
        //第四次错误，对于重复的组合怎么办？倘若输入数组为[0,0,0,0,0]。
        int lens = nums.length;

        ArrayList<List<Integer>> result = new ArrayList<>();
        if (lens < 3) return result;
        Arrays.sort(nums);
        int preNumber = nums[0] + 1;
        for(int i = 0; i < lens-2; i++) {
            if(nums[i] != preNumber) {
                findTwoConbination(nums,nums[i],i+1,lens-1,0-nums[i],result);
                preNumber = nums[i];
            }
        }
        return result;

    }


    public void find3Combination (int[] nums, int left1, int left2, int right, int target, HashSet<List<Integer>> result) {
        if (left1<right && left2<right) {
            int currentSum = nums[left1] + nums[left2] + nums[right];
            if (currentSum > target) {
                find3Combination(nums, left1, left2, right-1, target, result);
            } else if (currentSum < target) {
                int newLeft1 = left1+1;
                if (newLeft1 == left2) newLeft1++;
                find3Combination(nums, newLeft1, left2, right, target, result);
                int newLeft2 = left2+1;
                if (newLeft2 == left1) newLeft2++;
                find3Combination(nums, left1, newLeft2, right, target, result);
            } else {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(nums[left1]);
                arrayList.add(nums[left2]);
                arrayList.add(nums[right]);
                result.add(arrayList);
                find3Combination(nums, left1, left2, right-1, target, result);
            }
        }
    }

    public void findTwoConbination(int[] nums, int currentNum, int left, int right, int target, ArrayList<List<Integer>> result) {
        HashSet<ArrayList<Integer>> h = new HashSet<>();
        while (left < right) {
            int currentSum = nums[left] + nums[right];
            if (currentSum > target) {
                right--;
            } else if (currentSum < target) {
                left++;
            } else {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(currentNum);
                arrayList.add(nums[left]);
                arrayList.add(nums[right]);
                h.add(arrayList);
                right--;
            }

        }

        for(ArrayList<Integer> temp:h) {
            result.add(temp);
        }


    }
}
