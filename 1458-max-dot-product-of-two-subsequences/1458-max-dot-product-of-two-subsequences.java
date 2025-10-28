class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        //a의 무엇 하나와 b의 무엇 하나를 곱한 것들을 선택적으로 택해서 max의 합을 만들면 되는것입니다
        //한 원소는 한번만 사용되어야 합니다...
        int n = nums1.length;
        int m = nums2.length;

        int [][] dp = new int [n][m];

        //초기화
        dp[0][0] = nums1[0]*nums2[0];

        for(int j=1;j<m;j++){
            //왜냐면 j번째를 안 쓰고 (j-1)까지의 최댓값을 가져올 수도 있으니까!
            dp[0][j] = Math.max(dp[0][j-1],nums1[0]*nums2[j]);
        }

        for(int i=1;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0],nums1[i]*nums2[0]);
        }

        //이제 착착 계산해보기~행별로 밑으로 가야함?
        for(int i=1; i<n; i++){
            for(int j=1;j<m;j++){
                int cross = nums1[i]*nums2[j];//이정도면 복붙을 하면 안된다 nums1[0]=>nums1[i]로 바꿈 ㅎㅎ...
                int max = Math.max(dp[i-1][j],dp[i][j-1]);
                max = Math.max(max,dp[i-1][j-1]+cross); 
                max = Math.max(max,cross); 
                dp[i][j] = max;
            }
        }

        return dp[n-1][m-1];
    }
}