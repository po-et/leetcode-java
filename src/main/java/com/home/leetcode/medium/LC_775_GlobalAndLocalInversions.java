package com.home.leetcode.medium;

/**
 * 775. Global and Local Inversions (全局倒置与局部倒置)
 *
 * You are given an integer array nums of length n which represents a permutation of all the integers in the range [0, n - 1].
 *
 * The number of global inversions is the number of the different pairs (i, j) where:
 *      - 0 <= i < j < n
 *      - nums[i] > nums[j]
 *
 * The number of local inversions is the number of indices i where:
 *      - 0 <= i < n - 1
 *      - nums[i] > nums[i + 1]
 *
 * Return true if the number of global inversions is equal to the number of local inversions.
 *
 * Example 1:
 * Input: nums = [1,0,2]
 * Output: true
 * Explanation: There is 1 global inversion and 1 local inversion.
 *
 * Example 2:
 * Input: nums = [1,2,0]
 * Output: false
 * Explanation: There are 2 global inversions and 1 local inversion.
 *
 * @see <a href="https://leetcode.cn/problems/global-and-local-inversions/" />
 * @author Poet
 * @date 2022/11/16
 */
public class LC_775_GlobalAndLocalInversions {

    // 参考答案

    /**
     * 方法一：维护后缀最小值
     *
     * solution: https://leetcode.cn/problems/global-and-local-inversions/solution/quan-ju-dao-zhi-yu-ju-bu-dao-zhi-by-leet-bmjp/
     */
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length, minSuff = nums[n - 1];
        for (int i = n - 3; i >= 0; i--) {
            if (nums[i] > minSuff) {
                return false;
            }
            minSuff = Math.min(minSuff, nums[i + 1]);
        }
        return true;
    }

}
