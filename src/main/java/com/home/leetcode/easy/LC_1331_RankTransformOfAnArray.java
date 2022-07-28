package com.home.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1331. Rank Transform of an Array (数组序号转换)
 *
 * Given an array of integers arr, replace each element with its rank.
 *
 * The rank represents how large the element is. The rank has the following rules:
 *
 * Rank is an integer starting from 1.
 * The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
 * Rank should be as small as possible.
 *
 * Example 1:
 * Input: arr = [40,10,20,30]
 * Output: [4,1,2,3]
 * Explanation: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.
 *
 * Example 2:
 * Input: arr = [100,100,100]
 * Output: [1,1,1]
 * Explanation: Same elements share the same rank.
 *
 * Example 3:
 * Input: arr = [37,12,28,9,100,56,80,5,12]
 * Output: [5,3,4,2,8,6,7,1,3]
 *
 * @see <a href="https://leetcode.cn/problems/rank-transform-of-an-array/" />
 * @author Poet
 * @date 2022/7/28
 */
public class LC_1331_RankTransformOfAnArray {

    /**
     * 方法一：排序 + 哈希表
     *
     * time:  O(n×logn)，其中 n 是输入数组 arr 的长度，排序消耗 O(n×logn) 时间。
     * space: O(n)。有序数组和哈希表各消耗 O(n) 空间。
     */
    public int[] arrayRankTransform(int[] arr) {
        // 临时数组
        int[] copyArr = Arrays.copyOf(arr, arr.length);
        // 排序
        Arrays.sort(copyArr);

        Map<Integer, Integer> ranks = new HashMap<>();
        int index = 1;
        for (int num : copyArr) {
            if (!ranks.containsKey(num)) {
                ranks.put(num, index);
                index++;
            }
        }

        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = ranks.get(arr[i]);
        }
        return res;
    }

}
