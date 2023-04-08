package com.home.jianzhi_offer_II;

import java.util.Arrays;

/**
 * 剑指 Offer II 075. 数组相对排序
 *
 * 给定两个数组，arr1 和 arr2，
 *  - arr2 中的元素各不相同
 *  - arr2 中的每个元素都出现在 arr1 中
 *
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 * 示例：
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 * 注意：本题与主站 1122 题相同：https://leetcode-cn.com/problems/relative-sort-array/
 *
 * @see <a href="https://leetcode.cn/problems/0H97ZC/" />
 * @author Poet
 * @date 2023/4/8
 */
public class Offer_II_075_RelativeSortArray {

    /**
     * 方法二：计数排序
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = Arrays.stream(arr1).max().getAsInt();
        int n = arr1.length;
        int[] res = new int[n];

        int[] freq = new int[max + 1];
        for (int i = 0; i < n; i++) {
            freq[arr1[i]]++;
        }

        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < freq[arr2[i]]; j++) {
                res[index] = arr2[i];
                index++;
            }
            freq[arr2[i]] = 0;
        }

        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < freq[i]; j++) {
                res[index] = i;
                index++;
            }
        }

        return res;
    }
}
