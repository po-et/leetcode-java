package com.home.jianzhi_offer;

/**
 * 面试题16. 数值的整数次方
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x^n）。不得使用库函数，同时不需要考虑大数问题。
 *
 * 示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 * 示例 2：
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 *
 * 示例 3：
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 * @see <a href="https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/" />
 * @author Poet
 * @date 2020/5/27
 */
public class Offer_16_PowxN {

    /* 「快速幂算法」的本质是分治算法（有递归和迭代两个版本） */

    /**
     * 方法一：快速幂算法 + 递归
     *
     * time:  O(logn)，即为递归的层数。
     * space: O(logn)，即为递归的层数。这是由于递归的函数调用会使用栈空间。
     */
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }

        double y = quickMul(x, N / 2);
        // 判断奇偶
        return N % 2 == 0 ? y * y : y * y * x;
    }











    // 二分思想
    public double myPow_3(double x, int n) {
        if (x == 0) {
            return 0;
        }

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
