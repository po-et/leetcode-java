package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 658. Find K Closest Elements (找到 K 个最接近的元素)
 *
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
 * The result should also be sorted in ascending order.
 *
 * An integer a is closer to x than an integer b if:
 *      |a - x| < |b - x|, or
 *      |a - x| == |b - x| and a < b
 *
 * Example 1:
 * Input: arr = [1,2,3,4,5], k = 4, x = 3
 * Output: [1,2,3,4]
 *
 * Example 2:
 * Input: arr = [1,2,3,4,5], k = 4, x = -1
 * Output: [1,2,3,4]
 *
 * @see <a href="https://leetcode.cn/problems/find-k-closest-elements" />
 * @author Poet
 * @date 2022/8/25
 */
public class LC_658_FindKClosestElements {

    /**
     * 方法一：排序
     *
     * time:  O(nlogn)
     * space: O(logn)
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> data = new ArrayList<>();
        for (int num : arr) {
            data.add(num);
        }

        Collections.sort(data, (a,b)->{
            if (Math.abs(a - x) != Math.abs(b - x)) {
                return Math.abs(a - x) - Math.abs(b - x);
            } else {
                return a - b;
            }
        });

        List<Integer> res = data.subList(0, k);
        Collections.sort(res);
        return res;
    }

    /**
     * 方法二：二分查找 + 双指针
     *
     * 思路：
     * 将数组 arr 分成两部分，前一部分所有元素 [0,left] 都小于 x，后一部分所有元素 [right,n−1] 都大于等于 x
     * 最后，区间 [left+1,right−1] 的元素就是我们所要获得的结果
     *
     * time:  O(logn+k) 其中 n 是数组 arr 的长度。二分查找需要 O(logn)，双指针查找需要 O(k)
     * space: O(1)
     */
    public List<Integer> findClosestElements_2(int[] arr, int k, int x) {
        int right = binarySearch(arr, x);
        int left = right - 1;
        while (k-- > 0) {
            if (left < 0) {
                right++;
            } else if (right >= arr.length) {
                left--;
            } else if (x - arr[left] <= arr[right] - x) {
                left--;
            } else {
                right++;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left + 1; i < right; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

}
