package com.home.leetcode.easy;

/**
 * 345. 反转字符串中的元音字母
 *
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
 *
 * 示例 1：
 * 输入：s = "hello"
 * 输出："holle"
 *
 * @see <a href="https://leetcode.cn/problems/reverse-vowels-of-a-string/" />
 * @author Poet
 * @date 2022/5/13
 */
public class LC_345_ReverseVowelsOfAString {

    /**
     * 方法一：双指针
     */
    public String reverseVowels(String s) {

        char[] arr = s.toCharArray();
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            while (l < s.length() && !isVowelIgnoreCase(arr[l])) {
                l++;
            }
            while (r > 0 && !isVowelIgnoreCase(arr[r])) {
                r--;
            }
            if (l < r) {
                swap(arr, l, r);
                l++;
                r--;
            }
        }

        return String.valueOf(arr);   // OR return new String(arr);
    }

    private boolean isVowelIgnoreCase(char ch) {

        return "aeiouAEIOU".indexOf(ch) >= 0;
    }

    private void swap(char[] arr, int l, int r) {
        char tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

}
