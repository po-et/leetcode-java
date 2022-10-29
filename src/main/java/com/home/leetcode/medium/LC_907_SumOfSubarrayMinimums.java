package com.home.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 907. Sum of Subarray Minimums （子数组的最小值之和）
 *
 * Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr.
 * Since the answer may be large, return the answer modulo 10^9 + 7.
 *
 * Example 1:
 * Input: arr = [3,1,2,4]
 * Output: 17
 * Explanation:
 * Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
 * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
 * Sum is 17.
 *
 * Example 2:
 * Input: arr = [11,81,94,43,3]
 * Output: 444
 *
 * @see <a href="https://leetcode.cn/problems/sum-of-subarray-minimums/" />
 * @author Poet
 * @date 2022/10/28
 */
public class LC_907_SumOfSubarrayMinimums {

    /**
     * 方法一：单调栈
     */
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Deque<Integer> monoStack = new ArrayDeque<>();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            while (!monoStack.isEmpty() && arr[i] <= arr[monoStack.peek()]) {
                monoStack.pop();
            }
            left[i] = i - (monoStack.isEmpty() ? -1 : monoStack.peek());
            monoStack.push(i);
        }
        monoStack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!monoStack.isEmpty() && arr[i] < arr[monoStack.peek()]) {
                monoStack.pop();
            }
            right[i] = (monoStack.isEmpty() ? n : monoStack.peek()) - i;
            monoStack.push(i);
        }
        long ans = 0;
        final int MOD = 1000000007;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long) left[i] * right[i] * arr[i]) % MOD;
        }
        return (int) ans;
    }


    // 暴力解法：超出时间限制
    // time: O(N^2)
    public int sumSubarrayMins_bruteForce(int[] arr) {
        int res = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int min = arr[i];
            for (int j = i; j < n; j++) {
                min = Math.min(min, arr[j]);
                res = (res + min) % 1000000007;
            }
        }
        return res % 1000000007;
    }

}
