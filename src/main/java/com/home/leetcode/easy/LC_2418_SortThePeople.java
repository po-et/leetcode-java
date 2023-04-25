package com.home.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2418. Sort the People
 *
 * You are given an array of strings names, and an array heights that consists of distinct positive integers. Both arrays are of length n.
 *
 * For each index i, names[i] and heights[i] denote the name and height of the ith person.
 *
 * Return names sorted in descending order by the people's heights.
 *
 * Example 1:
 * Input: names = ["Mary","John","Emma"], heights = [180,165,170]
 * Output: ["Mary","Emma","John"]
 * Explanation: Mary is the tallest, followed by Emma and John.
 *
 * Example 2:
 * Input: names = ["Alice","Bob","Bob"], heights = [155,185,150]
 * Output: ["Bob","Alice","Bob"]
 * Explanation: The first Bob is the tallest, followed by Alice and the second Bob.
 *
 * @see <a href="https://leetcode.cn/problems/sort-the-people/" />
 * @author Poet
 * @date 2023/4/25
 */
public class LC_2418_SortThePeople {

    /**
     * 方法一：排序
     *
     * 创建一个索引数组 indices
     */
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> heights[b] - heights[a]);

        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = names[indices[i]];
        }
        return res;
    }


    public String[] sortPeople_1(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        int n = names.length;
        for (int i = 0; i < n; i++) {
            map.put(heights[i], names[i]);
        }

//        Arrays.sort(heights, (a, b) -> Integer.compare(b[0], a[0]));

        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = map.get(heights[i]);
        }
        return res;
    }
}
