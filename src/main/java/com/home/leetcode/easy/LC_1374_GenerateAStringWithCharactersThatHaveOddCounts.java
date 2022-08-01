package com.home.leetcode.easy;

/**
 * 1374. Generate a String With Characters That Have Odd Counts (生成每种字符都是奇数个的字符串)
 *
 * Given an integer n, return a string with n characters such that each character in such string occurs an odd number of times.
 *
 * The returned string must contain only lowercase English letters. If there are multiples valid strings, return any of them.
 *
 * Example 1:
 * Input: n = 4
 * Output: "pppz"
 * Explanation: "pppz" is a valid string since the character 'p' occurs three times and the character 'z' occurs once. Note that there are many other valid strings such as "ohhh" and "love".
 *
 * Example 2:
 * Input: n = 2
 * Output: "xy"
 * Explanation: "xy" is a valid string since the characters 'x' and 'y' occur once. Note that there are many other valid strings such as "ag" and "ur".
 *
 * Example 3:
 * Input: n = 7
 * Output: "holasss"
 *
 * @see <a href="https://leetcode.cn/problems/generate-a-string-with-characters-that-have-odd-counts/" />
 * @author Poet
 * @date 2022/8/1
 */
public class LC_1374_GenerateAStringWithCharactersThatHaveOddCounts {

    public String generateTheString(int n) {
        StringBuilder builder = new StringBuilder();

        if (n % 2 == 1) {   // n是奇数
            for (int i = 0; i < n; i++) {
                builder.append("a");
            }
        } else {
            for (int i = 0; i < n - 1; i++) {
                builder.append("a");
            }
            builder.append("b");
        }

        return builder.toString();
    }

}
