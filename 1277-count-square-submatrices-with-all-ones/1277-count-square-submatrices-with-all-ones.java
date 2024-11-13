class Solution {
    public int countSquares(int[][] matrix) {
        //뭔가 누적합 느낌의 문제...
        int count = 0;
        int [][] dp = new int [matrix.length][matrix[0].length];

        for(int i=0; i<dp.length; i++){
            dp[i][0] = matrix[i][0];
            count += dp[i][0];
        }
        for(int j=1; j<dp[0].length; j++){
            dp[0][j] = matrix[0][j];
            count += dp[0][j];
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+matrix[i][j];
                count+=dp[i][j];
                System.out.println(i+","+j+":"+dp[i][j]);
            }
        }

        return count;
    }
}