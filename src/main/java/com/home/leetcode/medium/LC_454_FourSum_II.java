package com.home.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 4Sum II（四数相加 II）
 *
 * Given four lists nums1, nums2, nums3, nums4 of integer values, compute how many tuples (i, j, k, l)
 * there are such that nums1[i] + nums2[j] + nums3[k] + nums4[l] is zero.
 *
 * To make problem nums1 bit easier, all nums1, nums2, nums3, nums4 have same length of N where 0 ≤ N ≤ 500.
 * All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 *
 * Example 1:
 * Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * Output: 2
 * Explanation:
 *  The two tuples are:
 *      1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 *      2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 *
 * Example 2:
 * Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * Output: 1
 *
 * @see <a href="https://leetcode.cn/problems/4sum-ii/" />
 * @author Poet
 * @date 2020/4/20
 */
public class LC_454_FourSum_II {

    /**
     * 方法一：分组 + 哈希表
     *
     * 我们可以将四个数组分成两部分，A 和 B 为一组，C 和 D 为另外一组
     *
     * time:  O(n^2)
     * space: O(n^2)
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> record = new HashMap<>();
        int res = 0;

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
                    res += record.get(sum);
                }
            }
        }

        return res;
    }
}
