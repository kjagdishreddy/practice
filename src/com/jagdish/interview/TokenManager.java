package com.jagdish.interview;

import java.util.*;

/*
When users are authenticated, they are given an authentication token.  Unless a token is reset, it expires after a system-wide expiryLimit.  If a reset request is received at or before the expiry time, the expiry time is reset to expiryLimit minutes from the time of reset.

1. An unexpired token_id can be reset any number of times.
2. A reset issued to a non-existent or an expired token_id is ignored.
3. Once a token_id expires it cannot be reused.

Command syntax: [type, token_id, T]
- Create command: Type 0 generates a token with id token_id a time T.  Its expiry is set to T + expiryLimit
- Reset commad: Type 1 resets the expiry to T + expiryLimit

Start with an empty list of tokens,  Perform a sequence of requests sorted ascending by their T parameter.  Find the number of tokens that are active after all commands have been executed, at the maximum T of all requests.

Example
expiryLimit = 4
commands = [[0,1,1], [0,2,2], [1,1,5], [1,2,7]]

The maximum time T = 7, so the analysis will end at T=7. Each time a token is crated or reset, its new expiration time will be at time T+4

Working thru commands

0:[0,1,1]: create token_id = 1 at time T = 1 and set its expiry to T+ expiryLimit =5
1: [0,2,2]: create token_id = 2 with s expiry to T =6
2: [1,1,5]: Reset token_id = 1 at T=5 The time is less than or equal to the expiry limit so a new limit is set 5+4 =9
3: [1,2,7]: Reset token_id=2 at T = 7. The id expires at time  so when the reset token_id =2 command comes in at T =7, it is ignored

only token_id =1 is active at time T=7 return 1


Complete the numberOfToken function (int expiryLimit, List<List<Integer>> commands)

Return iint the number of token that exist at the end of the command stream

The commands array is given sorted ascending by T
 */
public class TokenManager {
    public static int numberOfTokens(int expiryLimit, List<List<Integer>> commands) {
        Map<Integer, Integer> tokenExpiryMap = new HashMap<>();
        int maxT = 0; // Track the maximum time T

        for (List<Integer> command : commands) {
            int type = command.get(0);
            int tokenId = command.get(1);
            int timeT = command.get(2);
            maxT = Math.max(maxT, timeT); // Update maxT

            if (type == 0) { // Create token
                tokenExpiryMap.put(tokenId, timeT + expiryLimit);
            } else if (type == 1) { // Reset token
                if (tokenExpiryMap.containsKey(tokenId) && tokenExpiryMap.get(tokenId) >= timeT) {
                    tokenExpiryMap.put(tokenId, timeT + expiryLimit); // Extend expiry
                }
            }
        }

        // Count active tokens at maxT
        int activeTokens = 0;
        for (int expiryTime : tokenExpiryMap.values()) {
            if (expiryTime > maxT) {
                activeTokens++;
            }
        }
        return activeTokens;
    }

    public static void main(String[] args) {
        int expiryLimit = 4;
        List<List<Integer>> commands = Arrays.asList(
                Arrays.asList(0, 1, 1),
                Arrays.asList(0, 2, 2),
                Arrays.asList(1, 1, 5),
                Arrays.asList(1, 2, 7)
        );

        System.out.println("Active tokens at max T: " + numberOfTokens(expiryLimit, commands));
    }
}