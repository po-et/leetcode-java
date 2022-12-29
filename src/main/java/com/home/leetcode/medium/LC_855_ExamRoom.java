package com.home.leetcode.medium;

import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * 855. Exam Room
 *
 * There is an exam room with n seats in a single row labeled from 0 to n - 1.
 *
 * When a student enters the room, they must sit in the seat that maximizes the distance to the closest person. If there are multiple such seats, they sit in the seat with the lowest number. If no one is in the room, then the student sits at seat number 0.
 *
 * Design a class that simulates the mentioned exam room.
 *
 * Implement the ExamRoom class:
 *
 * ExamRoom(int n) Initializes the object of the exam room with the number of the seats n.
 * int seat() Returns the label of the seat at which the next student will set.
 * void leave(int p) Indicates that the student sitting at seat p will leave the room. It is guaranteed that there will be a student sitting at seat p.
 *
 * Example 1:
 * Input
 * ["ExamRoom", "seat", "seat", "seat", "seat", "leave", "seat"]
 * [[10], [], [], [], [], [4], []]
 * Output
 * [null, 0, 9, 4, 2, null, 5]
 * Explanation
 * ExamRoom examRoom = new ExamRoom(10);
 * examRoom.seat(); // return 0, no one is in the room, then the student sits at seat number 0.
 * examRoom.seat(); // return 9, the student sits at the last seat number 9.
 * examRoom.seat(); // return 4, the student sits at the last seat number 4.
 * examRoom.seat(); // return 2, the student sits at the last seat number 2.
 * examRoom.leave(4);
 * examRoom.seat(); // return 5, the student sits at the last seat number 5.
 *
 * @see <a href="https://leetcode.cn/problems/exam-room/" />
 * @author Poet
 * @date 2022/12/30
 */
public class LC_855_ExamRoom {

    // 参考答案

    /**
     * 方法一：延迟删除 + 有序集合 + 优先队列
     */
    class ExamRoom {
        int n;
        TreeSet<Integer> seats;
        PriorityQueue<int[]> pq;

        public ExamRoom(int n) {
            this.n = n;
            this.seats = new TreeSet<Integer>();
            this.pq = new PriorityQueue<int[]>((a, b) -> {
                int d1 = a[1] - a[0], d2 = b[1] - b[0];
                return d1 / 2 < d2 / 2 || (d1 / 2 == d2 / 2 && a[0] > b[0]) ? 1 : -1;
            });
        }

        public int seat() {
            if (seats.isEmpty()) {
                seats.add(0);
                return 0;
            }
            int left = seats.first(), right = n - 1 - seats.last();
            while (seats.size() >= 2) {
                int[] p = pq.peek();
                if (seats.contains(p[0]) && seats.contains(p[1]) && seats.higher(p[0]) == p[1]) { // 不属于延迟删除的区间
                    int d = p[1] - p[0];
                    if (d / 2 < right || d / 2 <= left) { // 最左或最右的座位更优
                        break;
                    }
                    pq.poll();
                    pq.offer(new int[]{p[0], p[0] + d / 2});
                    pq.offer(new int[]{p[0] + d / 2, p[1]});
                    seats.add(p[0] + d / 2);
                    return p[0] + d / 2;
                }
                pq.poll(); // leave 函数中延迟删除的区间在此时删除
            }
            if (right > left) { // 最右的位置更优
                pq.offer(new int[]{seats.last(), n - 1});
                seats.add(n - 1);
                return n - 1;
            } else {
                pq.offer(new int[]{0, seats.first()});
                seats.add(0);
                return 0;
            }
        }

        public void leave(int p) {
            if (p != seats.first() && p != seats.last()) {
                int prev = seats.lower(p), next = seats.higher(p);
                pq.offer(new int[]{prev, next});
            }
            seats.remove(p);
        }
    }

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
}
