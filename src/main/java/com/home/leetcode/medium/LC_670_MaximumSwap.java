package com.home.leetcode.medium;

/**
 * 670. Maximum Swap (最大交换)
 *
 * You are given an integer num. You can swap two digits at most once to get the maximum valued number.
 *
 * Return the maximum valued number you can get.
 *
 * Example 1:
 * Input: num = 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 *
 * Example 2:
 * Input: num = 9973
 * Output: 9973
 * Explanation: No swap.
 *
 * @see <a href="https://leetcode.cn/problems/maximum-swap/" />
 * @author Poet
 * @date 2022/9/13
 */
public class LC_670_MaximumSwap {

    /**
     * 方法一：暴力解法
     *
     * 思路：由于对于整数 num 的十进制数字位长最长为 8 位，任意两个数字交换一次最多有 28 种不同的交换方法，
     *      因此我们可以尝试遍历所有可能的数字交换方法即可，并找到交换后的最大数字即可。
     * time:
     */
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int n = chars.length;
        int maxNum = num;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(chars, i, j);
                maxNum = Math.max(maxNum, Integer.parseInt(new String(chars)));
                swap(chars, i, j);
            }
        }
        return maxNum;
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

}
