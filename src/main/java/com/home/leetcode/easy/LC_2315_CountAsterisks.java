package com.home.leetcode.easy;

/**
 * 2315. Count Asterisks (统计星号)
 *
 * You are given a string s, where every two consecutive vertical bars '|' are grouped into a pair. In other words, the 1st and 2nd '|' make a pair, the 3rd and 4th '|' make a pair, and so forth.
 *
 * Return the number of '*' in s, excluding the '*' between each pair of '|'.
 *
 * Note that each '|' will belong to exactly one pair.
 *
 * Example 1:
 * Input: s = "l|*e*et|c**o|*de|"
 * Output: 2
 * Explanation: The considered characters are underlined: "l|*e*et|c**o|*de|".
 * The characters between the first and second '|' are excluded from the answer.
 * Also, the characters between the third and fourth '|' are excluded from the answer.
 * There are 2 asterisks considered. Therefore, we return 2.
 *
 * Example 2:
 * Input: s = "iamprogrammer"
 * Output: 0
 * Explanation: In this example, there are no asterisks in s. Therefore, we return 0.
 *
 * Example 3:
 * Input: s = "yo|uar|e**|b|e***au|tifu|l"
 * Output: 5
 * Explanation: The considered characters are underlined: "yo|uar|e**|b|e***au|tifu|l". There are 5 asterisks considered. Therefore, we return 5.
 *
 * @see <a href="https://leetcode.cn/problems/count-asterisks/" />
 * @author Poet
 * @date 2023/1/29
 */
public class LC_2315_CountAsterisks {

    /**
     * 方法一：模拟
     *
     * 官方题解，使用一个boolean值，更简洁
     *
     * time:  O(n)
     * space: O(1)
     */
    public int countAsterisks(String s) {
        boolean valid = true;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '|') {
                valid = !valid;
            } else if (c == '*' && valid) {
                res++;
            }
        }
        return res;
    }

    /**
     * 方法：模拟（自己ac）
     *
     * 使用一个count统计|符号数量
     */
    public int countAsterisks_self(String s) {
        int res = 0;
        int asterisksCount = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '|') {
                asterisksCount++;
            } else if (asterisksCount % 2 == 0 && ch == '*') {
                res++;
            }
        }
        return res;
    }
}
