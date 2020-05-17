package com.home.leetcode.jianzhi_offer;

/**
 * 找出数组中重复的数字
 *
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，那么对应的输出是重复的数字2或者3。
 *
 * @see <a href="https://www.nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8?tpId=13&tqId=11203&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking" />
 * @author Poet
 * @date 2020/5/17
 */
public class Offer_1_FindDuplication {

    public boolean duplicate(int numbers[], int length, int [] duplication) {
        if(numbers == null || numbers.length == 0 )
            return false;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] >= length) {
                return false;
            }
        }

        int[] stat = new int[length];

        for (int i = 0; i < length; i++) {
            if (stat[numbers[i]] >= 1) {
                duplication[0] = numbers[i];
                return true;
            }
            stat[numbers[i]] ++;
        }

        return false;
    }



    /**
     * <href="https://www.cnblogs.com/yongh/p/9318604.html" />
     * @param arr
     * @return
     */
    public int getDuplicate(int[] arr) {
        if(arr == null || arr.length == 0 )
            throw new IllegalArgumentException("arr is not valid.");

        int len = arr.length;
        int[] stat = new int[len];

        for (int i = 0; i < arr.length; i++) {
            assert (arr[i] >= 0 && arr[i] < len);
            stat[arr[i]]++;
        }

        for (int i = 0; i < stat.length; i++) {
            if (stat[i] > 1) {
                return stat[i];
            }
        }
        return -1;
    }
}
