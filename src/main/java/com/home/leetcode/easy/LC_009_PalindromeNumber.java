package com.home.leetcode.easy;

/**
 * 9. Palindrome Number (回文数)
 *
 * Given an integer x, return true if x is palindrome integer.
 *
 * An integer is a palindrome when it reads the same backward as forward.
 *
 * For example, 121 is a palindrome while 123 is not.
 *
 * Example 1:
 * Input: x = 121
 * Output: true
 *
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * Example 3:
 * Input: x = 10
 * Output: false
 *
 * @see <a href="https://leetcode.cn/problems/palindrome-number" />
 * @author Poet
 * @date 2019/1/8
 */
public class LC_009_PalindromeNumber {

    /**
     * 方法一：反转一半数字
     *
     * 注意：本题要求的解法！转换为字符串以后判断回文，会增加额外的非常量空间
     */
    public static boolean isPalindrome(int x) {
        // 特殊情况：
        // ① 当 x < 0 时，x 不是回文数。
        // ② 如果数字的最后一位是 0，为了使该数字为回文， 则其第一位数字也应该是 0， 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public static boolean isPalindrome_1(int x) {
        String s = String.valueOf(x);
        int length = s.length();
        for (int i = 0; i <= length / 2; i++) {
            if (!(s.charAt(i) == s.charAt(length - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome_2(int x) {
        if (x < 0) {
            return false;
        }

        String str = String.valueOf(x);
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(123321));
        System.out.println(isPalindrome(1000));
        System.out.println(isPalindrome(1001));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(Integer.MAX_VALUE));
        System.out.println(isPalindrome(Integer.MIN_VALUE));
    }
}
