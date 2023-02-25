package com.home.leetcode.medium;

/**
 * 1247. Minimum Swaps to Make Strings Equal (交换字符使得字符串相同)
 *
 * You are given two strings s1 and s2 of equal length consisting of letters "x" and "y" only. Your task is to make these two strings equal to each other. You can swap any two characters that belong to different strings, which means: swap s1[i] and s2[j].
 *
 * Return the minimum number of swaps required to make s1 and s2 equal, or return -1 if it is impossible to do so.
 *
 * Example 1:
 * Input: s1 = "xx", s2 = "yy"
 * Output: 1
 * Explanation: Swap s1[0] and s2[1], s1 = "yx", s2 = "yx".
 *
 * Example 2:
 * Input: s1 = "xy", s2 = "yx"
 * Output: 2
 * Explanation: Swap s1[0] and s2[0], s1 = "yy", s2 = "xx".
 * Swap s1[0] and s2[1], s1 = "xy", s2 = "xy".
 * Note that you cannot swap s1[0] and s1[1] to make s1 equal to "yx", cause we can only swap chars in different strings.
 *
 * Example 3:
 * Input: s1 = "xx", s2 = "xy"
 * Output: -1
 *
 * @see <a href="https://leetcode.cn/problems/minimum-swaps-to-make-strings-equal/" />
 * @author Poet
 * @date 2023/2/25
 */
public class LC_1247_MinimumSwapsToMakeStringsEqual {

    /**
     * 方法一：贪心
     *
     * time:  O(n)
     * space: O(1)
     */
    public int minimumSwap(String s1, String s2) {
        int xy = 0, yx = 0;
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y') {
                xy++;
            }
            if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x') {
                yx++;
            }
        }
        if ((xy + yx) % 2 == 1) {
            return -1;
        }
        return xy / 2 + yx / 2 + xy % 2 + yx % 2;
    }

}
