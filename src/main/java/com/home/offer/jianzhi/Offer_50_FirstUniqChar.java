package com.home.offer.jianzhi;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 面试题50. 第一个只出现一次的字符
 *
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
        }

        for (char ch : chars) {
            if (freq.get(ch) == 1)
                return ch;
        }
        return ' ';
    }

    /*
     * 【优化点】：Map 结构的 Value 使用 Boolean 类型是一个更好的选择
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
            if(entry.getValue())
                return entry.getKey();
        }
        return ' ';
    }

}
