package com.home.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 447. Number of Boomerangs
 *
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that
 * the distance between i and j equals the distance between i and k (the order of the tuple matters).
 *
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 *
 * @see <a href = "https://leetcode.cn/problems/number-of-boomerangs/" />
 * @author Poet
 * @date 2020/4/21
 */
public class LC_447_NumberOfBoomerangs {

    /**
     * time: O(n^2)
     * space: O(n)
     */
    public int numberOfBoomerangs(int[][] points) {
        if (Objects.isNull(points) || points.length == 0) {
            throw new IllegalArgumentException("points is not valid.");
        }

        int ret = 0;
        for (int i = 0; i < points.length; i++) {
            // 查找表：key 到枢纽点i的距离； value 距离出现的频率
            Map<Integer, Integer> record = new HashMap<>();

            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int dis = distance(points[i], points[j]);
                    record.put( dis, record.getOrDefault(dis, 0) + 1);
                }
            }

            for (Map.Entry<Integer, Integer> entry : record.entrySet()) {
                if (entry.getValue() >= 2) {   // 距离频率 >= 2
                    ret += entry.getValue() * (entry.getValue() - 1);
                }
            }
        }
        return ret;
    }

    private int distance(int[] l, int[] r) {
        // 防止出现浮点数，所以计算距离时不开根号
        // 【注意】数据范围！ 坑：出现整形溢出
        return (r[0] - l[0]) * (r[0] - l[0]) + (r[1] - l[1]) * (r[1] - l[1]);
    }
}
