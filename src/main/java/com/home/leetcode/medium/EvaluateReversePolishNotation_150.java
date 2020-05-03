package com.home.leetcode.medium;

import java.util.Stack;

/**
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
 * @see <a href = "https://leetcode.com/problems/evaluate-reverse-polish-notation/" />
 * @author Poet
 * @date 2020/5/3
 */
public class EvaluateReversePolishNotation_150 {

    public int evalRPN(String[] tokens) {
        if(tokens == null) throw new IllegalArgumentException("param is not valid.");

        Stack<String> stack = new Stack<>();
        int res = 0;

        for (String token : tokens) {
            if("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token) ) {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
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
                stack.push(res+"");

            } else {
                stack.push(token);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    /**
     * 方法一样，上述写法的简化
     * @param tokens
     * @return
     */
    public int evalRPN2(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int num1, num2;

        for (String token : tokens) {
            if ("+".equals(token)) {
                stack.push(stack.pop() + stack.pop());

            } else if ("-".equals(token)) {
                num2 = stack.pop();
                num1 = stack.pop();
                stack.push(num1 - num2);

            } else if ("*".equals(token)) {
                stack.push(stack.pop() * stack.pop());

            } else if ("/".equals(token)) {
                num2 = stack.pop();
                num1 = stack.pop();
                stack.push(num1 / num2);

            } else {
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }
}
