package com.home.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 1640. Check Array Formation Through Concatenation (能否连接形成数组)
 *
 * You are given an array of distinct integers arr and an array of integer arrays pieces, where the integers in pieces are distinct. Your goal is to form arr by concatenating the arrays in pieces in any order. However, you are not allowed to reorder the integers in each array pieces[i].
 *
 * Return true if it is possible to form the array arr from pieces. Otherwise, return false.
 *
 * Example 1:
 * Input: arr = [15,88], pieces = [[88],[15]]
 * Output: true
 * Explanation: Concatenate [15] then [88]
 *
 * Example 2:
 * Input: arr = [49,18,16], pieces = [[16,18,49]]
 * Output: false
 * Explanation: Even though the numbers match, we cannot reorder pieces[0].
 *
 * Example 3:
 * Input: arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
 * Output: true
 * Explanation: Concatenate [91] then [4,64] then [78]
 *
 * @see <a href="https://leetcode.cn/problems/check-array-formation-through-concatenation/" />
 * @author Poet
 * @date 2022/9/22
 */
public class LC_1640_CheckArrayFormationThroughConcatenation {

    /**
     * 方法一：哈希表
     *
     * time:  O(n)
     * space: O(n)
     */
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int n = arr.length;
        int m = pieces.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(pieces[i][0], i);
        }

        for (int i = 0; i < n; ) {
            if (!map.containsKey(arr[i])) {
                return false;
            }
            int index = map.get(arr[i]);
            int len = pieces[index].length;
            for (int k = 0; k < len; k++) {
                if (arr[i + k] != pieces[index][k]) {
                    return false;
                }
            }
            i = i + len;
        }

        return true;
    }
}
