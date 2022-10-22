package com.home.leetcode.hard;

import java.util.Arrays;

/**
 * 1235. Maximum Profit in Job Scheduling (规划兼职工作)
 *
 * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].
 *
 * You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.
 *
 * If you choose a job that ends at time X you will be able to start another job that starts at time X.
 *
 *
 * Example 1:
 *
 * Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 * Output: 120
 * Explanation: The subset chosen is the first and fourth job.
 * Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
 *
 * Example 2:
 * Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
 * Output: 150
 * Explanation: The subset chosen is the first, fourth and fifth job.
 * Profit obtained 150 = 20 + 70 + 60.
 *
 * Example 3:
 * Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
 * Output: 6
 *
 * @see <a href="https://leetcode.cn/problems/maximum-profit-in-job-scheduling/" />
 * @author Poet
 * @date 2022/10/22
 */
public class LC_1235_MaximumProfitInJobScheduling {

    /**
     * 方法一：动态规划 + 二分查找
     *
     * 首先将兼职工作按结束时间 endTime 从小到大进行排序。
     *
     * 状态定义：
     *      dp[i] 表示前 i 份兼职工作可以获得的最大报酬
     *
     * 初始值：
     *      初始时 dp[0]=0
     *
     * 状态转移方程：
     *      dp[i]=max(dp[i−1],dp[k]+profit[i−1])   其中k表示满足结束时间小于等于第 i−1 份工作开始时间的兼职工作数量，可以通过二分查找获得
     *
     * solution：https://leetcode.cn/problems/maximum-profit-in-job-scheduling/solution/gui-hua-jian-zhi-gong-zuo-by-leetcode-so-gu0e/
     *
     * time:  O(nlogn)
     * space: O(n)
     */
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        // 按结束时间 endTime 从小到大进行排序
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);

        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int k = binarySearch(jobs, i - 1, jobs[i - 1][0]);
            dp[i] = Math.max(dp[i - 1], dp[k] + jobs[i - 1][2]);
        }

        return dp[n];
    }

    private int binarySearch(int[][] jobs, int right, int target) {
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][1] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
