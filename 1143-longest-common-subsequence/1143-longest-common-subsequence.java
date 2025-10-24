class Solution {
    public int longestCommonSubsequence(String w1, String w2) {
        int n = w1.length();
        int m = w2.length();

        int [][] dp = new int [n][m];
        
        if(w1.charAt(0)==w2.charAt(0)){
            dp[0][0] = 1;
        }

        // 처음 초기화(y==0)
        for(int i=1; i<n; i++){
            if(w1.charAt(i)==w2.charAt(0)){
		        dp[i][0] = 1;//dp[i][0] = dp[i-1][0] + 1;
            }else{
                dp[i][0] = dp[i-1][0];
            }
        }

        // 처음 초기화(x==0)
        for(int j=1; j<m; j++){
            if(w1.charAt(0)==w2.charAt(j)){
		        dp[0][j] = 1; //dp[0][j] = dp[0][j-1] + 1;
            }else{
                dp[0][j] = dp[0][j-1];
            }
        }

        // 나중(x==i) dp update
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(w1.charAt(i)==w2.charAt(j)){
		            dp[i][j] = dp[i-1][j-1] + 1;//이건 왜 대각선으로 해야하는거고
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);//이건 또 왜 내가 쓴대로고
                }
            }
        }
        
        return dp[n-1][m-1];
    }
}