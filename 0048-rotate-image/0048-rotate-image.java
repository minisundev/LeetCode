class Solution {

    int n;

    public void rotate(int[][] matrix) {
        n = matrix.length;
        boolean [][] visit = new boolean[matrix.length][matrix[0].length];
        // in place 로 고쳐야하면 swap을 4번 하는 수밖에 더 있나....
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(!visit[i][j]){
                    swap(i,j,matrix,visit);
                }
            }
        }
    }

    void swap(int x,int y,int [][] arr, boolean [][] visit){
        int temp = arr[x][y];
        int [] r90 = convert90(x,y);
        int [] r180 = convert90(r90[0],r90[1]);
        int [] r270 = convert90(r180[0],r180[1]);

        arr[x][y] = arr[r270[0]][r270[1]];
        arr[r270[0]][r270[1]] =  arr[r180[0]][r180[1]];
        arr[r180[0]][r180[1]] = arr[r90[0]][r90[1]];
        arr[r90[0]][r90[1]] = temp;


        visit[x][y] = true;
        visit[r270[0]][r270[1]] =  true;
        visit[r180[0]][r180[1]] = true;
        visit[r90[0]][r90[1]] = true;
    }

    int [] convert90(int x, int y){//우측 90도 회전
        int [] coord = new int [2];
        coord[0] = y;
        coord[1] = n-1-x;
        return coord;
    }
}