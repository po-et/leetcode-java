package com.home.leetcode.easy;

import java.util.HashSet;

/**
 * 2423. Remove Letter To Equalize Frequency (删除字符使频率相同)
 *
 * You are given a 0-indexed string word, consisting of lowercase English letters. You need to select one index and remove the letter at that index from word so that the frequency of every letter present in word is equal.
 *
 * Return true if it is possible to remove one letter so that the frequency of all letters in word are equal, and false otherwise.
 *
 * Note:
 * The frequency of a letter x is the number of times it occurs in the string.
 * You must remove exactly one letter and cannot chose to do nothing.
 *
 * Example 1:
 * Input: word = "abcc"
 * Output: true
 * Explanation: Select index 3 and delete it: word becomes "abc" and each character has a frequency of 1.
 *
 * Example 2:
 * Input: word = "aazz"
 * Output: false
 * Explanation: We must delete a character, so either the frequency of "a" is 1 and the frequency of "z" is 2, or vice versa. It is impossible to make all present letters have equal frequency.
 *
 * @see <a href="https://leetcode.cn/problems/remove-letter-to-equalize-frequency/" />
 * @author Poet
 * @date 2023/4/29
 */
public class LC_2423_RemoveLetterToEqualizeFrequency {

    /**
     * 方法一：枚举
     */
    public boolean equalFrequency(String word) {
        int[] charCount = new int[26];
        int n = word.length();
        for (int i = 0; i < n; i++) {
            charCount[word.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (charCount[i] == 0) {
                continue;
            }
            charCount[i]--;
            HashSet<Integer> frequency = new HashSet<>();
            for (int f : charCount) {
                if (f > 0) {
                    frequency.add(f);
                }
            }
            if (frequency.size() == 1) {
                return true;
            }
            charCount[i]++;
        }
        return false;
    }

}
