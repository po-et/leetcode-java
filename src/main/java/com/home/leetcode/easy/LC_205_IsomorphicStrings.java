package com.home.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 205. Isomorphic Strings （同构字符串）
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

    /**
     * 方法一：哈希表
     *
     * 判断每个位置上的字符是否都一一对应，即 s 的任意一个字符被 t 中唯一的字符对应，t 的任意一个字符被 s 中唯一的字符对应。这也被称为「双射」的关系。
     *
     * 备注：时间更快的解法 （执行用时：22 ms）
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }

    public boolean isIsomorphic_2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
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

    public boolean isIsomorphic_3(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> visited = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                map.put(s.charAt(i), t.charAt(i));
                if (visited.contains(t.charAt(i))) {
                    return false;
                }
                visited.add(t.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC_205_IsomorphicStrings solution = new LC_205_IsomorphicStrings();
        String s = "egg", t = "add";
        System.out.println(solution.isIsomorphic(s, t));
    }

}
