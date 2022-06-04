package com.home.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 929. Unique Email Addresses
 *
 * Given an array of strings emails where we send one email to each emails[i], return the number of different addresses that actually receive mails.
 *
 * Example 1:
 * Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * Output: 2
 * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails.
 *
 * Example 2:
 * Input: emails = ["a@leetcode.com","b@leetcode.com","c@leetcode.com"]
 * Output: 3
 *
 *
 * @see <a href="https://leetcode.cn/problems/unique-email-addresses/" />
 * @author poet
 * @date 2022/6/4
 */
public class LC_929_UniqueEmailAddresses {

    /**
     * 方法一：哈希表
     *
     * time:  O(L) 其中 L 是 emails 中字符串的长度之和
     * space: O(L)
     */
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();

        for (String email : emails) {
            int i = email.indexOf("@");

            String emailName = email.substring(0, i).split("\\+")[0];   // 去掉本地名第一个加号之后的部分
            emailName = emailName.replace(".", "");         // 去掉本地名中所有的句点

            emailSet.add(emailName + email.substring(i));
        }

        return emailSet.size();
    }
}
