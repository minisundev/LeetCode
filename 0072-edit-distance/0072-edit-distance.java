class Solution {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] dp = new int[m + 1][n + 1];
        
        // 초기화하기
        for(int i = 0; i <= m; i++){
            dp[i][0] = i;
        }
        for(int j = 0; j <= n; j++){
            dp[0][j] = j;
        }
        
        //dp로 확산시키기
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    //글자 같으면 대각선 그대로(교체 일어나지 않음)
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    //글자 다르면: 3가지 중 최소 + 1
                    int min = Math.min(dp[i][j-1],dp[i-1][j]);//삽입, 삭제 중 최소
                    min = Math.min(min,dp[i-1][j-1]);//교체
                    dp[i][j] = min+1;
                }
            }
        }
        
        return dp[m][n];
    }
}