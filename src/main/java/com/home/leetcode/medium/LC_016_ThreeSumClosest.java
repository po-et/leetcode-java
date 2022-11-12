package com.home.leetcode.medium;

import java.util.Arrays;

/**
 * 16. 3Sum Closest （最接近的三数之和）
 *
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Example:
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * @see <a href="https://leetcode.com/problems/3sum-closest/" />
 * @author Poet
 * @date 2020/4/19
 */
public class LC_016_ThreeSumClosest {

    /**
     * 参考 {@link LC_015_ThreeSum}, {@link LC_018_FourSum}
     *
     * 注：这道题比3sum和4sum简单的地方就是不需要判断重复问题  "have exactly one solution"
     */
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("nums is illegal!");
        }

        int closest = Integer.MAX_VALUE;
        int res = closest;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // 无论这个closest是在target左还是右，离target最近的就是最closest的
                if (Math.abs(target - sum) < closest) {
                    closest = Math.abs(target - sum);
                    res = sum;
                }

                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }



    public static void main(String[] args) {
        LC_016_ThreeSumClosest solution = new LC_016_ThreeSumClosest();

        int[] nums = new int[]{-1, 2, 1, -4};
        System.out.println(solution.threeSumClosest(nums, 1));

        nums = new int[]{-1, 0, -2, 1, 2, -1, -4, 4, -2};
        System.out.println(solution.threeSumClosest(nums, 8));
    }
}
