package com.home.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 2325. Decode the Message (解密消息)
 *
 * You are given the strings key and message, which represent a cipher key and a secret message, respectively. The steps to decode message are as follows:
 *
 * Use the first appearance of all 26 lowercase English letters in key as the order of the substitution table.
 * Align the substitution table with the regular English alphabet.
 * Each letter in message is then substituted using the table.
 * Spaces ' ' are transformed to themselves.
 * For example, given key = "happy boy" (actual key would have at least one instance of each letter in the alphabet), we have the partial substitution table of ('h' -> 'a', 'a' -> 'b', 'p' -> 'c', 'y' -> 'd', 'b' -> 'e', 'o' -> 'f').
 * Return the decoded message.
 *
 * Example 1:
 * Input: key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv"
 * Output: "this is a secret"
 * Explanation: The diagram above shows the substitution table.
 * It is obtained by taking the first appearance of each letter in "the quick brown fox jumps over the lazy dog".
 *
 * Example 2:
 * Input: key = "eljuxhpwnyrdgtqkviszcfmabo", message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb"
 * Output: "the five boxing wizards jump quickly"
 * Explanation: The diagram above shows the substitution table.
 * It is obtained by taking the first appearance of each letter in "eljuxhpwnyrdgtqkviszcfmabo".
 *
 * @see <a href="https://leetcode.cn/problems/decode-the-message/" />
 * @author Poet
 * @date 2023/2/1
 */
public class LC_2325_DecodeTheMessage {

    /**
     * 方法一：模拟
     *
     * time:  O(m+n)，其中 m 和 n 分别是字符串 key 和 message 的长度
     * space: O(n+∣Σ) 其中 Σ 是字符集
     */
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        map.put(' ', ' ');
        int index = 0;
        for (int i = 0; i < key.length(); i++) {
            if (index == 26) {
                break;
            }
            if (!map.containsKey(key.charAt(i))) {
                map.put(key.charAt(i), (char) ('a' + index));
                index++;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            Character ch = map.get(message.charAt(i));
            builder.append(ch);
        }
        return builder.toString();
    }

}
