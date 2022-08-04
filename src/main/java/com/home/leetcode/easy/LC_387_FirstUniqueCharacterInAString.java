package com.home.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. First Unique Character in a String (字符串中的第一个唯一字符)
 *
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 *
 * Example 1:
 * Input: s = "leetcode"
 * Output: 0
 *
 * Example 2:
 * Input: s = "loveleetcode"
 * Output: 2
 *
 * Example 3:
 * Input: s = "aabb"
 * Output: -1
 *
 * @see <a href="https://leetcode.cn/problems/first-unique-character-in-a-string/" />
 * @author Poet
 * @date 2020/5/5
 */
public class LC_387_FirstUniqueCharacterInAString {

    /**
     * 方法一：使用数组存储频数
     */
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        char[] chars = s.toCharArray();

        for (char ch : chars) {
            freq[ch - 'a'] ++;
        }

        for (int i = 0; i < chars.length; i++) {
            if (freq[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 方法二：使用哈希表存储频数
     *
     * time:  O(n)   其中 n 是字符串 s 的长度。我们需要进行两次遍历。
     * space: O(∣Σ∣) 其中 \Sigma Σ 是字符集，在本题中 s 只包含小写字母，因此 ∣Σ∣≤26。我们需要 O(∣Σ∣) 的空间存储哈希映射。
     */
    public int firstUniqChar_map(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); ++i) {
            if (freq.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

}
