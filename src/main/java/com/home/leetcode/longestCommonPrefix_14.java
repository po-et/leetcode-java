package com.home.leetcode;

/**
 * Created by Poet on 2019-01-10.
 */
public class longestCommonPrefix_14 {

    /**
     * time: O(n)
     * space: O(1)
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(res) != 0) {
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"test007", "testnew", "test101", "testbalabala"};
        System.out.println(longestCommonPrefix(strs));
    }
}
