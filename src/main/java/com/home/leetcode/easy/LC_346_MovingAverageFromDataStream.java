package com.home.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 346. Moving Average from Data Stream
 *
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 * Implement the MovingAverage class:
 *
 * MovingAverage(int size) Initializes the object with the size of the window size.
 * double next(int val) Returns the moving average of the last size values of the stream.
 *
 * Example 1:
 *
 * Input
 * ["MovingAverage", "next", "next", "next", "next"]
 * [[3], [1], [10], [3], [5]]
 * Output
 * [null, 1.0, 5.5, 4.66667, 6.0]
 * Explanation
 * MovingAverage movingAverage = new MovingAverage(3);
 * movingAverage.next(1); // return 1.0 = 1 / 1
 * movingAverage.next(10); // return 5.5 = (1 + 10) / 2
 * movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
 * movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
 * 
 * @see <a href="https://leetcode.cn/problems/moving-average-from-data-stream/" />
 * @author Poet
 * @date 2023/3/26
 */
public class LC_346_MovingAverageFromDataStream {

    class MovingAverage {
        Queue<Integer> queue;
        int size;
        double sum;

        public MovingAverage(int size) {
            queue = new ArrayDeque<>(size);
            this.size = size;
            this.sum = 0;
        }

        public double next(int val) {
            if (queue.size() == size) {
                sum -= queue.poll();
            }
            sum += val;
            queue.offer(val);
            return sum / queue.size();
        }
    }

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
}
