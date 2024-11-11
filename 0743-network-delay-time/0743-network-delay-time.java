class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // n nodes
        // k 시작 노드
        // times: source,target,cost

        Map<Integer,List<Node>> map = new HashMap<>();
        for(int [] i : times){
            int start = i[0]-1;
            int end = i[1]-1;
            int cost = i[2];
            List<Node> list = map.getOrDefault(start,new ArrayList<>());
            list.add(new Node(end,cost));
            map.put(start,list);
        }

        int [] dp = new int [n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
        dp[k-1] = 0;
        pq.add(new Node(k-1,0));

        while(!pq.isEmpty()){
            Node now = pq.poll();
            List<Node> list = map.getOrDefault(now.destination,new ArrayList<>());
            for(Node next : list){
                if(dp[now.destination]!=Integer.MAX_VALUE && dp[next.destination]>dp[now.destination]+next.cost){
                    dp[next.destination] = dp[now.destination]+next.cost;
                    pq.add(new Node(next.destination,dp[next.destination]));
                }
            }
        }

        int max = 0;
        for(int cost : dp){
            if(cost==Integer.MAX_VALUE){
                return -1;
            }
            max = Math.max(cost,max);
        }

        return max;
    }
}

class Node{
    public int destination;
    public int cost;
    public Node(int d, int c){
        destination=d;
        cost=c;
    }
}