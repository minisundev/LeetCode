class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }

        if(sum%2!=0){
            return false;
        }

        int N = nums.length;
        int S = sum/2;

        boolean[][] dp = new boolean[N + 1][S + 1];

        for (int i = 0; i <= N; i++) {
            dp[i][0] = true;//공집합
        }

        for (int i = 1; i <= N; i++) {
            for (int s = 1; s <= S; s++) {
                // 현재 원소를 포함하지 않는 경우
                dp[i][s] = dp[i-1][s];

                // 현재 원소를 포함하는 경우
                if (s >= nums[i-1]) {
                    dp[i][s] = dp[i][s] || dp[i-1][s - nums[i-1]];
                }
            }
        }

        return dp[N][S];
    }
    
}