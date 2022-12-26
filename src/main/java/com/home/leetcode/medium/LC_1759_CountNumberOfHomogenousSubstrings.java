package com.home.leetcode.medium;

/**
 * 1759. Count Number of Homogenous Substrings
 *
 * Given a string s, return the number of homogenous substrings of s. Since the answer may be too large, return it modulo 10^9 + 7.
 *
 * A string is homogenous if all the characters of the string are the same.
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 * Example 1:
 * Input: s = "abbcccaa"
 * Output: 13
 * Explanation: The homogenous substrings are listed as below:
 * "a"   appears 3 times.
 * "aa"  appears 1 time.
 * "b"   appears 2 times.
 * "bb"  appears 1 time.
 * "c"   appears 3 times.
 * "cc"  appears 2 times.
 * "ccc" appears 1 time.
 * 3 + 1 + 2 + 1 + 3 + 2 + 1 = 13.
 *
 * Example 2:
 * Input: s = "xy"
 * Output: 2
 * Explanation: The homogenous substrings are "x" and "y".
 *
 * Example 3:
 * Input: s = "zzzzz"
 * Output: 15
 *
 * @see <a href="https://leetcode.cn/problems/count-number-of-homogenous-substrings/" />
 * @author Poet
 * @date 2022/12/26
 */
public class LC_1759_CountNumberOfHomogenousSubstrings {

    /**
     * 方法一：数学
     *
     * time:  O(n)
     * space: O(1)
     */
    public int countHomogenous(String s) {
        long res = 0;
        char prev = s.charAt(0);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == prev) {
                count++;
            } else {
                res += (long) count * (count + 1) / 2;
                count = 1;
                prev = ch;
            }
        }
        res += (long) count * (count + 1) / 2;
        return (int) (res % 1000000007);
    }

}
