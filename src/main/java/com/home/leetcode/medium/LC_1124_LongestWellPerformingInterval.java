package com.home.leetcode.medium;

/**
 * 1124. Longest Well-Performing Interval
 *
 * We are given hours, a list of the number of hours worked per day for a given employee.
 *
 * A day is considered to be a tiring day if and only if the number of hours worked is (strictly) greater than 8.
 *
 * A well-performing interval is an interval of days for which the number of tiring days is strictly larger than the number of non-tiring days.
 *
 * Return the length of the longest well-performing interval.
 *
 * Example 1:
 * Input: hours = [9,9,6,0,6,6,9]
 * Output: 3
 * Explanation: The longest well-performing interval is [9,9,6].
 *
 * Example 2:
 * Input: hours = [6,6,6]
 * Output: 0
 *
 * @see <a href="https://leetcode.cn/problems/longest-well-performing-interval/" />
 * @author Poet
 * @date 2023/2/14
 */
public class LC_1124_LongestWellPerformingInterval {

    // 参考答案

    /**
     * 方法二：哈希表
     */
    public int longestWPI(int[] hours) {
        int n = hours.length;
        Map<Integer, Integer> map = new HashMap<>();
        int s = 0, res = 0;
        for (int i = 0; i < n; i++) {
            s += hours[i] > 8 ? 1 : -1;
            if (s > 0) {
                res = Math.max(res, i + 1);
            } else {
                if (map.containsKey(s - 1)) {
                    res = Math.max(res, i - map.get(s - 1));
                }
            }
            if (!map.containsKey(s)) {
                map.put(s, i);
            }
        }
        return res;
    }
}
