package com.home.leetcode.easy;

/**
 * 191. Number of 1 Bits
 *
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 *
 * Note:
 * Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer. -3.
 *
 * Example 1:
 * Input: n = 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 *
 * Example 2:
 * Input: n = 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 *
 * @see <a href="https://leetcode.cn/problems/number-of-1-bits/" />
 * @author Poet
 * @date 2022/7/4
 */
public class LC_191_NumberOf1Bits {

    // 使用位于运算
    public int hammingWeight_2(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n = n >>> 1;  // 无符合右移
        }
        return res ;
    }

    // 位运算优化
    public int hammingWeight_3(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            res++;
        }
        return res;
    }

}
