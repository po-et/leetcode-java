package com.home.leetcode.easy;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 *
 * @see <a href="https://leetcode.com/problems/first-unique-character-in-a-string/" />
 * @author Poet
 * @date 2020/5/5
 */
public class FirstUniqueCharacterInAString_387 {

    int[] freq = new int[26];

    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();

        for (char ch : chars) {
            freq[ch - 'a'] ++;
        }

        for (int i = 0; i < chars.length; i++) {
            if (freq[chars[i] - 'a'] == 1)
                return i;
        }
        return -1;
    }
}
