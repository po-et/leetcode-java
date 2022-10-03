package com.home.leetcode.easy;

/**
 * 1784. Check if Binary String Has at Most One Segment of Ones (检查二进制字符串字段)
 *
 * Given a binary string s without leading zeros, return true if s contains at most one contiguous segment of ones.
 * Otherwise, return false.
 *
 * Example 1:
 * Input: s = "1001"
 * Output: false
 * Explanation: The ones do not form a contiguous segment.
 *
 * Example 2:
 * Input: s = "110"
 * Output: true
 *
 * @see <a href="https://leetcode.cn/problems/check-if-binary-string-has-at-most-one-segment-of-ones/" />
 * @author Poet
 * @date 2022/10/3
 */
public class LC_1784_CheckIfBinaryStringHasAtMostOneSegmentOfOnes {

    // 自己完成ac
    public boolean checkOnesSegment(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                if (s.charAt(i) == '1') {
                    count++;
                }
                continue;
            }

            if (s.charAt(i) == '1') {
                if (s.charAt(i - 1) != '1') {
                    count++;
                }
            }
        }

        return count <= 1;
    }

    /**
     * 方法一：寻找 01 串
     *
     * 我们依次分析这两种情况：
     *      - 字符串 s 中包含零个由连续 1 组成的字段，那么整个串的表示为 0000⋯00
     *      - 字符串 s 中只包含一个由连续 1 组成的字段，因为已知字符串 s 不包含前导零，所以整个串的表示为 1⋯100⋯00
     *
     * 那么可以看到两种情况中都不包含 01 串，且不包含的 01 串的一个二进制字符串也有且仅有上面两种情况。
     * 所以我们可以通过原字符串中是否有 01 串来判断字符串中是否只包含零个或一个由连续 1 组成的字段。
     *
     * time:  O(n)
     * space: O(1)
     */
    public boolean checkOnesSegment_1(String s) {
        return !s.contains("01");
    }

}
