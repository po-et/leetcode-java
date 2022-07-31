package com.home.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 844. Backspace String Compare
 *
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 * Example 1:
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 *
 * Example 2:
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 *
 * Example 3:
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 *
 * Constraints:
 *  - 1 <= s.length, t.length <= 200
 *  - s and t only contain lowercase letters and '#' characters.
 *
 * Follow up: Can you solve it in O(n) time and O(1) space?
 *
 * @see <a href="https://leetcode.cn/problems/backspace-string-compare/" />
 * @author Poet
 * @date 2022/7/31
 */
public class LC_844_BackspaceStringCompare {

    /**
     * 方法一：重构字符串
     *
     * time:  O(N+M)，其中 N 和 M 分别为字符串 S 和 T 的长度。我们需要遍历两字符串各一次。
     * space: O(N+M)
     */
    public boolean backspaceCompare(String s, String t) {
        return buildString(s).equals(buildString(t));
    }

    private String buildString(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }

    /**
     * 方法二：双指针
     *
     * time:  O(N+M) 其中 N 和 M 分别为字符串 S 和 T 的长度。我们需要遍历两字符串各一次。
     * space: O(1)   对于每个字符串，我们只需要定义一个指针和一个计数器即可。
     */
    public boolean backspaceCompare_space_o1(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }

}
