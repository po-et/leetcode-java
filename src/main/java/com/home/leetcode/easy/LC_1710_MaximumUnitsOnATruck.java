package com.home.leetcode.easy;

import java.util.Arrays;

/**
 * 1710. Maximum Units on a Truck （卡车上的最大单元数）
 *
 * You are assigned to put some amount of boxes onto one truck.
 * You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:
 *
 * numberOfBoxesi is the number of boxes of type i.
 * numberOfUnitsPerBoxi is the number of units in each box of the type i.
 * You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck.
 * You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.
 *
 * Return the maximum total number of units that can be put on the truck.
 *
 * Example 1:
 * Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
 * Output: 8
 * Explanation: There are:
 * - 1 box of the first type that contains 3 units.
 * - 2 boxes of the second type that contain 2 units each.
 * - 3 boxes of the third type that contain 1 unit each.
 * You can take all the boxes of the first and second types, and one box of the third type.
 * The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.
 *
 * Example 2:
 * Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
 * Output: 91
 *
 * @see <a href="https://leetcode.cn/problems/maximum-units-on-a-truck/" />
 * @author Poet
 * @date 2022/11/15
 */
public class LC_1710_MaximumUnitsOnATruck {

    /**
     * 方法一：贪心
     *
     * 自己完成 ac
     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int res = 0;
        for (int[] boxType : boxTypes) {
            if (truckSize == 0) {
                break;
            }
            int count = boxType[0];
            while (count > 0 && truckSize > 0) {
                res += boxType[1];
                count--;
                truckSize--;
            }
        }
        return res;
    }

    /**
     * 贪心 另一种实现写法
     *
     * time:  O(nlogn)，其中 n 是 boxTypes 的长度，排序需要 O(nlogn) 的时间
     * space: O(logn)  排序需要 O(logn) 的递归调用栈空间
     */
    public int maximumUnits_2(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int res = 0;
        for (int[] boxType : boxTypes) {
            int numberOfBoxes = boxType[0];
            int numberOfUnitsPerBox = boxType[1];
            if (numberOfBoxes < truckSize) {
                res += numberOfBoxes * numberOfUnitsPerBox;
                truckSize -= numberOfBoxes;
            } else {
                res += truckSize * numberOfUnitsPerBox;
                break;
            }
        }
        return res;
    }

}
