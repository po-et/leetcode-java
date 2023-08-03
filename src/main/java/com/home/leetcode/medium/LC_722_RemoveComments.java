package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 722. Remove Comments
 *
 * Given a C++ program, remove comments from it. The program source is an array of strings source where source[i] is the ith line of the source code.
 * This represents the result of splitting the original source code string by the newline character '\n'.
 *
 * In C++, there are two types of comments, line comments, and block comments.
 *
 * The first effective comment takes precedence over others.
 *
 * @see <a href="https://leetcode.cn/problems/remove-comments/" />
 * @author Poet
 * @date 2023/8/3
 */
public class LC_722_RemoveComments {

    /**
     * 方法：模拟
     */
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        StringBuilder newLine = new StringBuilder();
        boolean inBlock = false;

        for (String line : source) {
            for (int i = 0; i < line.length(); i++) {
                if (inBlock) {
                    if (i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                        inBlock = false;
                        i++;
                    }
                } else {
                    if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                        inBlock = true;
                        i++;
                    } else if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                        break;
                    } else {
                        newLine.append(line.charAt(i));
                    }
                }
            }
            if (!inBlock && newLine.length() > 0) {
                res.add(newLine.toString());
                newLine.setLength(0);
            }
        }
        return res;
    }

}
