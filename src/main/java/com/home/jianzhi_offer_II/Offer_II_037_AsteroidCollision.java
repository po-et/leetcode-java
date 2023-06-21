package com.home.jianzhi_offer_II;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer II 037. 小行星碰撞
 *
 * 给定一个整数数组 asteroids，表示在同一行的小行星。
 *
 * 对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。
 *
 * 找出碰撞后剩下的所有小行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 *
 * 示例 1：
 * 输入：asteroids = [5,10,-5]
 * 输出：[5,10]
 * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
 *
 * 示例 2：
 * 输入：asteroids = [8,-8]
 * 输出：[]
 * 解释：8 和 -8 碰撞后，两者都发生爆炸。
 *
 * 示例 3：
 * 输入：asteroids = [10,2,-5]
 * 输出：[10]
 * 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
 *
 * 示例 4：
 * 输入：asteroids = [-2,-1,1,2]
 * 输出：[-2,-1,1,2]
 * 解释：-2 和 -1 向左移动，而 1 和 2 向右移动。 由于移动方向相同的行星不会发生碰撞，所以最终没有行星发生碰撞。
 *
 * 注意：本题与主站 735 题相同： https://leetcode-cn.com/problems/asteroid-collision/
 *
 * @see <a href="https://leetcode.cn/problems/XagZNi" />
 * @author Poet
 * @date 2023/3/24
 */
public class Offer_II_037_AsteroidCollision {

    /**
     * 方法一：栈模拟
     *
     * time:  O(n)
     * space: O(n)
     */
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            boolean isAlive = true;
            while (isAlive && asteroid < 0 && !stack.isEmpty() && stack.peek() > 0) {
                isAlive = stack.peek() < -asteroid; // 判断asteroid是否还存在
                if (stack.peek() <= -asteroid) {
                    stack.pop();
                }
            }
            if (isAlive) {
                stack.push(asteroid);
            }
        }

        int size = stack.size();
        int[] res = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

}
