package com.home.leetcode.jianzhi_offer;

import java.util.Arrays;

/**
 * 面试题45. 把数组排成最小的数
 *
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *
 * 链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof
 * @author Poet
 * @date 2020/6/1
 */
public class Offer_45_MinNumberInArray {

    // 重点：重新定义 排序判断规则

    /**
     * 方法一：内置排序函数
     */
    public String minNumber(int[] nums) {
        // 1.初始化: int[] --> string[]
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        // 2.列表排序
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        // 3.返回值拼接
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }


    /**
     * 方法二：自己写排序（快排）
     */
    public String minNumber_quickSort(int[] nums) {
        // 1.初始化: int[] --> string[]
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        // 2.列表排序
        quickSort(strs, 0, strs.length - 1);
        // 3.返回值拼接
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }

    private void quickSort(String[] strs, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(strs, l, r);
        quickSort(strs, l, p - 1);
        quickSort(strs, p + 1, r);
    }

    private int partition(String[] strs, int l, int r) {
        String v = strs[l];
        int i = l+1, j = r;
        while (true) {
            while (i <= r && ((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) < 0)) {
                i++;
            }
            while (j >= l+1 && ((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) > 0)) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(strs, i, j);
            i++;
            j--;
        }
        swap(strs, l, j);
        return j;
    }

    private void swap(String[] arr, int l, int r) {
        String tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}
