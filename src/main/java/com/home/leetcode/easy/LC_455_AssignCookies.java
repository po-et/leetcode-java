package com.home.leetcode.easy;

import java.util.Arrays;

/**
 * 455. Assign Cookies
 *
 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.
 *
 * Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with;
 * and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content.
 * Your goal is to maximize the number of your content children and output the maximum number.
 *
 * Example 1:
 * Input: g = [1,2,3], s = [1,1]
 * Output: 1
 *
 * Example 2:
 * Input: g = [1,2], s = [1,2,3]
 * Output: 2
 *
 * @see <a href="https://leetcode.cn/problems/assign-cookies/" />
 * @author bin.yang
 * @date 2022/6/4
 */
public class LC_455_AssignCookies {

    /**
     * 贪心算法
     *
     * 取最大/最小值，必然意味着要排序
     *
     * time: O(mlogm+nlogn)
     */
    public int findContentChildren(int[] g, int[] s) {

        // 排序：从大到小
        Arrays.sort(g);
        Arrays.sort(s);
        reverseSort(g);
        reverseSort(s);

        int si = 0, gi = 0;
        int res = 0;

        while (gi < g.length && si < s.length) {
            if (s[si] >= g[gi]) {
                res++;
                gi++;
                si++;
            } else {
                gi++;
            }
        }
        return res;
    }

    // int[] 逆序排列（Java中原生类型数组没有指定排序的方法）
    private void reverseSort(int[] g) {
        int l = 0;
        int r = g.length - 1;
        while (l < r) {
            int tmp = g[l];
            g[l] = g[r];
            g[r] = tmp;

            l++;
            r--;
        }
    }

}
