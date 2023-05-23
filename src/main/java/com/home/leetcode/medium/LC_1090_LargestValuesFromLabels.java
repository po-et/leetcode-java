package com.home.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1090. Largest Values From Labels (受标签影响的最大值)
 *
 * There is a set of n items. You are given two integer arrays values and labels where the value and the label of the ith element are values[i] and labels[i] respectively. You are also given two integers numWanted and useLimit.
 *
 * Choose a subset s of the n elements such that:
 *
 * The size of the subset s is less than or equal to numWanted.
 * There are at most useLimit items with the same label in s.
 * The score of a subset is the sum of the values in the subset.
 *
 * Return the maximum score of a subset s.
 *
 * Example 1:
 * Input: values = [5,4,3,2,1], labels = [1,1,2,2,3], numWanted = 3, useLimit = 1
 * Output: 9
 * Explanation: The subset chosen is the first, third, and fifth items.
 *
 * Example 2:
 * Input: values = [5,4,3,2,1], labels = [1,3,3,3,2], numWanted = 3, useLimit = 2
 * Output: 12
 * Explanation: The subset chosen is the first, second, and third items.
 *
 * Example 3:
 * Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], numWanted = 3, useLimit = 1
 * Output: 16
 * Explanation: The subset chosen is the first and fourth items.
 *
 * @see <a href="https://leetcode.cn/problems/largest-values-from-labels/" />
 * @author Poet
 * @date 2023/5/23
 */
public class LC_1090_LargestValuesFromLabels {

    /**
     * 方法一：排序 + 哈希表
     *
     * time:  O(NlogN)
     * space: O(N)
     */
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        // 定义下标数组
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        // 按照values降序排列
        Arrays.sort(ids, (a, b) -> values[b] - values[a]);

        int res = 0;
        int choose = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n && choose < numWanted; i++) {
            int label = labels[ids[i]];
            if (cnt.getOrDefault(label, 0) == useLimit) {
                continue;
            }

            choose++;
            res += values[ids[i]];
            cnt.put(label, cnt.getOrDefault(label, 0) + 1);
        }

        return res;
    }
}
