import java.util.*;

class Solution {
    public int change(int amount, int[] coins) {
        int [] dp = new int [amount+1];
        dp[0] = 1;

        for(int coin : coins){
            for(int i=coin; i<dp.length; i++){
                dp[i] = dp[i-coin] + dp[i];//포함?//응 시간초과 나올게~
            }
        }
        
        return dp[amount];
    }
}