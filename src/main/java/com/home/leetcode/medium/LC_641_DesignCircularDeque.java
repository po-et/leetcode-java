package com.home.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 641. Design Circular Deque (设计循环双端队列)
 *
 * Design your implementation of the circular double-ended queue (deque).
 *
 * Implement the MyCircularDeque class:
 *
 * MyCircularDeque(int k) Initializes the deque with a maximum size of k.
 * boolean insertFront() Adds an item at the front of Deque. Returns true if the operation is successful, or false otherwise.
 * boolean insertLast() Adds an item at the rear of Deque. Returns true if the operation is successful, or false otherwise.
 * boolean deleteFront() Deletes an item from the front of Deque. Returns true if the operation is successful, or false otherwise.
 * boolean deleteLast() Deletes an item from the rear of Deque. Returns true if the operation is successful, or false otherwise.
 * int getFront() Returns the front item from the Deque. Returns -1 if the deque is empty.
 * int getRear() Returns the last item from Deque. Returns -1 if the deque is empty.
 * boolean isEmpty() Returns true if the deque is empty, or false otherwise.
 * boolean isFull() Returns true if the deque is full, or false otherwise.
 *
 * Example 1:
 * Input
 * ["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
 * [[3], [1], [2], [3], [4], [], [], [], [4], []]
 *
 * Output
 * [null, true, true, true, false, 2, true, true, true, 4]
 *
 * Explanation
 * MyCircularDeque myCircularDeque = new MyCircularDeque(3);
 * myCircularDeque.insertLast(1);  // return True
 * myCircularDeque.insertLast(2);  // return True
 * myCircularDeque.insertFront(3); // return True
 * myCircularDeque.insertFront(4); // return False, the queue is full.
 * myCircularDeque.getRear();      // return 2
 * myCircularDeque.isFull();       // return True
 * myCircularDeque.deleteLast();   // return True
 * myCircularDeque.insertFront(4); // return True
 * myCircularDeque.getFront();     // return 4
 *
 * @see <a href="https://leetcode.cn/problems/design-circular-deque/" />
 * @author Poet
 * @date 2022/8/15
 */
public class LC_641_DesignCircularDeque {

    /**
     * 方法一：数组 (Better)
     *
     * solution: https://leetcode.cn/problems/design-circular-deque/solution/she-ji-xun-huan-shuang-duan-dui-lie-by-l-97v0/
     * 需要注意的点：
     *      1.数组大小是给定大小+1，因为rear所指向的位置始终是空的
     *      2.末尾插入要先赋值再移动rear指针
     *      3.队满和队空的条件
     *
     * time:  O(1) 初始化和每项操作的时间复杂度均为 O(1)
     * space: O(k) 其中 k 为给定的队列元素数目
     */
    class MyCircularDeque {
        private int[] elements;
        private int front, rear;
        private int capacity;

        public MyCircularDeque(int k) {
            capacity = k + 1;
            rear = front = 0;
            elements = new int[k + 1];
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            front = (front - 1 + capacity) % capacity;
            elements[front] = value;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            elements[rear] = value;
            rear = (rear + 1) % capacity;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            front = (front + 1) % capacity;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            rear = (rear - 1 + capacity) % capacity;
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return elements[front];
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return elements[(rear - 1 + capacity) % capacity];
        }

        public boolean isEmpty() {
            return rear == front;
        }

        public boolean isFull() {
            return (rear + 1) % capacity == front;
        }
    }



    /**
     * 方法二：列表
     *
     * 思路：使用size表示队列中的元素数量
     */
    class MyCircularDeque_List {
        List<Integer> data;
        int size;
        int capacity;

        public MyCircularDeque_List(int k) {
            data = new ArrayList<>(k);
            size = 0;
            capacity = k;
        }

        public boolean insertFront(int value) {
            if (size >= capacity) {
                return false;
            }
            data.add(0, value);
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (size >= capacity) {
                return false;
            }
            data.add(size, value);
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (size < 0) {
                return false;
            }
            data.remove(0);
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (size < 0) {
                return false;
            }
            data.remove(size - 1);
            size--;
            return true;
        }

        public int getFront() {
            if (size == 0) {
                return -1;
            }
            return data.get(0);
        }

        public int getRear() {
            if (size == 0) {
                return -1;
            }
            return data.get(size - 1);
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }


    /**
     * Your MyCircularDeque object will be instantiated and called as such:
     * MyCircularDeque obj = new MyCircularDeque(k);
     * boolean param_1 = obj.insertFront(value);
     * boolean param_2 = obj.insertLast(value);
     * boolean param_3 = obj.deleteFront();
     * boolean param_4 = obj.deleteLast();
     * int param_5 = obj.getFront();
     * int param_6 = obj.getRear();
     * boolean param_7 = obj.isEmpty();
     * boolean param_8 = obj.isFull();
     */
}
