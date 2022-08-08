package com.home.leetcode.medium;

/**
 * 240. Search a 2D Matrix II (搜索二维矩阵)
 *
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
 *
 * This matrix has the following properties:
 *  - Integers in each row are sorted in ascending from left to right.
 *  - Integers in each column are sorted in ascending from top to bottom.
 *
 * Example 1:
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * Output: true
 *
 * Example 2:
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * Output: false
 *
 * @see <a href="https://leetcode.cn/problems/search-a-2d-matrix-ii" />
 * @author poet
 * @date 2022/6/9
 */
public class LC_240_FindA2DMatrix_ii {

    /**
     * 方法一：Z字形查找
     *
     * 思路：从矩阵 matrix 的右上角 (0, n-1) 进行搜索
     *
     * time:  O(m+n)
     * space: O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        int row = 0;                // 从第一行开始
        int col = colLength - 1;    // 从最后一列开始

        while (row < rowLength && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }


    /**
     * 方法二：二分查找
     *
     * 思路：由于矩阵 matrix 中每一行的元素都是升序排列的，因此我们可以对每一行都使用一次二分查找，判断 target 是否在该行中，从而判断 target 是否出现。
     *
     * 执行结果：超出时间限制！！！
     *
     * time:  O(m * logn)
     * space: O(1)
     */
    public boolean searchMatrix_2(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int index = binarySearch(row, target);
            if (index > 0) {
                return true;
            }
        }
        return false;
    }

    private int binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                mid = mid - 1;
            } else {
                mid = mid + 1;
            }
        }
        return -1;
    }

}
