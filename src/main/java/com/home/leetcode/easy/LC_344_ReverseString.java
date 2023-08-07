package com.home.leetcode.easy;

/**
 * 344. Reverse String（反转字符串）
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 示例 1：
 * 输入：s = ["h","e","l","l","o"]
 * 输出：    ["o","l","l","e","h"]
 *
 * @see <a href="https://leetcode.cn/problems/reverse-string/" />
 * @author Poet
 * @date 2022/5/13
 */
public class LC_344_ReverseString {

    /**
     * 方法：双指针
     *
     * time:  O(n)
     * space: O(1)
     */
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;

        while (l < r) {
            swap(s, l, r);
            l++;
            r--;
        }
    }

    private void swap(char[] s, int l, int r) {
        char tmp = s[l];
        s[l] = s[r];
        s[r] = tmp;
    }
}
