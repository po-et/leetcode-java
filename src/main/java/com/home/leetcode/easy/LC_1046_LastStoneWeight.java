package com.home.leetcode.easy;

import java.util.PriorityQueue;

/**
 * 1046. Last Stone Weight (最后一块石头的重量)
 *
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 *
 * We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
 *      - If x == y, both stones are destroyed, and
 *      - If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 * At the end of the game, there is at most one stone left.
 *
 * Return the weight of the last remaining stone. If there are no stones left, return 0.
 *
 * Example 1:
 * Input: stones = [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.
 *
 * Example 2:
 * Input: stones = [1]
 * Output: 1
 *
 * @see <a href="https://leetcode.cn/problems/last-stone-weight/" />
 * @author Poet
 * @date 2022/7/31
 */
public class LC_1046_LastStoneWeight {

    /**
     * 方法一：最大堆
     *
     * time:  O(nlogn)，其中 n 是石头数量。每次从队列中取出元素需要花费 O(logn) 的时间，最多共需要粉碎 n - 1 次石头
     * space: O(n)
     */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            Integer num1 = pq.poll();
            Integer num2 = pq.poll();
            int res = Math.abs(num1 - num2);
            if (res > 0) {
                pq.offer(res);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}
