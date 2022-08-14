package com.home.leetcode.easy;

/**
 * 1422. Maximum Score After Splitting a String (分割字符串的最大得分)
 *
 * Given a string s of zeros and ones, return the maximum score after splitting the string into two non-empty substrings (i.e. left substring and right substring).
 *
 * The score after splitting a string is the number of zeros in the left substring plus the number of ones in the right substring.
 *
 * Example 1:
 * Input: s = "011101"
 * Output: 5
 * Explanation:
 * All possible ways of splitting s into two non-empty substrings are:
 * left = "0" and right = "11101", score = 1 + 4 = 5
 * left = "01" and right = "1101", score = 1 + 3 = 4
 * left = "011" and right = "101", score = 1 + 2 = 3
 * left = "0111" and right = "01", score = 1 + 1 = 2
 * left = "01110" and right = "1", score = 2 + 1 = 3
 *
 * Example 2:
 * Input: s = "00111"
 * Output: 5
 * Explanation: When left = "00" and right = "111", we get the maximum score = 2 + 3 = 5
 *
 * Example 3:
 * Input: s = "1111"
 * Output: 3
 *
 * @see <a href="https://leetcode.cn/problems/maximum-score-after-splitting-a-string/" />
 * @author Poet
 * @date 2022/8/14
 */
public class LC_1422_MaximumScoreAfterSplittingAString {

    /**
     * 方法一：枚举每个分割点
     *
     * time:  O(n^2)  执行用时 7 ms
     * space: O(1)
     */
    public int maxScore(String s) {
        int res = 0;
        int n = s.length();
        for (int i = 1; i < n; i++) {
            int score = 0;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == '0') {
                    score++;
                }
            }
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == '1') {
                    score++;
                }
            }

            res = Math.max(res, score);
        }
        return res;
    }

    /**
     * 方法二：两次遍历
     *
     * time:  O(n)  执行用时 1 ms
     * space: O(1)
     */
    public int maxScore_2(String s) {
        int n = s.length();
        int zeroSum = 0;
        int oneSum = 0;
        int res = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                oneSum++;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                zeroSum++;
            } else {
                oneSum--;
            }

            res = Math.max(res, zeroSum + oneSum);
        }

        return res;
    }
}
