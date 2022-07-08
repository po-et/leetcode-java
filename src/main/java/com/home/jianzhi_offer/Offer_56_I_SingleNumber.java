package com.home.jianzhi_offer;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 *
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * 示例 1：
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 *
 * 示例 2：
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 * @see <a href="https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/" />
 * @author Poet
 * @date 2022/7/5
 */
public class Offer_56_I_SingleNumber {

    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret ^= num;//ret最终答案就是那两个只出现一次的的数异或的结果
        }

        //找到ret二进制数中第几位是1
        int target = 1; //初始位0001
        while ((target & ret) == 0) {//如果target第一个二进制位不为1，就将target左移一位位0010，然后与相与，判断ret第二位是否为一.按此循环，知道找到ret的第一个为1的二进制位
            target = target << 1;
        }

        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & target) == 0) {//第一组
                a ^= num;
            } else {//第二组
                b ^= num;
            }
        }
        return new int[]{a, b};
    }

}
