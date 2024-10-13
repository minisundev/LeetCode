class Solution {
    boolean [] dp ;
    int [] arr;
    public boolean canJump(int[] nums) {
        dp = new boolean[nums.length];
        dp[0] = true;
        arr = nums;

        for(int i=1; i<nums.length; i++){
            int num = nums[i];
            
            for(int j=i-1; j>=0 ; j--){//조금 빨라졌지만 아직도 느리다
                if(dp[i]){
                    break;
                }
                int jump = nums[j];
                if(j+jump>=i){
                    dp[i] = dp[i]||dp[j];
                }
                if(dp[i]){
                    break;
                }
            }
        }
        return dp[nums.length-1];
    }
}