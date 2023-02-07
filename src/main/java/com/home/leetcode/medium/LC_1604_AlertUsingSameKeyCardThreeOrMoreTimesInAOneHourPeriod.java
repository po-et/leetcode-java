package com.home.leetcode.medium;

import java.util.*;

/**
 * 1604. Alert Using Same Key-Card Three or More Times in a One Hour Period (警告一小时内使用相同员工卡大于等于三次的人)
 *
 * LeetCode company workers use key-cards to unlock office doors. Each time a worker uses their key-card, the security system saves the worker's name and the time when it was used. The system emits an alert if any worker uses the key-card three or more times in a one-hour period.
 *
 * You are given a list of strings keyName and keyTime where [keyName[i], keyTime[i]] corresponds to a person's name and the time when their key-card was used in a single day.
 *
 * Access times are given in the 24-hour time format "HH:MM", such as "23:51" and "09:49".
 *
 * Return a list of unique worker names who received an alert for frequent keycard use. Sort the names in ascending order alphabetically.
 *
 * Notice that "10:00" - "11:00" is considered to be within a one-hour period, while "22:51" - "23:52" is not considered to be within a one-hour period.
 *
 * Example 1:
 * Input: keyName = ["daniel","daniel","daniel","luis","luis","luis","luis"], keyTime = ["10:00","10:40","11:00","09:00","11:00","13:00","15:00"]
 * Output: ["daniel"]
 * Explanation: "daniel" used the keycard 3 times in a one-hour period ("10:00","10:40", "11:00").
 *
 * Example 2:
 * Input: keyName = ["alice","alice","alice","bob","bob","bob","bob"], keyTime = ["12:01","12:00","18:00","21:00","21:20","21:30","23:00"]
 * Output: ["bob"]
 * Explanation: "bob" used the keycard 3 times in a one-hour period ("21:00","21:20", "21:30").
 *
 * @see <a href="https://leetcode.cn/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/" />
 * @author Poet
 * @date 2023/2/7
 */
public class LC_1604_AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod {

    /**
     * 方法一：哈希表 + 排序
     *
     * time:  O(nlogn)
     * space: O(n)
     */
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> keyMap = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            keyMap.putIfAbsent(name, new ArrayList<>());
            int hour = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
            int minute = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
            keyMap.get(name).add(hour * 60 + minute);
        }

        List<String> res = new ArrayList<>();
        for (String name : keyMap.keySet()) {
            List<Integer> list = keyMap.get(name);
            Collections.sort(list);
            for (int i = 2; i < list.size(); i++) {
                int time2 = list.get(i);
                int time1 = list.get(i - 2);
                int diff = time2 - time1;
                if (diff <= 60) {
                    res.add(name);
                    break;
                }
            }
        }

        Collections.sort(res);
        return res;
    }
}
