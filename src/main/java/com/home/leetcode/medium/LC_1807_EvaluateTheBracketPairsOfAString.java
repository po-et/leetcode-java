package com.home.leetcode.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1807. Evaluate the Bracket Pairs of a String (替换字符串中的括号内容)
 *
 * You are given a string s that contains some bracket pairs, with each pair containing a non-empty key.
 *
 * For example, in the string "(name)is(age)yearsold", there are two bracket pairs that contain the keys "name" and "age".
 * You know the values of a wide range of keys. This is represented by a 2D string array knowledge where each knowledge[i] = [keyi, valuei] indicates that key keyi has a value of valuei.
 *
 * You are tasked to evaluate all of the bracket pairs. When you evaluate a bracket pair that contains some key keyi, you will:
 *
 * Replace keyi and the bracket pair with the key's corresponding valuei.
 * If you do not know the value of the key, you will replace keyi and the bracket pair with a question mark "?" (without the quotation marks).
 * Each key will appear at most once in your knowledge. There will not be any nested brackets in s.
 *
 * Return the resulting string after evaluating all of the bracket pairs.
 *
 * Example 1:
 * Input: s = "(name)is(age)yearsold", knowledge = [["name","bob"],["age","two"]]
 * Output: "bobistwoyearsold"
 * Explanation:
 * The key "name" has a value of "bob", so replace "(name)" with "bob".
 * The key "age" has a value of "two", so replace "(age)" with "two".
 *
 * Example 2:
 * Input: s = "hi(name)", knowledge = [["a","b"]]
 * Output: "hi?"
 * Explanation: As you do not know the value of the key "name", replace "(name)" with "?".
 *
 * Example 3:
 * Input: s = "(a)(a)(a)aaa", knowledge = [["a","yes"]]
 * Output: "yesyesyesaaa"
 * Explanation: The same key can appear multiple times.
 * The key "a" has a value of "yes", so replace all occurrences of "(a)" with "yes".
 * Notice that the "a"s not in a bracket pair are not evaluated.
 *
 * @see <a href="https://leetcode.cn/problems/evaluate-the-bracket-pairs-of-a-string/" />
 * @author Poet
 * @date 2023/1/12
 */
public class LC_1807_EvaluateTheBracketPairsOfAString {

    /**
     * 方法一：哈希表
     *
     * 自己ac
     */
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> dict = new HashMap<>();
        for (List<String> list : knowledge) {
            dict.put(list.get(0), list.get(1));
        }

        StringBuilder builder = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                int index = i+1;
                while (index < n && s.charAt(index) != ')') {
                    index++;
                }
                String subStr = s.substring(i + 1, index);
                if(dict.containsKey(subStr)){
                    builder.append(dict.get(subStr));
                } else {
                    builder.append("?");
                }
                i = index;

            } else {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }


    /**
     * 官方题解（和自己ac的是一个思路，写法不同）
     *
     * time:  O(n+k)，其中 n 是字符串 s 的长度，k 是字符串数组 knowledge 中所有字符串的长度之和
     * space: 保存哈希表 dict 和 key 分别需要 O(k) 和 O(n)
     */
    public String evaluate_2(String s, List<List<String>> knowledge) {
        Map<String, String> dict = new HashMap<String, String>();
        for (List<String> kd : knowledge) {
            dict.put(kd.get(0), kd.get(1));
        }
        boolean addKey = false;
        StringBuilder key = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                addKey = true;
            } else if (c == ')') {
                if (dict.containsKey(key.toString())) {
                    res.append(dict.get(key.toString()));
                } else {
                    res.append('?');
                }
                addKey = false;
                key.setLength(0);
            } else {
                if (addKey) {
                    key.append(c);
                } else {
                    res.append(c);
                }
            }
        }
        return res.toString();
    }
}
