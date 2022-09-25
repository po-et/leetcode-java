package com.home.leetcode.medium;

/**
 * 788. Rotated Digits (旋转数字)
 *
 * An integer x is a good if after rotating each digit individually by 180 degrees, we get a valid number that is different from x.
 * Each digit must be rotated - we cannot choose to leave it alone.
 *
 * A number is valid if each digit remains a digit after rotation. For example:
 *
 * 0, 1, and 8 rotate to themselves,
 * 2 and 5 rotate to each other (in this case they are rotated in a different direction, in other words, 2 or 5 gets mirrored),
 * 6 and 9 rotate to each other, and
 * the rest of the numbers do not rotate to any other number and become invalid.
 *
 * Given an integer n, return the number of good integers in the range [1, n].
 *
 * Example 1:
 * Input: n = 10
 * Output: 4
 * Explanation: There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 * Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 *
 * Example 2:
 * Input: n = 1
 * Output: 0
 *
 * Example 3:
 * Input: n = 2
 * Output: 1
 *
 * @see <a href="https://leetcode.cn/problems/rotated-digits/" />
 * @author Poet
 * @date 2022/9/25
 */
public class LC_788_RotatedDigits {

    /**
     * 方法一：枚举每一个数
     *
     * 根据题目的要求，一个数是好数，当且仅当：
     * - 数中没有出现 3, 4, 7
     * - 数中至少出现一次 2 或 5 或 6 或 9
     * - 对于 0, 1, 8 则没有要求。
     */
    int[] check = new int[]{0, 0, 1, -1, -1, 1, 1, -1, 0, 1};

    public int rotatedDigits(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            String num = String.valueOf(i);
            boolean valid = true;          // 对应第一个条件
            boolean atLeastOnce = false;   // 对应第二个条件
            for (int j = 0; j < num.length(); j++) {
                char ch = num.charAt(j);
                if (check[ch - '0'] == -1) {
                    valid = false;
                } else if (check[ch - '0'] == 1) {
                    atLeastOnce = true;
                }
            }
            if (valid && atLeastOnce) {
                res++;
            }
        }
        return res;
    }

    /**
     * 方法二：数位动态规划
     *
     * solution: https://leetcode.cn/problems/rotated-digits/solution/xuan-zhuan-shu-zi-by-leetcode-solution-q9bh/
     */
}
