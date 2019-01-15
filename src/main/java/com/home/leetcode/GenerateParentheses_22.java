package com.home.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成n对正确匹配的括号
 *
 * 【卡特兰数】：
 *     (0,n-1) (1,n-2) (2,n-3) ... (n-1,0)
 *
 *  catalan数满足递推式：
 *      h(n)= h(0)*h(n-1)+h(1)*h(n-2) + ... + h(n-1)*h(0) (n>=2)
 *  递推关系的解为：
 *      h(n)=C(2n,n)/(n+1) (n=0,1,2,...)
 *  递推关系的另类解为：
 *      h(n)=c(2n,n)-c(2n,n-1)(n=0,1,2,...)
 *
 *   给定n对括号，求括号正确配对的字符串数，例如：
 *      0对括号：[空序列] 1种可能
 *      1对括号：() 1种可能
 *      2对括号：()() (()) 2种可能
 *      3对括号：((())) ()(()) ()()() (())() (()()) 5种可能
 * @Via: https://zh.wikipedia.org/wiki/%E5%8D%A1%E5%A1%94%E5%85%B0%E6%95%B0
 *
 * Created by Poet on 2019-01-11.
 */
public class GenerateParentheses_22 {

    /**
     * time: O(n!) (2^n)
     * space: O(n)
     */
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n==0) return res;
        helper(res, "", n, n);
        return res;
    }

    private static void helper(List<String> res, String s, int left, int right) {
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        if (left > 0) {
            helper(res, s+"(", left-1, right);
        }
        if (right > 0) {
            helper(res, s + ")", left, right-1);
        }
    }


    public static void main(String[] args) {
        generateParenthesis(1).forEach(System.out::println);
        System.out.println("-----------------");
        generateParenthesis(2).forEach(System.out::println);
        System.out.println("-----------------");
        generateParenthesis(3).forEach(System.out::println);
        System.out.println("-----------------");
        generateParenthesis(4).forEach(System.out::println);
    }

}
