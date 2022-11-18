package com.home.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1106. Parsing A Boolean Expression （解析布尔表达式）
 *
 * A boolean expression is an expression that evaluates to either true or false. It can be in one of the following shapes:
 *
 * 't' that evaluates to true.
 * 'f' that evaluates to false.
 * '!(subExpr)' that evaluates to the logical NOT of the inner expression subExpr.
 * '&(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical AND of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
 * '|(subExpr1, subExpr2, ..., subExprn)' that evaluates to the logical OR of the inner expressions subExpr1, subExpr2, ..., subExprn where n >= 1.
 *
 * Given a string expression that represents a boolean expression, return the evaluation of that expression.
 *
 * It is guaranteed that the given expression is valid and follows the given rules.
 *
 * Example 1:
 * Input: expression = "&(|(f))"
 * Output: false
 * Explanation:
 * First, evaluate |(f) --> f. The expression is now "&(f)".
 * Then, evaluate &(f) --> f. The expression is now "f".
 * Finally, return false.
 *
 * Example 2:
 * Input: expression = "|(f,f,f,t)"
 * Output: true
 * Explanation: The evaluation of (false OR false OR false OR true) is true.
 *
 * Example 3:
 * Input: expression = "!(&(f,t))"
 * Output: true
 * Explanation:
 * First, evaluate &(f,t) --> (false AND true) --> false --> f. The expression is now "!(f)".
 * Then, evaluate !(f) --> NOT false --> true. We return true.
 *
 * @see <a href="https://leetcode.cn/problems/parsing-a-boolean-expression/" />
 * @author Poet
 * @date 2022/11/5
 */
public class LC_1106_ParsingABooleanExpression {

    /* --- 这道题来自：第 143 场周赛 --- */

    /**
     * 方法：栈
     */
    public boolean parseBoolExpr(String expression) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = expression.length();
        for (int i = 0; i < n; i++) {
            char ch = expression.charAt(i);
            if (ch == ',') {
                continue;
            } else if (ch != ')') {
                stack.push(ch);
            } else {
                int t = 0, f = 0;
                while (stack.peek() != '(') {
                    char val = stack.pop();
                    if (val == 't') {
                        t++;
                    } else {    // val == 'f'
                        f++;
                    }
                }
                stack.pop();

                char op = stack.pop();
                switch (op) {
                    case '!' -> stack.push(f == 1 ? 't' : 'f');
                    case '&' -> stack.push(f == 0 ? 't' : 'f');
                    case '|' -> stack.push(t > 0 ? 't' : 'f');
                    default -> {}
                }
            }
        }
        return stack.pop() == 't';
    }

}