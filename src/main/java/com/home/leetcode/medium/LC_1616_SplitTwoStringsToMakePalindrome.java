package com.home.leetcode.medium;

/**
 * 1616. Split Two Strings to Make Palindrome （分割两个字符串得到回文串）
 *
 * You are given two strings a and b of the same length. Choose an index and split both strings at the same index, splitting a into two strings: aprefix and asuffix where a = aprefix + asuffix, and splitting b into two strings: bprefix and bsuffix where b = bprefix + bsuffix. Check if aprefix + bsuffix or bprefix + asuffix forms a palindrome.
 *
 * When you split a string s into sprefix and ssuffix, either ssuffix or sprefix is allowed to be empty. For example, if s = "abc", then "" + "abc", "a" + "bc", "ab" + "c" , and "abc" + "" are valid splits.
 *
 * Return true if it is possible to form a palindrome string, otherwise return false.
 *
 * Notice that x + y denotes the concatenation of strings x and y.
 *
 * Example 1:
 * Input: a = "x", b = "y"
 * Output: true
 * Explaination: If either a or b are palindromes the answer is true since you can split in the following way:
 * aprefix = "", asuffix = "x"
 * bprefix = "", bsuffix = "y"
 * Then, aprefix + bsuffix = "" + "y" = "y", which is a palindrome.
 *
 * Example 2:
 * Input: a = "xbdef", b = "xecab"
 * Output: false
 *
 * Example 3:
 * Input: a = "ulacfd", b = "jizalu"
 * Output: true
 * Explaination: Split them at index 3:
 * aprefix = "ula", asuffix = "cfd"
 * bprefix = "jiz", bsuffix = "alu"
 * Then, aprefix + bsuffix = "ula" + "alu" = "ulaalu", which is a palindrome.
 *
 * @see <a href="https://leetcode.cn/problems/split-two-strings-to-make-palindrome/" />
 * @author Poet
 * @date 2023/3/18
 */
public class LC_1616_SplitTwoStringsToMakePalindrome {

    /**
     * 方法一：双指针
     *
     * time:  O(n)
     * space: O(1)
     */
    public boolean checkPalindromeFormation(String a, String b) {
        return checkFormation(a, b) || checkFormation(b, a);
    }

    private boolean checkFormation(String a, String b) {
        int l = 0, r = a.length() - 1;
        while (l < r && a.charAt(l) == b.charAt(r)) {
            l++;
            r--;
        }
        if (l >= r) {
            return true;
        }
        return checkSelf(a, l, r) || checkSelf(b, l, r);
    }

    private boolean checkSelf(String str, int l, int r) {
        while (l < r && str.charAt(l) == str.charAt(r)) {
            l++;
            r--;
        }
        return l >= r;
    }

}
