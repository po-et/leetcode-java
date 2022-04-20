package com.home.offer.jianzhi;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长不含重复字符的子字符串
 *
 * 题目：请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。假设字符串中只包含从'a'到'z'的字符。
 *
 * @author Poet
 * @date 2020/5/20
 */
public class Offer_48_LongestSubstringWithoutDuplicate {

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
