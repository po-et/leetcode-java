package com.home.jianzhi_offer_II;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer II 016. 不含重复字符的最长子字符串
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子字符串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子字符串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 *
 * 注意：本题与主站 3 题相同： https://leetcode-cn.com/problems/longest-substring-without-repeating-
 *
 * @see <a href="https://leetcode.cn/problems/wtcaE1" />
 * @author Poet
 * @date 2023/3/16
 */
public class Offer_II_016_LongestSubstringWithoutRepeatingCharacters {

    /**
     * 方法一：滑动窗口
     *
     * time:  O(N)，其中 N 是字符串的长度。左指针和右指针分别会遍历整个字符串一次
     * space: O(∣Σ∣)，其中 Σ 表示字符集（即字符串中可以出现的字符），∣Σ∣ 表示字符集的大小。在本题中没有明确说明字符集，因此可以默认为所有 ASCII 码在 [0,128) 内的字符，即 ∣Σ∣=128
     */
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int res = 0;
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int r = -1;
        for (int l = 0; l < n; l++) {
            if (l != 0) {
                // 左指针向右移动一格，移除一个字符
                set.remove(s.charAt(l - 1));
            }
            while (r + 1 < n && !set.contains(s.charAt(r + 1))) {
                set.add(s.charAt(r + 1));
                // 不断地移动右指针
                r++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
