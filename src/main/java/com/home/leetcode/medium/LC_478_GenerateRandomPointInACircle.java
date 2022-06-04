package com.home.leetcode.medium;

import java.util.Random;

/**
 * 478. Generate Random Point in a Circle
 *
 * Given the radius and the position of the center of a circle, implement the function randPoint which generates a uniform random point inside the circle.
 *
 * Example 1:
 *
 * Input
 * ["Solution","randPoint","randPoint","randPoint"]
 * [[1.0, 0.0, 0.0], [], [], []]
 * Output
 * [null, [-0.02493, -0.38077], [0.82314, 0.38945], [0.36572, 0.17248]]
 *
 * Explanation
 * Solution solution = new Solution(1.0, 0.0, 0.0);
 * solution.randPoint(); // return [-0.02493, -0.38077]
 * solution.randPoint(); // return [0.82314, 0.38945]
 * solution.randPoint(); // return [0.36572, 0.17248]
 *
 * @see <a href="https://leetcode.cn/problems/generate-random-point-in-a-circle" />
 * @author poet
 * @date 2022/6/5
 */
public class LC_478_GenerateRandomPointInACircle {

    /**
     * 方法一：拒绝采样
     *
     * 拒绝采样的意思是说：我们在一个更大的范围内生成随机数，并拒绝掉那些不在题目给定范围内的随机数，此时保留下来的随机数都是在范围内的。
     * 官方答案：https://leetcode.cn/problems/generate-random-point-in-a-circle/solution/zai-yuan-nei-sui-ji-sheng-cheng-dian-by-qp342/
     *
     * time： 期望时间复杂度为 O(1)
     * space：O(1)
     */
    class Solution {
        Random random;
        double xc, yc, r;

        public Solution(double radius, double x_center, double y_center) {
            random = new Random();
            xc = x_center;
            yc = y_center;
            r = radius;
        }

        public double[] randPoint() {
            while (true) {
                double x = random.nextDouble() * (2 * r) - r;
                double y = random.nextDouble() * (2 * r) - r;
                if (x * x + y * y <= r * r) {
                    return new double[]{xc + x, yc + y};
                }
            }
        }
    }

}
