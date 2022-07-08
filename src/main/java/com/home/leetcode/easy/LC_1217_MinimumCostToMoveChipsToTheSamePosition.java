package com.home.leetcode.easy;

/**
 * 1217. Minimum Cost to Move Chips to The Same Position
 *
 * We have n chips, where the position of the ith chip is position[i].
 *
 * We need to move all the chips to the same position. In one step, we can change the position of the ith chip from position[i] to:
 *
 * position[i] + 2 or position[i] - 2 with cost = 0.
 * position[i] + 1 or position[i] - 1 with cost = 1.
 * Return the minimum cost needed to move all the chips to the same position.
 *
 * Example 1:
 * Input: position = [1,2,3]
 * Output: 1
 *
 * Example 2:
 * Input: position = [2,2,2,3,3]
 * Output: 2
 *
 * Example 3:
 * Input: position = [1,1000000000]
 * Output: 1
 *
 * @see <a href="https://leetcode.cn/problems/minimum-cost-to-move-chips-to-the-same-position/" />
 * @author Poet
 * @date 2022/7/8
 */
public class LC_1217_MinimumCostToMoveChipsToTheSamePosition {

    /**
     * 方法一：贪心
     *
     * 那么我们可以把初始每一个偶数位置的「筹码」看作一个整体，每一个奇数位置的「筹码」看作一个整体。因为我们的目标是最后将全部的「筹码」移动到同一个位置，那么最后的位置只有两种情况：
     * - 移动到某一个偶数位置，此时的开销最小值就是初始奇数位置「筹码」的数量。
     * - 移动到某一个奇数位置，此时的开销最小值就是初始偶数位置「筹码」的数量。
     *
     * time:  O(n)，其中 n 为数组 position 的长度，只对数组进行了一次遍历。
     * space: O(1)
     */
    public int minCostToMoveChips(int[] position) {
        int odd = 0, even = 0;
        for (int pos : position) {
            if ((pos & 1) == 0) {   // 偶数
                even++;
            } else { // 奇数
                odd++;
            }
        }
        return Math.min(odd, even);
    }
}
