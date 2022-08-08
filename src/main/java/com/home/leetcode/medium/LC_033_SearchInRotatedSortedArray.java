package com.home.leetcode.medium;


/**
 * 33. Search in Rotated Sorted Array (搜索旋转排序数组)
 *
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 * Example 3:
 * Input: nums = [1], target = 0
 * Output: -1
 *
 * @see <a href="https://leetcode.cn/problems/search-in-rotated-sorted-array/" />
 * @author Poet
 * @date 2019/1/15
 */
public class LC_033_SearchInRotatedSortedArray {

    /**
     * 方法一：二分查找
     *
     * 官方solution：https://leetcode.cn/problems/search-in-rotated-sorted-array/solution/sou-suo-xuan-zhuan-pai-xu-shu-zu-by-leetcode-solut/
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[0] <= nums[mid]) {      // 前半段是升序的，旋转点在mid后
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {                        // 后半段是升序的，旋转点在mid前
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }



    /**
     * 方法一：二分查找
     *
     * 考的是binary search，时间复杂度如果是O(n)这样循环遍历则没有意义
     *
     * time:  O(logn)
     * space: O(1)
     */
    public int search_2(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {            //start < end 会死循环
            int mid = (end - start) / 2 + start;
            if(nums[mid] == mid) return mid;
            if (nums[start] < nums[mid]) {  //前面是升序
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else start = mid;
            } else {                        //后面是升序
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else end = mid;
            }
        }
        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
        return -1;
    }

}
