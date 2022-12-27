package com.home.leetcode.easy;

/**
 * 2027. Minimum Moves to Convert String
 *
 * You are given a string s consisting of n characters which are either 'X' or 'O'.
 *
 * A move is defined as selecting three consecutive characters of s and converting them to 'O'. Note that if a move is applied to the character 'O', it will stay the same.
 *
 * Return the minimum number of moves required so that all the characters of s are converted to 'O'.
 *
 * Example 1:
 * Input: s = "XXX"
 * Output: 1
 * Explanation: XXX -> OOO
 * We select all the 3 characters and convert them in one move.
 *
 * Example 2:
 * Input: s = "XXOX"
 * Output: 2
 * Explanation: XXOX -> OOOX -> OOOO
 * We select the first 3 characters in the first move, and convert them to 'O'.
 * Then we select the last 3 characters and convert them so that the final string contains all 'O's.
 *
 * Example 3:
 * Input: s = "OOOO"
 * Output: 0
 * Explanation: There are no 'X's in s to convert.
 *
 * @see <a href="https://leetcode.cn/problems/minimum-moves-to-convert-string/" />
 * @author Poet
 * @date 2022/12/27
 */
public class LC_2027_MinimumMovesToConvertString {

    // 看完答案后，很简单，第一次做错了

    /**
     * 方法一：模拟
     *
     * time:  O(n)
     * space: O(1)
     */
    public int minimumMoves(String s) {
        int res = 0;
        int covered = -1;   // 表示 res 操作次数内最多可以转换的下标数【重点】
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X' && i > covered) {
                res++;
                covered = i + 2;
            }
        }
        return res;
    }

}
