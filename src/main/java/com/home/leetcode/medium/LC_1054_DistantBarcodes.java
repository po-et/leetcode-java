package com.home.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 1054. Distant Barcodes (距离相等的条形码)
 *
 * In a warehouse, there is a row of barcodes, where the ith barcode is barcodes[i].
 *
 * Rearrange the barcodes so that no two adjacent barcodes are equal. You may return any answer, and it is guaranteed an answer exists.
 *
 * Example 1:
 * Input: barcodes = [1,1,1,2,2,2]
 * Output: [2,1,2,1,2,1]
 *
 * Example 2:
 * Input: barcodes = [1,1,1,1,2,2,3,3]
 * Output: [1,3,1,3,1,2,1,2]
 *
 * @see <a href="https://leetcode.cn/problems/distant-barcodes/" />
 * @author Poet
 * @date 2023/5/14
 */
public class LC_1054_DistantBarcodes {

    /**
     * 方法一：最大堆
     *
     * time:  O(NlogN)
     * space: O(N)
     */
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int barcode : barcodes) {
            map.put(barcode, map.getOrDefault(barcode, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new int[]{entry.getValue(), entry.getKey()});
        }

        int n = barcodes.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int[] p = pq.poll();
            int count = p[0];
            int num = p[1];
            if (i == 0 || res[i - 1] != num) {
                res[i] = num;
                if (count > 1) {
                    pq.offer(new int[]{count - 1, num});
                }
            } else {
                int[] p2 = pq.poll();
                res[i] = p2[1];
                if (p2[0] > 1) {
                    pq.offer(new int[]{p2[0] - 1, p2[1]});
                }
                pq.offer(new int[]{count, num});
            }
        }

        return res;
    }
}
