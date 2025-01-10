class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int [] left = new int [prices.length];//min
        int [] dp = new int [prices.length];
        int [] right = new int [prices.length];//max
        //앞에서부터 판 수익이랑 뒤에서부터 판 수익이랑 더했을때 최고값 나오는거 구하면 되지 않을까 싶음!

        //왼쪽부터 여태까지 가장 작았던 것 기록
        // -> 으로 일단 한 번 돌렸을때의 최댓값을 구함

        //오른쪽부터 여태까지 가장 큰 것 기록
        //을 합하던가... 왼쪽수익만으로 비교하던가... 해서 MAX값을 찾아서 돌려보내면 되지 않을까요 ㅎ
        left[0] = prices[0];//min
        dp[0] = 0;
        for(int i=1;i<prices.length;i++){
            left[i] = Math.min(prices[i],left[i-1]);
            dp[i] = Math.max(dp[i-1],prices[i]-left[i-1]);
            if(max<dp[i]){
                max = dp[i];
                //System.out.println(i+":"+max);
            }
        }

        //두번돌렸을때의 최댓값도 비교해야 함... 
        right[prices.length-1] = prices[prices.length-1];//max
        for(int i=prices.length-2;i>=1;i--){
            right[i] = Math.max(prices[i],right[i+1]);
            if(max<dp[i-1]+right[i+1]-prices[i]){
                max = dp[i-1]+right[i+1]-prices[i];
                //System.out.println(i+":"+(dp[i-1])+"+"+(right[i+1]-prices[i]));
            }
        }
        
        return max;
    }
}