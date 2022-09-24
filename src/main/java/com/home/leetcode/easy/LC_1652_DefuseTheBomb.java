package com.home.leetcode.easy;

/**
 * 1652. Defuse the Bomb (拆炸弹)
 *
 * You have a bomb to defuse, and your time is running out! Your informer will provide you with a circular array code of length of n and a key k.
 *
 * To decrypt the code, you must replace every number. All the numbers are replaced simultaneously.
 *
 * If k > 0, replace the ith number with the sum of the next k numbers.
 * If k < 0, replace the ith number with the sum of the previous k numbers.
 * If k == 0, replace the ith number with 0.
 * As code is circular, the next element of code[n-1] is code[0], and the previous element of code[0] is code[n-1].
 *
 * Given the circular array code and an integer key k, return the decrypted code to defuse the bomb!
 *
 * Example 1:
 * Input: code = [5,7,1,4], k = 3
 * Output: [12,10,16,13]
 * Explanation: Each number is replaced by the sum of the next 3 numbers. The decrypted code is [7+1+4, 1+4+5, 4+5+7, 5+7+1]. Notice that the numbers wrap around.
 *
 * Example 2:
 * Input: code = [1,2,3,4], k = 0
 * Output: [0,0,0,0]
 * Explanation: When k is zero, the numbers are replaced by 0.
 *
 * Example 3:
 * Input: code = [2,4,9,3], k = -2
 * Output: [12,5,6,13]
 * Explanation: The decrypted code is [3+9, 2+3, 4+2, 9+4]. Notice that the numbers wrap around again. If k is negative, the sum is of the previous numbers.
 *
 * @see <a href="https://leetcode.cn/problems/defuse-the-bomb/" />
 * @author Poet
 * @date 2022/9/24
 */
public class LC_1652_DefuseTheBomb {

    /**
     * 分类讨论，自己完成
     */
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] arr = new int[n];
        if (k == 0) {
            for (int i = 0; i < n; i++) {
                arr[i] = 0;
            }
        } else if (k > 0) {
            for (int i = 0; i < n; i++) {
                int index = 1;
                int sum = 0;
                while (index <= k) {
                    sum = sum + code[(i + index) % n];
                    index++;
                }
                arr[i] = sum;
            }
        } else {
            for (int i = 0; i < n; i++) {
                int index = 1;
                int sum = 0;
                while (index <= -k) {
                    sum = sum + code[(i + n - index) % n];
                    index++;
                }
                arr[i] = sum;
            }
        }
        return arr;
    }


    /**
     * 方法二：滑动窗口
     */
    public int[] decrypt_2(int[] code, int k) {
        int n = code.length;
        if (k == 0) {
            return new int[n];
        }

        int[] res = new int[n];
        int[] newCode = new int[n * 2];
        System.arraycopy(code, 0, newCode, 0, n);
        System.arraycopy(code, 0, newCode, n, n);
        code = newCode;
        int l = k > 0 ? 1 : n + k;
        int r = k > 0 ? k : n - 1;
        int w = 0;
        for (int i = l; i <= r; i++) {
            w += code[i];
        }
        for (int i = 0; i < n; i++) {
            res[i] = w;
            w -= code[l];
            w += code[r + 1];
            l++;
            r++;
        }
        return res;
    }
}
