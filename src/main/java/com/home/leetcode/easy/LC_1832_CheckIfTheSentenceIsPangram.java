package com.home.leetcode.easy;

/**
 * 1832. Check if the Sentence Is Pangram (判断句子是否为全字母句)
 *
 * A pangram is a sentence where every letter of the English alphabet appears at least once.
 *
 * Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
 *
 * Example 1:
 * Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
 * Output: true
 * Explanation: sentence contains at least one of every letter of the English alphabet.
 *
 * Example 2:
 * Input: sentence = "leetcode"
 * Output: false
 *
 * @see <a href="https://leetcode.cn/problems/check-if-the-sentence-is-pangram/" />
 * @author Poet
 * @date 2022/12/13
 */
public class LC_1832_CheckIfTheSentenceIsPangram {

    /**
     * 方法一：数组
     *
     * time:  O(n+C) 其中 n 是 sentence 的长度，C 是字符集的大小（即小写字母的个数）
     * space: O(C)
     */
    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) {
            return false;
        }

        boolean[] exist = new boolean[26];
        for (char ch : sentence.toCharArray()) {
            exist[ch - 'a'] = true;
        }

        for (boolean x : exist) {
            if (!x) {
                return false;
            }
        }
        return true;
    }

}
