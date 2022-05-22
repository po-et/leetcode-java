package com.home.leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Example 1:
 *
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 *
 * @coment 逆波兰表达式，所有操作符置于操作数的后面，因此也被称为后缀表示法。逆波兰记法不需要括号来标识操作符的优先级。
 *
 * @see <a href = "https://leetcode.cn/problems/evaluate-reverse-polish-notation/" />
 * @author Poet
 * @date 2020/5/3
 */
public class LC_150_EvaluateReversePolishNotation {

    /**
     * 方法一：栈
     */
    public int evalRPN(String[] tokens) {
        if(tokens == null) throw new IllegalArgumentException("param is not valid.");

        Stack<Integer> stack = new Stack<>();
//        Deque<Integer> stack = new LinkedList<>();    // 更快
        int res = 0;

        for (String token : tokens) {
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                int num2 = stack.pop();
                int num1 = stack.pop();

                if ("+".equals(token)) {
                    res = num1 + num2;
                } else if ("-".equals(token)) {
                    res = num1 - num2;
                } else if ("*".equals(token)) {
                    res = num1 * num2;
                } else {  // "/".equals(token)
                    assert (num2 != 0);
                    res = num1 / num2;
                }
                stack.push(res);

            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    /**
     * 方法一样，官方回答的写法
     * time: O(n)
     * space: O(n)
     */
    public int evalRPN2(String[] tokens) {
        Deque<Integer> stack = new LinkedList<Integer>();

        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            String token = tokens[i];
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                }
            }
        }
        return stack.pop();
    }

    public boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }

}
