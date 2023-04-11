package com.home.leetcode.medium;

/**
 * 1041. Robot Bounded In Circle (困于环中的机器人)
 *
 * On an infinite plane, a robot initially stands at (0, 0) and faces north. Note that:
 *
 * The north direction is the positive direction of the y-axis.
 * The south direction is the negative direction of the y-axis.
 * The east direction is the positive direction of the x-axis.
 * The west direction is the negative direction of the x-axis.
 * The robot can receive one of three instructions:
 *
 * "G": go straight 1 unit.
 * "L": turn 90 degrees to the left (i.e., anti-clockwise direction).
 * "R": turn 90 degrees to the right (i.e., clockwise direction).
 * The robot performs the instructions given in order, and repeats them forever.
 *
 * Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.
 *
 * Example 1:
 * Input: instructions = "GGLLGG"
 * Output: true
 * Explanation: The robot is initially at (0, 0) facing the north direction.
 * "G": move one step. Position: (0, 1). Direction: North.
 * "G": move one step. Position: (0, 2). Direction: North.
 * "L": turn 90 degrees anti-clockwise. Position: (0, 2). Direction: West.
 * "L": turn 90 degrees anti-clockwise. Position: (0, 2). Direction: South.
 * "G": move one step. Position: (0, 1). Direction: South.
 * "G": move one step. Position: (0, 0). Direction: South.
 * Repeating the instructions, the robot goes into the cycle: (0, 0) --> (0, 1) --> (0, 2) --> (0, 1) --> (0, 0).
 * Based on that, we return true.
 *
 * Example 2:
 * Input: instructions = "GG"
 * Output: false
 * Explanation: The robot is initially at (0, 0) facing the north direction.
 * "G": move one step. Position: (0, 1). Direction: North.
 * "G": move one step. Position: (0, 2). Direction: North.
 * Repeating the instructions, keeps advancing in the north direction and does not go into cycles.
 * Based on that, we return false.
 *
 * Example 3:
 * Input: instructions = "GL"
 * Output: true
 * Explanation: The robot is initially at (0, 0) facing the north direction.
 * "G": move one step. Position: (0, 1). Direction: North.
 * "L": turn 90 degrees anti-clockwise. Position: (0, 1). Direction: West.
 * "G": move one step. Position: (-1, 1). Direction: West.
 * "L": turn 90 degrees anti-clockwise. Position: (-1, 1). Direction: South.
 * "G": move one step. Position: (-1, 0). Direction: South.
 * "L": turn 90 degrees anti-clockwise. Position: (-1, 0). Direction: East.
 * "G": move one step. Position: (0, 0). Direction: East.
 * "L": turn 90 degrees anti-clockwise. Position: (0, 0). Direction: North.
 * Repeating the instructions, the robot goes into the cycle: (0, 0) --> (0, 1) --> (-1, 1) --> (-1, 0) --> (0, 0).
 * Based on that, we return true.
 *
 * @see <a href="https://leetcode.cn/problems/robot-bounded-in-circle/" />
 * @author Poet
 * @date 2023/4/11
 */
public class LC_1041_RobotBoundedInCircle {

    /**
     * 方法一：模拟
     */
    public boolean isRobotBounded(String instructions) {
        int[][] direc = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direcIndex = 0;
        int x = 0, y = 0;
        int n = instructions.length();
        for (int idx = 0; idx < n; idx++) {
            char instruction = instructions.charAt(idx);
            if (instruction == 'G') {
                x += direc[direcIndex][0];
                y += direc[direcIndex][1];
            } else if (instruction == 'L') {
                direcIndex += 3;
                direcIndex %= 4;
            } else {
                direcIndex++;
                direcIndex %= 4;
            }
        }
        return direcIndex != 0 || (x == 0 && y == 0);
    }
}