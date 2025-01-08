class Solution {

    boolean [][] visit;
    char [][] board;
    String word;
    boolean result = false;

    public boolean exist(char[][] board, String word) {
        visit = new boolean [board.length][board[0].length];
        this.word = word;
        this.board = board;

        for(int x=0; x<board.length; x++){
            for(int y=0; y<board[0].length; y++){
                if(board[x][y] == word.charAt(0)){
                    search(x,y,1);
                }else{
                    search(x,y,0);
                }
            }
        }
        return result;
    }

    int [][] d = {{0,1},{0,-1},{1,0},{-1,0}};

    void search(int x, int y, int index) {
        if(index==word.length()){
            result = true;
            return;
        }

        for(int [] ds : d){
            int dx = x+ds[0];
            int dy = y+ds[1];

            if(0<=dx && 0<=dy && dx<board.length && dy<board[0].length 
            && !visit[dx][dy] 
            && board[dx][dy]==word.charAt(index)){         
                visit[dx][dy] = true;
                search(dx,dy,index+1);
                visit[dx][dy] = false;
            }
        }

    }
}