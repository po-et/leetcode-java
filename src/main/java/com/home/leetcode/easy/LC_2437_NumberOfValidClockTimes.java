package com.home.leetcode.easy;

/**
 * 2437. Number of Valid Clock Times
 *
 * You are given a string of length 5 called time, representing the current time on a digital clock in the format "hh:mm". The earliest possible time is "00:00" and the latest possible time is "23:59".
 *
 * In the string time, the digits represented by the ? symbol are unknown, and must be replaced with a digit from 0 to 9.
 *
 * Return an integer answer, the number of valid clock times that can be created by replacing every ? with a digit from 0 to 9.
 *
 * Example 1:
 * Input: time = "?5:00"
 * Output: 2
 * Explanation: We can replace the ? with either a 0 or 1, producing "05:00" or "15:00". Note that we cannot replace it with a 2, since the time "25:00" is invalid. In total, we have two choices.
 *
 * Example 2:
 * Input: time = "0?:0?"
 * Output: 100
 * Explanation: Each ? can be replaced by any digit from 0 to 9, so we have 100 total choices.
 *
 * Example 3:
 * Input: time = "??:??"
 * Output: 1440
 * Explanation: There are 24 possible choices for the hours, and 60 possible choices for the minutes. In total, we have 24 * 60 = 1440 choices.
 *
 * @see <a href="https://leetcode.cn/problems/number-of-valid-clock-times/" />
 * @author Poet
 * @date 2023/5/9
 */
public class LC_2437_NumberOfValidClockTimes {

    public int countTime(String time) {
        int ans = 1;
        char a = time.charAt(0), b = time.charAt(1), c = time.charAt(3), d = time.charAt(4);
        if (d == '?') ans *= 10;
        if (c == '?') ans *= 6;
        if (a == '?' && b == '?') {
            ans *= 24;
        } else if (b == '?') {
            if (a == '2') ans *= 4;
            else ans *= 10;
        } else if (a == '?') {
            if (b <= '9' && b >= '4') ans *= 2;
            else ans *= 3;
        }
        return ans;
    }
}
