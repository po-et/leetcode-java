package com.home.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2309. Greatest English Letter in Upper and Lower Case （兼具大小写的最好英文字母）
 *
 * Given a string of English letters s, return the greatest English letter which occurs as both a lowercase and uppercase letter in s. The returned letter should be in uppercase. If no such letter exists, return an empty string.
 *
 * An English letter b is greater than another letter a if b appears after a in the English alphabet.
 *
 * Example 1:
 * Input: s = "lEeTcOdE"
 * Output: "E"
 * Explanation:
 * The letter 'E' is the only letter to appear in both lower and upper case.
 *
 * Example 2:
 * Input: s = "arRAzFif"
 * Output: "R"
 * Explanation:
 * The letter 'R' is the greatest letter to appear in both lower and upper case.
 * Note that 'A' and 'F' also appear in both lower and upper case, but 'R' is greater than 'F' or 'A'.
 *
 * Example 3:
 * Input: s = "AbCdEfGhIjK"
 * Output: ""
 * Explanation:
 * There is no letter that appears in both lower and upper case.
 *
 * @see <a href="https://leetcode.cn/problems/greatest-english-letter-in-upper-and-lower-case/" />
 * @author Poet
 * @date 2023/1/27
 */
public class LC_2309_GreatestEnglishLetterInUpperAndLowerCase {

    /**
     * 方法一：哈希表
     *
     * time:  O(n+∣Σ∣)，其中 n 是字符串的长度， Σ 是字符集，本题中 ∣Σ∣=26
     * space: O(∣Σ∣)  Σ 是字符集
     */
    public String greatestLetter(String s) {
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            set.add(ch);
        }

        for (int i = 25; i >= 0; i--) {
            if (set.contains((char) ('a' + i)) && set.contains((char) ('A' + i))) {
                return String.valueOf((char) ('A' + i));
            }
        }
        return "";
    }

}
