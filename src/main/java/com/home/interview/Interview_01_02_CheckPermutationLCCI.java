package com.home.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 01.02. Check Permutation LCCI （判定是否互为字符重排）
 *
 * Given two strings,write a method to decide if one is a permutation of the other.
 *
 * Example 1:
 *
 * Input: s1 = "abc", s2 = "bca"
 * Output: true
 * Example 2:
 *
 * Input: s1 = "abc", s2 = "bad"
 * Output: false
 *
 * @see <a href="https://leetcode.cn/problems/check-permutation-lcci/" />
 * @author Poet
 * @date 2022/9/27
 */
public class Interview_01_02_CheckPermutationLCCI {

    public boolean CheckPermutation(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : s2.toCharArray()) {
            if (!map.containsKey(ch) || map.get(ch) < 1) {
                return false;
            }
            Integer count = map.get(ch);
            map.put(ch, count - 1);
        }

        return true;
    }

}
