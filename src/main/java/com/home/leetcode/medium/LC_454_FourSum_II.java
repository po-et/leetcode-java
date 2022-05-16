package com.home.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加 II
 *
 * Given four lists nums1, nums2, nums3, nums4 of integer values, compute how many tuples (i, j, k, l)
 * there are such that nums1[i] + nums2[j] + nums3[k] + nums4[l] is zero.
 *
 * To make problem nums1 bit easier, all nums1, nums2, nums3, nums4 have same length of N where 0 ≤ N ≤ 500.
 * All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 *
 * @see <a href = "https://leetcode.cn/problems/4sum-ii/" />
 * @author Poet
 * @date 2020/4/20
 */
public class LC_454_FourSum_II {

    /**
     * time: O(n^2)
     * space: O(n^2)
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        Map<Integer, Integer> record = new HashMap<>();
        int ret = 0;

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                record.put(sum, record.getOrDefault(sum, 0) + 1);   // value为sum的次数
            }
        }

        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int sum = 0 - nums3[i] - nums4[j];
                if (record.containsKey(sum)) {
                    ret += record.get(sum);
                }
            }
        }

        return ret;
    }
}
