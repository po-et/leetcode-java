package com.home.leetcode.easy;

/**
 * 2299. Strong Password Checker II （强密码检验器 II）
 *
 * A password is said to be strong if it satisfies all the following criteria:
 *   - It has at least 8 characters.
 *   - It contains at least one lowercase letter.
 *   - It contains at least one uppercase letter.
 *   - It contains at least one digit.
 *   - It contains at least one special character. The special characters are the characters in the following string: "!@#$%^&*()-+".
 *   - It does not contain 2 of the same character in adjacent positions (i.e., "aab" violates this condition, but "aba" does not).
 *
 * Given a string password, return true if it is a strong password. Otherwise, return false.
 *
 *
 * Example 1:
 * Input: password = "IloveLe3tcode!"
 * Output: true
 * Explanation: The password meets all the requirements. Therefore, we return true.
 *
 * Example 2:
 * Input: password = "Me+You--IsMyDream"
 * Output: false
 * Explanation: The password does not contain a digit and also contains 2 of the same character in adjacent positions. Therefore, we return false.
 *
 * Example 3:
 * Input: password = "1aB!"
 * Output: false
 * Explanation: The password does not meet the length requirement. Therefore, we return false.
 *
 * @see <a href="https://leetcode.cn/problems/strong-password-checker-ii/" />
 * @author Poet
 * @date 2023/1/19
 */
public class LC_2299_StrongPasswordChecker_II {

    /**
     * 方法一：模拟
     */
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        boolean notContain2Same = true;

        String specialString = "!@#$%^&*()-+";

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (specialString.contains(String.valueOf(ch))) {
                hasSpecial = true;
            }

            if (i+1 < password.length() && ch == password.charAt(i + 1)) {
                notContain2Same = false;
            }
        }

        return hasLower && hasUpper && hasDigit && hasSpecial && notContain2Same;
    }
}
