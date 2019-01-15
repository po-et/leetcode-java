package com.home.leetcode;

/**
 * 回文数判断
 * Created by Poet on 2019-01-08.
 */
public class PalindromeNumber_9 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(123321));
        System.out.println(isPalindrome(1000));
        System.out.println(isPalindrome(1001));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(Integer.MAX_VALUE));
        System.out.println(isPalindrome(Integer.MIN_VALUE));
    }


    /**
     * corner case: 1000
     * 相当于 1000 与 1 比较
     */
    public static boolean isPalindrome(int x) {
        if (x < 0 ||(x != 0 && x % 10 == 0)) return false;
        int palind = x;
        int rev = 0;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x/=10;
        }
        return palind == rev;
    }

    public static boolean isPalindrome1(int x) {
        String s = String.valueOf(x);
        int length = s.length();
        for (int i = 0; i <= length/2; i++) {
            if (!(s.charAt(i) == s.charAt(length - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}
