package com.home.leetcode.easy;

/**
 * 2586. Count the Number of Vowel Strings in Range (统计范围内的元音字符串数)
 *
 * You are given a 0-indexed array of string words and two integers left and right.
 *
 * A string is called a vowel string if it starts with a vowel character and ends with a vowel character where vowel characters are 'a', 'e', 'i', 'o', and 'u'.
 *
 * Return the number of vowel strings words[i] where i belongs to the inclusive range [left, right].
 *
 * Example 1:
 * Input: words = ["are","amy","u"], left = 0, right = 2
 * Output: 2
 * Explanation:
 * - "are" is a vowel string because it starts with 'a' and ends with 'e'.
 * - "amy" is not a vowel string because it does not end with a vowel.
 * - "u" is a vowel string because it starts with 'u' and ends with 'u'.
 * The number of vowel strings in the mentioned range is 2.
 *
 * Example 2:
 * Input: words = ["hey","aeo","mu","ooo","artro"], left = 1, right = 4
 * Output: 3
 * Explanation:
 * - "aeo" is a vowel string because it starts with 'a' and ends with 'o'.
 * - "mu" is not a vowel string because it does not start with a vowel.
 * - "ooo" is a vowel string because it starts with 'o' and ends with 'o'.
 * - "artro" is a vowel string because it starts with 'a' and ends with 'o'.
 * The number of vowel strings in the mentioned range is 3.
 *
 * @see <a href="https://leetcode.cn/problems/count-the-number-of-vowel-strings-in-range/description/" />
 * @author Poet
 * @date 2023/11/7
 */
public class LC_2586_CountTheNumberOfVowelStringsInRange {

    /**
     * 方法：直接遍历
     */
    public int vowelStrings(String[] words, int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            String word = words[i];
            if (isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1))) {
                res++;
            }
        }
        return res;
    }

    /**
     * 判断是否是元音字符
     */
    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

}
