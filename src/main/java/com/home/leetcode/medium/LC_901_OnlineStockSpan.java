package com.home.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 901. Online Stock Span (股票价格跨度)
 *
 * Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.
 *
 * The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backward)
 * for which the stock price was less than or equal to today's price.
 *
 * For example, if the price of a stock over the next 7 days were [100,80,60,70,60,75,85], then the stock spans would be [1,1,1,2,1,4,6].
 * Implement the StockSpanner class:
 *
 * StockSpanner() Initializes the object of the class.
 * int next(int price) Returns the span of the stock's price given that today's price is price.
 *
 * Example 1:
 *
 * Input
 * ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
 * [[], [100], [80], [60], [70], [60], [75], [85]]
 * Output
 * [null, 1, 1, 1, 2, 1, 4, 6]
 *
 * Explanation
 * StockSpanner stockSpanner = new StockSpanner();
 * stockSpanner.next(100); // return 1
 * stockSpanner.next(80);  // return 1
 * stockSpanner.next(60);  // return 1
 * stockSpanner.next(70);  // return 2
 * stockSpanner.next(60);  // return 1
 * stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
 * stockSpanner.next(85);  // return 6
 *
 * @see <a href="https://leetcode.cn/problems/online-stock-span/" />
 * @author Poet
 * @date 2022/10/21
 */
public class LC_901_OnlineStockSpan {

    /* --- 这道题来自：第 101 场周赛 --- */

    // 暴力解法
    // 自己完成 ac
    class StockSpanner {
        List<Integer> data;
        int size;
        public StockSpanner() {
            data = new ArrayList<>();
            size = 0;
        }

        public int next(int price) {
            data.add(price);
            size++;
            int res = 0;
            for (int i = size - 1; i >= 0; i--) {
                if (data.get(i) <= price) {
                    res++;
                } else {
                    break;
                }
            }
            return res;
        }
    }


    /**
     * 方法一：单调栈
     */
    class StockSpanner_1 {
        Deque<int[]> stack;
        int idx;

        public StockSpanner_1() {
            stack = new ArrayDeque<>();
            stack.push(new int[]{-1, Integer.MAX_VALUE});
            idx = -1;
        }

        public int next(int price) {
            idx++;
            while (price >= stack.peek()[1]) {
                stack.pop();
            }
            int res = idx - stack.peek()[0];
            stack.push(new int[]{idx, price});
            return res;
        }
    }

    /**
     * Your StockSpanner object will be instantiated and called as such:
     * StockSpanner obj = new StockSpanner();
     * int param_1 = obj.next(price);
     */
}
