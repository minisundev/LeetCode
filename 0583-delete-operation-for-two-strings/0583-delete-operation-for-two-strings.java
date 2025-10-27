class Solution {
    public int minDistance(String word1, String word2) {
        //이거 같은거 세는거..대로 해서 긴거에서 전체 길이 빼면 되는거아님?
        int n = word1.length();
        int m = word2.length();

        int [][] dp = new int [n][m];
        //초기화
        if(word1.charAt(0)==word2.charAt(0)){
            dp[0][0]=1;
        }

        if(word1.length()>1){
            for(int i=1; i<n; i++){
                if(word1.charAt(i)==word2.charAt(0)){
                    dp[i][0] = 1;
                }else{
                    dp[i][0] = dp[i-1][0];
                }
            }
        }

        if(word2.length()>1){
            for(int i=1; i<m; i++){
                if(word1.charAt(0)==word2.charAt(i)){
                    dp[0][i] = 1;
                }else{
                    dp[0][i] = dp[0][i-1];
                }
            }
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(word1.charAt(i)==word2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        System.out.println("최대공약수:"+dp[n-1][m-1]);

        return word1.length()+word2.length() - dp[n-1][m-1]*2;
    }
}