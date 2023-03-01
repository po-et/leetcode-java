package com.home.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 1797. Design Authentication Manager （设计一个验证系统）
 *
 * There is an authentication system that works with authentication tokens. For each session, the user will receive a new authentication token that will expire timeToLive seconds after the currentTime. If the token is renewed, the expiry time will be extended to expire timeToLive seconds after the (potentially different) currentTime.
 *
 * Implement the AuthenticationManager class:
 *
 * AuthenticationManager(int timeToLive) constructs the AuthenticationManager and sets the timeToLive.
 * generate(string tokenId, int currentTime) generates a new token with the given tokenId at the given currentTime in seconds.
 * renew(string tokenId, int currentTime) renews the unexpired token with the given tokenId at the given currentTime in seconds. If there are no unexpired tokens with the given tokenId, the request is ignored, and nothing happens.
 * countUnexpiredTokens(int currentTime) returns the number of unexpired tokens at the given currentTime.
 * Note that if a token expires at time t, and another action happens on time t (renew or countUnexpiredTokens), the expiration takes place before the other actions.
 *
 * Example 1:
 * Input
 * ["AuthenticationManager", "renew", "generate", "countUnexpiredTokens", "generate", "renew", "renew", "countUnexpiredTokens"]
 * [[5], ["aaa", 1], ["aaa", 2], [6], ["bbb", 7], ["aaa", 8], ["bbb", 10], [15]]
 * Output
 * [null, null, null, 1, null, null, null, 0]
 *
 * Explanation
 * AuthenticationManager authenticationManager = new AuthenticationManager(5); // Constructs the AuthenticationManager with timeToLive = 5 seconds.
 * authenticationManager.renew("aaa", 1); // No token exists with tokenId "aaa" at time 1, so nothing happens.
 * authenticationManager.generate("aaa", 2); // Generates a new token with tokenId "aaa" at time 2.
 * authenticationManager.countUnexpiredTokens(6); // The token with tokenId "aaa" is the only unexpired one at time 6, so return 1.
 * authenticationManager.generate("bbb", 7); // Generates a new token with tokenId "bbb" at time 7.
 * authenticationManager.renew("aaa", 8); // The token with tokenId "aaa" expired at time 7, and 8 >= 7, so at time 8 the renew request is ignored, and nothing happens.
 * authenticationManager.renew("bbb", 10); // The token with tokenId "bbb" is unexpired at time 10, so the renew request is fulfilled and now the token will expire at time 15.
 * authenticationManager.countUnexpiredTokens(15); // The token with tokenId "bbb" expires at time 15, and the token with tokenId "aaa" expired at time 7, so currently no token is unexpired, so return 0.
 *
 * @see <a href="https://leetcode.cn/problems/design-authentication-manager/" />
 * @author Poet
 * @date 2023/2/9
 */
public class LC_1797_DesignAuthenticationManager {

    /**
     * 方法一：哈希表
     *
     * time:  构造函数：O(1)，generate：O(1)，renew：O(1)，countUnexpiredTokens：O(n)，其中 n 为 generate 的调用次数
     * space: O(n)
     */
    class AuthenticationManager {

        private Map<String, Integer> timeMap;
        private Integer timeToLive;

        public AuthenticationManager(int timeToLive) {
            this.timeToLive = timeToLive;
            this.timeMap = new HashMap<>();
        }

        public void generate(String tokenId, int currentTime) {
            if (!timeMap.containsKey(tokenId)) {
                timeMap.put(tokenId, currentTime);
            }
        }

        public void renew(String tokenId, int currentTime) {
            if (timeMap.containsKey(tokenId)) {
                Integer time = timeMap.get(tokenId);
                if (time + timeToLive > currentTime) {
                    timeMap.put(tokenId, currentTime);
                } else {
                    timeMap.remove(tokenId);
                }
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            int res = 0;
            for (String key : timeMap.keySet()) {
                if (timeMap.get(key) + timeToLive > currentTime) {
                    res++;
                }
            }
            return res;
        }
    }

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */

}
