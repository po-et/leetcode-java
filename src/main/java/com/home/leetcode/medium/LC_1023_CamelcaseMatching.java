package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 1023. Camelcase Matching (驼峰式匹配)
 *
 * Given an array of strings queries and a string pattern, return a boolean array answer where answer[i] is true if queries[i] matches pattern, and false otherwise.
 *
 * A query word queries[i] matches pattern if you can insert lowercase English letters pattern so that it equals the query. You may insert each character at any position and you may not insert any characters.
 *
 * Example 1:
 * Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
 * Output: [true,false,true,true,false]
 * Explanation: "FooBar" can be generated like this "F" + "oo" + "B" + "ar".
 * "FootBall" can be generated like this "F" + "oot" + "B" + "all".
 * "FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".
 *
 * Example 2:
 * Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
 * Output: [true,false,true,false,false]
 * Explanation: "FooBar" can be generated like this "Fo" + "o" + "Ba" + "r".
 * "FootBall" can be generated like this "Fo" + "ot" + "Ba" + "ll".
 *
 * Example 3:
 * Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
 * Output: [false,true,false,false,false]
 * Explanation: "FooBarTest" can be generated like this "Fo" + "o" + "Ba" + "r" + "T" + "est".
 *
 * @see <a href="https://leetcode.cn/problems/camelcase-matching/" />
 * @author Poet
 * @date 2023/4/14
 */
public class LC_1023_CamelcaseMatching {

    /**
     * 方法一：双指针
     *
     * time:  O(nm)
     * space: O(1)
     */
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String query : queries) {
            res.add(isMatch(query, pattern));
        }
        return res;
    }

    private Boolean isMatch(String query, String pattern) {
        int idx = 0;
        for (int i = 0; i < query.length(); i++) {
            char ch = query.charAt(i);
            if (idx < pattern.length() && ch == pattern.charAt(idx)) {
                idx++;
            } else if (Character.isUpperCase(ch)) {
                return false;
            }
        }
        return idx >= pattern.length();
    }

}
