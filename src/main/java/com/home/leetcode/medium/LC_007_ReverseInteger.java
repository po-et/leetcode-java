package com.home.leetcode.medium;

/**
 * 7. Reverse Integer
 *
 * corner case: 越界（int越界！）
 *
 * Example 1:
 * Input: x = 123
 * Output: 321
 *
 * Created by Poet on 2019-01-08.
 */
public class LC_007_ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(12345));
        System.out.println(reverse(-12345));
        System.out.println(reverse(Integer.MAX_VALUE));
        System.out.println(reverse(Integer.MIN_VALUE));
    }

    /**
     * time: O(log|x|)
     * space: O(1)
     */
    public static int reverse(int x) {
        long res = 0;

        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;

            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
        }

        return (int) res;
    }
}
