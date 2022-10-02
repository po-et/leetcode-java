package com.home.leetcode.medium;

/**
 * 777. Swap Adjacent in LR String (在LR字符串中交换相邻字符)
 *
 * In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either replacing one occurrence
 * of "XL" with "LX", or replacing one occurrence of "RX" with "XR". Given the starting string start and the ending string end,
 * return True if and only if there exists a sequence of moves to transform one string to the other.
 *
 * Example 1:
 * Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
 * Output: true
 * Explanation: We can transform start to end following these steps:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 *
 * Example 2:
 * Input: start = "X", end = "L"
 * Output: false
 *
 * @see <a href="https://leetcode.cn/problems/swap-adjacent-in-lr-string/" />
 * @author Poet
 * @date 2022/10/2
 */
public class LC_777_SwapAdjacentInLRString {

    /**
     * 方法一：双指针
     *
     * solution: https://leetcode.cn/problems/swap-adjacent-in-lr-string/solution/zai-lrzi-fu-chuan-zhong-jiao-huan-xiang-rjaw8/
     */
    public boolean canTransform(String start, String end) {
        int n = start.length();
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }
            while (j < n && end.charAt(j) == 'X') {
                j++;
            }
            if (i < n && j < n) {
                if (start.charAt(i) != end.charAt(j)) {
                    return false;
                }
                char c = start.charAt(i);
                if ((c == 'L' && i < j) || (c == 'R' && i > j)) {
                    return false;
                }
                i++;
                j++;
            }
        }
        while (i < n) {
            if (start.charAt(i) != 'X') {
                return false;
            }
            i++;
        }
        while (j < n) {
            if (end.charAt(j) != 'X') {
                return false;
            }
            j++;
        }
        return true;
    }

}
