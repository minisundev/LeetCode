class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {

        int [] dp = new int [arr.length+1];
        
        for(int i=0;i<dp.length;i++){
            for(int j=1; j<=k; j++){
                if(i-j>=0){
                    dp[i] = Math.max(dp[i],dp[i-j]+j*findMax(i-j,i-1,arr));
                }
            }
        }
        
        return dp[dp.length-1];

    }

    int findMax(int start, int end, int [] arr){
        int max=0;
        for(int i = start; i<=end; i++){
            max=Math.max(max,arr[i]);
        }
        return max;
    }
}