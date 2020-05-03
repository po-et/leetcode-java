package com.home.leetcode.medium;

import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 *
 * Example 1:
 *
 * Input: "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 *
 * @see <a href = "https://leetcode.com/problems/simplify-path/" />
 * @author Poet
 * @date 2020/5/3
 */
public class SimplifyPath_71 {

    public String simplifyPath(String path) {
        if(path == null || path.isEmpty()) return "";

        Stack<String> stack = new Stack<>();
        for (String str : path.split("/")) {
            if (".".equals(str) || "".equals(str)) {
                continue;

            } else if ("..".equals(str)) {
                if(!stack.isEmpty()) stack.pop();

            } else {
                stack.push(str);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }
//        StringBuilder res = new StringBuilder();
//        for (String str : stack) {
//            res.append("/").append(str);
//        }
//        return res.toString();

        return "/" + String.join("/", stack);
    }
}
