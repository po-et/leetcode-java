package com.home.leetcode.medium;

/**
 * 875. Koko Eating Bananas
 *
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 *
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 *
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 *
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 *
 * Example 1:
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 *
 * Example 2:
 * Input: piles = [30,11,23,4,20], h = 5
 * Output: 30
 *
 * Example 3:
 * Input: piles = [30,11,23,4,20], h = 6
 * Output: 23
 *`
 * @see <a href="https://leetcode.cn/problems/koko-eating-bananas" />
 * @author Poet
 * @date 2022/6/7
 */
public class LC_875_KokoEatingBananas {

    /**
     * 方法一：二分查找（官方题解）
     *
     * @see <a href="https://leetcode.cn/problems/koko-eating-bananas/solution/ai-chi-xiang-jiao-de-ke-ke-by-leetcode-s-z4rt/" />
     *
     * time:  O(nlogm) 其中 n 是数组 piles 的长度，m 是数组 piles 中的最大值。
     * space: O(1)
     */
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int k = high;
        while (low < high) {
            int speed = (high - low) / 2 + low;
            long time = getTime(piles, speed);
            if (time <= h) {
                k = speed;  // 记录当前解
                high = speed;
            } else {
                low = speed + 1;
            }
        }
        // 二分查找结束之后，即可得到在 h 小时内吃掉所有香蕉的最小速度 k
        return k;
    }

    public long getTime(int[] piles, int speed) {
        long time = 0;
        for (int pile : piles) {
            int curTime = (pile + speed - 1) / speed;
            time += curTime;
        }
        return time;
    }
}
