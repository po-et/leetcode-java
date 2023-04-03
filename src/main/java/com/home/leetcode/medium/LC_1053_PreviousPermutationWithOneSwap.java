package com.home.leetcode.medium;

/**
 * 1053. Previous Permutation With One Swap (交换一次的先前排列)
 *
 * Given an array of positive integers arr (not necessarily distinct), return the lexicographically largest permutation that is smaller than arr, that can be made with exactly one swap. If it cannot be done, then return the same array.
 *
 * Note that a swap exchanges the positions of two numbers arr[i] and arr[j]
 *
 * Example 1:
 * Input: arr = [3,2,1]
 * Output: [3,1,2]
 * Explanation: Swapping 2 and 1.
 *
 * Example 2:
 * Input: arr = [1,1,5]
 * Output: [1,1,5]
 * Explanation: This is already the smallest permutation.
 *
 * Example 3:
 * Input: arr = [1,9,4,6,7]
 * Output: [1,7,4,6,9]
 * Explanation: Swapping 9 and 7.
 *
 * @see <a href="https://leetcode.cn/problems/previous-permutation-with-one-swap/" />
 * @author Poet
 * @date 2023/4/3
 */
public class LC_1053_PreviousPermutationWithOneSwap {

    /**
     * 方法一：贪心
     */
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                int j = n - 1;
                while (arr[j] >= arr[i] || arr[j] == arr[j - 1]) {
                    j--;
                }
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                break;
            }
        }
        return arr;
    }

}
