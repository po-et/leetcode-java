package com.home.jianzhi_offer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 *
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * @see <a href="https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/" />
 * @author Poet
 * @date 2022/6/7
 */
public class Offer_58_ReverseWords_I {

    /**
     * 方法一：使用语言特性
     */
    public String reverseWords_inner_api(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        // 翻转
        Collections.reverse(wordList);
        // 连接
        return String.join(" ", wordList);
    }


    /**
     * 方法二：自行编写对应的函数
     */
    public String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split("\\s+");
        int l = 0, r = arr.length - 1;
        while (l < r) {
            swap(arr, l, r);
            l++;
            r--;
        }
        return String.join(" ", arr);
    }

    private void swap(String[] arr, int l, int r) {
        String tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }



    // python版本，如此简洁
//    def reverseWords(self, s: str) -> str:
//        s_list = s.split()
//        return ' '.join(s_list[::-1])
}
