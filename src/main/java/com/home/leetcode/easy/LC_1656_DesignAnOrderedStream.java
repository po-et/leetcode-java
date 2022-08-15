package com.home.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 1656. Design an Ordered Stream (设计有序流)
 *
 * There is a stream of n (idKey, value) pairs arriving in an arbitrary order, where idKey is an integer between 1 and n and value is a string. No two pairs have the same id.
 *
 * Design a stream that returns the values in increasing order of their IDs by returning a chunk (list) of values after each insertion. The concatenation of all the chunks should result in a list of the sorted values.
 *
 * Implement the OrderedStream class:
 *
 * OrderedStream(int n) Constructs the stream to take n values.
 * String[] insert(int idKey, String value) Inserts the pair (idKey, value) into the stream, then returns the largest possible chunk of currently inserted values that appear next in the order.
 *
 * Example:
 * Input
 * ["OrderedStream", "insert", "insert", "insert", "insert", "insert"]
 * [[5], [3, "ccccc"], [1, "aaaaa"], [2, "bbbbb"], [5, "eeeee"], [4, "ddddd"]]
 * Output
 * [null, [], ["aaaaa"], ["bbbbb", "ccccc"], [], ["ddddd", "eeeee"]]
 *
 * Explanation
 * // Note that the values ordered by ID is ["aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee"].
 * OrderedStream os = new OrderedStream(5);
 * os.insert(3, "ccccc"); // Inserts (3, "ccccc"), returns [].
 * os.insert(1, "aaaaa"); // Inserts (1, "aaaaa"), returns ["aaaaa"].
 * os.insert(2, "bbbbb"); // Inserts (2, "bbbbb"), returns ["bbbbb", "ccccc"].
 * os.insert(5, "eeeee"); // Inserts (5, "eeeee"), returns [].
 * os.insert(4, "ddddd"); // Inserts (4, "ddddd"), returns ["ddddd", "eeeee"].
 * // Concatentating all the chunks returned:
 * // [] + ["aaaaa"] + ["bbbbb", "ccccc"] + [] + ["ddddd", "eeeee"] = ["aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee"]
 * // The resulting order is the same as the order above.
 *
 * @see <a href="https://leetcode.cn/problems/design-an-ordered-stream/" />
 * @author Poet
 * @date 2022/8/16
 */
public class LC_1656_DesignAnOrderedStream {

    /**
     * 方法一：使用数组存储 + 遍历
     *
     * time:  构造器O(n)，insert函数时间复杂度均摊为O(1)
     * space: O(n)
     */
    class OrderedStream {

        private String[] elements;
        private int ptr;

        public OrderedStream(int n) {
            elements = new String[n + 1];
            ptr = 1;
        }

        public List<String> insert(int idKey, String value) {
            elements[idKey] = value;

            List<String> res = new ArrayList<>();
            while (ptr < elements.length && elements[ptr] != null) {
                res.add(elements[ptr]);
                ptr++;
            }
            return res;
        }
    }

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
}
