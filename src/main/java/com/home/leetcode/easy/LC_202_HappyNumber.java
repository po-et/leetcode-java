package com.home.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 *
 * Write an algorithm to determine if a number n is "happy".
 *
 * @see <a href = "https://leetcode.cn/problems/happy-number/" />
 * @author Poet
 * @date 2020/4/18
 */
public class LC_202_HappyNumber {

    public static void main(String[] args) {
        LC_202_HappyNumber solution = new LC_202_HappyNumber();
//        int n = 19;
        int n = 7;
        System.out.println(solution.isHappy(n));
    }

    public boolean isHappy(int n) {
        n = Math.abs(n);
        Set<Integer> record = new HashSet<>();

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
            sum = sum + digit * digit;
        }

        return sum;
    }


}
