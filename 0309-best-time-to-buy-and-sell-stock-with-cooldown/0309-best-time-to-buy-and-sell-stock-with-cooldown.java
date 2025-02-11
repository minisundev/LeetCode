class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;

        int[] hold = new int[n];
        int[] sold = new int[n];
        int[] rest = new int[n];

        hold[0] = -prices[0]; //첫날부터 매수해버림~
        sold[0] = 0;
        rest[0] = 0;

        //매수 => hold => 매도 => sold => 1일존버 => rest => 매수
        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], rest[i - 1] - prices[i]);
            //hold[i - 1] : 계속 보유하는 경우
            //rest[i - 1] - prices[i] : 새로 사는 경우
            sold[i] = hold[i - 1] + prices[i];
            //이번에 파는 경우
            rest[i] = Math.max(rest[i - 1], sold[i - 1]);
            //rest[i - 1] : 계속 쉰다
            //sold[i - 1] : 저번에 팔았으면 쿨다운 끝나서 여기로 이동
        }

        return Math.max(sold[n - 1], rest[n - 1]);
    }
}
