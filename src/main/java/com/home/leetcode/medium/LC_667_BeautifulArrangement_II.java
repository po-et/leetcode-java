package com.home.leetcode.medium;

/**
 * 667. Beautiful Arrangement II (优美的排列 II)
 * 
 * Given two integers n and k, construct a list answer that contains n different positive integers ranging from 1 to n and obeys the following requirement:
 *
 * Suppose this list is answer = [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.
 * Return the list answer. If there multiple valid answers, return any of them.
 *
 * Example 1:
 * Input: n = 3, k = 1
 * Output: [1,2,3]
 * Explanation: The [1,2,3] has three different positive integers ranging from 1 to 3, and the [1,1] has exactly 1 distinct integer: 1
 *
 * Example 2:
 * Input: n = 3, k = 2
 * Output: [1,3,2]
 * Explanation: The [1,3,2] has three different positive integers ranging from 1 to 3, and the [2,1] has exactly 2 distinct integers: 1 and 2.
 *
 * @see <a href="https://leetcode.cn/problems/beautiful-arrangement-ii/" />
 * @author Poet
 * @date 2022/9/8
 */
public class LC_667_BeautifulArrangement_II {

    /**
     * 方法一：从特殊情况到一般情况
     */
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int index = 0;

        for (int i = 1; i < n - k; ++i) {
            res[index] = i;
            ++index;
        }

        for (int i = n - k, j = n; i <= j; ++i, --j) {
            res[index] = i;
            ++index;
            if (i != j) {
                res[index] = j;
                ++index;
            }
        }
        return res;
    }
    
}
