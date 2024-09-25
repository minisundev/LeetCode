class Solution {
    public int[][] generateMatrix(int n) {

        int [][] answer = new int [n][n];

        int x = 0;
        int y = -1;//아니면 처음을 -1로 해주는 수도 있어

        int [][] dl = {{0,1},{1,0},{0,-1},{-1,0}};
        int index = 0;

        //answer[0][0] = 1; //들어가서 dl만큼 전진하니까 0,0은 미리 해줘야 함
        int count = 1;

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