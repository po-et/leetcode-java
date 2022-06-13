package com.home.leetcode.easy;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 *
 * @see <a href='https://leetcode.cn/problems/valid-parentheses/' />
 * @author Poet
 * @date 2020/5/3
 */
public class LC_020_ValidParentheses {

    /**
     * 方法：栈
     *
     * core:【栈顶元素反映了在嵌套的层次关系中，最近的需要匹配的元素】
     */
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if ('(' == ch || '[' == ch || '{' == ch) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
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

    public static boolean isValid_2(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

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
        LC_020_ValidParentheses solution = new LC_020_ValidParentheses();

        String s = "([)]{}";
        System.out.println(solution.isValid(s));
    }

}
