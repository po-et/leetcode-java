package com.home.leetcode.easy;

/**
 * 2485. Find the Pivot Integer (找出中枢整数)
 *
 * Given a positive integer n, find the pivot integer x such that:
 *
 * The sum of all elements between 1 and x inclusively equals the sum of all elements between x and n inclusively.
 *
 * Return the pivot integer x. If no such integer exists, return -1. It is guaranteed that there will be at most one pivot index for the given input.
 *
 * Example 1:
 * Input: n = 8
 * Output: 6
 * Explanation: 6 is the pivot integer since: 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21.
 *
 * Example 2:
 * Input: n = 1
 * Output: 1
 * Explanation: 1 is the pivot integer since: 1 = 1.
 *
 * Example 3:
 * Input: n = 4
 * Output: -1
 * Explanation: It can be proved that no such integer exist.
 *
 * @see <a href="https://leetcode.cn/problems/find-the-pivot-integer/" />
 * @author Poet
 * @date 2023/6/26
 */
public class LC_2485_FindThePivotInteger {

    /**
     * 方法一：一次遍历
     */
    public int pivotInteger(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        int leftSum = 0;
        int rightSum = sum;
        for (int i = 1; i <= n; i++) {
            if (leftSum + i == rightSum) {
                return i;
            }
            leftSum += i;
            rightSum -= i;
        }
        return -1;
    }
}
