package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. Triangle（三角形最小路径和）
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *
 * @see <a href="https://leetcode.cn/problems/triangle/" />
 * @author Poet
 * @date 2020/5/12
 */
public class LC_120_Triangle {


    /**
     * 官方答案
     *
     * 状态转移方程：
     * f[i][j] = f[i-1][0] + c[i][0]                    j=0
     *           f[i-1][i-1] + c[i][i]                  j=i
     *           min(f[i-1][j-1], f[i-1][j]) + c[i][j]  otherwise
     *
     * @see <a href="https://leetcode.cn/problems/triangle/solution/san-jiao-xing-zui-xiao-lu-jing-he-by-leetcode-solu/" />
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];

        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }

        int minTotal = f[n - 1][0];
        for (int i = 1; i < n; i++) {
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }

        return minTotal;
    }


    public static int minimumTotal_2(List<List<Integer>> triangle) {
        int length = triangle.size();
        if (length == 0) return 0;
        if (length == 1) return triangle.get(0).get(0);

        List<Integer> sum = triangle.get(length - 1);

        for (int i = length - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {

                int sum1 = triangle.get(i).get(j) + sum.get(j);
                int sum2 = triangle.get(i).get(j) + sum.get(j + 1);
                sum.set(j, Math.min(sum1, sum2));
            }
        }
        return sum.get(0);
    }


    /**
     * 动态规划：<Wrong Answer!!!>
     *
     * 状态：MP(i,j)表示从位置（i,j）达到底部的最小路径和；
     * 状态转移方程为：MP(i,j)=min{MP(i+1,j),MP(i+1,j+1)} + triangle[i][j]
     *
     * @see <a href="https://blog.csdn.net/Jin_Kwok/article/details/51418353" />
     */
    public static int minimumTotal___Wrong(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int length = triangle.size();

        List<List<Integer>> MP = new ArrayList<>(triangle);
//        MP.add(length - 1, triangle.get(length - 1));

        for (int i = length - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {

                int min = Math.min(MP.get(i + 1).get(j),
                        j + 1 < triangle.get(i).size() ? MP.get(i + 1).get(j + 1) : Integer.MAX_VALUE)
                        + triangle.get(i).get(j);

                MP.get(i).add(j, min);
            }
        }

        return MP.get(0).get(0);
    }


    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));

        LC_120_Triangle solution = new LC_120_Triangle();
        int min = solution.minimumTotal(triangle);
        System.out.println(min);
    }

}
