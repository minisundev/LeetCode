class Solution {
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
        boolean [] visit = new boolean [10];
        for(int i=x;i<x+3;i++){
            for(int j=y;j<y+3;j++){
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