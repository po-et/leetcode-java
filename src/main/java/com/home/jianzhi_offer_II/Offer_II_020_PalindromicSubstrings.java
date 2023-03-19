package com.home.jianzhi_offer_II;

/**
 * 剑指 Offer II 020. 回文子字符串的个数
 *
 * 给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 * 示例 1：
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 *
 * 示例 2：
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 * 注意：本题与主站 647 题相同：https://leetcode-cn.com/problems/palindromic-substrings/
 *
 * @see <a href="https://leetcode.cn/problems/a7VOhD" />
 * @author Poet
 * @date 2023/3/18
 */
public class Offer_II_020_PalindromicSubstrings {

    /**
     * 方法一：中心拓展
     *
     * time:  O(n^2)
     * space: O(1)
     */
    public int countSubstrings_1(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2;
            int r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }

    /**
     * 方法二：Manacher 算法
     *
     * Manacher 算法是在线性时间内求解最长回文子串的算法。
     */



    /**
     * 暴力解法（自己ac）
     *
     * time:  O(n^3)  | 枚举所有字串：O(n^2)，再判断是不是回文O(n)
     * space: O(1)
     */
    public int countSubstrings_bruteForce(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (isPalindrome(s.substring(i, j))) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
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
