package com.home.leetcode.easy;

/**
 * 2490. Circular Sentence
 *
 * A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
 *      - For example, "Hello World", "HELLO", "hello world hello world" are all sentences.
 *
 * Words consist of only uppercase and lowercase English letters. Uppercase and lowercase English letters are considered different.
 *
 * A sentence is circular if:
 *      - The last character of a word is equal to the first character of the next word.
 *      - The last character of the last word is equal to the first character of the first word.
 *
 * For example, "leetcode exercises sound delightful", "eetcode", "leetcode eats soul" are all circular sentences. However, "Leetcode is cool", "happy Leetcode", "Leetcode" and "I like Leetcode" are not circular sentences.
 *
 * Given a string sentence, return true if it is circular. Otherwise, return false.
 *
 * Example 1:
 * Input: sentence = "leetcode exercises sound delightful"
 * Output: true
 *
 * Example 2:
 * Input: sentence = "eetcode"
 * Output: true
 *
 * Example 3:
 * Input: sentence = "Leetcode is cool"
 * Output: false
 *
 * @see <a href="https://leetcode.cn/problems/circular-sentence/" />
 * @author Poet
 * @date 2023/6/30
 */
public class LC_2490_CircularSentence {

    /**
     * 方法一：遍历
     */
    public boolean isCircularSentence(String sentence) {
        String[] strArray = sentence.split("\\s");
        int n = strArray.length;
        if (n == 1) {
            return sentence.charAt(0) == sentence.charAt(sentence.length() - 1);
        }

        for (int i = 1; i < n; i++) {
            if (strArray[i].charAt(0) != strArray[i - 1].charAt(strArray[i - 1].length() - 1)) {
                return false;
            }
            if (i == n - 1) {
                if (strArray[i].charAt(strArray[i].length() - 1) != strArray[0].charAt(0)) {
                    return false;
                }
            }
        }
        return true;
    }

}
