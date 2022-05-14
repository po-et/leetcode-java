package com.home.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 350. 两个数组的交集 II
 *
 * Given two arrays, write a function to compute their intersection.
 *
 *  Example 1:
 *
 *  Input: nums1 = [1,2,2,1], nums2 = [2,2]
 *  Output: [2,2]
 *
 * @see <a href="https://leetcode.com/problems/intersection-of-two-arrays-ii/" />
 * @author Poet
 * @date 2020/4/16
 */
public class LC_350_IntersectionOfTwoArrays_II {

    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};
        int[] res = intersect(num1, num2);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 方法一：哈希表
     *
     * time: O(m+n)
     * space: O(min(m,n))
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> record = new HashMap<>();
        for (int num : nums1) {
            int count = record.getOrDefault(num, 0) + 1;
            record.put(num, count);
        }

        int[] res = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = record.getOrDefault(num, 0);
            if (count > 0) {
                res[index] = num;
                index++;
                count--;
                if (count > 0) {
                    record.put(num, count);
                } else {
                    record.remove(num);
                }
            }
        }

        return Arrays.copyOfRange(res, 0, index);
    }

}
