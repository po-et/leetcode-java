package com.home.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 1408. String Matching in an Array （数组中的字符串匹配）
 *
 * Given an array of string words. Return all strings in words which is substring of another word in any order.
 *
 * String words[i] is substring of words[j], if can be obtained removing some characters to left and/or right side of words[j].
 *
 * Example 1:
 * Input: words = ["mass","as","hero","superhero"]
 * Output: ["as","hero"]
 * Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
 * ["hero","as"] is also a valid answer.
 *
 * Example 2:
 * Input: words = ["leetcode","et","code"]
 * Output: ["et","code"]
 * Explanation: "et", "code" are substring of "leetcode".
 *
 * Example 3:
 * Input: words = ["blue","green","bu"]
 * Output: []
 *
 * @see <a href="https://leetcode.cn/problems/string-matching-in-an-array/" />
 * @author Poet
 * @date 2022/8/6
 */
public class LC_1408_StringMatchingInAnArray {

    /**
     * 方法一：暴力枚举
     *
     * time:  O(n^2 × L^2)，其中 n 是字符串数组的长度，L 是字符串数组中最长字符串的长度
     * space: O(1) 返回值不计入空间复杂度。如果使用 KMP 字符串匹配算法，那么对应的空间复杂度为 O(T)
     */
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        
        int len = words.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                if (words[j].contains(words[i])) {
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }
}
