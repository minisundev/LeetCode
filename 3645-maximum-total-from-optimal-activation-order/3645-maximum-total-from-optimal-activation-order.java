class Solution {
    public long maxTotal(int[] value, int[] limit) {
        int n = value.length;
        //지금 active인 수 < limit[i]여야 i를 active가능
        //dp인가?
        //i는 알겠는데 j는 뭔데? 지금 말고 앞의 모든 elements를 순회하는건가봄
        //for문 2번 돌리면 너무 비효율적이지 않나
        //지금 active인 수 >= limit[j]인 애들 다 꺼짐 지금 active여도
        //maximum total을 구해봐라
        //두가지 경우가 있음
        //1. 지금 activate하기
        //2. 지금 activate하지 않기
        //in any order. 인데 dp가 되나...? dp는 앞부터 뒤까지 전파시키는거고
        //그리디인가 싶은게 limit 가장 적은거부터 실행시키는데
        
        //정렬해놓고 오큰수인가
        // Limit을 넘으면 일단 다 꺼지는거고
        //value는 남고 꺼지기만 하는건가?

        //limit 순서대로 고르는거고 같은 limit이 있으면 value가 가장 큰것을 더하는 문제
        //같은 Limit중에 제일 큰거 고르기+중복으로 안 들어가게 체크하기 -> HashMap에다 넣어놓고 계속 업데이트해
        //limit별로 정렬해보기->priorityQueue쓸게 걍
        Map<Integer,PriorityQueue<Integer>> map = new HashMap<>();
        PriorityQueue<Integer> limits = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            int l = limit[i];
            int v = value[i];
            PriorityQueue<Integer> pq = map.getOrDefault(l,null);
            if(pq==null){
                pq = new PriorityQueue<>((o1,o2)->o2-o1);//value가 큰 순서대로
                limits.add(l);
            }
            pq.add(v);
            map.put(l,pq);
        }

        ArrayDeque<Integer> deq = new ArrayDeque<>();
        long total = 0L;
        int maxLimit = 0;

        while(!limits.isEmpty()){
            int l = limits.poll();
            PriorityQueue<Integer> pq = map.get(l);
            //작은 순서대로 하면서 limit을 여태까지 뽑은게 넘었는지 봐봄... 
            //이거 슬라이딩 윈도우랑도 비슷한데
            //limits 안 넘으면 value가 큰 순서대로 activate시킴
            if(l<maxLimit){
                continue;
            }
            while(!pq.isEmpty()){
                int v = pq.poll();
                if(deq.size()<l){
                    total += v; deq.addLast(l);

                    if(l<=deq.size()) pq.clear();
                    
                    while(!deq.isEmpty() && deq.peekFirst()<=deq.size()) deq.pollFirst();
                }
            }
        }

        return total;
    }
}