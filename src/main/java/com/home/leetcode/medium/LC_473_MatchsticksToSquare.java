package com.home.leetcode.medium;

import java.util.Arrays;

/**
 * 473. Matchsticks to Square
 * 
 * You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick.
 * You want to use all the matchsticks to make one square. You should not break any stick, but you can link them up,
 * and each matchstick must be used exactly one time.
 *
 *
 * Example 1:
 *
 * Input: matchsticks = [1,1,2,2,2]
 * Output: true
 * Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
 *
 * @see <a href="https://leetcode.cn/problems/matchsticks-to-square/" />
 * @author poet
 * @date 2022/6/1
 */
public class LC_473_MatchsticksToSquare {

    /**
     * 方法一：回溯法
     *
     * time: O(4^n) 其中 n 是火柴的数目，每根火柴都可以选择放在 4 条边上
     * space: O(n) 递归栈需要占用 O(n)O 的空间
     */
    public boolean makesquare(int[] matchsticks) {
        int totalLen = Arrays.stream(matchsticks).sum();
        if (totalLen % 4 != 0) {
            return false;
        }

        // 为了减少搜索量，需要对火柴长度从大到小进行排序。
        Arrays.sort(matchsticks);
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }

        // 用 edges 来记录 4 条边已经放入的火柴总长度
        int[] edges = new int[4];
        return dfs(0, matchsticks, edges, totalLen / 4);
    }

    public boolean dfs(int index, int[] matchsticks, int[] edges, int len) {
        if (index == matchsticks.length) {
            return true;
        }

        for (int i = 0; i < edges.length; i++) {
            edges[i] += matchsticks[index];
            if (edges[i] <= len && dfs(index + 1, matchsticks, edges, len)) {
                return true;
            }
            edges[i] -= matchsticks[index];
        }
        return false;
    }

}
