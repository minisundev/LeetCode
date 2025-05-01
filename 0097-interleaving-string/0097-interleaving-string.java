class Solution {

    boolean[][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() == 0)
            return true;

        // 나는 String dp가 제일 어렵다고 생각해..
        if (s1.equals("") || s1 == null) {
            if (s2.equals(s3))
                return true;
            return false;
        }
        if (s2.equals("") || s2 == null) {
            if (s1.equals(s3))
                return true;
            return false;
        }

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        // 매 칸을 채울때마다 선택지가 있어 s1에서 고를것이냐 s2에서 고를것이냐
        // 둘 중 무엇을 골라도 s3가 될 수 없으면 망한 분기점인거라 return false
        dp = new boolean[s1.length() + 1][s2.length() + 1]; // State를 dp화 함

        dp[0][0] = true;
        // 첫 행 초기화 (s2만 사용)
        for (int j = 1; j <= s2.length(); j++) {
            if (s2.charAt(j - 1) == s3.charAt(j - 1)) {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // 첫 열 초기화 (s1만 사용)
        for (int i = 1; i <= s1.length(); i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = dp[i - 1][0];
            }
        }

        if (s1.length() > 0 && s1.charAt(0) == s3.charAt(0)) {
            dp[1][0] = true;
        }
        if (s2.length() > 0 && s2.charAt(0) == s3.charAt(0)) {
            dp[0][1] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                    if (dp[i][j] && i + j == s3.length()) {
                        return true;
                    }
                }
                if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                    if (dp[i][j] && i + j == s3.length()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}