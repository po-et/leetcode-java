package com.home.leetcode.easy;

/**
 * 1108. Defanging an IP Address
 *
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 *
 * A defanged IP address replaces every period "." with "[.]".
 *
 * Example 1:
 * Input: address = "1.1.1.1"
 * Output: "1[.]1[.]1[.]1"
 *
 * Example 2:
 * Input: address = "255.100.50.0"
 * Output: "255[.]100[.]50[.]0"
 *
 * @see <a href="https://leetcode.cn/problems/defanging-an-ip-address/" />
 * @author Poet
 * @date 2022/6/21
 */
public class LC_1108_DefangingAnIPAddress {

    public String defangIPaddr(String address) {
        StringBuilder res = new StringBuilder();
        for (char ch : address.toCharArray()) {
            if (ch == '.') {
                res.append("[.]");
            } else {
                res.append(ch);
            }
        }
        return res.toString();
    }


    /**
     * 正则简化版本
     *
     * time:  O(n) 其中 n 为字符串 s 的长度。需要遍历一遍字符串即可。
     * space: O(1) 除返回值外，不需要额外的存储空间。
     */
    public String defangIPaddr_simplify(String address) {
        return address.replace(".", "[.]");
    }

}
