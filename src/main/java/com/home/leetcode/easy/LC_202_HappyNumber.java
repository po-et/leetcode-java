package com.home.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. Happy Number (快乐数)
 *
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is a number defined by the following process:
 *     - Starting with any positive integer, replace the number by the sum of the squares of its digits.
 *     - Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 *           Those numbers for which this process ends in 1 are happy.
 *     - Return true if n is a happy number, and false if not.
 *
 * Example 1:
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * Example 2:
 * Input: n = 2
 * Output: false
 *
 * @see <a href="https://leetcode.cn/problems/happy-number/" />
 * @author Poet
 * @date 2020/4/18
 */
public class LC_202_HappyNumber {

    /**
     * 方法一：用哈希集合检测循环
     */
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        n = Math.abs(n);
        int sum = n;
        while (true) {
            sum = sumSquare(sum);
            if (sum == 1) {
                return true;
            }
            if (record.contains(sum)) {
                return false;
            }
            record.add(sum);
        }
    }

    public int sumSquare(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            n = n / 10;
            sum += digit * digit;
        }
        return sum;
    }


    /**
     * 方法二：快慢指针法
     */
    public boolean isHappy_2(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && fastRunner != slowRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }

    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }



    public static void main(String[] args) {
        LC_202_HappyNumber solution = new LC_202_HappyNumber();
        System.out.println(solution.isHappy(7));
        System.out.println(solution.isHappy(19));
    }

}
