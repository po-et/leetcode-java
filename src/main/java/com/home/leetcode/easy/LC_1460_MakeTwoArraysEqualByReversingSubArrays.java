package com.home.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1460. Make Two Arrays Equal by Reversing Sub-arrays (通过翻转子数组使两个数组相等)
 *
 * You are given two integer arrays of equal length target and arr. In one step, you can select any non-empty sub-array of arr and reverse it. You are allowed to make any number of steps.
 *
 * Return true if you can make arr equal to target or false otherwise.
 *
 * Example 1:
 * Input: target = [1,2,3,4], arr = [2,4,1,3]
 * Output: true
 * Explanation: You can follow the next steps to convert arr to target:
 * 1- Reverse sub-array [2,4,1], arr becomes [1,4,2,3]
 * 2- Reverse sub-array [4,2], arr becomes [1,2,4,3]
 * 3- Reverse sub-array [4,3], arr becomes [1,2,3,4]
 * There are multiple ways to convert arr to target, this is not the only way to do so.
 *
 * Example 2:
 * Input: target = [7], arr = [7]
 * Output: true
 * Explanation: arr is equal to target without any reverses.
 *
 * Example 3:
 * Input: target = [3,7,9], arr = [3,7,11]
 * Output: false
 * Explanation: arr does not have value 9 and it can never be converted to target.
 *
 * @see <a href="https://leetcode.cn/problems/make-two-arrays-equal-by-reversing-sub-arrays/" />
 * @author Poet
 * @date 2022/8/27
 */
public class LC_1460_MakeTwoArraysEqualByReversingSubArrays {

    /**
     * 方法一：哈希表判断数组元素是否相同
     *
     * time:  O(n)
     * space: O(n) 哈希表最多消耗 O(n) 空间
     */
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : target) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {
            if (!map.containsKey(num)) {
                return false;
            }
            if (map.get(num) <= 0) {
                return false;
            }
            map.put(num, map.get(num) - 1);
        }
        return true;
    }

    /**
     * 方法一：哈希表判断数组元素是否相同 （另一种写法）
     *
     * time:  O(n)
     * space: O(n) 哈希表最多消耗 O(n) 空间
     */
    public boolean canBeEqual_hashmap(int[] target, int[] arr) {
        Map<Integer, Integer> counts1 = new HashMap<>();
        Map<Integer, Integer> counts2 = new HashMap<>();

        for (int num : target) {
            counts1.put(num, counts1.getOrDefault(num, 0) + 1);
        }
        for (int num : arr) {
            counts2.put(num, counts2.getOrDefault(num, 0) + 1);
        }
        if (counts1.size() != counts2.size()) {
            return false;
        }
        for (Map.Entry<Integer, Integer> entry : counts1.entrySet()) {
            int key = entry.getKey(), value = entry.getValue();
            if (!counts2.containsKey(key) || counts2.get(key) != value) {
                return false;
            }
        }
        return true;
    }

    /**
     * 方法二：排序判断数组元素是否相同
     *
     * time:  O(nlogn)
     * space: O(logn)，快速排序递归深度平均为 O(logn)
     */
    public boolean canBeEqual_sort(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }

}
