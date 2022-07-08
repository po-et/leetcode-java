package com.home.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. Pascal's Triangle II （杨辉三角 II）
 *
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 * Example 1:
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 *
 * Example 2:
 * Input: rowIndex = 0
 * Output: [1]
 *
 * Example 3:
 * Input: rowIndex = 1
 * Output: [1,1]
 *
 * @see <a href="https://leetcode.cn/problems/pascals-triangle-ii/" />
 * @author Poet
 * @date 2022/6/21
 */
public class LC_119_PascalTriangle_II {

    /**
     * 方法一：递推
     *
     * 利用杨辉三角的性质
     * 官方题解：https://leetcode.cn/problems/pascals-triangle-ii/solution/yang-hui-san-jiao-ii-by-leetcode-solutio-shuk/
     */
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }
        return res.get(rowIndex);
    }
}
