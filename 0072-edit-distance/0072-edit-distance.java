class Solution {
    public int minDistance(String word1, String word2) {
        //이것도 대가리 깨지는데 더 빠른 풀이가 있음
        int m = word1.length();
        int n = word2.length();

        //초기화
        int[][] dp = new int[m + 1][n + 1];

        //max값 세팅
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;  //word1의 첫 i문자 삭제
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;  //word2의 첫 j문자 삽입
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];  
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1,//대체
                               Math.min(dp[i][j - 1] + 1,//삽입
                                        dp[i - 1][j] + 1));//삭제
                }
            }
        }

        return dp[m][n];
    }
}