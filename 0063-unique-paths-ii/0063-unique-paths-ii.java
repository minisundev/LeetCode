class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if(obstacleGrid[0][0]==1){
            return 0;
        }

        int [][] map = new int[obstacleGrid.length][obstacleGrid[0].length];

        for(int i=0;i<map.length;i++){
            if(obstacleGrid[i][0]!=1){
                map[i][0] = 1;
            }else{break;}//돌이 있으면 거기는 절대 못 감 갈 수 있는 방법이 한 가지 뿐인데 막혔으니까
        }

        for(int j=1;j<map[0].length;j++){
            if(obstacleGrid[0][j]!=1){
                map[0][j] = 1;
            }else{break;}//돌이 있으면 거기는 절대 못 감 갈 수 있는 방법이 한 가지 뿐인데 막혔으니까
        }

        for(int i=1; i<map.length; i++){
            for(int j=1;j<map[0].length;j++){
                if(obstacleGrid[i][j]!=1){
                    map[i][j] = map[i-1][j]+map[i][j-1];
                }
            }
        }

        return map[map.length-1][map[0].length-1];  
    }
}