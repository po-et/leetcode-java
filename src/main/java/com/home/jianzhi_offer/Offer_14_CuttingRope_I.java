package com.home.jianzhi_offer;

import com.home.leetcode.medium.LC_343_IntegerBreak;

/**
 * 面试题14- I. 剪绳子
 *
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 *
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 *
 * 注意：本题与主站 343 题相同：https://leetcode.cn/problems/integer-break/
 * {@link LC_343_IntegerBreak}
 *
 * @see <a href="https://leetcode.cn/problems/jian-sheng-zi-lcof/" />
 * @author Poet
 * @date 2020/5/27
 */
public class Offer_14_CuttingRope_I {

    private int[] memo;

    public int cuttingRope(int n) {
        if (n <= 1) {
            throw new IllegalArgumentException("param is not valid.");
        }

        memo = new int[n + 1];
        return cuttingRecursive(n);
    }

    /**
     * [递归（记忆化搜索）]
     *
     * 将n分割求最大乘积（至少分割为两部分）
     */
    public int cuttingRecursive(int n){
        if (n == 1) {
            return 1;
        }

        if (memo[n] > 0) {
            return memo[n];
        }

        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            res = max3(res, i * (n - i), i * cuttingRecursive(n - i));
        }
        memo[n] = res;
        return res;
    }

    public int max3(int i, int j, int k) {
        return Math.max(i, Math.max(j, k));
    }
}
