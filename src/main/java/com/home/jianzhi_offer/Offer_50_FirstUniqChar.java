package com.home.jianzhi_offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 面试题50. 第一个只出现一次的字符
 *
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例 1:
 *
 * 输入：s = "abaccdeff"
 * 输出：'b'
 *
 * 示例 2:
 * 输入：s = ""
 * 输出：' '
 *
 * @see <a href="https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof" />
 * @author Poet
 * @date 2020/6/1
 */
public class Offer_50_FirstUniqChar {

    /**
     * 方法一：哈希表
     * 时间复杂度 O(2N)
     */
    public char firstUniqChar(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            freq.compute(ch, (key, val) -> val == null ? 1 : val + 1);
            // OR freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        for (char ch : chars) {
            if (freq.get(ch) == 1) {
                return ch;
            }
        }
        return ' ';
    }

    /*
     * 【方法一优化点】：Map 结构的 Value 使用 Boolean 类型是一个更好的选择
     * 1、一个字母出现的次数大于 1 次就不符合要求了，这个时候使用 False 标记状态相对于 Integer 的不断递增更合理，也更省空间。
     * 2、布尔值可以用来判断，可以简化代码逻辑。
     */


    /**
     * 方法二：有序哈希表
     * 时间复杂度 O(N)
     */
    public char firstUniqChar_LinkedHashMap(String s) {
        Map<Character, Boolean> freq = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            freq.put(ch, !freq.containsKey(ch));
        }

        for (Map.Entry<Character, Boolean> entry : freq.entrySet()) {
            if (entry.getValue()) {
                return entry.getKey();
            }
        }
        return ' ';
    }

}
