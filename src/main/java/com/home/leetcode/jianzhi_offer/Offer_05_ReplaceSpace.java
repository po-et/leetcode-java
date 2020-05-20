package com.home.leetcode.jianzhi_offer;

/**
 * 面试题05. 替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * @author Poet
 * @date 2020/5/20
 */
public class Offer_05_ReplaceSpace {

    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        StringBuilder ret = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (' ' == c ) {
                ret.append("%20");
            } else {
                ret.append(c);
            }
        }

        return ret.toString();
    }
}
