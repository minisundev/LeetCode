class Solution {
    char [][] map;
    boolean set = false;

    public void solveSudoku(char[][] board) {
        map = board;
        set(0);
    }

    void set(int index){

        if(set){
            return;
        }

        if(index==map.length*map[0].length){
            if(isValidSudoku(map)){
                set = true;
                return;
            }
        }

        int row = index/map.length;
        int col = index%map.length;

        if(map[row][col]!='.'){
            set(index+1); 
            if(set){
                return;
            } 
        }else{
            for(char c='1'; c<='9'; c++){
                map[row][col] = c;
                if(verifyRow(map,row)&&verifyCol(map, col)&&verifyBlock(map, row, col)){
                    set(index+1);
                    if(set){
                        return;
                    }
                }
                map[row][col] = '.';
            }
        }
    }

    public boolean isValidSudoku(char[][] board) {

        boolean result = true;
        for(int i=0; i<board.length; i++){
            result = result && verifyRow(board,i);
            if(!result){
                return false;
            }
        }

        for(int j=0; j<board[0].length; j++){
            result = result && verifyCol(board,j);
            if(!result){
                return false;
            }
        }

        for(int i=0; i<board.length; i=i+3){
            for(int j=0; j<board[0].length; j=j+3){
                result = result && verifyBlock(board, i,j);
                if(!result){
                    return false;
                }
            }
        }

        return true;
    }

    boolean verifyRow(char [][] board, int row){
        boolean [] visit = new boolean [10];
        for(int j=0;j<board[0].length;j++){
            if(board[row][j]!='.'){
                if(visit[board[row][j]-'0']){
                    return false;
                }else{
                    visit[board[row][j]-'0'] = true;
                }
            }
        }
        return true;
    }

    boolean verifyBlock(char [][] board, int x, int y){
        int baseX = (x/3)*(3);
        int baseY = (y/3)*(3);
        boolean [] visit = new boolean [10];
        for(int i=baseX;i<baseX+3;i++){
            for(int j=baseY;j<baseY+3;j++){
                if(board[i][j]!='.'){
                    if(visit[board[i][j]-'0']){
                        return false;
                    }else{
                        visit[board[i][j]-'0'] = true;
                    }
                }
            }
        }
        return true;
    }

    boolean verifyCol(char [][] board, int col){
        boolean [] visit = new boolean [10];
        for(int i=0;i<board.length;i++){
            if(board[i][col]!=0){
                if(board[i][col]!='.'){
                    if(visit[board[i][col]-'0']){
                        return false;
                    }else{
                        visit[board[i][col]-'0'] = true;
                    }
                }
            }
        }
        return true;
    }
}