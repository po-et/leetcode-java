package com.home.leetcode.medium;

/**
 * 1010. Pairs of Songs With Total Durations Divisible by 60 (总持续时间可被 60 整除的歌曲)
 *
 * You are given a list of songs where the ith song has a duration of time[i] seconds.
 *
 * Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
 *
 * Example 1:
 * Input: time = [30,20,150,100,40]
 * Output: 3
 * Explanation: Three pairs have a total duration divisible by 60:
 * (time[0] = 30, time[2] = 150): total duration 180
 * (time[1] = 20, time[3] = 100): total duration 120
 * (time[1] = 20, time[4] = 40): total duration 60
 *
 * Example 2:
 * Input: time = [60,60,60]
 * Output: 3
 * Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 *
 * @see <a href="https://leetcode.cn/problems/pairs-of-songs-with-total-durations-divisible-by-60/" />
 * @author Poet
 * @date 2023/5/7
 */
public class LC_1010_PairsOfSongsWithTotalDurationsDivisibleBy60 {

    /**
     * 方法一：组合数学
     *
     * 本质是组合问题，可分4种情况讨论
     */
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        for (int t : time) {
            count[t % 60]++;
        }

        long res = 0;
        // 1、(0，30)
        for (int i = 1; i < 30; i++) {
            res += count[i] * count[60 - i];
        }
        // 2、i = 0
        res += (long) count[0] * (count[0] - 1) / 2;
        // 3、i = 30
        res += (long) count[30] * (count[30] - 1) / 2;

        return (int) res;
    }



    /**
     * not ac (超出时间限制)
     */
    public int numPairsDivisibleBy60_timeout(int[] time) {
        int res = 0;
        int n = time.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = time[i] + time[j];
                if (sum % 60 == 0) {
                    res++;
                }
            }
        }
        return res;
    }
}
