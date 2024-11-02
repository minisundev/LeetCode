import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        boolean [][] visit = new boolean [matrix.length][matrix[0].length];

        int x = 0;
        int y = 0;

        int [][] dl = {{0,1},{1,0},{0,-1},{-1,0}};
        int index = 0;

        list.add(matrix[0][0]);
        visit[0][0] = true; //들어가서 dl만큼 전진하니까 0,0은 미리 해줘야 함
        int count = 2; //1을 이미 썼으니 2부터

        while(count<=matrix.length*matrix[0].length){

            int X = x+dl[index][0];
            int Y = y+dl[index][1];

            if(X<0 || Y<0 || X>=matrix.length || Y>=matrix[0].length || visit[X][Y]){
                index = (index+1)%dl.length;
                continue;
            }

            visit[X][Y] = true;
            list.add(matrix[X][Y]);

            x = X;
            y = Y;

            count++;
        }

        // int x = 0;
        // int y = 0;

        // int [][] d = {{0,1},{1,0},{0,-1},{-1,0}};
        // int index = 0;

        // list.add(matrix[0][0]);
        // visit[0][0] = true;

        // for(int i=0; i<matrix.length*matrix[0].length; i++){
        //     int X = x+d[index][0];
        //     int Y = y+d[index][1];
        //     if(X<matrix.length && X>=0 && Y<matrix[0].length && Y>=0 && !visit[X][Y]){
        //         System.out.println("true");
        //         visit[X][Y] = true;
        //         list.add(matrix[X][Y]);
        //     }else{
        //         i--;
        //         index = (index+1)%d.length;
        //     }
        //     x = X;
        //     y = Y;
        // }

        return list;
    }
}