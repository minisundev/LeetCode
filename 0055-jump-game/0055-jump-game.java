class Solution {
    boolean [] dp ;
    int [] arr;
    public boolean canJump(int[] nums) {
        dp = new boolean[nums.length];
        dp[0] = true;
        arr = nums;

        for(int i=1; i<nums.length; i++){
            int num = nums[i];
            
            for(int j=i-1; j>=0 ; j--){//true가 되는 순간 break를 걸면 빠르지 않아?            
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