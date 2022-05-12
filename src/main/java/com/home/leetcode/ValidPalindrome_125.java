package com.home.leetcode;

/**
 * 125. Valid Palindrome
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Example 1:
 *  Input: "A man, a plan, a canal: Panama"
 *  Output: true
 *
 * @see <a href ="https://leetcode.com/problems/valid-palindrome/" />
 * @author Poet
 * @date 2020/4/11
 */
public class ValidPalindrome_125 {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
        System.out.println(isPalindrome2(s));
    }

    public static boolean isPalindrome(String s) {
        if (s.trim().isEmpty()) {
            return true;
        }

        int l = 0, r = s.length()-1;

        while (l < r) {
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            } else if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            } else {
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {
        if (s.trim().isEmpty()) {
            return true;
        }

        s = s.toLowerCase();

        int l = 0;
        int r = s.length() - 1;

        while (true) {
            while (l <= s.length() - 1 && !isAlphanumeric(s.charAt(l))) {
                l++;
            }
            while (r >= 0 && !isAlphanumeric(s.charAt(r))) {
                r--;
            }

            if (l > r) {
                break;
            }
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    public static  boolean isAlphanumeric(Character c){
        // 0 48, A 65, a 97
        String pattern = "[a-zA-Z0-9]";
        return c.toString().matches(pattern);
    }

}
