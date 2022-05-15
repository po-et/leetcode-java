package com.home.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 290. Word Pattern
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Example 1:
 *
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 *
 * @see <a href="https://leetcode.com/problems/word-pattern/" />
 * @author Poet
 * @date 2020/4/18
 */
public class LC_290_WordPattern {

    public static void main(String[] args) {
        LC_290_WordPattern solution = new LC_290_WordPattern();
        String pattern = "abba", str = "dog cat cat dog";
        System.out.println(solution.wordPattern(pattern, str));
    }

    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if(pattern.length() != strs.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>(pattern.length());

        // 处理 "abba"   "dog dog dog dog" 的情况
        Set<String> unique = new HashSet<>();

        for (int i = 0; i < pattern.toCharArray().length; i++) {
            char ch = pattern.charAt(i);
            if (map.containsKey(ch)) {
                if(!map.get(ch).equals(strs[i])){
                    return false;
                }
            } else {
                if (unique.contains(strs[i])) {
                    return false;
                }
                unique.add(strs[i]);
                map.put(ch, strs[i]);
            }
        }

        return true;
    }

}
