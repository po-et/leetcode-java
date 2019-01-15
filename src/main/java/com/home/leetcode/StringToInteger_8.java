package com.home.leetcode;

/**
 * StringToInteger
 * <p>
 * corner case: + - not valid 越界
 * time: O(n)
 * space: O(1)
 * <p>
 * Created by Poet on 2019-01-08.
 */
public class StringToInteger_8 {
    public static void main(String[] args) {
        System.out.println(myAtoi("1234567"));
        System.out.println(myAtoi("+1234567"));
        System.out.println(myAtoi("-1234567"));
        System.out.println(myAtoi("abc1234567"));
        System.out.println(myAtoi("1234abc567"));
        System.out.println(myAtoi(Integer.MAX_VALUE + ""));
        System.out.println(myAtoi(Integer.MIN_VALUE + ""));
        System.out.println(myAtoi(Integer.MAX_VALUE+1 + ""));
        System.out.println(myAtoi(Integer.MIN_VALUE-1 + ""));
    }

    public static int myAtoi(String str) {
        if (str == null || str.length() < 1) return 0;
        long res = 0;
        int sign = 1;
        int start = 0;
        char fistChar = str.charAt(0);
        if (fistChar == '+') {
            sign = 1;
            start++;
        } else if (fistChar == '-') {
            sign = -1;
            start++;
        }

        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) (res * sign);
            }
            res = res * 10 + str.charAt(i) - '0';
            if (sign == 1 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && res > Integer.MAX_VALUE) return Integer.MIN_VALUE;
        }
        return (int) (res * sign);
    }


}
