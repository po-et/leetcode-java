package com.home.leetcode;

/**
 * reverse integer
 * <p>
 * corner case: 越界（int越界！）
 *
 * time: O(n)
 * space: O(1)
 *
 * Created by Poet on 2019-01-08.
 */
public class ReverseInteger_7 {

    public static void main(String[] args) {
        System.out.println(reverse(12345));
        System.out.println(reverse(-12345));
        System.out.println(reverse(Integer.MAX_VALUE));
        System.out.println(reverse(Integer.MIN_VALUE));
    }

    public static int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        }
        return (int) res;
    }
}
