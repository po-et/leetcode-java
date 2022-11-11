package com.home.leetcode.easy;

/**
 * 1704. Determine if String Halves Are Alike (判断字符串的两半是否相似)
 *
 * You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.
 *
 * Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').
 * Notice that s contains uppercase and lowercase letters.
 *
 * Return true if a and b are alike. Otherwise, return false.
 *
 * Example 1:
 * Input: s = "book"
 * Output: true
 * Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
 *
 * Example 2:
 * Input: s = "textbook"
 * Output: false
 * Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
 * Notice that the vowel o is counted twice.
 *
 * @see <a href="https://leetcode.cn/problems/determine-if-string-halves-are-alike/" />
 * @author Poet
 * @date 2022/11/11
 */
public class LC_1704_DetermineIfStringHalvesAreAlike {

    /**
     * 方法一：计数
     *
     * time:  O(n) 其中 n 为字符串 s 的长度
     * space: O(n)
     */
    public boolean halvesAreAlike(String s) {
        String vowels = "aeiouAEIOU";
        String a = s.substring(0, s.length() / 2);
        String b = s.substring(s.length() / 2);
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < a.length(); i++) {
            if (vowels.indexOf(a.charAt(i)) >= 0) {
                count1++;
            }
        }
        for (int i = 0; i < b.length(); i++) {
            if (vowels.indexOf(b.charAt(i)) >= 0) {
                count2++;
            }
        }

        return count1 == count2;
    }
}
