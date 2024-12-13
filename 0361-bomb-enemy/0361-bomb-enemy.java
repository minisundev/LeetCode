class Solution {
    int max = 0;
    char [][] map;

    public int maxKilledEnemies(char[][] grid) {
        map = grid;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]!='0') continue;
                int count = 0;
                count += getMax(i,j,1,0);
                count += getMax(i,j,-1,0);
                count += getMax(i,j,0,1);
                count += getMax(i,j,0,-1);
                max = Math.max(max,count);
            }
        }
        return max;   
    }

    int getMax(int x, int y, int dx, int dy){
        int count = 0;
        while(x>=0 && x<map.length && y>=0 && y<map[0].length){
            if(map[x][y]=='E') count++;
            if(map[x][y]=='W') break;
            x = x+dx;
            y = y+dy;
        }
        return count;
    }
}