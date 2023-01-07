package com.home.leetcode.medium;

import java.util.Arrays;

/**
 * 1658. Minimum Operations to Reduce X to Zero (将 x 减到 0 的最小操作数)
 *
 * You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.
 *
 * Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.
 *
 * Example 1:
 *
 * Input: nums = [1,1,4,2,3], x = 5
 * Output: 2
 * Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
 * Example 2:
 *
 * Input: nums = [5,6,7,8,9], x = 4
 * Output: -1
 * Example 3:
 *
 * Input: nums = [3,2,20,1,1,3], x = 10
 * Output: 5
 * Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 *
 * @see <a href="https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/" />
 * @author Poet
 * @date 2023/1/7
 */
public class LC_1658_MinimumOperationsToReduceXToZero {

    /**
     * 方法一：滑动窗口
     */
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();

        if (sum < x) {
            return -1;
        }

        int right = 0;
        int lsum = 0;
        int rsum = sum;
        int res = n + 1;

        for (int left = -1; left < n; ++left) {
            if (left != -1) {
                lsum += nums[left];
            }
            while (right < n && lsum + rsum > x) {
                rsum -= nums[right];
                ++right;
            }
            if (lsum + rsum == x) {
                res = Math.min(res, (left + 1) + (n - right));
            }
        }

        return res > n ? -1 : res;
    }
}
