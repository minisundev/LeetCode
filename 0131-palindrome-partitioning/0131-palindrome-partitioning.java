import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> list;
    int n;
    boolean[][] dp;

    public List<List<String>> partition(String s) {
        n = s.length();
        dp = new boolean[n][n];
        list = new ArrayList<>();

        // DP 테이블 초기화: i가 시작, j가 끝
        for (int i = 0; i < n; i++) {
            dp[i][i] = true; // 길이가 1인 것은 모두 팰린드롬
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1)); // 길이가 2인 경우
        }
        
        // 길이가 3 이상인 경우 체크
        for (int length = 3; length <= n; length++) {
            for (int start = 0; start <= n - length; start++) {
                int end = start + length - 1;
                // 두 문자 끝이 같은가 체크
                dp[start][end] = (s.charAt(start) == s.charAt(end)) && dp[start + 1][end - 1];
            }
        }

        // DFS를 통해 가능한 조합 생성
        dfs(new ArrayList<>(), 0, s);
        return list;
    }

    void dfs(List<String> element, int start, String s) {
        // 모든 문자 사용시 조합 추가
        if (start == n) {
            list.add(new ArrayList<>(element));
            return;
        }

        for (int end = start; end < n; end++) {
            // 부분 문자열이 팰린드롬인지 확인
            if (dp[start][end]) {
                element.add(s.substring(start, end + 1)); // 부분 문자열 추가
                dfs(element, end + 1, s); // 다음 문자로 이동
                element.remove(element.size() - 1); // 마지막 요소 제거
            }
        }
    }
}
