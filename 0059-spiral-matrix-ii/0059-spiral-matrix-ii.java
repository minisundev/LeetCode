class Solution {
    public int[][] generateMatrix(int n) {

        if(n==1){
            int [][] result = {{1}};
            return result;
        }

        int [][] answer = new int [n][n];

        int x = 0;
        int y = 0;

        answer[0][0] = 1;
        //int [][] dl = {{-1,0},{0,1},{1,0},{0,-1}};
        //int [][] dl = {{-1,0},{0,-1},{1,0},{0,1}};
        //int [][] dl = {{1,0},{0,1},{-1,0},{0,-1}};
        int [][] dl = {{0,1},{1,0},{0,-1},{-1,0}};
        int index = 0;
        int count = 2;

        while(count<=n*n){

            int X = x+dl[index][0];
            int Y = y+dl[index][1];

            if(X<0 || Y<0 || X>=n || Y>=n || answer[X][Y]!=0){
                index = (index+1)%dl.length;
                continue;
            }

            answer[X][Y] = count;

            x = X;
            y = Y;

            count++;
        }

        return answer;
    }
}