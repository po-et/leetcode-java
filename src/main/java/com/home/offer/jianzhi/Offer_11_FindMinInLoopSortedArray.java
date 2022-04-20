package com.home.offer.jianzhi;

/**
 * 面试题11. 旋转数组的最小数字
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * @author Poet
 * @date 2020/5/26
 */
public class Offer_11_FindMinInLoopSortedArray {

    public int minArray(int[] numbers) {
        if (numbers == null)
            throw new IllegalArgumentException("param is not valid.");
        if (numbers.length == 1) {
            return numbers[0];
        }
        if (numbers.length == 2) {
            return Math.min(numbers[0], numbers[1]);
        }


        // 在[l..r]区间寻找最小值
        int l = 0, r = numbers.length - 1;

        while (l < r) {
            int mid = l + ((r - l) >> 1);

            if (numbers[mid] > numbers[r]) {  // [mid..r]区间有转折
                l = mid + 1;
            } else if (numbers[mid] < numbers[r]) {  // [l..mid]区间有转折
                r = mid;
            } else {
                // 执行 r = r - 1 缩小判断范围
                r--;
            }
        }

        return numbers[l];
    }


}
