package com.home.leetcode.easy;

import java.util.Arrays;

/**
 * 2496. Maximum Value of a String in an Array
 *
 * The value of an alphanumeric string can be defined as:
 *      - The numeric representation of the string in base 10, if it comprises of digits only.
 *      - The length of the string, otherwise.
 *
 * Given an array strs of alphanumeric strings, return the maximum value of any string in strs.
 *
 * Example 1:
 * Input: strs = ["alic3","bob","3","4","00000"]
 * Output: 5
 * Explanation:
 * - "alic3" consists of both letters and digits, so its value is its length, i.e. 5.
 * - "bob" consists only of letters, so its value is also its length, i.e. 3.
 * - "3" consists only of digits, so its value is its numeric equivalent, i.e. 3.
 * - "4" also consists only of digits, so its value is 4.
 * - "00000" consists only of digits, so its value is 0.
 * Hence, the maximum value is 5, of "alic3".
 *
 * Example 2:
 * Input: strs = ["1","01","001","0001"]
 * Output: 1
 * Explanation:
 * Each string in the array has value 1. Hence, we return 1.
 *
 * @see <a href="https://leetcode.cn/problems/maximum-value-of-a-string-in-an-array/" />
 * @author Poet
 * @date 2023/6/23
 */
public class LC_2496_MaximumValueOfAStringInAnArray {

    /**
     * 方法一：字符串遍历
     *
     * time:  O(mn)
     * space: O(1)
     */
    public int maximumValue(String[] strs) {
        int n = strs.length;
        int[] lenArray = new int[n];
        for (int i = 0; i < n; i++) {
            String str = strs[i];
            if (isDigit(str)) {
                lenArray[i] = Integer.valueOf(str);
            } else {
                lenArray[i] = str.length();
            }
        }

        return Arrays.stream(lenArray).max().getAsInt();
    }

    private boolean isDigit(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

}
