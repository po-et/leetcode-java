package com.home.leetcode.hard;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 295. Find Median from Data Stream
 *
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.
 *
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 *
 * Implement the MedianFinder class:
 *
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 *
 * Example 1:
 *
 * Input
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * Output
 * [null, null, null, 1.5, null, 2.0]
 *
 * @see <a href="https://leetcode.cn/problems/find-median-from-data-stream/" />
 * @author Poet
 * @date 2022/6/21
 */
public class LC_295_FindMedianFromDataStream {

    /**
     * 建立一个 小顶堆 A 和 大顶堆 B ，各保存列表的一半元素
     *
     * 极好的题解：https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/solution/mian-shi-ti-41-shu-ju-liu-zhong-de-zhong-wei-shu-y/
     */
    class MedianFinder {
        Queue<Integer> A, B;

        /** initialize your data structure here. */
        public MedianFinder() {
            A = new PriorityQueue<>();   // 小顶堆，保存较大的一半
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
