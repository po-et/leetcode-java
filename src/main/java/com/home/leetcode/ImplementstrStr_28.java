package com.home.leetcode;

/**
 * 28. Inplement strStr()
 * 获取string包含str的第一个index
 * Created by Poet on 2019-01-13.
 */
public class ImplementstrStr_28 {

    /**
     * time: O(n)
     * space: O(1)
     *
     * 注意：substring函数在java 7以后是线性的时间复杂度，而不是常数级的时间复杂度，所以时间复杂度是O(n)，
     *      加上外层的for循环，所以总的时间复杂度是O(n)
     */
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        for (int i = 0; i <= haystack.length()-needle.length(); i++) {
            if(haystack.substring(i, i+needle.length()).equals(needle)) return i;
        }
        return -1;
    }
}
