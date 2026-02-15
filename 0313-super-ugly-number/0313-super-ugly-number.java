class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {

        long[] dp = new long[n];
        dp[0] = 1;

        int[] idx = new int[primes.length]; 

        for(int i = 1; i < n; i++) {

            long min = Long.MAX_VALUE;

            for(int j = 0; j < primes.length; j++) {
                long candidate = primes[j] * dp[idx[j]];
                min = Math.min(min, candidate);
            }

            dp[i] = min;

            for(int j = 0; j < primes.length; j++) {
                if(primes[j] * dp[idx[j]] == min) {
                    idx[j]++;
                }
            }
        }

        return (int)dp[n-1];
    }
}
