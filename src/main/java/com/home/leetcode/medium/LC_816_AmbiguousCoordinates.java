package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 816. Ambiguous Coordinates
 *
 * We had some 2-dimensional coordinates, like "(1, 3)" or "(2, 0.5)". Then, we removed all commas, decimal points, and spaces and ended up with the string s.
 *
 * For example, "(1, 3)" becomes s = "(13)" and "(2, 0.5)" becomes s = "(205)".
 * Return a list of strings representing all possibilities for what our original coordinates could have been.
 *
 * Our original representation never had extraneous zeroes, so we never started with numbers like "00", "0.0", "0.00", "1.0", "001", "00.01", or any other number that can be represented with fewer digits. Also, a decimal point within a number never occurs without at least one digit occurring before it, so we never started with numbers like ".1".
 *
 * The final answer list can be returned in any order. All coordinates in the final answer have exactly one space between them (occurring after the comma.)
 *
 * Example 1:
 * Input: s = "(123)"
 * Output: ["(1, 2.3)","(1, 23)","(1.2, 3)","(12, 3)"]
 *
 * Example 2:
 * Input: s = "(0123)"
 * Output: ["(0, 1.23)","(0, 12.3)","(0, 123)","(0.1, 2.3)","(0.1, 23)","(0.12, 3)"]
 * Explanation: 0.0, 00, 0001 or 00.01 are not allowed.
 *
 * Example 3:
 * Input: s = "(00011)"
 * Output: ["(0, 0.011)","(0.001, 1)"]
 *
 * @see <a href="https://leetcode.cn/problems/ambiguous-coordinates/" />
 * @author Poet
 * @date 2022/11/7
 */
public class LC_816_AmbiguousCoordinates {

    /* --- 这道题来自周赛：Weekly Contest 80 --- */

    /**
     * 方法一：枚举
     *
     * solution: https://leetcode.cn/problems/ambiguous-coordinates/solution/mo-hu-zuo-biao-by-leetcode-solution-y1yz/
     */
    public List<String> ambiguousCoordinates(String s) {
        int n = s.length() - 2;
        s = s.substring(1, s.length() - 1);     // 去掉左右括号
        List<String> res = new ArrayList<>();

        for (int l = 1; l < n; ++l) {
            List<String> lt = getPos(s.substring(0, l));
            if (lt.isEmpty()) {
                continue;
            }
            List<String> rt = getPos(s.substring(l));
            if (rt.isEmpty()) {
                continue;
            }
            for (String i : lt) {
                for (String j : rt) {
                    res.add("(" + i + ", " + j + ")");
                }
            }
        }
        return res;
    }

    public List<String> getPos(String s) {
        List<String> pos = new ArrayList<>();
        if (s.charAt(0) != '0' || "0".equals(s)) {
            pos.add(s);
        }
        for (int p = 1; p < s.length(); ++p) {
            if ((p != 1 && s.charAt(0) == '0') || s.charAt(s.length() - 1) == '0') {
                continue;
            }
            pos.add(s.substring(0, p) + "." + s.substring(p));
        }
        return pos;
    }

}
