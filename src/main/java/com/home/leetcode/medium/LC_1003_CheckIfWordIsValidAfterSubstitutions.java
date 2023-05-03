package com.home.leetcode.medium;

/**
 * 1003. Check If Word Is Valid After Substitutions (检查替换后的词是否有效)
 *
 * Given a string s, determine if it is valid.
 *
 * A string s is valid if, starting with an empty string t = "", you can transform t into s after performing the following operation any number of times:
 *
 * Insert string "abc" into any position in t. More formally, t becomes tleft + "abc" + tright, where t == tleft + tright. Note that tleft and tright may be empty.
 * Return true if s is a valid string, otherwise, return false.
 *
 * Example 1:
 * Input: s = "aabcbc"
 * Output: true
 * Explanation:
 * "" -> "abc" -> "aabcbc"
 * Thus, "aabcbc" is valid.
 *
 * Example 2:
 * Input: s = "abcabcababcc"
 * Output: true
 * Explanation:
 * "" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
 * Thus, "abcabcababcc" is valid.
 *
 * Example 3:
 * Input: s = "abccba"
 * Output: false
 * Explanation: It is impossible to get "abccba" using the operation.
 *
 * @see <a href="https://leetcode.cn/problems/check-if-word-is-valid-after-substitutions/" />
 * @author Poet
 * @date 2023/5/3
 */
public class LC_1003_CheckIfWordIsValidAfterSubstitutions {

    /**
     * 方法一：栈
     */
    public boolean isValid(String s) {
        StringBuilder stk = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stk.append(c);
            if (stk.length() >= 3 && stk.substring(stk.length() - 3).equals("abc")) {
                stk.delete(stk.length() - 3, stk.length());
            }
        }
        return stk.isEmpty();
    }
}
