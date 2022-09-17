package com.home.leetcode.easy;

/**
 * 1624. Largest Substring Between Two Equal Characters (两个相同字符之间的最长子字符串)
 *
 * Given a string s, return the length of the longest substring between two equal characters, excluding the two characters. If there is no such substring return -1.
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 * Example 1:
 * Input: s = "aa"
 * Output: 0
 * Explanation: The optimal substring here is an empty substring between the two 'a's.
 *
 * Example 2:
 * Input: s = "abca"
 * Output: 2
 * Explanation: The optimal substring here is "bc".
 *
 * Example 3:
 * Input: s = "cbzxy"
 * Output: -1
 * Explanation: There are no characters that appear twice in s.
 *
 * @see <a href="https://leetcode.cn/problems/largest-substring-between-two-equal-characters/" />
 * @author Poet
 * @date 2022/9/17
 */
public class LC_1624_LargestSubstringBetweenTwoEqualCharacters {

    /**
     * 方法一：直接遍历
     */
    public int maxLengthBetweenEqualCharacters(String s) {
        int res = -1;
        char[] chars = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i ; j--) {
                if (chars[i] == chars[j]) {
                    res = Math.max(res, j - i - 1);
                    break;
                }
            }
        }
        return res;
    }
}
