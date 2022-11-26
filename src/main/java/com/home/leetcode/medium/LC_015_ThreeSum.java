package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum（三数之和）
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0 ?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * @see <a href="https://leetcode.cn/problems/3sum/" />
 * @author Poet
 * @date 2020/4/19
 */
public class LC_015_ThreeSum {

    /**
     * 方法一：排序 + 双指针
     *
     * time:  O(n^2) 数组排序O(NlogN)，遍历数组O(n)，双指针遍历O(n)，总体O(NlogN)+O(n)∗O(n)，所以是O(n^2)
     * space: O(1)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }

        // 先排序 O(nlogn)
        Arrays.sort(nums);

        // nums.length-2 是因为左右都有指针，而且3元素相加
        for (int i = 0; i < nums.length - 2; i++) {
            // 选定nums[i]为第一个数，并去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    // 去重
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < 0) {
                    left++;
                } else {  // sum > 0
                    right--;
                }
            }
        }
        return res;
    }



    public static void main(String[] args) {
        LC_015_ThreeSum solution = new LC_015_ThreeSum();

        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums));

        int[] nums1 = new int[]{-1, 0, -2, 1, 2, -1, -4, 4, -2};
        System.out.println(solution.threeSum(nums1));
    }

}
