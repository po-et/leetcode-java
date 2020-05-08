package com.home.leetcode.medium;

import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 *
 * @see <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/" />
 * @author Poet
 * @date 2020/4/11
 */
public class KthLargestElementInAnArray_215 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int   k    = 2;
//        System.out.println(findKthLargest(nums, k));
        System.out.println(findKthLargest2(nums, k));
    }

    /**
     * time: O(nlog(k))
     * space:
     */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    /**
     * 快排partition思路
     * time: O(n)
     * space:
     */
    public static int findKthLargest2(int[] nums, int k) {
        return findKthLargest2(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int findKthLargest2(int[] nums, int l, int r, int k) {

        int p = partition(nums, l, r);

        if (p == k) {
            return nums[p];
        } else if (p > k) {
            return findKthLargest2(nums, l, p - 1, k);
        } else { // p < k
            return findKthLargest2(nums, p + 1, r, k);
        }
    }

    private static int partition(int[] nums, int l, int r) {

        swap(nums, l, (int) (Math.random() * (r - l + 1)) + l);
        int v = nums[l];

        int lt = l;
        // nums[l...lt]<v, [lt+1...i]>=v

        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < v) {
                lt++;
                swap(nums, lt, i);
            }
        }

        swap(nums, lt, l);
        return lt;
    }

    private static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

}
