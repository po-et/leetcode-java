package com.home.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 *
 * @see <a href="https://leetcode.com/problems/intersection-of-two-arrays/" />
 * @author Poet
 * @date 2020/4/16
 */
public class LC_349_IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};
        int[] res = intersection(num1, num2);
        System.out.println(Arrays.toString(res));
    }

    /**
     * time: O(nlogn) / O(n) 哈希表
     * space: O(n)
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> record = new HashSet<>(nums1.length);
        for (int i : nums1) {
            record.add(i);
        }

        Set<Integer> resultSet = new HashSet<>(nums2.length);
        for (int i : nums2) {
            if (record.contains(i)) {
                resultSet.add(i);
            }
        }

//        return res.stream().toArray((IntFunction<Object[]>) Integer[]::new);
        int[] res = new int[resultSet.size()];
        int index = 0;
        for (Integer num : resultSet) {
            res[index++] = num;
        }
        return res;
    }
}
