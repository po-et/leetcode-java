package com.home.jianzhi_offer;

import com.home.leetcode.hard.LC_295_FindMedianFromDataStream;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指 Offer 41. 数据流中的中位数
 *
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 * 示例 1：
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 *
 * 示例 2：
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 *
 * 题目同主站 {@link LC_295_FindMedianFromDataStream}
 *
 * @see <a href="https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/" />
 * @author Poet
 * @date 2020/5/31
 */
public class Offer_41_FindMedianFromDataStream {

    /**
     * 建立一个 小顶堆 A 和 大顶堆 B ，各保存列表的一半元素
     *
     * 极好的题解：https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/solution/mian-shi-ti-41-shu-ju-liu-zhong-de-zhong-wei-shu-y/
     */
    class MedianFinder {
        Queue<Integer> A, B;

        /** initialize your data structure here. */
        public MedianFinder() {
            A = new PriorityQueue<>();                      // 小顶堆，保存较大的一半
            B = new PriorityQueue<>((o1, o2) -> (o2 - o1)); // 大顶堆，保存较小的一半
        }

        public void addNum(int num) {
            if (A.size() != B.size()) {
                A.add(num);
                B.add(A.poll());
            } else {
                B.add(num);
                A.add(B.poll());
            }
        }

        public double findMedian() {
            return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
        }
    }

}
