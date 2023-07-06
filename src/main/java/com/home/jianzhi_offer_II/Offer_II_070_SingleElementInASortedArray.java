package com.home.jianzhi_offer_II;

/**
 * 剑指 Offer II 070. 排序数组中只出现一次的数字
 *
 * 给定一个只包含整数的有序数组 nums ，每个元素都会出现两次，唯有一个数只会出现一次，请找出这个唯一的数字。
 *
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 *
 * 示例 1:
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 *
 * 注意：本题与主站 540 题相同：https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
 *
 * @see <a href="https://leetcode.cn/problems/skFtm2/" />
 * @author Poet
 * @date 2023/4/4
 */
public class Offer_II_070_SingleElementInASortedArray {

    /**
     * 方法二：偶数下标的二分查找
     *
     * time:  O(logN)
     * space: O(1)
     */
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            // 确保mid是偶数
            if (mid % 2 != 0) {
                mid = mid - 1;
            }
            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }

    /**
     * 滑动窗口（自己ac）
     *
     * time:  O(N)
     */
    public int singleNonDuplicate_bruteForce(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int l = 0, r = 0;
        while (l < n) {
            while (r < n && nums[l] == nums[r]) {
                r++;
            }
            if (r - l <= 1) {
                return nums[l];
            }
            l = r;
        }
        return res;
    }
}
