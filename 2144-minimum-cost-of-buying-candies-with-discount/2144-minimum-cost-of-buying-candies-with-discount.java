class Solution {
    public int minimumCost(int[] cost) {
        //2개를 사면 3개째는 공짜로 줌
        //2개중 같거나 작은 가격=> 을 고를 수가 있음 3번째 캔디는
        //그러면 걍 그리디로 제일 큰거부터 골라서 포함시키면 도지 않아 정렬해가지고?
        int answer = 0;

        Arrays.sort(cost);
        //That will work fine with 'Array of Objects' such as Integer array but will not work with a primitive array such as int array.
        //아 갑자기 풀기도 싫고 ㅎ 하....
        int idx = 0;
        for(int i=cost.length-1; i>=0; i--){
            if(idx==2){
                idx = -1;
            }else{
                System.out.println(cost[i]);
                answer += cost[i];
            }
            idx++;
        }

        return answer;

    }
}