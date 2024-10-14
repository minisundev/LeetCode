class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        if(nums.length==3){
            return Math.max(Math.max(nums[0],nums[1]),nums[2]);
        }
        
        int [] dp = new int [nums.length];
        
        //0을 포함하는 경우
        dp[0] = nums[0];
        dp[1] = /*nums[1];*/ Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length-1; i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
            //System.out.println("0포함 "+i +" : "+dp[i]);
        }
        int maxWithZero = dp[nums.length-2];
        
        //0을 포함하지 않는 경우
        dp[0] = 0;
        dp[1] = nums[1];
        dp[2] = /*nums[2];*/ Math.max(nums[1], nums[2]);
        for(int i=3; i<nums.length; i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
            //System.out.println("0제외 "+i +" : "+dp[i]);
        }
        int maxWithOutZero = dp[nums.length-1];
        
       // System.out.println(maxWithZero+","+maxWithOutZero);
        
        return Math.max(maxWithZero,maxWithOutZero);
    }
}