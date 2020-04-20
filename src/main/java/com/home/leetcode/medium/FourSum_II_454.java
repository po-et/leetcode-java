package com.home.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 *
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 *
 * @see <a href = "https://leetcode.com/problems/4sum-ii/" />
 * @author Poet
 * @date 2020/4/20
 */
public class FourSum_II_454 {

    /**
     * time: O(n^2)
     * space: O(n^2)
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer, Integer> record = new HashMap<>();
        int ret = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int key = A[i] + B[j];
                record.put(key, record.getOrDefault(key, 0) + 1);
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int key = -(C[i] + D[j]);
                if (record.containsKey(key)) {
                    ret += record.get(key);
                }
            }
        }

        return ret;
    }
}
