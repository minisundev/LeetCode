class Solution {

    public int countSubstrings(String s) {
        //이걸 dp로 효율을 개선해보자... -> memoization
        int count = 0;
        int n = s.length();
       boolean [][] dp = new boolean [n][n];//from[],to[] -> 되면 1 안 되면 -1 계산 안 했으면 0

       // 한 글자짜리 문자열은 항상 palindrome
        for (int i = 0; i<n; i++) {
            dp[i][i] = true;
            count++;
        }

        // 두 글자짜리 문자열 처리
        for (int i = 0; i<n-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                count++;
            }
        }

        for(int size=3; size<=n; size++){
            for(int start=0;start+size<=n;start++){
                int end = start+size-1;
                if(s.charAt(start)==s.charAt(end) && dp[start+1][end-1]){
                    dp[start][end] = true;
                    count++;
                }
            }
        }

        return count;
    }

    // int ifPalindrome(String s,int start, int end){
    //     if(start>=end){
    //         return 1;
    //     }

    //     int memoization = memo[start][end];

    //     if(memoization==1){
    //         return 1;
    //     }else if(memoization==-1){
    //         return -1;
    //     }else{//memoization==0
    //         if(s.charAt(start)!=s.charAt(end)){
    //             memo[start][end] = -1;
    //             return -1;
    //         }else{
    //             memo[start][end] = ifPalindrome(s,start+1,end-1);
    //             return memo[start][end];
    //         }
    //     }
    // }
}