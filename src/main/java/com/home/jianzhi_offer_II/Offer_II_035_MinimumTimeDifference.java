package com.home.jianzhi_offer_II;

import java.util.Collections;
import java.util.List;

/**
 * 剑指 Offer II 035. 最小时间差
 *
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 *
 * 示例 1：
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 *
 * 示例 2：
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
 *
 * 注意：本题与主站 539 题相同： https://leetcode-cn.com/problems/minimum-time-difference/
 *
 * @see <a href="https://leetcode.cn/problems/569nqc/" />
 * @author Poet
 * @date 2023/3/23
 */
public class Offer_II_035_MinimumTimeDifference {

    /**
     * 方法一：排序
     *
     * time:  O(nlogn)
     * space: O(n) 或 O(logn) 为排序需要的空间，取决于具体语言的实现
     */
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < timePoints.size(); i++) {
            int pre = transfer(timePoints.get(i - 1));
            int cur = transfer(timePoints.get(i));
            res = Math.min(res, minDiff(pre, cur));
        }

        // 首尾时间的时间差
        res = Math.min(res, transfer(timePoints.get(0)) + 1440 - transfer(timePoints.get(timePoints.size() - 1)));
        return res;
    }

    private int minDiff(int pre, int cur) {
        return Math.min(Math.abs(pre - cur), 1440 - Math.abs(pre - cur));
    }

    private Integer transfer(String timePoint) {
        String[] arr = timePoint.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }

}
