package com.home.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 771. Jewels and Stones (宝石与石头)
 *
 * You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have.
 * Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
 *
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 * Input: jewels = "aA", stones = "aAAbbbb"
 * Output: 3
 *
 * Example 2:
 * Input: jewels = "z", stones = "ZZ"
 * Output: 0
 *
 * @see <a href="https://leetcode.cn/problems/jewels-and-stones/" />
 * @author Poet
 * @date 2023/7/24
 */
public class LC_771_JewelsAndStones {

    /**
     * 哈希集合
     */
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> dict = new HashMap<>();
        for (char ch : jewels.toCharArray()) {
            dict.put(ch, dict.getOrDefault(ch, 0) + 1);
        }

        int res = 0;
        for (char ch : stones.toCharArray()) {
            if (dict.containsKey(ch)) {
                res++;
            }
        }
        return res;
    }
}
