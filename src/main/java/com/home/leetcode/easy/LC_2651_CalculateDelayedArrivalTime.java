package com.home.leetcode.easy;

/**
 * 2651. Calculate Delayed Arrival Time (计算列车到站时间)
 *
 * You are given a positive integer arrivalTime denoting the arrival time of a train in hours, and another positive integer delayedTime denoting the amount of delay in hours.
 *
 * Return the time when the train will arrive at the station.
 *
 * Note that the time in this problem is in 24-hours format.
 *
 * Example 1:
 * Input: arrivalTime = 15, delayedTime = 5
 * Output: 20
 * Explanation: Arrival time of the train was 15:00 hours. It is delayed by 5 hours. Now it will reach at 15+5 = 20 (20:00 hours).
 *
 * Example 2:
 * Input: arrivalTime = 13, delayedTime = 11
 * Output: 0
 * Explanation: Arrival time of the train was 13:00 hours. It is delayed by 11 hours. Now it will reach at 13+11=24 (Which is denoted by 00:00 in 24 hours format so return 0).
 *
 * @see <a href="https://leetcode.cn/problems/calculate-delayed-arrival-time/description/?envType=daily-question&envId=2023-09-08" />
 * @author Poet
 * @date 2023/9/8
 */
public class LC_2651_CalculateDelayedArrivalTime {

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }

}
