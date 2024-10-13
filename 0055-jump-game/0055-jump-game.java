class Solution {
    public boolean canJump(int[] nums) {
        //이게ㅐ 어떻게 dp더라....
        boolean [] dp = new boolean[nums.length];
        dp[0] = true;

        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            if(dp[i]){
                for(int j=0; j<=num && i+j<nums.length ;j++){//시간초과가 날 것 같은데요
                //System.out.println(i+"+"+j);
                    dp[i+j] = true;//.이게 아닌거같은데.............
                    //dp[i+j]=dp[i]||dp //점화식이 안 나오는 dp가 어디있음
                }
            }
            
        }

        return dp[nums.length-1];
    }
}