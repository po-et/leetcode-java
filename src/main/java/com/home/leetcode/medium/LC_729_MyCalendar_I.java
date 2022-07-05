package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 729. My Calendar I
 *
 * You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a double booking.
 *
 * A double booking happens when two events have some non-empty intersection (i.e., some moment is common to both events.).
 *
 * The event can be represented as a pair of integers start and end that represents a booking on the half-open interval [start, end), the range of real numbers x such that start <= x < end.
 *
 * Implement the MyCalendar class:
 *
 * MyCalendar() Initializes the calendar object.
 * boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.
 *
 *
 * Example 1:
 * Input
 *      ["MyCalendar", "book", "book", "book"]
 *      [[], [10, 20], [15, 25], [20, 30]]
 * Output
 *      [null, true, false, true]
 *
 * @see <a href="https://leetcode.cn/problems/my-calendar-i/" />
 * @author Poet
 * @date 2022/7/5
 */
public class LC_729_MyCalendar_I {

    /**
     * 方法一：直接遍历
     *
     * time:  O(n^2)
     * space: O(n)
     */
    class MyCalendar {
        List<int[]> booked;

        public MyCalendar() {
            booked = new ArrayList<int[]>();
        }

        public boolean book(int start, int end) {
            for (int[] arr : booked) {
                int l = arr[0], r = arr[1];
                if (l < end && start < r) {
                    return false;
                }
            }
            booked.add(new int[]{start, end});
            return true;
        }
    }
}
