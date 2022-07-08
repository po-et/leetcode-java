package com.home.leetcode.easy;

/**
 * 338. Counting Bits (比特位计数)
 *
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 *
 * Example 1:
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 *
 * Example 2:
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *
 * @see <a href="https://leetcode.cn/problems/counting-bits" />
 * @author poet
 * @date 2022/6/16
 */
public class LC_338_CountingBits {

    /**
     * 方法一：Brian Kernighan 算法
     *
     * 算法的原理：对于任意整数 x，令 x=x&(x−1)，该运算将 x 的二进制表示的最后一个 1 变成 0。
     *           因此，对 x 重复该操作，直到 x 变成 0，则操作次数即为 x 的「一比特数」。
     *
     * time:  O(nlogn) 需要对从 0 到 n 的每个整数使用计算「一比特数」，对于每个整数计算「一比特数」的时间都不会超过 O(logn)。
     * space: O(1)
     */
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }

    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x = x & (x - 1);
            ones++;
        }
        return ones;
    }


    /**
     * 转换成二进制后遍历
     */
    public int[] countBits_2(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = countOnesOfBinaryBit(i);
        }
        return res;
    }

    private int countOnesOfBinaryBit(int n) {
        int res = 0;
        while (n > 0) {
            int mod = n % 2;
            if (mod == 1) {
                res++;
            }
            n = n / 2;
        }
        return res;
    }

}
