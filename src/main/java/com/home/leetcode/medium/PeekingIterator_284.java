package com.home.leetcode.medium;

import java.util.Iterator;

/**
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().
 *
 * @see <a href = "https://leetcode.com/problems/peeking-iterator/" />
 * @author Poet
 * @date 2020/4/21
 */
public class PeekingIterator_284 {

    /**
     * time: O(1)
     * space: O(1)
     */
    // Java Iterator interface reference:
    // https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
    class PeekingIterator implements Iterator<Integer> {

        private Integer data;
        private boolean isRecord = false;

        private Iterator<Integer> iterator;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (!isRecord) {
                data = iterator.next();
                isRecord = true;
            }
            return data;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (isRecord) {
                isRecord = false;
                return data;
            }
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            if (isRecord) {
                return true;
            }
            return iterator.hasNext();
        }
    }


    /**
     * 第二种方法（更巧妙）
     *
     * <p>使用Integer来做global variable的话就可以省略使用boolean了</p>
     */
    class PeekingIterator2 implements Iterator<Integer> {

        private Integer next;
        private Iterator<Integer> iter;

        public PeekingIterator2(Iterator<Integer> iterator) {
            this.iter = iterator;
            if (iter.hasNext()) {
                next = iter.next();
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return next;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer ret = next;
            next = iter.hasNext() ? iter.next() : null;
            return ret;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }
    }
}
