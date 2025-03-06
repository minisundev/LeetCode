class Solution {
    public boolean canPartition(int[] nums) {
        // 포함 안 포함의 조합을 dp로 표현하는 문제라고 할 수 있어요...
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0)
            return false;

        Boolean[][] dp = new Boolean[nums.length + 1][sum / 2 + 1];
        dp[0][0] = true;

        for (int index = 1; index <= nums.length; index++) {
            int num = nums[index - 1];
            dp[index][0] = true;

            //System.out.println("num: " + num);
            for (int i = 0; i <= sum / 2; i++) {

                if(dp[index - 1][i]!=null && dp[index-1][i]){
                    dp[index][i] = true;
                }

                if (i - num >= 0 && dp[index - 1][i - num] != null && dp[index - 1][i - num] == true) {
                    dp[index][i] = true;
                }
                if(dp[index][i] != null && dp[index][i]){
                    //System.out.println(index+","+i);
                }
                
                //print(dp, index);

            }
        }

        if (dp[nums.length][sum / 2] != null && dp[nums.length][sum / 2] == true)
            return true;
        return false;
    }

    void print(Boolean[][] dp, int index) {
        StringBuilder sb = new StringBuilder();
        // for (int index = 0; index < dp.length; index++) {
        sb.append("index: ").append(index).append('\n');
        for (int j = 0; j < dp[index].length; j++) {
            sb.append(dp[index][j]).append(' ');

        }
        sb.append('\n');
        // }
        System.out.println(sb);
    }
}
