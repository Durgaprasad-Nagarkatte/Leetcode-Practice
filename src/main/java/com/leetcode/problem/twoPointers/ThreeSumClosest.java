package com.leetcode.problem.twoPointers;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;

            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum < target) {
                    lo++;
                } else {
                    hi--;
                }
                if(Math.abs(target-sum) < minDiff){
                    minDiff = Math.abs(target-sum);
                    minSum = sum;
                }
            }
        }
        return minSum;
    }

    public static void main(String[] args){
        ThreeSumClosest closest = new ThreeSumClosest();
        int[] nums = {1, -3, -8, 4, 3};
        System.out.println(closest.threeSumClosest(nums, 1));
    }
}
