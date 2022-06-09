package com.home.offer.jianzhi;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 *
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 *
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *
 * @see <a href="https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof" />
 * @author Poet
 * @date 2022/6/7
 */
public class Offer_58_II_ReverseLeftWords {

    /**
     * 方法一：字符串切片
     */
    public String reverseLeftWords(String s, int n) {

        return s.substring(n, s.length()) + s.substring(0, n);
    }

    // 方法一：字符串切片(Python解法)
//    def reverseLeftWords(self, s: str, n: int) -> str:
//            return s[n:] + s[:n]

}
