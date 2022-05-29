package com.home.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N-Queens （N皇后问题）
 *
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *
 * Example 1:
 *
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 *
 * @see <a href = "https://leetcode.cn/problems/n-queens/" />
 * @author Poet
 * @date 2022/5/29
 */
public class LC_051_N_Queens {

    List<List<String>> res = new ArrayList<>();
    boolean[] col;      // 已放置的列
    boolean[] diag1;    // 已放置的对角线（从左往右）
    boolean[] diag2;    // 已放置的对角线（从右往左）

    /**
     * 回溯法（liuyubo讲解）
     */
    public List<List<String>> solveNQueens(int n) {

        col = new boolean[n];
        diag1 = new boolean[2 * n - 1];     // 对角线有2n-1个
        diag2 = new boolean[2 * n - 1];     // 对角线有2n-1个

        List<Integer> row = new ArrayList<>();
        putQueen(n, 0, row);

        return res;
    }

    // 尝试在一个N皇后问题中，摆放第index行的皇后位置
    // row的值为在已放置的皇后行的第几列
    private void putQueen(int n, int index, List<Integer> row) {
        if (index == n) {
            res.add(generateBoard(n, row));
            return;
        }

        for (int i = 0; i < n; i++) {
            // 尝试将第index行的皇后摆放在第i列
            if (!col[i] && !diag1[index + i] && !diag2[index - i + n - 1]) {
                row.add(i);
                col[i] = true;
                diag1[index + i] = true;
                diag2[index - i + n - 1] = true;

                putQueen(n, index + 1, row);

                // 回退
                col[i] = false;
                diag1[index + i] = false;
                diag2[index - i + n - 1] = false;
                row.remove(row.size() - 1);
            }
        }
    }

    // 生成棋盘形式的解
    private List<String> generateBoard(int n, List<Integer> row) {
        List<String> boardList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == row.get(i)) {
                    builder.append("Q");
                } else {
                    builder.append(".");
                }
            }
            boardList.add(builder.toString());
        }
        return boardList;
    }



    public static void main(String[] args) {
        LC_051_N_Queens solution = new LC_051_N_Queens();
        List<List<String>> res = solution.solveNQueens(8);
        for (List<String> innerList : res) {
            for (String list : innerList) {
                System.out.println(list);
            }
            System.out.println();
        }

        System.out.println("一共有解个数：" + res.size());
    }
}
