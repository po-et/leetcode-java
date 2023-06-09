package com.home.jianzhi_offer_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 015. 字符串中的所有变位词
 *
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 变位词 指字母相同，但排列不同的字符串。
 *
 * 示例 1：
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的变位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的变位词。
 *
 * 示例 2：
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的变位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的变位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的变位词。
 *
 * 注意：本题与主站 438 题相同： https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 *
 * @see <a href="https://leetcode.cn/problems/VabMRr" />
 * @author Poet
 * @date 2023/3/16
 */
public class Offer_II_015_FindAllAnagramsIInAString {

    /**
     * 方法一：滑动窗口
     *
     * time:  O(m + (n-m)*∣Σ∣) 这道题中的字符集是小写字母 ∣Σ∣=26
     * space: O(∣Σ∣)
     */
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), m = p.length();
        List<Integer> res = new ArrayList<>();
        if (n < m) {
            return res;
        }

        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < m; i++) {
            ++cnt1[s.charAt(i) - 'a'];
            ++cnt2[p.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            res.add(0);
        }

        for (int i = m; i < n; i++) {
            ++cnt1[s.charAt(i) - 'a'];
            --cnt1[s.charAt(i - m) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                res.add(i - m + 1);
            }
        }
        return res;
    }

}
