package com.home.leetcode.easy;

/**
 * 1281. Subtract the Product and Sum of Digits of an Integer
 *
 * Given an integer number n, return the difference between the product of its digits and the sum of its digits.
 *
 * Example 1:
 * Input: n = 234
 * Output: 15
 * Explanation:
 * Product of digits = 2 * 3 * 4 = 24
 * Sum of digits = 2 + 3 + 4 = 9
 * Result = 24 - 9 = 15
 *
 * Example 2:
 * Input: n = 4421
 * Output: 21
 * Explanation:
 * Product of digits = 4 * 4 * 2 * 1 = 32
 * Sum of digits = 4 + 4 + 2 + 1 = 11
 * Result = 32 - 11 = 21
 *
 * @see <a href="https://leetcode.cn/problems/subtract-the-product-and-sum-of-digits-of-an-integer/" />
 * @author Poet
 * @date 2023/8/9
 */
public class LC_1281_SubtractTheProductAndSumOfDigitsOfAnInteger {

    /**
     * 方法：模拟
     */
    public int subtractProductAndSum(int n) {
        int m = 1;
        int s = 0;

        while (n != 0) {
            int x = n % 10;
            n /= 10;
            m *= x;
            s += x;
        }
        return m - s;
    }

}
