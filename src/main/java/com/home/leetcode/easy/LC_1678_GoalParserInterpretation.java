package com.home.leetcode.easy;

/**
 * 1678. Goal Parser Interpretation （设计 Goal 解析器）
 *
 * You own a Goal Parser that can interpret a string command. The command consists of an alphabet of "G", "()" and/or "(al)" in some order.
 * The Goal Parser will interpret "G" as the string "G", "()" as the string "o", and "(al)" as the string "al".
 * The interpreted strings are then concatenated in the original order.
 *
 * Given the string command, return the Goal Parser's interpretation of command.
 *
 * Example 1:
 * Input: command = "G()(al)"
 * Output: "Goal"
 * Explanation: The Goal Parser interprets the command as follows:
 * G -> G
 * () -> o
 * (al) -> al
 * The final concatenated result is "Goal".
 *
 * Example 2:
 * Input: command = "G()()()()(al)"
 * Output: "Gooooal"
 *
 * Example 3:
 * Input: command = "(al)G(al)()()G"
 * Output: "alGalooG"
 *
 * @see <a href="https://leetcode.cn/problems/goal-parser-interpretation/" />
 * @author Poet
 * @date 2022/11/6
 */
public class LC_1678_GoalParserInterpretation {

    /* --- 这道题来自：第 218 场周赛 --- */

    /**
     * 方法一：直接遍历
     *
     * time:  O(n)
     * space: O(1)
     */
    public String interpret(String command) {
        int n = command.length();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (command.charAt(i) == 'G') {
                builder.append("G");
            } else if (command.charAt(i) == '(') {
                if (i + 1 < n && command.charAt(i + 1) == ')') {
                    builder.append("o");
                } else {
                    builder.append("al");
                }
            }
        }
        return builder.toString();
    }
}
