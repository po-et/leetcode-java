package com.home.leetcode.easy;

/**
 * 14. Longest Common Prefix (最长公共前缀)
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * @see <a href="https://leetcode.cn/problems/longest-common-prefix/" />
 * @author Poet
 * @date 2022/8/2
 */
public class LC_14_LongestCommonPrefix {

    /**
     * 方法一：横向扫描
     *
     * time:  O(mn) 其中 m 是字符串数组中的字符串的平均长度，n 是字符串的数量
     * space: O(1)
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs[0].length() == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    private String longestCommonPrefix(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < len && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

}
