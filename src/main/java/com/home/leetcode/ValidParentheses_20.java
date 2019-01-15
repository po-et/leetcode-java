package com.home.leetcode;

import java.util.Stack;

/**
 * 括号是否匹配
 * <p>
 * case: ()[]{}   ture
 * case: ([)]     false
 * <p>
 * tips: 用栈的思想！
 * <p>
 * Created by Poet on 2019-01-11.
 */
public class ValidParentheses_20 {

    /**
     * time: O(n)
     * space: O(n)
     */
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "([)]{}";
        System.out.println(isValid(s));
    }
}
