class Solution {
    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        //이거뭔가 dp느낌인데 뭔가뭔가 풀수있을것만 같은 느낌적인 느낌~
        int n = regular.length;
        long [] cost = new long [n];
        long [] minR = new long [n+1];
        long [] minE = new long [n+1];

        minE[0] = expressCost;
        minR[0] = 0;

        for(int i=1; i<=n; i++){
            //express로 이동하는 경우의 수 + express에 계속 있는 경우의 수
            minE[i] = Math.min(minR[i-1]+regular[i-1]+expressCost, minE[i-1]+express[i-1]);
            //regular으로 이동하는 경우의 수 + regular에 계속 있는 경우의 수
            minR[i] = Math.min(minE[i-1]+express[i-1], minR[i-1]+regular[i-1]);

            //그중 최소인 값을 기록하자
            cost[i-1] = Math.min(minR[i],minE[i]);
        }

        return cost;
    }
}