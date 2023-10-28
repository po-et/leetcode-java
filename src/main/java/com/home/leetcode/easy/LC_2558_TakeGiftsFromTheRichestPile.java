package com.home.leetcode.easy;

import java.util.PriorityQueue;

/**
 * 2558. Take Gifts From the Richest Pile (从数量最多的堆取走礼物)
 *
 * You are given an integer array gifts denoting the number of gifts in various piles. Every second, you do the following:
 *  - Choose the pile with the maximum number of gifts.
 *  - If there is more than one pile with the maximum number of gifts, choose any.
 *  - Leave behind the floor of the square root of the number of gifts in the pile. Take the rest of the gifts.
 *
 * Return the number of gifts remaining after k seconds.
 *
 * Example 1:
 * Input: gifts = [25,64,9,4,100], k = 4
 * Output: 29
 * Explanation:
 * The gifts are taken in the following way:
 * - In the first second, the last pile is chosen and 10 gifts are left behind.
 * - Then the second pile is chosen and 8 gifts are left behind.
 * - After that the first pile is chosen and 5 gifts are left behind.
 * - Finally, the last pile is chosen again and 3 gifts are left behind.
 * The final remaining gifts are [5,8,9,4,3], so the total number of gifts remaining is 29.
 *
 * Example 2:
 * Input: gifts = [1,1,1,1], k = 4
 * Output: 4
 * Explanation:
 * In this case, regardless which pile you choose, you have to leave behind 1 gift in each pile.
 * That is, you can't take any pile with you.
 * So, the total gifts remaining are 4.
 *
 * @see <a href="https://leetcode.cn/problems/take-gifts-from-the-richest-pile/" />
 * @author Poet
 * @date 2023/10/28
 */
public class LC_2558_TakeGiftsFromTheRichestPile {

    /**
     * 方法一：直接遍历
     */
    public long pickGifts(int[] gifts, int k) {
        for (int i = 0; i < k; i++) {
            int max = Integer.MIN_VALUE;
            int index = -1;
            for (int j = 0; j < gifts.length; j++) {
                if (gifts[j] > max) {
                    max = gifts[j];
                    index = j;
                }
            }
            gifts[index] = (int) Math.sqrt(max);
        }

        long res = 0;
        for (int i = 0; i < gifts.length; i++) {
            res += gifts[i];
        }
        return res;
    }

    /**
     * 方法二：最大堆
     *
     * time:  O(klogn)
     * space: O(N)
     */
    public long pickGifts_Max_Heap(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int gift : gifts) {
            pq.offer(gift);
        }

        while (k > 0) {
            k--;
            int x = pq.poll();
            pq.offer((int) Math.sqrt(x));
        }

        long res = 0;
        while (!pq.isEmpty()) {
            res += pq.poll();
        }
        return res;
    }

}
