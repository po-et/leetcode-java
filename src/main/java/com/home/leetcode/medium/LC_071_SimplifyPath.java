package com.home.leetcode.medium;

import java.util.Stack;

/**
 * 71. Simplify Path
 *
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 *
 * Example 1:
 * Input: "/home/"
 * Output: "/home"
 *
 * Example 2:
 * Input: path = "/../"
 * Output: "/"
 *
 * @see <a href = "https://leetcode.cn/problems/simplify-path/" />
 * @author Poet
 * @date 2020/5/3
 */
public class LC_071_SimplifyPath {

    /**
     * 方法一：栈
     * time: O(n)
     * space: O(n)
     */
    public String simplifyPath(String path) {
        if (path == null || path.isEmpty()) return "";

        Stack<String> stack = new Stack<>();
//        Deque<String> stack = new ArrayDeque<String>();   // 会报错？
        for (String str : path.split("/")) {
            if (".".equals(str) || "".equals(str)) {
                continue;
            } else if ("..".equals(str)) {
                if (!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.push(str);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }
        // 拼接写法一
//        StringBuilder res = new StringBuilder();
//        for (String str : stack) {
//            res.append("/").append(str);
//        }
//        return res.toString();
        // 拼接写法二
        return "/" + String.join("/", stack);
    }

}
