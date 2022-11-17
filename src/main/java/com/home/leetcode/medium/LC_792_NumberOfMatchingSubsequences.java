package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 792. Number of Matching Subsequences (匹配子序列的单词数)
 *
 * Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 *
 * Example 1:
 * Input: s = "abcde", words = ["a","bb","acd","ace"]
 * Output: 3
 * Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
 *
 * Example 2:
 * Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * Output: 2
 *
 * @see <a href="https://leetcode.cn/problems/number-of-matching-subsequences/" />
 * @author Poet
 * @date 2022/11/17
 */
public class LC_792_NumberOfMatchingSubsequences {

    /* --- 这道题来自：Weekly Contest 74 --- */

    // 参考答案

    /**
     * 方法一：二分查找
     */
    public int numMatchingSubseq(String s, String[] words) {
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; ++i) {
            pos[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < s.length(); ++i) {
            pos[s.charAt(i) - 'a'].add(i);
        }
        int res = words.length;
        for (String w : words) {
            if (w.length() > s.length()) {
                --res;
                continue;
            }
            int p = -1;
            for (int i = 0; i < w.length(); ++i) {
                char c = w.charAt(i);
                if (pos[c - 'a'].isEmpty() || pos[c - 'a'].get(pos[c - 'a'].size() - 1) <= p) {
                    --res;
                    break;
                }
                p = binarySearch(pos[c - 'a'], p);
            }
        }
        return res;
    }

    public int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return list.get(left);
    }


    // 自己完成，wrong，不ac
    @Deprecated
    public int numMatchingSubseq_wrong(String s, String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(map.get(ch), 0) + 1);
        }

        int res = 0;
        for (String word : words) {
            Map<Character, Integer> wordMap = new HashMap<>(map);
            boolean flag = true;
            for (char ch : word.toCharArray()) {
                if (!wordMap.containsKey(ch) || wordMap.get(ch) == 0) {
                    flag = false;
                    break;
                }
                wordMap.put(ch, wordMap.get(ch) - 1);
            }
            if (flag) {
                res++;
            }
        }
        return res;
    }

}
