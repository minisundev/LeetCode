class Solution {
    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        int [][] dp = new int [n][m];
        for(int [] i : dp){
            Arrays.fill(i,Integer.MAX_VALUE);
        }

        PriorityQueue<Node> pq = new PriorityQueue<Node>(
            (o1,o2)-> o1.effort-o2.effort//이렇게 하면 안 되고 현재 effort 기준으로 정렬을 해줘야 하지 않나 싶긴 한데...
        );
        dp[0][0]=0;
        pq.add(new Node(0,0,0));

        int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

        while(!pq.isEmpty()){
            Node now = pq.poll();

            for(int [] d : dir){
                int x = now.x+d[0];
                int y = now.y+d[1];

                if(x>=0&&x<n&&y>=0&&y<m){
                    int increament = Math.abs(heights[x][y]-heights[now.x][now.y]);
                    if(dp[x][y]>Math.max(dp[now.x][now.y],increament)){//bfs 처럼 돌아가지만 더 최선의 경우만 돌리는게 다익스트라구나... 그래서 더 효율적인거구나.. 난 정말 망했다...
                    dp[x][y] = Math.max(dp[now.x][now.y],increament);
                    pq.add(new Node(x,y,dp[x][y]));
                    }
                }
            }
        }
        return dp[n-1][m-1];
    }
}

class Node{
    public int x;
    public int y;
    public int effort;
    public Node(
        int x, int y, int e
    ){
        this.x=x;
        this.y=y;
        this.effort = e;
    }
}