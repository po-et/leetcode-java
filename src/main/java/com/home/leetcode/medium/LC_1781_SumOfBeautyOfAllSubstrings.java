package com.home.leetcode.medium;

/**
 * 1781. Sum of Beauty of All Substrings (所有子字符串美丽值之和)
 *
 * The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.
 *
 * For example, the beauty of "abaacc" is 3 - 1 = 2.
 * Given a string s, return the sum of beauty of all of its substrings.
 *
 * Example 1:
 * Input: s = "aabcb"
 * Output: 5
 * Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.
 *
 * Example 2:
 * Input: s = "aabcbaa"
 * Output: 17
 *
 * @see <a href="https://leetcode.cn/problems/sum-of-beauty-of-all-substrings/" />
 * @author Poet
 * @date 2022/12/12
 */
public class LC_1781_SumOfBeautyOfAllSubstrings {

    /**
     * 双重循环
     *
     * time:  O(C×n^2) 其中 C 是 s 的元素种类，n 是 s 的长度
     * space: O(C)
     */
    public int beautySum(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] cnt = new int[26];
            int maxFreq = 0;
            for (int j = i; j < s.length(); j++) {
                cnt[s.charAt(j) - 'a']++;
                maxFreq = Math.max(maxFreq, cnt[s.charAt(j) - 'a']);
                int minFreq = s.length();
                for (int k = 0; k < 26; k++) {
                    if (cnt[k] > 0) {
                        minFreq = Math.min(minFreq, cnt[k]);
                    }
                }
                res += maxFreq - minFreq;
            }
        }
        return res;
    }
}
