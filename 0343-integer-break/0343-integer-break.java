class Solution {
    int[] dp;//1,n 1+1,n-1 등을 곱해서 만들 수 있는 최대숫자

    public int integerBreak(int n) {
        //무언가를 쪼개서 만들 수 있는 맥시멈으로 곱해가지고 최대의 값을 만들면 된다고 한다~~
        dp = new int[n + 1];
        dp[0] = -1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            divide(i);
        }

        int max = 0;
        for(int i=1; i<=n/2; i++){
            max = Math.max(max, dp[n-i]*dp[i]);
        }
        return max;
    }

    void divide(int n) {
        System.out.println("divide " + n);
        dp[n] = Math.max(dp[n],n);
        for (int i = 1; i <= n/2+1; i++) {
            if (dp[i] == 0) {
                divide(i);
            }
            if (dp[n - i] == 0) {
                divide(i);
            }

            if(dp[i] * dp[n - i]>dp[n]){
                dp[n] =  dp[i] * dp[n - i];
                //System.out.println("dp[" + n + "] update at " + i +"*"+(n-i)+" to "+ dp[n]);
            }
        }
        //System.out.println("dp[" + n + "]" + dp[n]);
    }
}