package com.home.leetcode.medium;

/**
 * 1769. Minimum Number of Operations to Move All Balls to Each Box （移动所有球到每个盒子所需的最小操作数）
 *
 * You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty, and '1' if it contains one ball.
 *
 * In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1. Note that after doing so, there may be more than one ball in some boxes.
 *
 * Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls to the ith box.
 *
 * Each answer[i] is calculated considering the initial state of the boxes.
 *
 * Example 1:
 * Input: boxes = "110"
 * Output: [1,1,3]
 * Explanation: The answer for each box is as follows:
 * 1) First box: you will have to move one ball from the second box to the first box in one operation.
 * 2) Second box: you will have to move one ball from the first box to the second box in one operation.
 * 3) Third box: you will have to move one ball from the first box to the third box in two operations, and move one ball from the second box to the third box in one operation.
 *
 * Example 2:
 * Input: boxes = "001011"
 * Output: [11,8,5,4,3,4]
 *
 * @see <a href="https://leetcode.cn/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/" />
 * @author Poet
 * @date 2022/12/2
 */
public class LC_1769_MinimumNumberOfOperationsToMoveAllBallsToEachBox {

    /**
     * 方法一：双重循环模拟
     *
     * time:  O(n^2)
     * space: O(1) 除了结果数组外，只需要常数空间
     */
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (boxes.charAt(j) == '1') {
                    sum += Math.abs(i - j);
                }
            }
            res[i] = sum;
        }
        return res;
    }
}
