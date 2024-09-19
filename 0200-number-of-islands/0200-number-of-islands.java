class Solution {
    char [][] map;
    boolean [][] visit;
    int count;

    public int numIslands(char[][] grid) {
        map = grid;
        visit = new boolean[map.length][map[0].length];
        count = 0;
        for(int i=0; i< map.length; i++){
            for(int j=0;j<map[0].length; j++){
                if(map[i][j]=='1' && !visit[i][j]){
                    visit[i][j] = true;
                    count++;
                    search(i,j);
                }
            }
        }
        return count;
    }

    int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    void search(int x, int y){
        System.out.println(x+","+y+"count:"+count);
        if(x<0 || x>=map.length || y<0 || y>=map[0].length){
            return;
        }

        for(int [] d : dir){
            int X = x+d[0];
            int Y = y+d[1];
            if(X<0 || X>=map.length || Y<0 || Y>=map[0].length){
                continue;
            }
            if(map[X][Y]=='1' && !visit[X][Y]){
                visit[X][Y] = true;
                search(X,Y);
            }  
        }
    }
}