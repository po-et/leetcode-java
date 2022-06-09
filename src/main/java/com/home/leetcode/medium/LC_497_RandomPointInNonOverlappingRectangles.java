package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// 待思考，直接参考了答案
/**
 * 497. Random Point in Non-overlapping Rectangles （非重叠矩形中的随机点）
 *
 * You are given an array of non-overlapping axis-aligned rectangles rects where rects[i] = [ai, bi, xi, yi] indicates that (ai, bi) is the bottom-left corner point of the ith rectangle and (xi, yi) is the top-right corner point of the ith rectangle. Design an algorithm to pick a random integer point inside the space covered by one of the given rectangles. A point on the perimeter of a rectangle is included in the space covered by the rectangle.
 *
 * Any integer point inside the space covered by one of the given rectangles should be equally likely to be returned.
 *
 *
 * @see <a href="https://leetcode.cn/problems/random-point-in-non-overlapping-rectangles" />
 * @author poet
 * @date 2022/6/9
 */
public class LC_497_RandomPointInNonOverlappingRectangles {

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(rects);
     * int[] param_1 = obj.pick();
     */

    /**
     * 方法一：前缀和 + 二分查找
     *
     * 直接参考官方题解：https://leetcode.cn/problems/random-point-in-non-overlapping-rectangles/solution/fei-zhong-die-ju-xing-zhong-de-sui-ji-di-6s33/
     */
    class Solution {
        Random rand;
        List<Integer> arr;
        int[][] rects;

        public Solution(int[][] rects) {
            rand = new Random();
            arr = new ArrayList<>();
            arr.add(0);
            this.rects = rects;
            for (int[] rect : rects) {
                int a = rect[0], b = rect[1], x = rect[2], y = rect[3];
                arr.add(arr.get(arr.size() - 1) + (x - a + 1) * (y - b + 1));
            }
        }

        public int[] pick() {
            int k = rand.nextInt(arr.get(arr.size() - 1));
            int rectIndex = binarySearch(arr, k + 1) - 1;
            k -= arr.get(rectIndex);
            int[] rect = rects[rectIndex];
            int a = rect[0], b = rect[1], y = rect[3];
            int col = y - b + 1;
            int da = k / col;
            int db = k - col * da;
            return new int[]{a + da, b + db};
        }

        private int binarySearch(List<Integer> arr, int target) {
            int low = 0, high = arr.size() - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                int num = arr.get(mid);
                if (num == target) {
                    return mid;
                } else if (num > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }

}
