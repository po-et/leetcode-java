package com.home.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 1805. Number of Different Integers in a String
 *
 * You are given a string word that consists of digits and lowercase English letters.
 *
 * You will replace every non-digit character with a space. For example, "a123bc34d8ef34" will become " 123  34 8  34".
 * Notice that you are left with some integers that are separated by at least one space: "123", "34", "8", and "34".
 *
 * Return the number of different integers after performing the replacement operations on word.
 *
 * Two integers are considered different if their decimal representations without any leading zeros are different.
 *
 * Example 1:
 * Input: word = "a123bc34d8ef34"
 * Output: 3
 * Explanation: The three different integers are "123", "34", and "8". Notice that "34" is only counted once.
 *
 * Example 2:
 * Input: word = "leet1234code234"
 * Output: 2
 *
 * Example 3:
 * Input: word = "a1b01c001"
 * Output: 1
 * Explanation: The three integers "1", "01", and "001" all represent the same integer because the leading zeros are ignored when comparing their decimal values.
 *
 * @see <a href="https://leetcode.cn/problems/number-of-different-integers-in-a-string/" />
 * @author Poet
 * @date 2022/12/6
 */
public class LC_1805_NumberOfDifferentIntegersInAString {

    /**
     * 方法一：双指针
     *
     * time:  O(n)
     * space: O(n)
     */
    public int numDifferentIntegers(String word) {
        int n = word.length();
        Set<String> set = new HashSet<>();
        int p1 = 0;
        int p2;

        while (true) {
            while (p1 < n && Character.isLetter(word.charAt(p1))) {
                p1++;
            }
            if (p1 == n) {
                break;
            }
            p2 = p1;
            while (p2 < n && Character.isDigit(word.charAt(p2))) {
                p2++;
            }
            // 去除前导0
            while (p2 - p1 > 1 && word.charAt(p1) == '0') {
                p1++;
            }
            set.add(word.substring(p1, p2));
            p1 = p2;
        }
        return set.size();
    }

}

