package com.home.leetcode.jianzhi_offer;

/**
 * 面试题20. 表示数值的字符串
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
 *
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * @author Poet
 * @date 2020/5/28
 */
public class Offer_20_ValidNumber {

    /**
     * Solution: https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/solution/javaban-ben-ti-jie-luo-ji-qing-xi-by-yangshyu6/
     */
    public boolean isNumber(String s) {
        if(s == null || s.trim().length() == 0)
            return false;

        // 标记是否遇到相应情况
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;

        char[] str = s.trim().toCharArray();

        for (int i = 0; i < s.trim().length(); i++) {
            if (str[i] >= '0' && str[i] <= '9') {
                numSeen = true;

            } else if (str[i] == '.') {
                // .之前不能出现.或者e
                if (dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;

            } else if (str[i] == 'e' || str[i] == 'E') {
                // e之前不能出现e，必须出现数字
                if (eSeen || !numSeen) {
                    return false;
                }
                eSeen = true;
                numSeen = false;    // 重置numSeen，排除123e或者123e+的情况,确保e之后也出现数

            } else if (str[i] == '-' || str[i] == '+') {
                // +-出现在0位置或者e/E后面的第一个位置才是合法的
                if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    return false;
                }

            } else {    // 其他不合法字符
                return false;
            }
        }
        return numSeen;
    }
}
