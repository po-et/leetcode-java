package com.home.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 *
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 *
 * @see <a href="https://leetcode.cn/problems/isomorphic-strings/" />
 * @author Poet
 * @date 2020/4/18
 */
public class LC_205_IsomorphicStrings {

    public static void main(String[] args) {
        LC_205_IsomorphicStrings solution = new LC_205_IsomorphicStrings();
        String s = "egg", t = "add";
        System.out.println(solution.isIsomorphic(s, t));
    }

    /**
     * 时间更快的解法 （执行用时：22 ms）
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>(s.length());

        for (int i = 0; i < s.toCharArray().length; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(t.charAt(i))) {
                    return false;
                }
            } else {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(ch, t.charAt(i));
            }
        }
        return true;
    }

}
