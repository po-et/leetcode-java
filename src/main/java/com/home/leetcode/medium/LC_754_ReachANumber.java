package com.home.leetcode.medium;

/**
 * 754. Reach a Number
 *
 * You are standing at position 0 on an infinite number line. There is a destination at position target.
 *
 * You can make some number of moves numMoves so that:
 *
 * On each move, you can either go left or right.
 * During the ith move (starting from i == 1 to i == numMoves), you take i steps in the chosen direction.
 * Given the integer target, return the minimum number of moves required (i.e., the minimum numMoves) to reach the destination.
 *
 * Example 1:
 * Input: target = 2
 * Output: 3
 * Explanation:
 * On the 1st move, we step from 0 to 1 (1 step).
 * On the 2nd move, we step from 1 to -1 (2 steps).
 * On the 3rd move, we step from -1 to 2 (3 steps).
 *
 * Example 2:
 * Input: target = 3
 * Output: 2
 * Explanation:
 * On the 1st move, we step from 0 to 1 (1 step).
 * On the 2nd move, we step from 1 to 3 (2 steps).
 *
 * @see <a href="https://leetcode.cn/problems/reach-a-number/" />
 * @author Poet
 * @date 2022/11/4
 */
public class LC_754_ReachANumber {

    /* --- 这道题来自周赛：Weekly Contest 65 --- */

    /**
     * 方法一：分析 + 数学
     */
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0) {
            k++;
            target -= k;
        }
        return target % 2 == 0 ? k : k + 1 + k % 2;
    }

}
