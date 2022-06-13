package com.home.leetcode.easy;

import java.util.Arrays;

/**
 * 1051. Height Checker
 *
 * A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height. Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.
 *
 * You are given an integer array heights representing the current order that the students are standing in. Each heights[i] is the height of the ith student in line (0-indexed).
 *
 * Return the number of indices where heights[i] != expected[i].
 *
 * Example 1:
 *  Input: heights = [1,1,4,2,1,3]
 *  Output: 3
 *  Explanation:
 *  heights:  [1,1,4,2,1,3]
 *  expected: [1,1,1,2,3,4]
 *  Indices 2, 4, and 5 do not match.
 *
 * Example 2:
 *  Input: heights = [5,1,2,3,4]
 *  Output: 5
 *  Explanation:
 *  heights:  [5,1,2,3,4]
 *  expected: [1,2,3,4,5]
 *  All indices do not match.
 *
 * @see <a href="https://leetcode.cn/problems/height-checker" />
 * @author Poet
 * @date 2022/6/13
 */
public class LC_1051_HeightChecker {

    /**
     * 方法一：基于比较的排序
     *
     * time:  O(nlogn)
     * space: O(n)
     */
    public int heightChecker(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        // 复制新的数组
        int[] expected = Arrays.copyOf(heights, heights.length);
        // 排序
        Arrays.sort(expected);

        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (expected[i] != heights[i]) {
                res++;
            }
        }
        return res;
    }

    /**
     * 方法二：计数排序
     *
     * time:  O(n+C) 其中 n 是数组 heights 的长度，C 是数组 heights 中的最大值。即为计数排序需要的时间。
     * space: O(C) 即为计数排序需要的空间。
     */
    public int heightChecker_counting_sort(int[] heights) {
        int maxHeight = Arrays.stream(heights).max().getAsInt();

        // 计数排序
        int[] cnt = new int[maxHeight + 1];
        for (int h : heights) {
            cnt[h]++;
        }

        // 节省空间，直接在计数排序的数组上进行遍历
        int idx = 0, res = 0;
        for (int i = 1; i <= maxHeight; i++) {
            for (int j = 1; j <= cnt[i]; j++) {
                if (heights[idx] != i) {
                    res++;
                }
                idx++;
            }
        }
        return res;
    }

}
