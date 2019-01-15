package com.home.leetcode;

import java.util.Stack;

/**
 * 32. Longest Valid Parentheses
 *
 * for example:
 *  "(()"     -> 2
 *  ")()())"  -> 4
 *
 * Created by Poet on 2019-01-15.
 */
public class LongestValidParentheses_32 {

    /**
     * 使用栈stack
     *
     * time: O(n)
     * space: O(n)
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        res = Math.max(res, i - start);
                    } else {
                        res = Math.max(res, i - stack.peek());
                    }
                }
            }
        }
        return res;
    }
}
