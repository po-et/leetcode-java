package com.home.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 862. Shortest Subarray with Sum at Least K (和至少为 K 的最短子数组)
 *
 * Given an integer array nums and an integer k, return the length of the shortest non-empty subarray of nums with a sum of at least k.
 * If there is no such subarray, return -1.
 *
 * A subarray is a contiguous part of an array.
 *
 * Example 1:
 * Input: nums = [1], k = 1
 * Output: 1
 *
 * Example 2:
 * Input: nums = [1,2], k = 4
 * Output: -1
 *
 * Example 3:
 * Input: nums = [2,-1,2], k = 3
 * Output: 3
 *
 * @see <a href="https://leetcode.cn/problems/shortest-subarray-with-sum-at-least-k/" />
 * @author Poet
 * @date 2022/10/26
 */
public class LC_862_ShortestSubarrayWithSumAtLeastK {

    /* --- 这道题来自：第 91 场周赛 --- */

    // todo 学习前缀和：https://leetcode.cn/problems/shortest-subarray-with-sum-at-least-k/solution/liang-zhang-tu-miao-dong-dan-diao-dui-li-9fvh/

    /**
     * 方法一：前缀和 + 单调双端队列
     */
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] preSumArr = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSumArr[i + 1] = preSumArr[i] + nums[i];
        }

        int res = n + 1;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            long curSum = preSumArr[i];
            while (!queue.isEmpty() && curSum - preSumArr[queue.peekFirst()] >= k) {
                res = Math.min(res, i - queue.pollFirst());
            }
            while (!queue.isEmpty() && preSumArr[queue.peekLast()] >= curSum) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }

        return res < n + 1 ? res : -1;
    }


    /**
     * 暴力解法
     *
     * 超出时间限制 ！
     */
    public int shortestSubarray_brute_force(int[] nums, int k) {
        int res = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= k) {
                    res = Math.min(res, j - i + 1);
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
