class Solution {
    char[][] arr;
    boolean[][] search;
    boolean[][] visit;
    
    public void solve(char[][] board) {
        this.arr = board;
        visit = new boolean[arr.length][arr[0].length];
        search = new boolean[arr.length][arr[0].length];
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                boolean out = false;
                if(!visit[i][j] && arr[i][j]=='O'){
                    search[i][j] = true;
                    out = search(i,j,false);
                    visit[i][j] = true;
                    if(!out){
                        arr[i][j] = 'X';
                    }
                    reset(i,j,out);
                }
            }
        }
    }
    
    int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    boolean search(int x, int y, boolean out){
        if(x==0 || y==0 || x==arr.length-1 || y==arr[0].length-1) out = true;
        
        for(int [] d : dir){
            int X = x+d[0];
            int Y = y+d[1];
            if(X>=0 && Y>=0 && X<arr.length && Y<arr[0].length && !search[X][Y] && arr[X][Y]=='O'){
                search[X][Y] = true;
                out = out || search(X,Y,out);
                //System.out.println("search: "+X+","+Y+ " out: "+out);
            }
        }
        return out;
    }

    void reset(int x, int y, boolean out){
        for(int [] d : dir){
            int X = x+d[0];
            int Y = y+d[1];
            if(X>=0 && Y>=0 && X<arr.length && Y<arr[0].length && search[X][Y] ){
                //System.out.println("reset: "+X+","+Y+ " out: "+out);
                search[X][Y] = false;
                visit[X][Y] = true;
                if(!out){
                    arr[X][Y] = 'X';
                    //System.out.println("flipped");
                }
                reset(X,Y,out);
            }
        }
    }
}