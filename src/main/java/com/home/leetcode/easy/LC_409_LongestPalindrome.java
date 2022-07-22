package com.home.leetcode.easy;

/**
 * 409. Longest Palindrome (最长回文串)
 *
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
 *
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 *
 * Example 1:
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 *
 * Example 2:
 * Input: s = "a"
 * Output: 1
 * Explanation: The longest palindrome that can be built is "a", whose length is 1.
 *
 * @see <a href="https://leetcode.cn/problems/longest-palindrome/" />
 * @author Poet
 * @date 2022/7/22
 */
public class LC_409_LongestPalindrome {

    /**
     * 方法一：贪心
     *
     * time:  O(N)，其中 N 为字符串 s 的长度。我们需要遍历每个字符一次。
     * space: O(S)，其中 S 为字符集大小。在 Java 代码中，我们使用了一个长度为 128 的数组，存储每个字符出现的次数，这是因为字符的 ASCII 值的范围为 [0, 128)。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/longest-palindrome/solution/zui-chang-hui-wen-chuan-by-leetcode-solution/
     */
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;
        }

        int ans = 0;
        for (int v : count) {
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
            ans += v / 2 * 2;
        }
        return ans;
    }

}
