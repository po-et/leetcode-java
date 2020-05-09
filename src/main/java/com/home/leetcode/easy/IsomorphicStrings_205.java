package com.home.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
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
 * @see <a href="https://leetcode.com/problems/isomorphic-strings/" />
 * @author Poet
 * @date 2020/4/18
 */
public class IsomorphicStrings_205 {

    public static void main(String[] args) {
        IsomorphicStrings_205 solution = new IsomorphicStrings_205();
        String s = "egg", t = "add";
        System.out.println(solution.isIsomorphic(s, t));
    }

    public boolean isIsomorphic(String s, String t) {
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
