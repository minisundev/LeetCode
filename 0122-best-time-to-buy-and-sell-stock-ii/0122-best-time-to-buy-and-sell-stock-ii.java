class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = prices[0];
        int profit = 0;

        //보다보니까 최대 이익은 그냥 사이가 +가 될때마다 샀다가 팔았다가 할 때 나옴 -> 빗물 채우는 문제랑 비슷한 거 아니냐며   

        for(int i=1; i<prices.length; i++){
            if(prices[i]>min){
                profit+=prices[i]-min;
                min = prices[i];
            }else{
                min = prices[i];
            }
        }
        return profit;
    }
}