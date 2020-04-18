package com.home.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 *  Example 1:
 *
 *  Input: nums1 = [1,2,2,1], nums2 = [2,2]
 *  Output: [2,2]
 *
 * @url https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * @author Poet
 * @date 2020/4/16
 */
public class IntersectionOfTwoArrays_II_350 {

    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};
        int[] res = intersect(num1, num2);
        System.out.println(Arrays.toString(res));
    }

    /**
     * time: O(nlogn) / O(n) 哈希表
     * space: O(n)
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> record = new HashMap<>();
        for (int i : nums1) {
            if (record.containsKey(i)) {
                record.put(i, record.get(i) + 1);
            } else {
                record.put(i, 1);
            }
        }

        int[] res = new int[nums2.length];
        int index = 0;
        for (int i = 0; i < nums2.length; i++) {
            Integer freq = record.get(nums2[i]);
            if (!Objects.isNull(freq) && freq > 0) {
                res[index++] = nums2[i];
                record.put(i, freq--);
            }
        }
        return res;
    }
}
