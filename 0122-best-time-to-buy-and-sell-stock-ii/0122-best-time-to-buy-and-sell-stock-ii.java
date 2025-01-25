class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        //int [] min = new int [prices.length];
        int min = prices[0];
        
        for(int i=1;i<prices.length;i++){
            //근데 지금 보니까 내릴때마다 무조건 사고 오를때마다 무조건 파는게 최대수익이 나와 단타로
            //더 홀딩했다가 파는것도 의미없는게 계속 오르는 중일때도 무조건 팔고 거기서 또 매수해서 더 올랐을때 또 무조건 팔면 되는거라 그냥 내리면 사고 오르면 팔면 최대수익임
            //내려가는동안 내려가는것의 최저를 dp에 기록 -> 올라가면 팔면서 매입하고 또 팔기
            if(min>prices[i]){
                min = prices[i];
            }else{
                maxProfit += prices[i]-min;
                min = prices[i];
            }
        }
        return maxProfit;
    }
}