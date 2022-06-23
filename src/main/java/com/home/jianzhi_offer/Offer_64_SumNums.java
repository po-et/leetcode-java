package com.home.jianzhi_offer;

/**
 * 剑指 Offer 64. 求1+2+…+n
 *
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 示例 1：
 * 输入: n = 3
 * 输出: 6
 *
 * 示例 2：
 * 输入: n = 9
 * 输出: 45
 *
 * @see <a href="https://leetcode.cn/problems/qiu-12n-lcof/" />
 * @author Poet
 * @date 2022/6/23
 */
public class Offer_64_SumNums {

    /**
     * 首先我们梳理题目要求:
     *     题目要求我们不能使用乘除法、for、while、if、else、switch、case 等关键字及条件判断语句，
     *     因此我们手里能用的工具很少，列举出来发现只有加减法、赋值、位运算符以及逻辑运算符。
     */


    /**
     * 方法一：递归
     *
     * time:  O(n) 递归函数递归 n 次，每次递归中计算时间复杂度为 O(1)，因此总时间复杂度为 O(n)
     * space: O(n) 递归函数的空间复杂度取决于递归调用栈的深度，这里递归函数调用栈深度为 O(n)，因此空间复杂度为 O(n)
     */
    public int sumNums(int n) {
        // 使用提条件判断语句
//        return n == 0 ? 0 : n + sumNums(n - 1);

        // 替换为逻辑运算符 &&
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
