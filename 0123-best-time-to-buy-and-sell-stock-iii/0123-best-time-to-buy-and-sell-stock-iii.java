class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        //state 정의 : hold => sold => hold2 => rest
        int [] hold = new int [prices.length];
        int [] sold = new int [prices.length];
        int [] hold2 = new int [prices.length];

        hold[0] = -prices[0];//처음에 사버려~~~
        sold[0] = 0;
        hold2[0] = Integer.MIN_VALUE;
        for(int i=1;i<prices.length;i++){
            hold[i] = Math.max(hold[i-1],-prices[i]);//더 작으면 새로 삼
            sold[i] = Math.max(prices[i]+hold[i-1],sold[i-1]);
            hold2[i] = Math.max(hold2[i-1],sold[i-1]-prices[i]);
            max = Math.max(sold[i],Math.max(max,hold2[i]+prices[i]));

            //System.out.println("i: "+i+" hold:"+hold[i]+" sold:"+sold[i]+" hold2: "+hold2[i]+" max:"+max);
        }
        
        return max;
    }
}