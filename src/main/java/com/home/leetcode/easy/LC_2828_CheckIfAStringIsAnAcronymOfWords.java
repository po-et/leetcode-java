package com.home.leetcode.easy;

import java.util.List;

/**
 * 2828. Check if a String Is an Acronym of Words (判别首字母缩略词)
 *
 * Given an array of strings words and a string s, determine if s is an acronym of words.
 *
 * The string s is considered an acronym of words if it can be formed by concatenating the first character of each string in words in order. For example, "ab" can be formed from ["apple", "banana"], but it can't be formed from ["bear", "aardvark"].
 *
 * Return true if s is an acronym of words, and false otherwise.
 *
 * Example 1:
 * Input: words = ["alice","bob","charlie"], s = "abc"
 * Output: true
 * Explanation: The first character in the words "alice", "bob", and "charlie" are 'a', 'b', and 'c', respectively. Hence, s = "abc" is the acronym.
 *
 * @see <a href="https://leetcode.cn/problems/check-if-a-string-is-an-acronym-of-words/description/" />
 * @author Poet
 * @date 2023/12/20
 */
public class LC_2828_CheckIfAStringIsAnAcronymOfWords {

    /**
     * 方法：直接遍历
     */
    public boolean isAcronym(List<String> words, String s) {
        if (words.size() != s.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (words.get(i).charAt(0) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

}
