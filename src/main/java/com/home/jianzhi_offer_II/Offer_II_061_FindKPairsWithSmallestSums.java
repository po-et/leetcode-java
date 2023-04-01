package com.home.jianzhi_offer_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 剑指 Offer II 061. 和最小的 k 个数对
 *
 * 给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 *
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 *
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 *
 * 示例 1:
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 *     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 *
 * 示例 2:
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 *      [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 *
 * 示例 3:
 * 输入: nums1 = [1,2], nums2 = [3], k = 3
 * 输出: [1,3],[2,3]
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 *
 * 注意：本题与主站 373 题相同：https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/
 *
 * @see <a href="https://leetcode.cn/problems/qn8gGX/" />
 * @author Poet
 * @date 2023/4/1
 */
public class Offer_II_061_FindKPairsWithSmallestSums {

    // 参考答案

    /**
     * 方法一：优先队列
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // k 为 pq 的长度，余下的是 PriorityQueue 的构造方法中的比较器
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (a, b) -> {
            return nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]];
        });
        // PriorityQueue<int[]> pq = new PriorityQueue<>(k, new Comparator<>() {
        //     public int compare(int[] a, int[] b) {
        //         return nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]];
        //     }
        // });

        List<List<Integer>> res = new ArrayList<>();
        int m = nums1.length, n = nums2.length;
        for (int i = 0; i < Math.min(m, k); ++i) {
            pq.offer(new int[]{i, 0});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] idx = pq.poll();
            res.add(new ArrayList<>(Arrays.asList(nums1[idx[0]], nums2[idx[1]])));
            if (idx[1] + 1 < n) {
                pq.offer(new int[]{idx[0], idx[1] + 1});
            }
        }
        return res;
    }
}
