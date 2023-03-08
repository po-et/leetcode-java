package com.home.leetcode.easy;

/**
 * 2379. Minimum Recolors to Get K Consecutive Black Blocks (得到K个黑块的最少涂色次数)
 *
 * You are given a 0-indexed string blocks of length n, where blocks[i] is either 'W' or 'B', representing the color of the ith block. The characters 'W' and 'B' denote the colors white and black, respectively.
 *
 * You are also given an integer k, which is the desired number of consecutive black blocks.
 *
 * In one operation, you can recolor a white block such that it becomes a black block.
 *
 * Return the minimum number of operations needed such that there is at least one occurrence of k consecutive black blocks.
 *
 * Example 1:
 * Input: blocks = "WBBWWBBWBW", k = 7
 * Output: 3
 * Explanation:
 * One way to achieve 7 consecutive black blocks is to recolor the 0th, 3rd, and 4th blocks
 * so that blocks = "BBBBBBBWBW".
 * It can be shown that there is no way to achieve 7 consecutive black blocks in less than 3 operations.
 * Therefore, we return 3.
 *
 * Example 2:
 * Input: blocks = "WBWBBBW", k = 2
 * Output: 0
 * Explanation:
 * No changes need to be made, since 2 consecutive black blocks already exist.
 * Therefore, we return 0.
 *
 * @see <a href="https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/" />
 * @author Poet
 * @date 2023/3/9
 */
public class LC_2379_MinimumRecolorsToGetKConsecutiveBlackBlocks {

    /**
     * 方法一：滑动窗口
     *
     * time:  O(n)
     * space: O(1)
     */
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int l = 0, r = 0;
        int count = 0;
        while (r < k) {
            if (blocks.charAt(r) == 'W') {
                count++;
            }
            r++;
        }

        int res = count;

        while (r < n) {
            count += blocks.charAt(r) == 'W' ? 1 : 0;
            count -= blocks.charAt(l) == 'W' ? 1 : 0;
            res = Math.min(res, count);
            l++;
            r++;
        }
        return res;
    }
}
