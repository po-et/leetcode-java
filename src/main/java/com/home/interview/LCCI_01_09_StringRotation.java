package com.home.interview;

/**
 * 面试题 01.09. String Rotation LCCI (字符串轮转)
 *
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 (e.g.,"waterbottle" is a rotation of"erbottlewat").
 *
 * Can you use only one call to the method that checks if one word is a substring of another?
 *
 * Example 1:
 * Input: s1 = "waterbottle", s2 = "erbottlewat"
 * Output: True
 *
 * Example 2:
 * Input: s1 = "aa", s2 = "aba"
 * Output: False
 *
 * @see <a href="https://leetcode.cn/problems/string-rotation-lcci/" />
 * @author Poet
 * @date 2022/9/29
 */
public class LCCI_01_09_StringRotation {

    /**
     * 方法一：模拟
     *
     * time:  O(n^2)
     * space: O(1)
     */
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }

        int n = s1.length();
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (s1.charAt((i + j) %  n) != s2.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }

    /**
     * 方法二：搜索子字符串
     *
     * time:  O(n) KMP 算法搜索子字符串的时间复杂度为 O(n)
     * space: O(n) KMP 算法搜索子字符串的空间复杂度为 O(n)
     */
    public boolean isFlipedString_2(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }

}
