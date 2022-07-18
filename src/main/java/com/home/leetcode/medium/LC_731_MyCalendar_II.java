package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 731. My Calendar II
 *
 * You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a triple booking.
 *
 * A triple booking happens when three events have some non-empty intersection (i.e., some moment is common to all the three events.).
 *
 * The event can be represented as a pair of integers start and end that represents a booking on the half-open interval [start, end), the range of real numbers x such that start <= x < end.
 *
 * Implement the MyCalendarTwo class:
 *  MyCalendarTwo() Initializes the calendar object.
 *  boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without causing a triple booking. Otherwise, return false and do not add the event to the calendar.
 *
 * Example 1:
 * Input
 *      ["MyCalendarTwo", "book", "book", "book", "book", "book", "book"]
 *      [[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
 *  Output
 *      [null, true, true, true, false, true, true]
 * Explanation
 *      MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
 *      myCalendarTwo.book(10, 20); // return True, The event can be booked.
 *      myCalendarTwo.book(50, 60); // return True, The event can be booked.
 *      myCalendarTwo.book(10, 40); // return True, The event can be double booked.
 *      myCalendarTwo.book(5, 15);  // return False, The event cannot be booked, because it would result in a triple booking.
 *      myCalendarTwo.book(5, 10); // return True, The event can be booked, as it does not use time 10 which is already double booked.
 *      myCalendarTwo.book(25, 55); // return True, The event can be booked, as the time in [25, 40) will be double booked with the third event, the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
 *
 * @see <a href="https://leetcode.cn/problems/my-calendar-ii" />
 * @author Poet
 * @date 2022/7/19
 */
public class LC_731_MyCalendar_II {

    /**
     * 方法一：直接遍历
     *
     * 记录下所有已经预定的课程安排区间与已经预定过两次的课程安排区间，当我们预定新的区间 [start,end) 时，
     * 此时检查当前已经预定过两次的每个日程安排是否与新日程安排冲突。若不冲突，则可以添加新的日程安排。
     *
     * time:  O(n^2) 其中 n 表示日程安排的数量。由于每次在进行预定时，都需要遍历所有已经预定的行程安排。
     * space: O(n)   其中 n 表示日程安排的数量。需要保存所有已经预定的行程。
     */
    class MyCalendarTwo {
        List<int[]> booked;
        List<int[]> overlaps;

        public MyCalendarTwo() {
            booked = new ArrayList<>();
            overlaps = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (int[] arr : overlaps) {
                int l = arr[0], r = arr[1];
                if (l < end && start < r) {
                    return false;
                }
            }
            for (int[] arr : booked) {
                int l = arr[0], r = arr[1];
                if (l < end && start < r) {
                    overlaps.add(new int[]{Math.max(l, start), Math.min(r, end)});
                }
            }
            booked.add(new int[]{start, end});
            return true;
        }
    }


    /**
     * 方法二：线段树
     */

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
}
