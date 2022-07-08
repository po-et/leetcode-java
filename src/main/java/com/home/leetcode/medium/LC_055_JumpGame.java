package com.home.leetcode.medium;

/**
 * 55. Jump Game (跳跃游戏)
 *
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 * @see <a href="https://leetcode.cn/problems/jump-game/" />
 * @author Poet
 * @date 2022/6/18
 */
public class LC_055_JumpGame {

    /**
     * 方法一：贪心 (Greedy的思想)
     *
     * time:  O(n) 其中 n 为数组的大小。只需要访问 nums 数组一遍，共 n 个位置。
     * space: O(1)
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightMost = 0;  // 最远可以到达的位置
        for (int i = 0; i < n; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= nums[n - 1]) {
                    return true;
                }
            }
        }
        return false;
    }

}
