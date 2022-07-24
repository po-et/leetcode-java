package com.home.leetcode.easy;

/**
 * 1184. Distance Between Bus Stops (公交站间的距离)
 * 
 * A bus has n stops numbered from 0 to n - 1 that form a circle. We know the distance between all pairs of neighboring stops where distance[i] is the distance between the stops number i and (i + 1) % n.
 *
 * The bus goes along both directions i.e. clockwise and counterclockwise.
 *
 * Return the shortest distance between the given start and destination stops.
 *
 *
 * Example 1:
 * Input: distance = [1,2,3,4], start = 0, destination = 1
 * Output: 1
 * Explanation: Distance between 0 and 1 is 1 or 9, minimum is 1.
 *
 * Example 2:
 * Input: distance = [1,2,3,4], start = 0, destination = 2
 * Output: 3
 * Explanation: Distance between 0 and 2 is 3 or 7, minimum is 3.
 *
 * Example 3:
 * Input: distance = [1,2,3,4], start = 0, destination = 3
 * Output: 4
 * Explanation: Distance between 0 and 3 is 6 or 4, minimum is 4.
 *
 * @see <a href="https://leetcode.cn/problems/distance-between-bus-stops/" />
 * @author Poet
 * @date 2022/7/24
 */
public class LC_1184_DistanceBetweenBusStops {

    /**
     * 方法一：一次遍历
     */
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = 0;
        for(int i = 0; i < distance.length; i++){
            sum += distance[i];
        }

        if (start > destination) {
            int tmp = start;
            start = destination;
            destination = tmp;
        }

        int res = 0;
        for (int i = start; i < destination; i++) {
            res += distance[i];
        }

        return Math.min(res, sum - res);
    }


    /**
     * 方法一：一次遍历 (同上，不同的写法）
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/distance-between-bus-stops/solution/gong-jiao-zhan-jian-de-ju-chi-by-leetcod-o737/
     */
    public int distanceBetweenBusStops_2(int[] distance, int start, int destination) {
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < distance.length; i++) {
            if (i >= start && i < destination) {
                sum1 += distance[i];
            } else {
                sum2 += distance[i];
            }
        }
        return Math.min(sum1, sum2);
    }

}
