package com.home.leetcode.jianzhi_offer;

import java.util.Arrays;

/**
 * 面试题40. 最小的k个数
 *
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * @author Poet
 * @date 2020/5/31
 */
public class Offer_40_SmallestKNums {

    /**
     * 方法一：基于快排的思想 （Best！）
     * 时间复杂度：O(n)，空间复杂度：O(logn)，递归调用的期望深度为O(logn)，每层需要的空间为O(1)，只有常数个变量。
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr == null || arr.length == 0 || k == 0)
            return new int[0];

        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    public int[] quickSearch(int[] arr, int lo, int hi, int k) {
        // 每快排切分1次，找到排序后下标为p的元素，如果p恰好等于k就返回p以及p左边所有的数；
        int p = partition(arr, lo, hi);
        if (p == k) {
            return Arrays.copyOf(arr, p + 1);
        }
        // 否则根据下标p与k的大小关系来决定继续切分左段还是右段。
        return p > k ? quickSearch(arr, lo, p - 1, k) : quickSearch(arr, p + 1, hi, k);
    }

    // 快排切分，返回下标p，使得比nums[p]小的数都在p的左边，比nums[p]大的数都在p的右边。
    private int partition(int[] arr, int l, int r) {
        // swap random
        swap(arr, l, (int)(Math.random() * (r-l+1)) + l);
        int v = arr[l];

        // arr[l+1..i) <= v, (j..r] >= v
        int i = l + 1, j = r;

        while (true) {
            while(i <= r && arr[i] < v) i++;
            while(j >= l+1 && arr[j] > v) j--;
            if(i > j) break;

            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    private void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 方法二：最大堆
     * 时间复杂度：O(nlogk)，空间复杂度：O(k)
     */


}
