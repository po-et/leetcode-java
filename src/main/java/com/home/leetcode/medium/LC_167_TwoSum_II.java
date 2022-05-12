package com.home.leetcode.medium;

import java.util.Arrays;

/**
 * 167. 两数之和 II - 输入有序数组
 *
 * Example:
 *  Input: numbers = [2,7,11,15], target = 9
 *  Output: [1,2]
 *  Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 *
 * @see <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/" />
 * @author Poet
 * @date 2020/4/11
 */
public class LC_167_TwoSum_II {

    /**
     * 对撞指针
     */
    public static int[] twoSum(int[] numbers, int target) {

        int[] res = new int[2];
        int l = 0 ;
        int r = numbers.length - 1;

        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                res[0] = l + 1;
                res[1] = r + 1;
                return res;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                r--;
            }
        }

        throw new IllegalArgumentException("not existed solution!");
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

}
