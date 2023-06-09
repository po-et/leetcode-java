package com.home.jianzhi_offer_II;

import java.util.Arrays;

/**
 * 剑指 Offer II 014. 字符串中的变位词
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 *
 * 示例 1：
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 * 示例 2：
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 * 注意：本题与主站 567 题相同： https://leetcode-cn.com/problems/permutation-in-string/
 *
 * @see <a href="https://leetcode.cn/problems/MPnaiL" />
 * @author Poet
 * @date 2023/3/16
 */
public class Offer_II_014_PermutationInString {

    /**
     * 方法一：滑动窗口
     *
     * time:  O(n+m+∣Σ∣) 这道题中的字符集是小写字母 ∣Σ∣=26
     * space: O(∣Σ∣)
     */
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }

        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; i++) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }

        for (int i = n; i < m; i++) {
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 方法二：双指针
     */


}
