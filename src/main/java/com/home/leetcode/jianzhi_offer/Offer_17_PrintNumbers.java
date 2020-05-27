package com.home.leetcode.jianzhi_offer;

/**
 * 面试题17. 打印从1到最大的n位数
 *
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
 * @author Poet
 * @date 2020/5/28
 */
public class Offer_17_PrintNumbers {

    public int[] printNumbers(int n) {

        int size = 1;
        for (int i = 0; i < n; i++) {
            size *= 10;
        }

        int[] arr = new int[size - 1];
        for (int i = 0; i < size - 1; i++) {
            arr[i] = i + 1;
        }

        return arr;
    }
}
