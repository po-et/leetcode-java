package com.home.leetcode.medium;

// 直接参考答案
/**
 * 926. Flip String to Monotone Increasing （将字符串翻转到单调递增）
 *
 * A binary string is monotone increasing if it consists of some number of 0's (possibly none), followed by some number of 1's (also possibly none).
 *
 * You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.
 *
 * Return the minimum number of flips to make s monotone increasing.
 *
 * Example 1:
 * Input: s = "00110"
 * Output: 1
 * Explanation: We flip the last digit to get 00111.
 *
 * Example 2:
 * Input: s = "010110"
 * Output: 2
 * Explanation: We flip to get 011111, or alternatively 000111.
 *
 * @see <a href="https://leetcode.cn/problems/flip-string-to-monotone-increasing" />
 * @author Poet
 * @date 2022/6/11
 */
public class LC_926_FlipStringToMonotoneIncreasing {

    /**
     * 方法一：动态规划
     */
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int dp0 = 0, dp1 = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int dp0New = dp0, dp1New = Math.min(dp0, dp1);
            if (c == '1') {
                dp0New++;
            } else {
                dp1New++;
            }
            dp0 = dp0New;
            dp1 = dp1New;
        }

        return Math.min(dp0, dp1);
    }
}
