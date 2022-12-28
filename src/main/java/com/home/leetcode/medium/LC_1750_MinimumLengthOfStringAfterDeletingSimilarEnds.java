package com.home.leetcode.medium;

/**
 * 1750. Minimum Length of String After Deleting Similar Ends (删除字符串两端相同字符后的最短长度)
 *
 * Given a string s consisting only of characters 'a', 'b', and 'c'. You are asked to apply the following algorithm on the string any number of times:
 *
 *  1. Pick a non-empty prefix from the string s where all the characters in the prefix are equal.
 *  2. Pick a non-empty suffix from the string s where all the characters in this suffix are equal.
 *  3. The prefix and the suffix should not intersect at any index.
 *  4. The characters from the prefix and suffix must be the same.
 *  5. Delete both the prefix and the suffix.
 *
 * Return the minimum length of s after performing the above operation any number of times (possibly zero times).
 *
 * Example 1:
 * Input: s = "ca"
 * Output: 2
 * Explanation: You can't remove any characters, so the string stays as is.
 *
 * Example 2:
 * Input: s = "cabaabac"
 * Output: 0
 * Explanation: An optimal sequence of operations is:
 * - Take prefix = "c" and suffix = "c" and remove them, s = "abaaba".
 * - Take prefix = "a" and suffix = "a" and remove them, s = "baab".
 * - Take prefix = "b" and suffix = "b" and remove them, s = "aa".
 * - Take prefix = "a" and suffix = "a" and remove them, s = "".
 *
 * Example 3:
 * Input: s = "aabccabba"
 * Output: 3
 * Explanation: An optimal sequence of operations is:
 * - Take prefix = "aa" and suffix = "a" and remove them, s = "bccabb".
 * - Take prefix = "b" and suffix = "bb" and remove them, s = "cca".
 *
 * @see <a href="https://leetcode.cn/problems/minimum-length-of-string-after-deleting-similar-ends/" />
 * @author Poet
 * @date 2022/12/28
 */
public class LC_1750_MinimumLengthOfStringAfterDeletingSimilarEnds {

    /**
     * 方法一：双指针
     *
     * time:  O(n)
     * space: O(1)
     */
    public int minimumLength(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                break;
            }
            char ch = s.charAt(l);
            while (l <= r && s.charAt(l) == ch) {
                l++;
            }
            while (l <= r && s.charAt(r) == ch) {
                r--;
            }
        }
        return r - l + 1;
    }
}
