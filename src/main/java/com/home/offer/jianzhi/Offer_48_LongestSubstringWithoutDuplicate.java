package com.home.offer.jianzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 *
 * 题目：请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。假设字符串中只包含从'a'到'z'的字符。
 *
 * 示例1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * @see <a href="https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof" />
 * @author Poet
 * @date 2020/5/20
 */
public class Offer_48_LongestSubstringWithoutDuplicate {

    /**
     * 同主站 {@link LC_003_LongestSubstringWithoutRepeatingCharacters}
     */
    public int getLongestSubstring_readable(String s) {
        // s[l...r] 为滑动窗口
        int l = 0, r = -1;
        int res = 0;
        int[] freq = new int[128];

        while (l < s.length()) {
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
                freq[s.charAt(r + 1)] = 1;
                r++;
            } else {
                freq[s.charAt(l)] = 0;
                l++;
            }

            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public static String getLongestSubstring(String s) {
        // valid
        if (s == null) return "";

        // s[l...r]为滑动窗口
        int l = 0, r = -1;
        int maxLen = 0;
        String ret = "";
        Map<Character, Integer> freq = new HashMap<>();

        while (l < s.length()){
            if (r + 1 < s.length() && (!freq.containsKey(s.charAt(r + 1)) || freq.get(s.charAt(r + 1)) == 0)) {
                freq.put(s.charAt(r + 1), 1);
                r++;
            } else {
                freq.put(s.charAt(l), 0);
                l++;
            }

            if ((r - l + 1) > maxLen) {
                maxLen = r - l + 1;
                ret = s.substring(l, r + 1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String s = "arabcacfr";
        System.out.println(s);
        System.out.println(getLongestSubstring(s));

        String s1 = "abcdefghfa";
        System.out.println(s1);
        System.out.println(getLongestSubstring(s1));
    }

}
