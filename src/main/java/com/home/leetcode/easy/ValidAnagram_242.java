package com.home.leetcode.easy;

import java.util.Objects;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * @see <a href="https://leetcode.com/problemset/all/?search=242" />
 * @author Poet
 * @date 2020/4/18
 */
public class ValidAnagram_242 {

    public static void main(String[] args) {
//        String s = "anagram", t = "nagaram";
        String s = "ab", t = "a";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (Objects.isNull(s) || Objects.isNull(t) || s.length() != t.length()) {
            return false;
        }

        int[] array = new int[26];

        for (char ch : s.toCharArray()) {
            array[ch-'a'] ++;
        }

        for (char ch : t.toCharArray()) {
            if (array[ch - 'a'] == 0) {
                return false;
            }
            array[ch - 'a'] --;
        }

        return true;
    }

}
