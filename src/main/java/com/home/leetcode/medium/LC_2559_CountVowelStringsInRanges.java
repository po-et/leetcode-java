package com.home.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 2559. Count Vowel Strings in Ranges（统计范围内的元音字符串数）
 *
 * You are given a 0-indexed array of strings words and a 2D array of integers queries.
 *
 * Each query queries[i] = [li, ri] asks us to find the number of strings present in the range li to ri (both inclusive) of words that start and end with a vowel.
 *
 * Return an array ans of size queries.length, where ans[i] is the answer to the ith query.
 *
 * Note that the vowel letters are 'a', 'e', 'i', 'o', and 'u'.
 *
 * Example 1:
 * Input: words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
 * Output: [2,3,0]
 * Explanation: The strings starting and ending with a vowel are "aba", "ece", "aa" and "e".
 * The answer to the query [0,2] is 2 (strings "aba" and "ece").
 * to query [1,4] is 3 (strings "ece", "aa", "e").
 * to query [1,1] is 0.
 * We return [2,3,0].
 *
 * Example 2:
 * Input: words = ["a","e","i"], queries = [[0,2],[0,1],[2,2]]
 * Output: [3,2,1]
 * Explanation: Every string satisfies the conditions, so we return [3,2,1].
 *
 * @see <a href="https://leetcode.cn/problems/count-vowel-strings-in-ranges/" />
 * @author Poet
 * @date 2023/6/2
 */
public class LC_2559_CountVowelStringsInRanges {

    /**
     * 方法一：前缀和
     *
     * time:  O(n+q)
     * space: O(n)
     */
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefixSums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int value = isVowelString(words[i]) ? 1 : 0;
            prefixSums[i + 1] = prefixSums[i] + value;
        }

        int q = queries.length;
        int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            int start = queries[i][0], end = queries[i][1];
            res[i] = prefixSums[end + 1] - prefixSums[start];
        }
        return res;
    }

    public boolean isVowelString(String word) {
        return isVowelLetter(word.charAt(0)) && isVowelLetter(word.charAt(word.length() - 1));
    }

    public boolean isVowelLetter(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }


    /**
     * 超时时间限制（没有ac）
     */
    public int[] vowelStrings_timeout(String[] words, int[][] queries) {
        Set<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');

        int n = words.length;
        boolean[] wordVowel = new boolean[n];
        for (int i = 0; i < n; i++) {
            String word = words[i];
            if (vowel.contains(word.charAt(0)) && vowel.contains(word.charAt(word.length() - 1))) {
                wordVowel[i] = true;
            } else {
                wordVowel[i] = false;
            }
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            for (int j = query[0]; j <= query[1]; j++) {
                if (wordVowel[j]) {
                    res[i]++;
                }
            }
        }
        return res;
    }

}
