package com.home.jianzhi_offer_II;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer II 005. 单词长度的最大乘积
 *
 * 给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
 *
 * 示例 1:
 * 输入: words = ["abcw","baz","foo","bar","fxyz","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "fxyz"。它们不包含相同字符，且长度的乘积最大。
 *
 * 示例 2:
 * 输入: words = ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 *
 * 示例 3:
 * 输入: words = ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 *
 * 注意：本题与主站 318 题相同：https://leetcode-cn.com/problems/maximum-product-of-word-lengths/
 *
 * @see <a href="https://leetcode.cn/problems/aseY1I" />
 * @author Poet
 * @date 2023/3/13
 */
public class Offer_II_005_MaxProduct {

    /**
     * 方法一：位运算
     * 用数组 masks 记录每个单词的位掩码表示
     *
     * time:  O(L+n^2) 其中 L 是数组 words 中的全部单词长度之和， n 是数组 words 的长度
     * space: O(n)
     */
    public int maxProduct(String[] words) {
        int length = words.length;
        int[] masks = new int[length];
        for (int i = 0; i < length; i++) {
            String word = words[i];
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                masks[i] |= 1 << (word.charAt(j) - 'a');
            }
        }
        int maxProd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                }
            }
        }
        return maxProd;
    }


    /**
     * 暴力解法（自己ac）
     */
    public int maxProduct_bruceForce(String[] words) {
        int n = words.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for (int k = 0; k < words[i].length(); k++) {
                set.add(words[i].charAt(i));
            }

            for (int j = i + 1; j < n; j++) {
                boolean isRepeated = false;
                for (int k = 0; k < words[j].length(); k++) {
                    if (set.contains(words[j].charAt(k))) {
                        isRepeated = true;
                        break;
                    }
                }
                if (!isRepeated) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }

        return res;
    }

}
