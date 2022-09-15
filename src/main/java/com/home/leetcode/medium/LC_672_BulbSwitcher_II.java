package com.home.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 672. Bulb Switcher II (灯泡开关 Ⅱ)
 *
 * There is a room with n bulbs labeled from 1 to n that all are turned on initially, and four buttons on the wall.
 * Each of the four buttons has a different functionality where:
 *      Button 1: Flips the status of all the bulbs.
 *      Button 2: Flips the status of all the bulbs with even labels (i.e., 2, 4, ...).
 *      Button 3: Flips the status of all the bulbs with odd labels (i.e., 1, 3, ...).
 *      Button 4: Flips the status of all the bulbs with a label j = 3k + 1 where k = 0, 1, 2, ... (i.e., 1, 4, 7, 10, ...).
 * You must make exactly presses button presses in total. For each press, you may pick any of the four buttons to press.
 *
 * Given the two integers n and presses, return the number of different possible statuses after performing all presses button presses.
 *
 * Example 1:
 * Input: n = 1, presses = 1
 * Output: 2
 * Explanation: Status can be:
 * - [off] by pressing button 1
 * - [on] by pressing button 2
 *
 * Example 2:
 * Input: n = 2, presses = 1
 * Output: 3
 * Explanation: Status can be:
 * - [off, off] by pressing button 1
 * - [on, off] by pressing button 2
 * - [off, on] by pressing button 3
 *
 * Example 3:
 * Input: n = 3, presses = 1
 * Output: 4
 * Explanation: Status can be:
 * - [off, off, off] by pressing button 1
 * - [off, on, off] by pressing button 2
 * - [on, off, on] by pressing button 3
 * - [off, on, on] by pressing button 4
 *
 * @see <a href="https://leetcode.cn/problems/bulb-switcher-ii/" />
 * @author Poet
 * @date 2022/9/15
 */
public class LC_672_BulbSwitcher_II {

    // -- 没懂，直接参考官方答案

    public int flipLights(int n, int presses) {
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < 1 << 4; i++) {
            int[] pressArr = new int[4];
            for (int j = 0; j < 4; j++) {
                pressArr[j] = (i >> j) & 1;
            }
            int sum = Arrays.stream(pressArr).sum();
            if (sum % 2 == presses % 2 && sum <= presses) {
                int status = pressArr[0] ^ pressArr[1] ^ pressArr[3];
                if (n >= 2) {
                    status |= (pressArr[0] ^ pressArr[1]) << 1;
                }
                if (n >= 3) {
                    status |= (pressArr[0] ^ pressArr[2]) << 2;
                }
                if (n >= 4) {
                    status |= (pressArr[0] ^ pressArr[1] ^ pressArr[3]) << 3;
                }
                seen.add(status);
            }
        }
        return seen.size();
    }

}
