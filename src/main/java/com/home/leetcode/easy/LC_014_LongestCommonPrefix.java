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
public class LC_014_LongestCommonPrefix {

    /**
     * 方法一：横向扫描
     *
     * 用 LCP(S1…Sn) 表示字符串 S1…Sn 的最长公共前缀，可以得到以下结论：
     * LCP(S1… Sn) = LCP(LCP(LCP(S1,S2),S3),…Sn)
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


    /**
     * 方法二：纵向扫描
     *
     * time:  O(mn) 其中 m 是字符串数组中的字符串的平均长度，n 是字符串的数量
     * space: O(1)
     */
    public String longestCommonPrefix_2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

}
