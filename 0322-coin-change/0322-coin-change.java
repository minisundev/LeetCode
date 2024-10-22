
import java.lang.Math;

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        if(coins.length==1){
            if(amount%coins[0]==0){return amount/coins[0];}
            else{return -1;}
        }

        int [] dp = new int[amount+1];
        dp[0] = 0;

        //dp 초기값 구성
        for(int coin : coins){
            if(coin<=amount){
                dp[coin] = 1;//코인이 1개씩 있는 곳으로부터 시작하지 않을까... 
            }
        }

        //Arrays.sort(coins);
        for(int i=1;i<=amount;i++){
            dp[i] = Integer.MAX_VALUE;
        }


        for(int coin : coins){
            //System.out.println("coin: "+coin);
            for(int a = coin; a<=amount; a++){//knapsack
            //System.out.println("a: "+a);
                if(dp[a-coin]!=Integer.MAX_VALUE){
                    dp[a] = Math.min(dp[a],dp[a-coin]+1);
                }
            }
        }

        if(dp[amount]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[amount];
    }
}