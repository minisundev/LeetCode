class Solution {

    int target;
    int [] arr;
    boolean result=false;

    public boolean canPartition(int[] nums) {
        //백트래킹으로 풀어보기
        int sum = 0;
        arr = nums;

        for(int i : nums){
            sum += i;
        }

        if(sum%2!=0){
            return false;
        }
        
        int N = nums.length;
        int S = sum/2;

        boolean[] dp = new boolean[S + 1];

        for (int i = 0; i < N; i++) {
            dp[0] = true;//공집합
        }

        for (int i = 1; i < N; i++) {
            for (int s = S; s >= nums[i] ; s--) {//현재 원소를 포함할 수 있는 경우 모두 체크
            dp[s] = dp[s] || dp[s - nums[i]];

            }
        }

        return dp[S];

    }
    
}
            