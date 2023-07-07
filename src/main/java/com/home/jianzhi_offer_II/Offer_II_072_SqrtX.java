package com.home.jianzhi_offer_II;

/**
 * 剑指 Offer II 072. 求平方根
 *
 * 给定一个非负整数 x ，计算并返回 x 的平方根，即实现 int sqrt(int x) 函数。
 *
 * 正数的平方根有两个，只输出其中的正数平方根。
 *
 * 如果平方根不是整数，输出只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 * 输入: x = 4
 * 输出: 2
 *
 * 示例 2:
 * 输入: x = 8
 * 输出: 2
 * 解释: 8 的平方根是 2.82842...，由于小数部分将被舍去，所以返回 2
 *
 * 注意：本题与主站 69 题相同： https://leetcode-cn.com/problems/sqrtx/
 *
 * @see <a href="https://leetcode.cn/problems/jJ0w9p/" />
 * @author Poet
 * @date 2023/4/6
 */
public class Offer_II_072_SqrtX {

    /**
     * 二分查找
     *
     * 思路：由于 x 平方根的整数部分是满足 k^2 ≤ x 的最大 k 值，因此我们可以对 k 进行二分查找，从而得到答案
     *
     * time:  O(logX) 即为二分查找需要的次数
     * space: O(1)
     */
    public int mySqrt(int x) {
        int l = 0, r = x;
        int res = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * (long) mid <= x) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

}
