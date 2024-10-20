class Solution {
    public int numWays(int n, int k) {
        //일단 3칸 전은 안되니까 1칸전, 2칸전으로 dp를 하면 되겠네
        if(n==1){return k;}

        int [] dp = new int[n];
        
        dp[0] = k;
        dp[1] = k*k;

        for(int i=2 ; i<n; i++){
            dp[i] = (dp[i-1]+dp[i-2])*(k-1);
        }

        return dp[n-1];
    }
}    