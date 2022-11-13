package com.home.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 791. Custom Sort String （自定义字符串排序）
 *
 * You are given two strings order and s. All the characters of order are unique and were sorted in some custom order previously.
 *
 * Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.
 *
 * Return any permutation of s that satisfies this property.
 *
 * Example 1:
 * Input: order = "cba", s = "abcd"
 * Output: "cbad"
 * Explanation:
 * "a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a".
 * Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid outputs.
 *
 * Example 2:
 * Input: order = "cbafg", s = "abcd"
 * Output: "cbad"
 *
 * @see <a href="https://leetcode.cn/problems/custom-sort-string/" />
 * @author Poet
 * @date 2022/11/13
 */
public class LC_791_CustomSortString {

    /**
     * 方法：计数排序
     *
     * 会用HasMap，自己完成 ac
     */
    public String customSortString(String order, String s) {
        StringBuilder builder = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            if (map.containsKey(ch)) {
                for (int j = 0; j < map.get(ch); j++) {
                    builder.append(ch);
                }
                map.remove(ch);
            }
        }
        if (!map.isEmpty()) {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                for (int i = 0; i < entry.getValue(); i++) {
                    builder.append(entry.getKey());
                }
            }
        }
        return builder.toString();
    }

    /**
     * 方法：计数排序
     *
     * 会用数组，官方题解
     */
    public String customSortString_2(String order, String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            ++freq[ch - 'a'];
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < order.length(); ++i) {
            char ch = order.charAt(i);
            while (freq[ch - 'a'] > 0) {
                ans.append(ch);
                freq[ch - 'a']--;
            }
        }
        for (int i = 0; i < 26; ++i) {
            while (freq[i] > 0) {
                ans.append((char) (i + 'a'));
                freq[i]--;
            }
        }
        return ans.toString();
    }

}
