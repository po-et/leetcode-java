package com.home.leetcode.medium;

/**
 * 921. Minimum Add to Make Parentheses Valid (使括号有效的最少添加)
 *
 * A parentheses string is valid if and only if:
 *
 * It is the empty string,
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.
 *
 * For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
 * Return the minimum number of moves required to make s valid.
 *
 * Example 1:
 * Input: s = "())"
 * Output: 1
 *
 * Example 2:
 * Input: s = "((("
 * Output: 3
 *
 * @see <a href="https://leetcode.cn/problems/minimum-add-to-make-parentheses-valid/" />
 * @author Poet
 * @date 2022/10/4
 */
public class LC_921_MinimumAddToMakeParenthesesValid {

    /**
     * 方法一：贪心
     *
     * time:  O(n)
     * space: O(1)
     */
    public int minAddToMakeValid(String s) {
        int res = 0;
        int leftCount = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                leftCount++;
            } else {
                if (leftCount > 0) {
                    leftCount--;
                } else {
                    res++;
                }
            }
        }

        res += leftCount;
        return res;
    }
}
