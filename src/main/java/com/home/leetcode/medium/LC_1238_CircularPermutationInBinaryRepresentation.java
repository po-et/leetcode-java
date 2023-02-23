package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 1238. Circular Permutation in Binary Representation (循环码排列)
 *
 * Given 2 integers n and start. Your task is return any permutation p of (0,1,2.....,2^n -1) such that :
 *      p[0] = start
 *      p[i] and p[i+1] differ by only one bit in their binary representation.
 *      p[0] and p[2^n -1] must also differ by only one bit in their binary representation.
 *
 * Example 1:
 * Input: n = 2, start = 3
 * Output: [3,2,0,1]
 * Explanation: The binary representation of the permutation is (11,10,00,01).
 * All the adjacent element differ by one bit. Another valid permutation is [3,1,0,2]
 *
 * Example 2:
 * Input: n = 3, start = 2
 * Output: [2,6,7,5,4,0,1,3]
 * Explanation: The binary representation of the permutation is (010,110,111,101,100,000,001,011).
 *
 * @see <a href="https://leetcode.cn/problems/circular-permutation-in-binary-representation/" />
 * @author Poet
 * @date 2023/2/23
 */
public class LC_1238_CircularPermutationInBinaryRepresentation {

    // 参考答案

    /**
     * 本题和「89. 格雷编码」非常相似，区别在于「89. 格雷编码」要求第一个整数是 00，而本题要求第一个整数是 start，
     * 因此只需要将求出的结果的每一项都与 start 进行按位异或运算即可。
     */
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> res = new ArrayList<>();
        res.add(start);
        for (int i = 1; i <= n; i++) {
            int m = res.size();
            for (int j = m - 1; j >= 0; j--) {
                res.add(((res.get(j) ^ start) | (1 << (i - 1))) ^ start);
            }
        }
        return res;
    }

}
