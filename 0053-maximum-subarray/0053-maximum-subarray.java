import java.lang.Math;

class Solution {
    public int maxSubArray(int[] nums) {
        int [] dp = new int [nums.length];
        int max = nums[0];
        dp[0] = max;
        for(int i=1; i<nums.length; i++){
            dp[i] = Math.max(nums[i],nums[i]+dp[i-1]);
            max = Math.max(max,dp[i]);
            //System.out.println(i+":"+dp[i]);
        }
        return max;
    }
}