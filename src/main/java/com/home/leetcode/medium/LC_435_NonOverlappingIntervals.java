package com.home.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. Non-overlapping Intervals
 *
 * Given an array of intervals where intervals[i] = [starti, endi],
 * return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 *
 * Example 1:
 * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
 *
 * Example 2:
 * Input: intervals = [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
 *
 * 
 * @see <a href="https://leetcode.cn/problems/non-overlapping-intervals/" />
 * @author poet
 * @date 2022/6/4
 */
public class LC_435_NonOverlappingIntervals {

    /**
     * 暴力解法：找出所有子区间的组合，之后判断它不重叠
     *         -> 时间复杂度：O(2^n * n)
     *
     *
     * 动态规划：类似【最长上升子序列】 {@link LC_300_LongestIncreasingSubsequence}
     */


    /**
     * 方法一：动态规划（官方答案）
     *
     * time:  O(n^2)
     * space: O(n)
     * @see <a href="https://leetcode.cn/problems/non-overlapping-intervals/solution/wu-zhong-die-qu-jian-by-leetcode-solutio-cpsb/" />
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // 排序：从小到大
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                if (interval1[0] != interval2[0]) {
                    return interval1[0] - interval2[0];
                }
                return interval1[1] - interval2[1];
            }
        });

        // memo[i]表示使用intervals[0...i]的区间能构成的最长不重叠区间序列
        int n = intervals.length;
        int[] memo = new int[n];

        // 首先解决基础问题，可以直接为所有数组赋初值 1
        Arrays.fill(memo, 1);

        // 开始递推
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[j][1] <= intervals[i][0]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
        }

        // 即最长不重叠区间序列的个数
        int res = Arrays.stream(memo).max().getAsInt();
        return n - res;
    }


    /**
     * 方法二：贪心算法
     * 按照区间的结尾排序，每次选择结尾最早的，且和前一个区间不重叠的区间
     *
     * time:  O(nlogn)
     * space: O(logn)
     * @see <a href="https://leetcode.cn/problems/non-overlapping-intervals/solution/wu-zhong-die-qu-jian-by-leetcode-solutio-cpsb/" />
     */
    public int eraseOverlapIntervals_greedy(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // 按照区间的结尾排序：从小到大排序
        Arrays.sort(intervals, (interval1, interval2) -> {
            if (interval1[1] != interval2[1]) {
                return interval1[1] - interval2[1];
            }
            return interval1[0] - interval2[0];
        });

        int res = 1;
        int pre = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[pre][1] <= intervals[i][0]) {
                res++;
                pre = i;
            }
        }

        return intervals.length - res;
    }

}
