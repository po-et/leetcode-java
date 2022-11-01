package com.home.leetcode.easy;

/**
 * 1662. Check If Two String Arrays are Equivalent
 *
 * Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
 *
 * A string is represented by an array if the array elements concatenated in order forms the string.
 *
 * Example 1:
 * Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
 * Output: true
 * Explanation:
 * word1 represents string "ab" + "c" -> "abc"
 * word2 represents string "a" + "bc" -> "abc"
 * The strings are the same, so return true.
 *
 * Example 2:
 * Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
 * Output: false
 *
 * Example 3:
 * Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * Output: true
 *
 * @see <a href="https://leetcode.cn/problems/check-if-two-string-arrays-are-equivalent/" />
 * @author Poet
 * @date 2022/11/1
 */
public class LC_1662_CheckIfTwoStringArraysAreEquivalent {

    /**
     * 方法一：拼接字符串进行对比
     *
     * time:  O(n+m)
     * space: O(n+m)
     */
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return join(word1).equals(join(word2));
    }

    private String join(String[] words) {
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            builder.append(word);
        }
        return builder.toString();
    }


    /**
     * 方法二：遍历
     *
     * 更进一步的想法，我们可以直接在 word1 和 word2 上进行对比，避免额外创建字符串
     *
     * time:  O(n+m)
     * space: O(1)
     */
    public boolean arrayStringsAreEqual_2(String[] word1, String[] word2) {
        int p1 = 0, p2 = 0, i = 0, j = 0;
        while (p1 < word1.length && p2 < word2.length) {
            if (word1[p1].charAt(i) != word2[p2].charAt(j)) {
                return false;
            }
            i++;
            if (i == word1[p1].length()) {
                p1++;
                i = 0;
            }
            j++;
            if (j == word2[p2].length()) {
                p2++;
                j = 0;
            }
        }
        return p1 == word1.length && p2 == word2.length;
    }

}
