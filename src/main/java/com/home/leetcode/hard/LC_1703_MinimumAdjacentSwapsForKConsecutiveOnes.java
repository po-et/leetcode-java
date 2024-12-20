package com.home.leetcode.hard;

/**
 * 1703. Minimum Adjacent Swaps for K Consecutive Ones
 *
 * You are given an integer array, nums, and an integer k. nums comprises of only 0's and 1's.
 * In one move, you can choose two adjacent indices and swap their values.
 *
 * Return the minimum number of moves required so that nums has k consecutive 1's.
 *
 * Example 1:
 * Input: nums = [1,0,0,1,0,1], k = 2
 * Output: 1
 * Explanation: In 1 move, nums could be [1,0,0,0,1,1] and have 2 consecutive 1's.
 *
 * Example 2:
 * Input: nums = [1,0,0,0,0,0,1,1], k = 3
 * Output: 5
 * Explanation: In 5 moves, the leftmost 1 can be shifted right until nums = [0,0,0,0,0,1,1,1].
 *
 * Example 3:
 * Input: nums = [1,1,0,1], k = 2
 * Output: 0
 * Explanation: nums already has 2 consecutive 1's.
 *
 * @see <a href="https://leetcode.cn/problems/minimum-adjacent-swaps-for-k-consecutive-ones/" />
 * @author Poet
 * @date 2022/12/18
 */
public class LC_1703_MinimumAdjacentSwapsForKConsecutiveOnes {

    /**
     * 方法一：贪心 + 前缀和
     */
    public int minMoves(int[] nums, int k) {

        return -1;
    }

}
