package com.home.leetcode.easy;

/**
 * 461. Hamming Distance (汉明距离)
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, return the Hamming distance between them.
 *
 *
 * Example 1:
 * Input: x = 1, y = 4
 * Output: 2
 *  Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * The above arrows point to positions where the corresponding bits are different.
 *
 * Example 2:
 * Input: x = 3, y = 1
 * Output: 1
 *
 * @see <a href="https://leetcode.cn/problems/hamming-distance" />
 * @author poet
 * @date 2022/6/16
 */
public class LC_461_HammingDistance {

    /**
     * 前言
     *
     * 汉明距离广泛应用于多个领域。在编码理论中用于错误检测，在信息论中量化字符串之间的差异。
     *
     * 两个整数之间的汉明距离是对应位置上数字不同的位数。
     *
     * 根据以上定义，我们使用异或运算，记为 ⊕，当且仅当输入位不同时输出为 1。
     *
     * 所以，计算 x 和 yy 之间的汉明距离，可以先计算 x⊕y，然后统计结果中等于 1 的位数。
     *
     * ---> 原始问题转换为位计数问题。
     */


    /**
     * 方法一：内置位计数功能
     *
     * time:  O(1)
     * space: O(1)
     */
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    /**
     * 方法二：移位实现位计数
     *
     * time:  O(logC)，其中 C 是元素的数据范围，在本题中 log C = log 2^{31} = 31。
     * space: O(1)
     */
    public int hammingDistance_2(int x, int y) {
        int s = x ^ y;
        int res = 0;
        while (s != 0) {
            res += s & 1;
            s = s >> 1;
        }
        return res;
    }

    /**
     * 方法三：Brian Kernighan 算法
     *
     * time:  O(logC)，其中 C 是元素的数据范围，在本题中 log C = log 2^{31} = 31。
     * space: O(1)
     */
    public int hammingDistance_3(int x, int y) {
        int s = x ^ y;
        int res = 0;
        while (s != 0) {
            s = s & (s - 1);
            res++;
        }
        return res;
    }

}
