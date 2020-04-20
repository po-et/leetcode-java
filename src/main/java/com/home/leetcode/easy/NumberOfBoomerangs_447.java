package com.home.leetcode.easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 *
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 *
 * @see <a href = "https://leetcode.com/problems/number-of-boomerangs/" />
 * @author Poet
 * @date 2020/4/21
 */
public class NumberOfBoomerangs_447 {

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
            Map<Integer, Integer> record = new HashMap<>();

            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int dis = distance(points[i], points[j]);
                    record.put( dis, record.getOrDefault(dis, 0) + 1);
                }
            }

            Iterator<Map.Entry<Integer, Integer>> iterator = record.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                if (entry.getValue() > 1) {
                    ret += entry.getValue() * (entry.getValue() - 1);
                }
            }
        }
        return ret;
    }

    private int distance(int[] l, int[] r) {
        return (r[0] - l[0]) * (r[0] - l[0]) + (r[1] - l[1]) * (r[1] - l[1]);
    }
}
