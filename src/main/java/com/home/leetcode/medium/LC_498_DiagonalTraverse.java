package com.home.leetcode.medium;

/**
 * 498. Diagonal Traverse （对角线遍历）
 *
 * Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
 *
 * Example 1:
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,4,7,5,3,6,8,9]
 *
 * Example 2:
 * Input: mat = [[1,2],[3,4]]
 * Output: [1,2,3,4]
 *
 * @see <a href="https://leetcode.cn/problems/diagonal-traverse" />
 * @author Poet
 * @date 2022/6/14
 */
public class LC_498_DiagonalTraverse {

    /**
     * 方法一：直接模拟
     *
     * 官方题解：https://leetcode.cn/problems/diagonal-traverse/solution/dui-jiao-xian-bian-li-by-leetcode-soluti-plz7/
     */
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];
        int pos = 0;

        for (int i = 0; i < m + n - 1; i++) {
            if (i % 2 == 1) {    // 奇数：左下遍历
                int x = i < n ? 0 : i - n + 1;
                int y = i < n ? i : n - 1;
                while (x < m && y >= 0) {
                    res[pos] = mat[x][y];
                    pos++;
                    x++;
                    y--;
                }
            } else {            // 偶数：右上遍历
                int x = i < m ? i : m - 1;
                int y = i < m ? 0 : i - m + 1;
                while (x >= 0 && y < n) {
                    res[pos] = mat[x][y];
                    pos++;
                    x--;
                    y++;
                }
            }
        }
        return res;
    }

}
