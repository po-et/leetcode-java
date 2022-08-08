package com.home.leetcode.medium;

/**
 * 74. Search a 2D Matrix (搜索二维矩阵)
 *
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
 *
 * This matrix has the following properties:
 *  - Integers in each row are sorted from left to right.
 *  - The first integer of each row is greater than the last integer of the previous row.
 *
 * Example 1:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 *
 * Example 2:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 *
 * @see <a href="https://leetcode.cn/problems/search-a-2d-matrix/" />
 * @author poet
 * @date 2022/6/9
 */
public class LC_074_FindA2DMatrix {

    /**
     * 方法一：Z字形查找
     * 同 {@link LC_240_FindA2DMatrix_ii}
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
     * 方法二：两次二分查找
     *
     * 思路：对矩阵的第一列的元素二分查找，找到最后一个不大于目标值的元素，然后在该元素所在行中二分查找目标值是否存在
     *
     * time:  O(logm+logn) = O(logmn)，其中 m 和 n 分别是矩阵的行数和列数
     * space: O(1)
     */
    public boolean searchMatrix_binarySearch_twice(int[][] matrix, int target) {
        int rowIndex = binarySearchFirstColumn(matrix, target);
        if (rowIndex < 0) {
            return false;
        }
        return binarySearchRow(matrix[rowIndex], target);
    }

    public int binarySearchFirstColumn(int[][] matrix, int target) {
        int low = -1, high = matrix.length - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (matrix[mid][0] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean binarySearchRow(int[] row, int target) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }


    /**
     * 方法三：一次二分查找
     *
     * 思路：将矩阵每一行拼接在上一行的末尾，则会得到一个升序数组，我们可以在该数组上二分找到目标元素。
     *      代码实现时，可以二分升序数组的下标，将其映射到原矩阵的行和列上。
     *
     * time:  O(logmn)，其中 m 和 n 分别是矩阵的行数和列数
     * space: O(1)
     */
    public boolean searchMatrix_binarySearch_once(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int x = matrix[mid / n][mid % n];   // 重点关注下标！
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
