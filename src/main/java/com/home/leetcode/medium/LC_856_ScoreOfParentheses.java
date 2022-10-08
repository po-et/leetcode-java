package com.home.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 856. Score of Parentheses （括号的分数）
 *
 * Given a balanced parentheses string s, return the score of the string.
 *
 * The score of a balanced parentheses string is based on the following rule:
 *      "()" has score 1.
 *      AB has score A + B, where A and B are balanced parentheses strings.
 *      (A) has score 2 * A, where A is a balanced parentheses string.
 *
 * Example 1:
 * Input: s = "()"
 * Output: 1
 *
 * Example 2:
 * Input: s = "(())"
 * Output: 2
 *
 * Example 3:
 * Input: s = "()()"
 * Output: 2
 *
 * @see <a href="https://leetcode.cn/problems/score-of-parentheses/" />
 * @author Poet
 * @date 2022/10/9
 */
public class LC_856_ScoreOfParentheses {

    /**
     * 方法一：分治
     *
     * time:  O(n^2) 其中 n 是字符串的长度。递归深度为 O(n)，每一层的所有函数调用的总时间复杂度都是 O(n)，因此总时间复杂度为 O(n^2)
     * space: O(n^2)
     */
    public int scoreOfParentheses(String s) {
        if (s.length() == 2) {
            return 1;
        }

        int balance = 0;
        int n = s.length();
        int len = 0;
        for (int i = 0; i < n; i++) {
            balance += s.charAt(i) == '(' ? 1 : -1;
            if (balance == 0) {
                len = i + 1;
                break;
            }
        }

        if (len == n) {
            // 对应 (A) 的形式
            return 2 * scoreOfParentheses(s.substring(1, n - 1));
        } else {
            // 对应 A+B 的形式
            return scoreOfParentheses(s.substring(0, len)) + scoreOfParentheses(s.substring(len));
        }
    }


    /**
     * 方法二：栈
     *
     * time:  O(n)
     * space: O(n)
     */
    public int scoreOfParentheses_2(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(0);
            } else {
                int v = stack.pop();
                int top = stack.pop() + Math.max(2 * v, 1);
                stack.push(top);
            }
        }

        return stack.peek();
    }

}