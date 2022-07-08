package com.home.leetcode.medium;

/**
 * 29. Divide Two Integers
 *  不能使用除号，乘号，取模
 *
 * 注意：
 *  1、+ -
 *  2、越界
 *  3、==0
 *
 * @see <a href="https://leetcode.cn/problems/divide-two-integers/" />
 * Created by Poet on 2019-01-13.
 */
public class LC_029_DivideTwoIntegers {

    /**
     * time: O(logn)
     * space: O(logn)
     * 注意：
     *  1. 最容易错的就是空间复杂度
     *  2. 3/0这种被除数为0的情况下Java的异常错误会处理，所以没有在代码中体现
     */
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) sign = -1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        if (ldividend < ldivisor || ldividend == 0) return 0;

        long lres = divide(ldividend, ldivisor);
        int res = 0;
        if (lres > Integer.MAX_VALUE) {
            res = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            res = (int) (sign * lres);
        }
        return res;

    }

    private long divide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) return 0;
        long sum = ldivisor;
        long multiple = 1;
        while ((sum + sum) < ldividend) { // (sum + sum) <= ldividend 也可以，而且时间复杂度小于O(logn)，要清除运行的区别！
            sum += sum;
            multiple += multiple;
        }
        return multiple + divide(ldividend - sum, ldivisor);
    }
}
