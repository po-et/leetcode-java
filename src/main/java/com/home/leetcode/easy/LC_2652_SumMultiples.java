package com.home.leetcode.easy;

/**
 * 2652. Sum Multiples
 *
 * Given a positive integer n, find the sum of all integers in the range [1, n] inclusive that are divisible by 3, 5, or 7.
 *
 * Return an integer denoting the sum of all numbers in the given range satisfying the constraint.
 *
 * Example 1:
 * Input: n = 7
 * Output: 21
 * Explanation: Numbers in the range [1, 7] that are divisible by 3, 5, or 7 are 3, 5, 6, 7. The sum of these numbers is 21.
 *
 * Example 2:
 * Input: n = 10
 * Output: 40
 * Explanation: Numbers in the range [1, 10] that are divisible by 3, 5, or 7 are 3, 5, 6, 7, 9, 10. The sum of these numbers is 40.
 *
 * Example 3:
 * Input: n = 9
 * Output: 30
 * Explanation: Numbers in the range [1, 9] that are divisible by 3, 5, or 7 are 3, 5, 6, 7, 9. The sum of these numbers is 30.
 *
 * @see <a href="https://leetcode.cn/problems/sum-multiples/" />
 * @author Poet
 * @date 2023/10/17
 */
public class LC_2652_SumMultiples {

    /**
     * 方法：枚举
     *
     * time:  O(N)
     * space: O(1)
     */
    public int sumOfMultiples(int n) {
        int res = 0;
        for (int i = 3; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                res += i;
            }
        }
        return res;
    }
}
