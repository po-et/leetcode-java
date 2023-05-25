package com.home.leetcode.easy;

import java.util.Arrays;

/**
 * 2451. Odd String Difference (差值数组不同的字符串)
 *
 * You are given an array of equal-length strings words. Assume that the length of each string is n.
 *
 * Each string words[i] can be converted into a difference integer array difference[i] of length n - 1 where difference[i][j] = words[i][j+1] - words[i][j] where 0 <= j <= n - 2. Note that the difference between two letters is the difference between their positions in the alphabet i.e. the position of 'a' is 0, 'b' is 1, and 'z' is 25.
 *
 * For example, for the string "acb", the difference integer array is [2 - 0, 1 - 2] = [2, -1].
 * All the strings in words have the same difference integer array, except one. You should find that string.
 *
 * Return the string in words that has different difference integer array.
 *
 * Example 1:
 * Input: words = ["adc","wzy","abc"]
 * Output: "abc"
 * Explanation:
 * - The difference integer array of "adc" is [3 - 0, 2 - 3] = [3, -1].
 * - The difference integer array of "wzy" is [25 - 22, 24 - 25]= [3, -1].
 * - The difference integer array of "abc" is [1 - 0, 2 - 1] = [1, 1].
 * The odd array out is [1, 1], so we return the corresponding string, "abc".
 *
 * Example 2:
 * Input: words = ["aaa","bob","ccc","ddd"]
 * Output: "bob"
 * Explanation: All the integer arrays are [0, 0] except for "bob", which corresponds to [13, -13].
 *
 * @see <a href="https://leetcode.cn/problems/odd-string-difference/" />
 * @author Poet
 * @date 2023/5/25
 */
public class LC_2451_OddStringDifference {

    /**
     * 方法一：遍历
     */
    public String oddString(String[] words) {
        int[] diff0 = get(words[0]);
        int[] diff1 = get(words[1]);
        if (Arrays.equals(diff0, diff1)) {
            for (int i = 2; i < words.length; i++) {
                if (!Arrays.equals(diff0, get(words[i]))) {
                    return words[i];
                }
            }
        }
        return Arrays.equals(diff0, get(words[2])) ? words[1] : words[0];
    }

    public int[] get(String word) {
        int[] diff = new int[word.length() - 1];
        for (int i = 0; i + 1 < word.length(); i++) {
            diff[i] = word.charAt(i + 1) - word.charAt(i);
        }
        return diff;
    }

}
