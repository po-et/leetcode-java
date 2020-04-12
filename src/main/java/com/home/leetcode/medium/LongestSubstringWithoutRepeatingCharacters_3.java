package com.home.leetcode.medium;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * @url https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * @author Poet
 * @date 2020/4/12
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {

    static int[] freq = new int[128];

    public static int lengthOfLongestSubstring(String s) {
        // s[l...r] 为滑动窗口
        int l = 0,r = -1;
        int res= 0;

        while (l < s.length()) {
            if(r + 1 < s.length() && freq[s.charAt(r+1)] == 0){
                freq[s.charAt(r+1)] = 1;
                r++;
            } else {
                freq[s.charAt(l)] = 0;
                l++;
            }

            res = Math.max(res, r-l+1);
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
