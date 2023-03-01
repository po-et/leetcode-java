package com.home.leetcode.medium;

import java.util.Arrays;

/**
 * 1798. Maximum Number of Consecutive Values You Can Make (你能构造出连续值的最大数目)
 *
 * You are given an integer array coins of length n which represents the n coins that you own. The value of the ith coin is coins[i]. You can make some value x if you can choose some of your n coins such that their values sum up to x.
 *
 * Return the maximum number of consecutive integer values that you can make with your coins starting from and including 0.
 *
 * Note that you may have multiple coins of the same value.
 *
 * Example 1:
 * Input: coins = [1,3]
 * Output: 2
 * Explanation: You can make the following values:
 * - 0: take []
 * - 1: take [1]
 * You can make 2 consecutive integer values starting from 0.
 *
 * Example 2:
 * Input: coins = [1,1,1,4]
 * Output: 8
 * Explanation: You can make the following values:
 * - 0: take []
 * - 1: take [1]
 * - 2: take [1,1]
 * - 3: take [1,1,1]
 * - 4: take [4]
 * - 5: take [4,1]
 * - 6: take [4,1,1]
 * - 7: take [4,1,1,1]
 * You can make 8 consecutive integer values starting from 0.
 *
 * Example 3:
 * Input: nums = [1,4,10,3,1]
 * Output: 20
 *
 * @see <a href="https://leetcode.cn/problems/maximum-number-of-consecutive-values-you-can-make/" />
 * @author Poet
 * @date 2023/2/4
 */
public class LC_1798_MaximumNumberOfConsecutiveValuesYouCanMake {

    // 参考答案
    /**
     * 方法一：贪心
     *
     * time:  O(nlogn)
     * space: O(logn) 排序需要 O(logn) 的栈空间。
     */
    public int getMaximumConsecutive(int[] coins) {
        int res = 1;
        Arrays.sort(coins);
        for (int i : coins) {
            if (i > res) {
                break;
            }
            res += i;
        }
        return res;
    }



    // 自己写的，错误
    public int getMaximumConsecutive_wrong_answer(int[] coins) {
        int res = 0;
        Arrays.sort(coins);
        int max = Arrays.stream(coins).sum();
        for (int i = 1; i < max; i++) {
            int num = i;
            for (int j = coins.length - 1; j >= 0; j--) {
                if (coins[j] > num) {
                    continue;
                }
                num = num - coins[j];
                if (num == 0) {
                    res = i;
                    break;
                }
            }
            if (num != 0) {
                break;
            }
        }
        return res + 1;
    }
}
