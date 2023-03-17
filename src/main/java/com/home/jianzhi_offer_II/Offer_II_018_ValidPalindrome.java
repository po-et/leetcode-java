package com.home.jianzhi_offer_II;

/**
 * 剑指 Offer II 019. 最多删除一个字符得到回文
 *
 * 给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。
 *
 * 示例 1:
 * 输入: s = "aba"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "abca"
 * 输出: true
 * 解释: 可以删除 "c" 字符 或者 "b" 字符
 *
 * 示例 3:
 * 输入: s = "abc"
 * 输出: false
 *
 * 注意：本题与主站 680 题相同： https://leetcode-cn.com/problems/valid-palindrome-ii/
 *
 * @see <a href="https://leetcode.cn/problems/XltzEq" />
 * @author Poet
 * @date 2023/3/17
 */
public class Offer_II_018_ValidPalindrome {

    /**
     * 方法一：贪心
     *
     * time:  O(n)
     * space: O(1)
     */
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }

        }
        return true;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
