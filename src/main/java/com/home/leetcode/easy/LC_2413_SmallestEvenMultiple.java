package com.home.leetcode.easy;

/**
 * 2413. Smallest Even Multiple (最小偶倍数)
 *
 * Given a positive integer n, return the smallest positive integer that is a multiple of both 2 and n.
 *
 * Example 1:
 * Input: n = 5
 * Output: 10
 * Explanation: The smallest multiple of both 5 and 2 is 10.
 *
 * Example 2:
 * Input: n = 6
 * Output: 6
 * Explanation: The smallest multiple of both 6 and 2 is 6. Note that a number is a multiple of itself.
 *
 * @see <a href="https://leetcode.cn/problems/smallest-even-multiple/" />
 * @author Poet
 * @date 2023/4/21
 */
public class LC_2413_SmallestEvenMultiple {

    public int smallestEvenMultiple(int n) {
        if (n % 2 == 0) {
            return n;
        }
        return 2 * n;
    }
}
