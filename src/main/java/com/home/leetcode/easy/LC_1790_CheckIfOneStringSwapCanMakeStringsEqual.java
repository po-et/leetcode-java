package com.home.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 1790. Check if One String Swap Can Make Strings Equal (仅执行一次字符串交换能否使两个字符串相等)
 *
 * You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices
 * in a string (not necessarily different) and swap the characters at these indices.
 *
 * Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. Otherwise, return false.
 *
 * Example 1:
 * Input: s1 = "bank", s2 = "kanb"
 * Output: true
 * Explanation: For example, swap the first character with the last character of s2 to make "bank".
 *
 * Example 2:
 * Input: s1 = "attack", s2 = "defend"
 * Output: false
 * Explanation: It is impossible to make them equal with one string swap.
 *
 * Example 3:
 * Input: s1 = "kelb", s2 = "kelb"
 * Output: true
 * Explanation: The two strings are already equal, so no string swap operation is required.
 *
 * @see <a href="https://leetcode.cn/problems/check-if-one-string-swap-can-make-strings-equal/" />
 * @author Poet
 * @date 2022/10/11
 */
public class LC_1790_CheckIfOneStringSwapCanMakeStringsEqual {

    // 自己完成 ac
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }

        int n = s1.length();
        int first = -1;
        int second = -1;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (first == -1) {
                    first = i;
                    continue;
                }
                if (second == -1) {
                    second = i;
                    if (s1.charAt(first) != s2.charAt(second) || s1.charAt(second) != s2.charAt(first)) {
                        return false;
                    }
                    continue;
                }
                if (first >= 0 && second >= 0) {
                    return false;
                }
            }
        }
        return first >= 0 && second >= 0;
    }

    /**
     * 方法一：计数统计
     *
     * time:  O(n) 其中 n 表示字符串的长度，我们只需遍历一遍字符串
     * space: O(C) 由于两个字符串中字符不同的数目大于 2 即可返回，因此最多只需要保存 C = 2 个不同位置的索引
     */
    public boolean areAlmostEqual_1(String s1, String s2) {
        int n = s1.length();
        List<Integer> diff = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (diff.size() >= 2) {
                    return false;
                }
                diff.add(i);
            }
        }

        if (diff.isEmpty()) {
            return true;
        }
        if (diff.size() != 2) {
            return false;
        }
        return s1.charAt(diff.get(0)) == s2.charAt(diff.get(1)) && s1.charAt(diff.get(1)) == s2.charAt(diff.get(0));
    }



    public static void main(String[] args) {
        LC_1790_CheckIfOneStringSwapCanMakeStringsEqual solution = new LC_1790_CheckIfOneStringSwapCanMakeStringsEqual();
        String s1 = "bank";
        String s2 = "kanb";
        System.out.println(solution.areAlmostEqual(s1, s2));
    }
}
