package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 833. Find And Replace in String (字符串中的查找与替换)
 *
 * You are given a 0-indexed string s that you must perform k replacement operations on. The replacement operations are given as three 0-indexed parallel arrays, indices, sources, and targets, all of length k.
 *
 * To complete the ith replacement operation:
 *
 *  1. Check if the substring sources[i] occurs at index indices[i] in the original string s.
 *  2. If it does not occur, do nothing.
 *  3. Otherwise if it does occur, replace that substring with targets[i].
 *
 * For example, if s = "abcd", indices[i] = 0, sources[i] = "ab", and targets[i] = "eee", then the result of this replacement will be "eeecd".
 *
 * All replacement operations must occur simultaneously, meaning the replacement operations should not affect the indexing of each other. The testcases will be generated such that the replacements will not overlap.
 *
 * For example, a testcase with s = "abc", indices = [0, 1], and sources = ["ab","bc"] will not be generated because the "ab" and "bc" replacements overlap.
 * Return the resulting string after performing all replacement operations on s.
 *
 * Example 1:
 * Input: s = "abcd", indices = [0, 2], sources = ["a", "cd"], targets = ["eee", "ffff"]
 * Output: "eeebffff"
 * Explanation:
 * "a" occurs at index 0 in s, so we replace it with "eee".
 * "cd" occurs at index 2 in s, so we replace it with "ffff".
 *
 * @see <a href="https://leetcode.cn/problems/find-and-replace-in-string/" />
 * @author Poet
 * @date 2023/8/15
 */
public class LC_833_FindAndReplaceInString {

    /**
     * 方法二：哈希表 + 模拟
     */
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length(), m = indices.length;

        Map<Integer, List<Integer>> ops = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            ops.putIfAbsent(indices[i], new ArrayList<>());
            ops.get(indices[i]).add(i);
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; ) {
            boolean succeed = false;
            if (ops.containsKey(i)) {
                for (int pt : ops.get(i)) {
                    if (s.substring(i, Math.min(i + sources[pt].length(), n)).equals(sources[pt])) {
                        succeed = true;
                        builder.append(targets[pt]);
                        i += sources[pt].length();
                        break;
                    }
                }
            }
            if (!succeed) {
                builder.append(s.charAt(i));
                ++i;
            }
        }
        return builder.toString();
    }

}
