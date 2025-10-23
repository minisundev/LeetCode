class Solution {
    double[][][] dp;
    int n;

    public double knightProbability(int n, int k, int row, int column) {
        this.n = n;
        this.dp = new double[k+1][n][n];
        
        for(int i=0; i<=k; i++){
            for(int j=0; j<n; j++){
                Arrays.fill(dp[i][j], -1);//연산 전인것을 표시하기위해 -1로 초기화해봄
            }
        }
        
        double answer = cal(k, row, column);
        double base = Math.pow(8, k);
        return answer / base;
    }

    int[][] dir = {{2,1},{-2,1},{2,-1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2}};

    double cal(int k, int x, int y){
        if(k == 0) return 1;
        
        if(dp[k][x][y] != -1) return dp[k][x][y];
        
        double chance = 0;
        for(int[] d : dir){
            int X = x + d[0];
            int Y = y + d[1];
            if(X >= 0 && X < n && Y >= 0 && Y < n){
                chance += cal(k-1, X, Y);
            }
        }
        
        dp[k][x][y] = chance;
        return chance;
    }
}