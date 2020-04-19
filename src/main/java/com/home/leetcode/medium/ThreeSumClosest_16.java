package com.home.leetcode.medium;

import java.util.Arrays;
import java.util.Objects;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Example:
 *
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * @see <a href = "https://leetcode.com/problems/3sum-closest/" />
 * @author Poet
 * @date 2020/4/19
 */
public class ThreeSumClosest_16 {

    public static void main(String[] args) {
        ThreeSumClosest_16 solution = new ThreeSumClosest_16();

        int[] nums = new int[]{-1, 2, 1, -4};
        int target = 1;
        System.out.println(solution.threeSumClosest(nums,target));
    }

    /**
     * 参考 {@link ThreeSum_15}, {@link FourSum_18}
     * 注：这道题比3sum和4sum简单的地方就是不需要判断重复问题  "have exactly one solution"
     */
    public int threeSumClosest(int[] nums, int target) {
        if(Objects.isNull(nums) || nums.length<3)
            throw new IllegalArgumentException("nums is illegal!");

        int closest = Integer.MAX_VALUE;
        int ret = closest;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int left = i+1, right = nums.length-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // 无论这个closest是在target左还是右，离target最近的就是最closest的
                if (Math.abs(target - sum) < closest) {
                    closest = Math.abs(target - sum);
                    ret = sum;
                }

                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    left ++;
                } else {
                    right --;
                }
            }
        }
        return ret;
    }

}
