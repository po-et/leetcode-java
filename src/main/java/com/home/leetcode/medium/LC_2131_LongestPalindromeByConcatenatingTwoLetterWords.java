package com.home.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 2131. Longest Palindrome by Concatenating Two Letter Words (连接两字母单词得到的最长回文串)
 *
 * You are given an array of strings words. Each element of words consists of two lowercase English letters.
 *
 * Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. Each element can be selected at most once.
 *
 * Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.
 *
 * A palindrome is a string that reads the same forward and backward.
 *
 * Example 1:
 * Input: words = ["lc","cl","gg"]
 * Output: 6
 * Explanation: One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of length 6.
 * Note that "clgglc" is another longest palindrome that can be created.
 *
 * Example 2:
 * Input: words = ["ab","ty","yt","lc","cl","ab"]
 * Output: 8
 * Explanation: One longest palindrome is "ty" + "lc" + "cl" + "yt" = "tylcclyt", of length 8.
 * Note that "lcyttycl" is another longest palindrome that can be created.
 *
 * Example 3:
 * Input: words = ["cc","ll","xx"]
 * Output: 2
 * Explanation: One longest palindrome is "cc", of length 2.
 * Note that "ll" is another longest palindrome that can be created, and so is "xx".
 *
 * @see <a href="https://leetcode.cn/problems/longest-palindrome-by-concatenating-two-letter-words/" />
 * @author Poet
 * @date 2022/8/6
 */
public class LC_2131_LongestPalindromeByConcatenatingTwoLetterWords {

    // 参考答案
    /**
     * 方法一：贪心 + 哈希表
     *
     * solution: https://leetcode.cn/problems/longest-palindrome-by-concatenating-two-letter-words/solution/lian-jie-liang-zi-mu-dan-ci-de-dao-de-zu-vs99/
     */
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        int add = 0;
        int ans = 0;
        for (String s : map.keySet()) {
            if (s.charAt(0) == s.charAt(1)) {
                ans += ((map.get(s) >> 1) << 2);
                if (((map.get(s) & 1) == 1)) {add = 2;}
            } else {
                String t = pal(s);
                if (map.containsKey(t)) {
                    ans += Math.min(map.get(s), map.get(t)) * 2;
                }
            }
        }
        return ans + add;
    }

    public String pal(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
