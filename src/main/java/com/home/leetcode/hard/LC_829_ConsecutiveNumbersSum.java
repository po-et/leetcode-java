package com.home.leetcode.hard;

/**
 * 829. Consecutive Numbers Sum
 *
 * Given an integer n, return the number of ways you can write n as the sum of consecutive positive integers.
 *
 * Example 1:
 * Input: n = 5
 * Output: 2
 * Explanation: 5 = 2 + 3
 *
 * Example 2:
 * Input: n = 9
 * Output: 3
 * Explanation: 9 = 4 + 5 = 2 + 3 + 4
 *
 * @see <a href="https://leetcode.cn/problems/consecutive-numbers-sum/" />
 * @author bin.yang
 * @date 2022/6/3
 */
public class LC_829_ConsecutiveNumbersSum {

    // 参考官方答案
    // 答题涉及数学推导
    public int consecutiveNumbersSum(int n) {
        int ans = 0;
        int bound = 2 * n;
        for (int k = 1; k * (k + 1) <= bound; k++) {
            if (isKConsecutive(n, k)) {
                ans++;
            }
        }
        return ans;
    }

    public boolean isKConsecutive(int n, int k) {
        if (k % 2 == 1) {
            return n % k == 0;
        } else {
            return n % k != 0 && 2 * n % k == 0;
        }
    }

}
