package com.home.jianzhi_offer;

/**
 * 面试题43. 1～n整数中1出现的次数
 *
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * 示例 1：
 * 输入：n = 12
 * 输出：5
 *
 * 链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof
 * @author Poet
 * @date 2020/5/31
 */
public class Offer_43_NumberOfDigitOne {


    // 超出时间限制
    // 入参：824883294
    public static int countDigitOne(int n) {
        int res = 0;
        for (int i = 1; i <= n ; i++) {
            res += stat(i);
        }
        return res;
    }

    private static int stat(int n) {
        int res = 0;
        while (n > 0) {
            int mod = n % 10;
            if(mod == 1) res++;
            n = n / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countDigitOne(824883294));
    }
}
