package com.home.jianzhi_offer_II;

/**
 * 剑指 Offer II 006. 排序数组中两个数字之和
 *
 * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 *
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 0 开始计数 ，所以答案数组应当满足 0 <= answer[0] < answer[1] < numbers.length 。
 *
 * 假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。
 *
 * 示例 1：
 * 输入：numbers = [1,2,4,6,10], target = 8
 * 输出：[1,3]
 * 解释：2 与 6 之和等于目标数 8 。因此 index1 = 1, index2 = 3 。
 *
 * 示例 2：
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[0,2]
 *
 * 示例 3：
 * 输入：numbers = [-1,0], target = -1
 * 输出：[0,1]
 *
 * 注意：本题与主站 167 题相似（下标起点不同）：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * @see <a href="https://leetcode.cn/problems/kLl5u1" />
 * @author Poet
 * @date 2023/3/13
 */
public class Offer_II_006_TwoSum_ii_InputArrayIsSorted {

    /**
     * 方法二：双指针
     *
     * time:  O(n)
     * space: O(1)
     */
    public int[] twoSum(int[] numbers, int target) {
        int sum;
        int l = 0, r = numbers.length - 1;

        while (l < r) {
            sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l, r};
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }

        return new int[]{-1, -1};
    }


    /**
     * 方法一：二分查找
     *
     * time:  O(NlogN)
     * space: O(1)
     */
    public int[] twoSum_1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1, high = numbers.length - 1;

            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i, mid};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return new int[]{-1, -1};
    }

}
