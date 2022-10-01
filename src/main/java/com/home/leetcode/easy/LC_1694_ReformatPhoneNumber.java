package com.home.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 1694. Reformat Phone Number (重新格式化电话号码)
 *
 * You are given a phone number as a string number. number consists of digits, spaces ' ', and/or dashes '-'.
 *
 * You would like to reformat the phone number in a certain manner. Firstly, remove all spaces and dashes. Then, group the digits from left to right into blocks of length 3 until there are 4 or fewer digits. The final digits are then grouped as follows:
 *
 * 2 digits: A single block of length 2.
 * 3 digits: A single block of length 3.
 * 4 digits: Two blocks of length 2 each.
 * The blocks are then joined by dashes. Notice that the reformatting process should never produce any blocks of length 1 and produce at most two blocks of length 2.
 *
 * Return the phone number after formatting.
 *
 * Example 1:
 * Input: number = "1-23-45 6"
 * Output: "123-456"
 * Explanation: The digits are "123456".
 * Step 1: There are more than 4 digits, so group the next 3 digits. The 1st block is "123".
 * Step 2: There are 3 digits remaining, so put them in a single block of length 3. The 2nd block is "456".
 * Joining the blocks gives "123-456".
 *
 * Example 2:
 * Input: number = "123 4-567"
 * Output: "123-45-67"
 * Explanation: The digits are "1234567".
 * Step 1: There are more than 4 digits, so group the next 3 digits. The 1st block is "123".
 * Step 2: There are 4 digits left, so split them into two blocks of length 2. The blocks are "45" and "67".
 * Joining the blocks gives "123-45-67".
 *
 * Example 3:
 * Input: number = "123 4-5678"
 * Output: "123-456-78"
 * Explanation: The digits are "12345678".
 * Step 1: The 1st block is "123".
 * Step 2: The 2nd block is "456".
 * Step 3: There are 2 digits left, so put them in a single block of length 2. The 3rd block is "78".
 * Joining the blocks gives "123-456-78".
 *
 * @see <a href="https://leetcode.cn/problems/reformat-phone-number/" />
 * @author Poet
 * @date 2022/10/1
 */
public class LC_1694_ReformatPhoneNumber {

    // 自己完成的
    public String reformatNumber(String number) {
        number = number.replaceAll(" ", "").replaceAll("-", "");
        int n = number.length();

        int remain = 0;
        if (n % 3 == 0) {
            remain = 3;
        } else if (n % 3 == 1) {
            remain = 4;
        } else if (n % 3 == 2) {
            remain = 2;
        }

        int size = n - remain;
        List<String> list = new ArrayList<>();

        for (int i = 0; i < size; ) {
            list.add(number.substring(i, i + 3));
            i += 3;
        }

        if (remain == 4) {
            list.add(number.substring(n - 4, n - 2));
            list.add(number.substring(n - 2));
        } else {
            list.add(number.substring(n - remain));
        }

//        return list.stream().collect(Collectors.joining("-"));
        return String.join("-", list);
    }


    /**
     * 方法一：找出所有的数字并分块
     *
     * time:  O(n)
     * space: O(n)
     */
    public String reformatNumber_1(String number) {
        StringBuilder digits = new StringBuilder();
        for (int i = 0; i < number.length(); ++i) {
            char ch = number.charAt(i);
            if (Character.isDigit(ch)) {
                digits.append(ch);
            }
        }

        int n = digits.length();
        int pt = 0;
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            if (n > 4) {
                res.append(digits.substring(pt, pt + 3) + "-");
                pt += 3;
                n -= 3;
            } else {
                if (n == 4) {
                    res.append(digits.substring(pt, pt + 2) + "-" + digits.substring(pt + 2, pt + 4));
                } else {
                    res.append(digits.substring(pt, pt + n));
                }
                break;
            }
        }
        return res.toString();
    }
}
