class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        //state 정의 : hold => sold => hold2 => rest
        //int [] hold = new int [prices.length];
        //int [] sold = new int [prices.length];
        //int [] hold2 = new int [prices.length];

        int hold = -prices[0];//처음에 사버려~~~
        int sold = 0;
        int hold2 = Integer.MIN_VALUE;
        for(int i=1;i<prices.length;i++){
            hold = Math.max(hold,-prices[i]);//더 작으면 새로 삼
            sold = Math.max(prices[i]+hold,sold);
            hold2 = Math.max(hold2,sold-prices[i]);
            max = Math.max(sold,Math.max(max,hold2+prices[i]));

            //System.out.println("i: "+i+" hold:"+hold+" sold:"+sold+" hold2: "+hold2+" max:"+max);
        }
        
        return max;
    }
}