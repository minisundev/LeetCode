class Solution {
    public int minCost(int[][] costs) {
        int [][] dp = new int [costs.length][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for(int i=1; i<costs.length; i++){

            for(int j=0;j<3;j++){
                dp[i][j] = Math.min(dp[i-1][(j+1)%3],dp[i-1][(j+2)%3])+costs[i][j];
            }
            
        }
        return Math.min(dp[costs.length-1][2],Math.min(dp[costs.length-1][0],dp[costs.length-1][1]));
    }
}