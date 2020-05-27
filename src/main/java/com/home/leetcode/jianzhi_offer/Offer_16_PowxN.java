package com.home.leetcode.jianzhi_offer;

/**
 * 面试题16. 数值的整数次方
 *
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 *
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * @author Poet
 * @date 2020/5/27
 */
public class Offer_16_PowxN {

    // 二分思想
    public double myPow(double x, int n) {
        if(x == 0)
            return 0;

        // Java中int32 变量n∈[−2147483648,2147483647] ，因此当 n = -2147483648时执行 n = -n会因越界而赋值出错。解决方法是先将 n存入 long 变量 b
        long b = n;
        double res = 1.0;

        if (b < 0) {
            x = 1 / x;
            b = -b;
        }

        while (b > 0) {
            if ((b & 1) == 1) { // 奇数
                res *= x;
            }
            x *= x;
            b >>= 1;
        }

        return res;
    }


    /**
     * 超出时间限制（Wrong Answer！！！）
     */
    public double myPow2(double x, int n) {
        if(x == 0 && n < 0)
            throw new IllegalArgumentException("param is not valid.");

        int num = n > 0 ? n : -n;
        double ret = 1;
        for (int i = 0; i < num; i++) {
            ret = ret * x;
        }

        if (n < 0) {
            ret = 1 / ret;
        }
        return ret;
    }
}
