package com.home.leetcode.utils;

/**
 * @author Poet
 * @date 2020/4/9
 */
public class ArrayUtils {

    public static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}
