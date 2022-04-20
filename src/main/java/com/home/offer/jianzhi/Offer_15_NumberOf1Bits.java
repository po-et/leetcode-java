package com.home.offer.jianzhi;

/**
 * 面试题15. 二进制中1的个数
 *
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 * 示例 1：
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 *
 * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
 * @author Poet
 * @date 2020/5/27
 */
public class Offer_15_NumberOf1Bits {

    public int hammingWeight(int n) {
        String str = convertBinary(n);
        int ret = 0;
        for (char ch : str.toCharArray()) {
            if(ch == '1')
                ret++;
        }
        return ret;
    }


    // 转化为二进制
    public static String convertBinary(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n = n >> 1;
        }
        return sb.reverse().toString();
    }



    // 使用位于运算
    public int hammingWeight2(int n) {
        int ret = 0;
        while (n != 0) {
            ret += n & 1;
            n = n >>> 1;  // 无符合右移
        }
        return ret ;
    }



    public static void main(String[] args) {
        System.out.println(convertBinary(1));
        System.out.println(convertBinary(8));
//        System.out.println(convertBinary(4294967293L));
    }
}
