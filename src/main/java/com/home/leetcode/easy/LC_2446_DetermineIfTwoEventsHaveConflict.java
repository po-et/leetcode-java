package com.home.leetcode.easy;

/**
 * 2446. Determine if Two Events Have Conflict (判断两个事件是否存在冲突)
 *
 * You are given two arrays of strings that represent two inclusive events that happened on the same day, event1 and event2, where:
 *
 * event1 = [startTime1, endTime1] and
 * event2 = [startTime2, endTime2].
 * Event times are valid 24 hours format in the form of HH:MM.
 *
 * A conflict happens when two events have some non-empty intersection (i.e., some moment is common to both events).
 *
 * Return true if there is a conflict between two events. Otherwise, return false.
 *
 * Example 1:
 * Input: event1 = ["01:15","02:00"], event2 = ["02:00","03:00"]
 * Output: true
 * Explanation: The two events intersect at time 2:00.
 *
 * Example 2:
 * Input: event1 = ["01:00","02:00"], event2 = ["01:20","03:00"]
 * Output: true
 * Explanation: The two events intersect starting from 01:20 to 02:00.
 *
 * Example 3:
 * Input: event1 = ["10:00","11:00"], event2 = ["14:00","15:00"]
 * Output: false
 * Explanation: The two events do not intersect.
 *
 * @see <a href="https://leetcode.cn/problems/determine-if-two-events-have-conflict/" />
 * @author Poet
 * @date 2023/5/17
 */
public class LC_2446_DetermineIfTwoEventsHaveConflict {

    /**
     * 方法一：直接比较字符串
     */
    public boolean haveConflict(String[] event1, String[] event2) {
        return !(event1[1].compareTo(event2[0]) < 0 || event2[1].compareTo(event1[0]) < 0);
    }


    public boolean haveConflict_2(String[] event1, String[] event2) {
        int[] time1 = new int[2];
        for (int i = 0; i < event1.length; i++) {
            String[] split = event1[i].split(":");
            time1[i] = Integer.valueOf(split[0]) * 24 + Integer.valueOf(split[1]);
        }

        int[] time2 = new int[2];
        for (int i = 0; i < event2.length; i++) {
            String[] split = event2[i].split(":");
            time2[i] = Integer.valueOf(split[0]) * 24 + Integer.valueOf(split[1]);
        }

        return !(time1[1] < time2[0] || time2[1] < time1[0]);
    }
}
