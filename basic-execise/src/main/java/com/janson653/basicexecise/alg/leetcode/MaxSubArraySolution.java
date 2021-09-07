package com.janson653.basicexecise.alg.leetcode;

import java.util.Arrays;

/**
 * @author zhangqian
 * @date 2021/9/1
 */
public class MaxSubArraySolution {
    public static void main(String[] args) {
        // case1
        int sum = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.err.println("sum=" + sum);
        // case2
        sum = maxSubArrayV2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.err.println("sum=" + sum);
    }

    /**
     * 问题描述
     * 求连续的子序列的最大和
     * 贪心法
     */
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            throw new RuntimeException("error input");
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int currentSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (currentSum < 0) {
                currentSum = nums[i];
            } else {
                currentSum = currentSum + nums[i];
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }


    /**
     * 问题描述
     * 求连续的子序列的最大和
     * 动态规划
     */
    public static int maxSubArrayV2(int[] nums) {
        if (nums.length == 0) {
            throw new RuntimeException("error input");
        }

        if (nums.length == 1) {
            return nums[0];
        }


        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] = nums[i] + nums[i - 1];
            }
        }
        Arrays.sort(nums);
        return nums[nums.length - 1];
    }
}
