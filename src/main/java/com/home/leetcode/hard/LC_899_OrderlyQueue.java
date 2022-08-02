package com.home.leetcode.hard;

import java.util.Arrays;

/**
 * 899. Orderly Queue (有序队列)
 *
 * You are given a string s and an integer k. You can choose one of the first k letters of s and append it at the end of the string..
 *
 * Return the lexicographically smallest string you could have after applying the mentioned step any number of moves.
 *
 * Example 1:
 * Input: s = "cba", k = 1
 * Output: "acb"
 * Explanation:
 * In the first move, we move the 1st character 'c' to the end, obtaining the string "bac".
 * In the second move, we move the 1st character 'b' to the end, obtaining the final result "acb".
 *
 * Example 2:
 * Input: s = "baaca", k = 3
 * Output: "aaabc"
 * Explanation:
 * In the first move, we move the 1st character 'b' to the end, obtaining the string "aacab".
 * In the second move, we move the 3rd character 'c' to the end, obtaining the final result "aaabc".
 *
 * @see <a href="https://leetcode.cn/problems/orderly-queue/" />
 * @author Poet
 * @date 2022/8/3
 */
public class LC_899_OrderlyQueue {

    /**
     * 方法一：分情况讨论
     */
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String min = s;
            StringBuilder builder = new StringBuilder(s);
            for (int i = 1; i < s.length(); i++) {
                char c = builder.charAt(0);
                builder.deleteCharAt(0);
                builder.append(c);
                if (builder.toString().compareTo(min) < 0) {
                    min = builder.toString();
                }
            }
            return min;

        } else {    // k >= 2 解即为字典升序
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }
}
