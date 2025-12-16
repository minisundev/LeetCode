class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;

        boolean [][] v = new boolean [n][m];

        int [][] d = {{0,1},{1,0},{0,-1},{-1,0}};
        int i = 0;

        int x = 0;
        int y = 0;
        list.add(matrix[x][y]);
        v[0][0]=true;

        for(int c=1;c<n*m;c++){
            
            int X = x+d[i][0];
            int Y = y+d[i][1];
            
            if(
                i==0 && (Y>=m||v[X][Y])||
                i==2 && (Y<0||v[X][Y])||
                i==1 && (X>=n||v[X][Y])||
                i==3 && (X<0||v[X][Y])
            ){
                i = (i+1)%d.length;
                c--;
                continue;
            }

            list.add(matrix[X][Y]);
            v[X][Y]=true;

            x=X;
            y=Y;
        }

        return list;
    }
}