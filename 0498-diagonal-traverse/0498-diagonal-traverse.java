class Solution {
    int [][] mat;

    public int[] findDiagonalOrder(int[][] mat) {
        this.mat = mat;

        int n= mat.length*mat[0].length;
        int [] arr = new int [n];

        Coord coord = new Coord(0,0,0);
        int index=0;

        while(index<n){
            //System.out.println("index:"+index+" "+coord.x+","+coord.y);
            arr[index++] = mat[coord.x][coord.y];
            move(coord);
        }
        return arr;
    }

    int [][] direction = {{-1,1},{1,-1}};

    void move(Coord coord){
        if(coord.way==1 &&coord.x==mat.length-1){
            coord.x = coord.x;
            coord.y = coord.y+1;
            coord.way = (coord.way+1)%2;
            return;
        }
        if(coord.way==0 &&coord.y==mat[0].length-1){
            coord.x = coord.x+1;
            coord.y = coord.y;
            coord.way = (coord.way+1)%2;
            return;
        }
        if(coord.way==1 &&coord.y==0){
            coord.x = coord.x+1;
            coord.y = coord.y;
            coord.way = (coord.way+1)%2;
            return;
        }
        if(coord.way==0 && coord.x==0){
            coord.x = coord.x;
            coord.y = coord.y+1;
            coord.way = (coord.way+1)%2;
            return;
        }
        
        coord.x = coord.x + direction[coord.way][0];
        coord.y = coord.y + direction[coord.way][1];
    }
}

class Coord{
    public int x;
    public int y;
    public int way;
    public Coord(int x, int y, int way){
        this.x = x;
        this.y = y;
        this.way = way;
    }
}