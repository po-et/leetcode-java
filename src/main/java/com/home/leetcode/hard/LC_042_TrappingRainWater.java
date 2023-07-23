package com.home.leetcode.hard;

/**
 * 42. Trapping Rain Water (接雨水)
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 * Example 1:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 *
 * Example 2:
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 * @see <a href="https://leetcode.cn/problems/trapping-rain-water/" />
 * @author Poet
 * @date 2019/1/19
 */
public class LC_042_TrappingRainWater {

    /**
     0,1,0,2,1,0,1,3,2,1,2,1

                   *
           *       * *   *
       *   * *   * * * * * *
     0 1 2 3 4 5 6 7 8 9 0 1
     l                     r
     */


    /**
     * 方法一：动态规划
     *
     * 官方题解：https://leetcode.cn/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode-solution-tuvc/
     *
     * 思路：正向遍历数组 height 得到数组 leftMax 的每个元素值，反向遍历数组 height 得到数组 rightMax 的每个元素值
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode-solution-tuvc/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * time:  O(n) 其中 n 是数组 height 的长度。计算数组 leftMax 和 rightMax 的元素值各需要遍历数组 height 一次，计算能接的雨水总量还需要遍历一次
     * space: O(n) 需要创建两个长度为 n 的数组 leftMax 和 rightMax
     */
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int res = 0;
        for (int i = 0; i < n; ++i) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }



    /**
     *
     * time:  O(n)
     * space: O(1)
     */
    @Deprecated
//    public static int trap(int[] height) {
//        int left = 0;
//        int right = height.length - 1;
//        int leftMax = 0;
//        int rightMax = 0;
//        int res = 0;
//        while (left < right) {
//            if (height[left] < height[right]) {
//                leftMax = Math.max(height[left], leftMax);
//                res += leftMax - height[left];
//                left++;
//            } else {
//                rightMax = Math.max(height[right], rightMax);
//                res += rightMax - height[right];
//                right--;
//            }
//        }
//        return res;
//    }

    public static void main(String[] args) {
        LC_042_TrappingRainWater solution = new LC_042_TrappingRainWater();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap(height));
    }

}
