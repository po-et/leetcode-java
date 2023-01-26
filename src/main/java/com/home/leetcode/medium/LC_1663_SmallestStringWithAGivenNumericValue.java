package com.home.leetcode.medium;

/**
 * 1663. Smallest String With A Given Numeric Value (具有给定数值的最小字符串)
 *
 * The numeric value of a lowercase character is defined as its position (1-indexed) in the alphabet, so the numeric value of a is 1, the numeric value of b is 2, the numeric value of c is 3, and so on.
 *
 * The numeric value of a string consisting of lowercase characters is defined as the sum of its characters' numeric values. For example, the numeric value of the string "abe" is equal to 1 + 2 + 5 = 8.
 *
 * You are given two integers n and k. Return the lexicographically smallest string with length equal to n and numeric value equal to k.
 *
 * Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order, that is, either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i] comes before y[i] in alphabetic order.
 *
 * Example 1:
 * Input: n = 3, k = 27
 * Output: "aay"
 * Explanation: The numeric value of the string is 1 + 1 + 25 = 27, and it is the smallest string with such a value and length equal to 3.
 *
 * Example 2:
 * Input: n = 5, k = 73
 * Output: "aaszz"
 *
 * @see <a href="https://leetcode.cn/problems/smallest-string-with-a-given-numeric-value/" />
 * @author Poet
 * @date 2023/1/26
 */
public class LC_1663_SmallestStringWithAGivenNumericValue {

    /**
     * 贪心
     *
     * 备注：自己ac
     */
    char[] alpha = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public String getSmallestString(int n, int k) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int index = k - n + i;
            if (index == 1) {
                builder.append('a');
            } else if (index > 26) {
                builder.append('z');
                index = 26;
            } else {
                builder.append(alpha[index - 1]);
            }
            k = k - index;
        }

        return builder.reverse().toString();
    }


    /**
     * 官方题解：贪心
     *
     * time:  O(n)
     * space: O(1)
     *
     * 链接：https://leetcode.cn/problems/smallest-string-with-a-given-numeric-value/solution/ju-you-gei-ding-shu-zhi-de-zui-xiao-zi-f-e0e4/
     */
    public String getSmallestString_official(int n, int k) {
        StringBuilder res = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int lower = Math.max(1, k - (n - i) * 26);
            k -= lower;
            res.append((char) ('a' + lower - 1));
        }
        return res.toString();
    }

}
