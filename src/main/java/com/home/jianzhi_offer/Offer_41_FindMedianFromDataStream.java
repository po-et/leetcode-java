package com.home.jianzhi_offer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 面试题41. 数据流中的中位数
 *
 * https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 * @author Poet
 * @date 2020/5/31
 */
public class Offer_41_FindMedianFromDataStream {

    /**
     * 建立一个 小顶堆 A 和 大顶堆 B ，各保存列表的一半元素
     * https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/solution/mian-shi-ti-41-shu-ju-liu-zhong-de-zhong-wei-shu-y/
     */
    class MedianFinder {
        Queue<Integer> A, B;

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
