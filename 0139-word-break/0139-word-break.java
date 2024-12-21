class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;  // 빈 문자열은 항상 가능

        // 모든 위치에 대해
        for (int i = 1; i <= n; i++) {
            // 이전 모든 위치에서 현재 위치까지 단어가 있는지 확인
            for (String word : wordDict) {
                int len = word.length();
                if (len <= i) {
                    // 이전 위치까지 분할 가능하고, 현재 부분이 사전에 있는 단어인 경우
                    if (dp[i - len] && s.substring(i - len, i).equals(word)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        
        return dp[n];
    }
}