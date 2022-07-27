package com.home.leetcode.medium;

/**
 * 592. Fraction Addition and Subtraction
 *
 * Given a string expression representing an expression of fraction addition and subtraction, return the calculation result in string format.
 *
 * The final result should be an irreducible fraction. If your final result is an integer, change it to the format of a fraction
 * that has a denominator 1. So in this case, 2 should be converted to 2/1.
 *
 * Example 1:
 * Input: expression = "-1/2+1/2"
 * Output: "0/1"
 *
 * Example 2:
 * Input: expression = "-1/2+1/2+1/3"
 * Output: "1/3"
 *
 * Example 3:
 * Input: expression = "1/3-1/2"
 * Output: "-1/6"
 *
 * @see <a href="https://leetcode.cn/problems/fraction-addition-and-subtraction/" />
 * @author Poet
 * @date 2022/7/27
 */
public class LC_592_FractionAdditionAndSubtraction {

    // 直接参考答案
    /**
     * 方法一：模拟
     *
     * 模拟数学计算，然后取最大公约数
     */
    public String fractionAddition(String expression) {
        long denominator = 0, numerator = 1; // 分子，分母
        int index = 0, n = expression.length();
        while (index < n) {
            // 读取分子
            long denominator1 = 0, sign = 1;
            if (expression.charAt(index) == '-' || expression.charAt(index) == '+') {
                sign = expression.charAt(index) == '-' ? -1 : 1;
                index++;
            }
            while (index < n && Character.isDigit(expression.charAt(index))) {
                denominator1 = denominator1 * 10 + expression.charAt(index) - '0';
                index++;
            }
            denominator1 = sign * denominator1;
            index++;

            // 读取分母
            long numerator1 = 0;
            while (index < n && Character.isDigit(expression.charAt(index))) {
                numerator1 = numerator1 * 10 + expression.charAt(index) - '0';
                index++;
            }

            denominator = denominator * numerator1 + denominator1 * numerator;
            numerator *= numerator1;
        }
        if (denominator == 0) {
            return "0/1";
        }
        long g = gcd(Math.abs(denominator), numerator); // 获取最大公约数
        return Long.toString(denominator / g) + "/" + Long.toString(numerator / g);
    }

    public long gcd(long a, long b) {
        long remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }
}
