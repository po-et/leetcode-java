package com.home.interview;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 面试题 17.09. Get Kth Magic Number LCCI (第 k 个数)
 *
 * Design an algorithm to find the kth number such that the only prime factors are 3, 5, and 7.
 * Note that 3, 5, and 7 do not have to be factors, but it should not have any other prime factors.
 *
 * For example, the first several multiples would be (in order) 1, 3, 5, 7, 9, 15, 21.
 *
 * Example 1:
 * Input: k = 5
 * Output: 9
 *
 * @see <a href="https://leetcode.cn/problems/get-kth-magic-number-lcci/" />
 * @author Poet
 * @date 2022/9/28
 */
public class LLCI_17_09_GetKthMagicNumber {

    /**
     * 优先队列（最小堆）
     *
     * solution: https://leetcode.cn/problems/get-kth-magic-number-lcci/solution/di-k-ge-shu-by-leetcode-solution-vzp7/
     */
    public int getKthMagicNumber(int k) {
        int[] factors = {3, 5, 7};

        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        seen.add(1L);
        queue.offer(1L);

        int res = 0;
        for (int i = 0; i < k; i++) {
            long cur = queue.poll();
            res = (int) cur;
            for (int factor : factors) {
                long next = cur * factor;
                if (seen.add(next)) {
                    queue.offer(next);
                }
            }
        }
        return res;
    }

}
