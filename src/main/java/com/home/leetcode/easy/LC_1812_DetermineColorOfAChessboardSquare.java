package com.home.leetcode.easy;


/**
 * 1812. Determine Color of a Chessboard Square (判断国际象棋棋盘中一个格子的颜色)
 *
 * You are given coordinates, a string that represents the coordinates of a square of the chessboard. Below is a chessboard for your reference.
 *
 * Return true if the square is white, and false if the square is black.
 *
 * The coordinate will always represent a valid chessboard square. The coordinate will always have the letter first, and the number second.
 *
 * Example 1:
 * Input: coordinates = "a1"
 * Output: false
 * Explanation: From the chessboard above, the square with coordinates "a1" is black, so return false.
 *
 * Example 2:
 * Input: coordinates = "h3"
 * Output: true
 * Explanation: From the chessboard above, the square with coordinates "h3" is white, so return true.
 *
 * Example 3:
 * Input: coordinates = "c7"
 * Output: false
 *
 * @see <a href="https://leetcode.cn/problems/determine-color-of-a-chessboard-square/" />
 * @author Poet
 * @date 2022/12/8
 */
public class LC_1812_DetermineColorOfAChessboardSquare {

    /**
     * 数学：找规律
     *
     * 从左下角开始，棋盘的行数和列数（均从 1 开始计数）之和如果为奇数，则为白色格子，如果和为偶数，则为黑色格子
     *
     * time:  O(1)
     * space: O(1)
     */
    public boolean squareIsWhite(String coordinates) {
        int x = coordinates.charAt(0) - 'a' + 1;
        int y = coordinates.charAt(1) - '0';
        return (x + y) % 2 != 0;
    }

}
