package com.home.jianzhi_offer_II;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 032. 有效的变位词
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断它们是不是一组变位词（字母异位词）。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同且字符顺序不完全相同，则称 s 和 t 互为变位词（字母异位词）。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 示例 3:
 * 输入: s = "a", t = "a"
 * 输出: false
 *
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 注意：本题与主站 242 题相似（字母异位词定义不同）：https://leetcode-cn.com/problems/valid-anagram/
 *
 * @see <a href="https://leetcode.cn/problems/dKk3P7" />
 * @author Poet
 * @date 2023/3/21
 */
public class Offer_II_032_ValidAnagram {

    /**
     * 方法一：排序
     *
     * time:  O(NlogN)
     * space: O(NlogN)
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) {
            return false;
        }

        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);

        return Arrays.equals(str1, str2);
    }

    /**
     * 方法二：哈希表
     *
     * time:  O(n)
     * space: O(S)，其中 S 为字符集大小，此处 S=26
     */
    public boolean isAnagram_2(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) {
            return false;
        }

        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            if (!freq.containsKey(ch) || freq.get(ch) <= 0) {
                return false;
            }
            freq.put(ch, freq.get(ch) - 1);
        }

        return true;
    }

}
