package com.home.leetcode.medium;

/**
 * 1813. Sentence Similarity III (句子相似性 III)
 *
 * A sentence is a list of words that are separated by a single space with no leading or trailing spaces. For example, "Hello World", "HELLO", "hello world hello world" are all sentences. Words consist of only uppercase and lowercase English letters.
 *
 * Two sentences sentence1 and sentence2 are similar if it is possible to insert an arbitrary sentence (possibly empty) inside one of these sentences such that the two sentences become equal. For example, sentence1 = "Hello my name is Jane" and sentence2 = "Hello Jane" can be made equal by inserting "my name is" between "Hello" and "Jane" in sentence2.
 *
 * Given two sentences sentence1 and sentence2, return true if sentence1 and sentence2 are similar. Otherwise, return false.
 *
 * Example 1:
 * Input: sentence1 = "My name is Haley", sentence2 = "My Haley"
 * Output: true
 * Explanation: sentence2 can be turned to sentence1 by inserting "name is" between "My" and "Haley".
 *
 * Example 2:
 * Input: sentence1 = "of", sentence2 = "A lot of words"
 * Output: false
 * Explanation: No single sentence can be inserted inside one of the sentences to make it equal to the other.
 *
 * Example 3:
 * Input: sentence1 = "Eating right now", sentence2 = "Eating"
 * Output: true
 * Explanation: sentence2 can be turned to sentence1 by inserting "right now" at the end of the sentence.
 *
 * @see <a href="https://leetcode.cn/problems/sentence-similarity-iii/" />
 * @author Poet
 * @date 2023/1/16
 */
public class LC_1813_SentenceSimilarity_III {

    /**
     * 方法一：字符串按空格分割 + 双指针
     *
     * time:  O(m+n)
     * space: O(m+n)
     */
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        int l = 0, r = 0;
        int m = words1.length, n = words2.length;

        while (l < m && l < n && words1[l].equals(words2[l])) {
            l++;
        }
        while (r < m - l && r < n - l && words1[m - r - 1].equals(words2[n - r - 1])) {
            r++;
        }

        return l + r == Math.min(m, n);
    }

}
