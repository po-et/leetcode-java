package com.home.leetcode.easy;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * @see <a href = 'https://leetcode.com/problems/valid-parentheses/' />
 * @author Poet
 * @date 2020/5/3
 */
public class ValidParentheses_20 {

    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) return true;

        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if ('(' == ch || '[' == ch || '{' == ch) {
                stack.push(ch);
            } else {
                if (stack.isEmpty())
                    return false;

                Character pop = stack.pop();
                if (')' == ch && pop != '(') {
                    return false;
                } else if (']' == ch && pop != '[') {
                    return false;
                } else if ('}' == ch && pop != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }



}
