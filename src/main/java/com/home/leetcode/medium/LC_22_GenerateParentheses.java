package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses (括号生成)
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 *
 * @see <a href="https://leetcode.cn/problems/generate-parentheses/" />
 * @author Poet
 * @date 2022/8/28
 */
public class LC_22_GenerateParentheses {

    /**
     * 方法一：暴力法
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateAll(new char[2 * n], 0, res);
        return res;
    }

    private void generateAll(char[] current, int pos, List<String> res) {
        if (pos == current.length) {
            if (valid(current)) {
                res.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, res);
            current[pos] = ')';
            generateAll(current, pos + 1, res);
        }
    }

    private boolean valid(char[] current) {
        int balance = 0;
        for (char ch : current) {
            if (ch == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }


    /**
     * 方法二：回溯法
     *
     * sulution: https://leetcode.cn/problems/generate-parentheses/solution/gua-hao-sheng-cheng-by-leetcode-solution/
     */
    public List<String> generateParenthesis_2(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuffer(), 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, StringBuffer cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            res.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append('(');
            backtrack(res, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(res, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

}
