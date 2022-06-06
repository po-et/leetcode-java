package com.home.leetcode.hard;

import java.util.Map;
import java.util.TreeMap;

/**
 * 732. My Calendar III
 *
 * A k-booking happens when k events have some non-empty intersection (i.e., there is some time that is common to all k events.)
 *
 * You are given some events [start, end), after each given event, return an integer k representing the maximum k-booking between all the previous events.
 *
 * @see <a href="https://leetcode.cn/problems/my-calendar-iii/" />
 * @author poet
 * @date 2022/6/6
 */
public class LC_732_MyCalendar_III {

    /**
     * Your MyCalendarThree object will be instantiated and called as such:
     * MyCalendarThree obj = new MyCalendarThree();
     * int param_1 = obj.book(start,end);
     */

    /**
     * 方法一：差分数组（官方题解）
     */
    class MyCalendarThree {

        private TreeMap<Integer, Integer> cnt;

        public MyCalendarThree() {
            cnt = new TreeMap<>();
        }

        public int book(int start, int end) {
            int ans = 0;
            int maxBook = 0;
            cnt.put(start, cnt.getOrDefault(start, 0) + 1);
            cnt.put(end, cnt.getOrDefault(end, 0) - 1);
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                int freq = entry.getValue();
                maxBook += freq;
                ans = Math.max(maxBook, ans);
            }
            return ans;
        }
    }

}
