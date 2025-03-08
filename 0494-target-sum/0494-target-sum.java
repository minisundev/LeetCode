class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if (target > sum || target < -sum || (target + sum) % 2 != 0) {
            return 0;
        }
        
        int newTarget = (target + sum) / 2; 
        int[] dp = new int[newTarget + 1];
        dp[0] = 1; 

        for (int num : nums) {
            for (int j = newTarget; j >= num; j--) {
                dp[j] += dp[j - num]; 
            }
        }

        return dp[newTarget]; 
    }
}
