package com.home.leetcode.medium;

/**
 * 3. Longest Substring Without Repeating Characters（无重复字符的最长子串）
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * @see <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/" />
 * @author Poet
 * @date 2020/4/12
 */
public class LC_003_LongestSubstringWithoutRepeatingCharacters {

    static int[] freq = new int[128];

    public static int lengthOfLongestSubstring(String s) {
        // s[l...r] 为滑动窗口
        int l = 0, r = -1;
        int res = 0;

        while (l < s.length()) {
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
                freq[s.charAt(r + 1)] = 1;
                r++;
            } else {
                freq[s.charAt(l)] = 0;
                l++;
            }

            res = Math.max(res, r - l + 1);
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

}
