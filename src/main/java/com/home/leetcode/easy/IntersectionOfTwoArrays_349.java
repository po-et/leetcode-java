package com.home.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 *
 * @url https://leetcode.com/problems/intersection-of-two-arrays/
 * @author Poet
 * @date 2020/4/16
 */
public class IntersectionOfTwoArrays_349 {

    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};
        int[] res = intersection(num1, num2);
        System.out.println(Arrays.toString(res));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> record = new HashSet<>(nums1.length);
        Set<Integer> notExisted = new HashSet<>(nums2.length);
        for (int i : nums1) {
            record.add(i);
        }
        for (int i : nums2) {
            if (record.contains(i)) {
                notExisted.add(i);
            }
        }

//        return res.stream().toArray((IntFunction<Object[]>) Integer[]::new);
        int[] res = new int[notExisted.size()];
        int index = 0;
        Iterator<Integer> iterator = notExisted.iterator();
        while (iterator.hasNext()) {
            res[index++] = iterator.next();
        }
        return res;
    }
}
