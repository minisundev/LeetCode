import java.util.*;

class Solution {

    int [][] arr;

    public void wallsAndGates(int[][] rooms) {
        arr = rooms;
        for(int x = 0; x<arr.length; x++){
            for(int y=0; y<arr[0].length; y++){
                if(arr[x][y] == 2147483647){
                    arr[x][y] = search(x, y);
                }
            }
        }

    }

    int [][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    int search(int originX, int originY){
        boolean [][] visit = new boolean[arr.length][arr[0].length];
        int count = 0;
        List<Coord> list = new ArrayList();
        List<Coord> next;
        list.add(new Coord(originX, originY));

        while(!list.isEmpty()){
            next = new ArrayList();
            for(Coord c : list){
                
                if(arr[c.x][c.y]==0){
                    return count;
                }

                for(int [] dir : directions){
                    int x = c.x+dir[0];
                    int y = c.y+dir[1];
                    if(x>=0 && x<arr.length && y>=0 && y<arr[0].length && arr[x][y]!=-1 && !visit[x][y]){
                        visit[x][y] == true;
                        next.add(new Coord(x,y));
                    }
                }
            }
            list = next;
            count++;
        }

        return 2147483647;
    }
}

class Coord{
    public int x;
    public int y;
    public Coord(int x, int y){
        this.x = x;
        this.y = y;
    }
}