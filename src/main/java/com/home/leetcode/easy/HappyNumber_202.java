package com.home.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number n is "happy".
 *
 * @see <a href = "https://leetcode.com/problems/happy-number/" />
 * @author Poet
 * @date 2020/4/18
 */
public class HappyNumber_202 {

    public static void main(String[] args) {
        HappyNumber_202 solution = new HappyNumber_202();
//        int n = 19;
        int n = 7;
        System.out.println(solution.isHappy(n));
    }

    public boolean isHappy(int n) {
        n = Math.abs(n);
        Set<Integer> record = new HashSet<>();

        int sum = n;

        while(true){
            sum = sumSquare(sum);
            if(sum == 1) {
                return true;
            }
            if (record.contains(sum)) {
                return false;
            }
            record.add(sum);
        }
    }

    public int sumSquare(int n) {
        int sum = 0 ;
        while (n > 0) {
            int digit = n % 10;
            n = n/10;
            sum = sum + digit * digit;
        }

        return sum;
    }


}
