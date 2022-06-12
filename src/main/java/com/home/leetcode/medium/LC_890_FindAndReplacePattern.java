package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 890. Find and Replace Pattern
 *
 * Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.
 *
 * A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
 *
 * Example 1:
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * Output: ["mee","aqq"]
 *
 * Example 2:
 * Input: words = ["a","b","c"], pattern = "a"
 * Output: ["a","b","c"]
 *
 * @see <a href="https://leetcode.cn/problems/find-and-replace-pattern/" />
 * @author Poet
 * @date 2022/6/12
 */
public class LC_890_FindAndReplacePattern {

    /**
     * 方法一：构造双射
     * 逐个判断 words 中的每个单词 word 是否与 pattern 匹配
     *
     * time:  O(nm) 其中 n 是数组 words 的长度，m 是 pattern 的长度
     * space: O(m) 哈希表需要O(m)的空间
     */
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern) && match(pattern, word)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean match(String word, String pattern) {
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char x = word.charAt(i);
            char y = pattern.charAt(i);

            if (!map.containsKey(x)) {
                map.put(x, y);
            } else if (map.get(x) != y) {  // word 中的同一字母必须映射到 pattern 中的同一字母上
                return false;
            }
        }
        return true;
    }

}
